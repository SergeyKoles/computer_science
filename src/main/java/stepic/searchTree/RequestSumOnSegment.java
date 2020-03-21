package stepic.searchTree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class RequestSumOnSegment {

  public static final String NOT_FOUND = "Not found";
  public static final String FOUND = "Found";
  public static final int MOD = 1_000_000_001;
  public static long s = 0;
  public static Node root;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());

      for (int i = 0; i < n; i++) {
        String req = br.readLine();
        process(req);
      }
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  public static void process(String req) {
    StringTokenizer st = new StringTokenizer(req);
    String key = st.nextToken();

    switch (key) {
      case "+":
        add(st.nextToken());
        break;
      case "-":
        delete(st.nextToken());
        break;
      case "?":
        find(st.nextToken());
        break;
      case "s":
        sum(st.nextToken(), st.nextToken());
        break;
    }
  }

  public static void sum(String left, String right) {
    long l = getFi(left);
    long r = getFi(right);

    Node rootOfSegment = findRootOfSegment(l, r);
    long sum = 0;

    if (rootOfSegment != null && l <= rootOfSegment.val && rootOfSegment.val <= r) {
      sum = rootOfSegment.sum;

      Node rightEnd;
      if (rootOfSegment.right != null) {
        rightEnd = findRightEnd(rootOfSegment, r);
        sum -= subtractRightSum(rootOfSegment, rightEnd, r);
      }

      Node leftEnd;
      if (rootOfSegment.left != null) {
        leftEnd = findLeftEnd(rootOfSegment, l);
        sum -= subtractLeftSum(rootOfSegment, leftEnd, l);
      }
    }

    s = sum;
    System.out.println(sum);
  }

  public static void delete(String value) {
    long fi = getFi(value);
    Node d = findNode(fi);
    if (d == null) return;

    Node nodeForSwap = d;

    if (d.left != null) {
      nodeForSwap = findMaxNode(d.left);
    } else if (d.right != null) {
      nodeForSwap = findMinNode(d.right);
    }

    Node parent = d.parent;
    if (nodeForSwap.val == d.val) {
      if (parent != null) {
        setParentSon(d.val, null, parent);
        balance(parent);
      } else {
        root = null;
      }
    } else {
      d.val = nodeForSwap.val;

      if (!nodeForSwap.parent.equals(d)) {
        if (nodeForSwap.left != null) {
          nodeForSwap.parent.right = nodeForSwap.left;
          nodeForSwap.left.parent = nodeForSwap.parent;
          nodeForSwap.left = null;
        } else if (nodeForSwap.right != null) {
          nodeForSwap.parent.left = nodeForSwap.right;
          nodeForSwap.right.parent = nodeForSwap.parent;
          nodeForSwap.right = null;
        } else if (nodeForSwap.parent != null) {
          setParentSon(nodeForSwap.val, null, nodeForSwap.parent);
          balance(nodeForSwap.parent);
          nodeForSwap.parent = null;
        }
      } else {
        if (nodeForSwap.left != null) {
          d.left = nodeForSwap.left;
          nodeForSwap.left.parent = d;
        } else if (nodeForSwap.right != null) {
          d.right = nodeForSwap.right;
          nodeForSwap.right.parent = d;
        } else {
          setParentSon(nodeForSwap.val, null, d);
        }
      }
      balance(d.left);
      balance(d.right);
      balance(d);
    }
  }

  public static void find(String value) {
    long fi = getFi(value);

    String result = "";
    if (root == null || findNode(fi) == null)
      result = NOT_FOUND;
    else result = FOUND;
    System.out.println(result);
  }

  public static void add(String value) {
    long fi = getFi(value);

    if (root == null) {
      root = new Node(fi, null);
    } else if (findNode(fi) == null) {
      Node node = createNode(fi);
      balance(node.parent);
    }
  }

  // ==========================================

  private static long getFi(String value) {
    long val = Integer.parseInt(value);
    return (val + (s % MOD)) % MOD;
  }

  private static long subtractLeftSum(Node currentRoot, Node leftEnd, long l) {
    Node current = leftEnd;
    long sum = 0;
    if (leftEnd != null && leftEnd.val >= l) {
      sum += nodeSum(leftEnd.left);
    }
    while (current != null && !current.equals(currentRoot)) {
      if (current.val < l) {
        sum += current.val + nodeSum(current.left);
      }
      current = current.parent;
    }
    return sum;
  }

  private static long subtractRightSum(Node currentRoot, Node rightEnd, long r) {
    Node current = rightEnd;
    long sum = 0;
    if (rightEnd != null && rightEnd.val <= r) {
      sum += nodeSum(rightEnd.right);
    }
    while (current != null && !current.equals(currentRoot)) {
      if (current.val > r) {
        sum += current.val + nodeSum(current.right);
      }
      current = current.parent;
    }
    return sum;
  }

  private static Node findRootOfSegment(long l, long r) {
    Node rootOfSegment = root;

    while (rootOfSegment != null) {
      long val = rootOfSegment.val;
      if (l <= val && val <= r) {
        break;
      } else if (l > val) {
        if (rootOfSegment.right == null) break;
        rootOfSegment = rootOfSegment.right;
      } else {
        if (rootOfSegment.left == null) break;
        rootOfSegment = rootOfSegment.left;
      }
    }
    return rootOfSegment;
  }

  private static Node createNode(long val) {
    Node node = root;
    while (val != node.val) {
      if (node.val > val) {
        if (node.left == null) {
          node.left = new Node(val, node);
        }
        node = node.left;
      } else {
        if (node.right == null) {
          node.right = new Node(val, node);
        }
        node = node.right;
      }
    }
    return node;
  }

  private static Node findNode(long val) {
    Node node = root;
    if (node != null) {
      while (val != node.val) {
        if (node.val > val) {
          node = node.left;
        } else {
          node = node.right;
        }
        if (node == null) {
          return null;
        }
      }
    }
    return node;
  }

  private static Node findLeftEnd(Node startNode, long end) {
    Node node = startNode;
    if (node != null) {
      while (end != node.val) {
        if (node.val > end) {
          if (node.left == null) {
            break;
          }
          node = node.left;
        } else {
          if (node.right == null) {
            break;
          }
          node = node.right;
        }
      }
    }
    return node;
  }

  private static Node findRightEnd(Node startNode, long end) {
    Node node = startNode;
    if (node != null) {
      while (end != node.val) {
        if (node.val < end) {
          if (node.right == null) {
            break;
          }
          node = node.right;
        } else {
          if (node.left == null) {
            break;
          }
          node = node.left;
        }
      }
    }
    return node;
  }

  private static Node findMinNode(Node initialNode) {
    while (initialNode.left != null) {
      initialNode = initialNode.left;
    }
    return initialNode;
  }

  private static Node findMaxNode(Node initialNode) {
    while (initialNode.right != null) {
      initialNode = initialNode.right;
    }
    return initialNode;
  }

  private static void setParentSon(long val, Node son, Node parent) {
    if (parent.right != null && parent.right.val == val)
      parent.right = son;
    else parent.left = son;
  }

  private static void balance(Node n) {
    while (n != null) {
      fixHeight(n);
      fixSum(n);
      int balance = bFactor(n);
      if (balance == 2) {
        if (bFactor(n.right) < 0)
          n.right = rightRotation(n.right);
        n = leftRotation(n);
      } else if (balance == -2) {
        if (bFactor(n.left) > 0)
          n.left = leftRotation(n.left);
        n = rightRotation(n);
      }
      if (n.parent == null)
        root = n;
      n = n.parent;
    }
  }

  private static Node leftRotation(Node n) {
    Node r = n.right;
    if (n.parent != null) {
      setParentSon(n.val, r, n.parent);
    }
    n.right = r.left;
    if (n.right != null)
      n.right.parent = n;
    r.left = n;
    r.parent = n.parent;
    n.parent = r;
    fixHeight(n);
    fixHeight(r);
    fixSum(n);
    fixSum(r);
    return r;
  }

  private static Node rightRotation(Node n) {
    Node l = n.left;
    if (n.parent != null) {
      setParentSon(n.val, l, n.parent);
    }
    n.left = l.right;
    if (n.left != null)
      n.left.parent = n;
    l.right = n;
    l.parent = n.parent;
    n.parent = l;
    fixHeight(n);
    fixHeight(l);
    fixSum(n);
    fixSum(l);
    return l;
  }

  private static void fixHeight(Node n) {
    int hl = height(n.left);
    int hr = height(n.right);
    n.h = ((hl > hr) ? hl : hr) + 1;
  }

  private static void fixSum(Node n) {
    long sumL = nodeSum(n.left);
    long sumR = nodeSum(n.right);
    n.sum = n.val + sumL + sumR;
  }

  private static int height(Node n) {
    return n != null ? n.h : 0;
  }

  private static long nodeSum(Node n) {
    return n != null ? n.sum : 0;
  }

  private static int bFactor(Node n) {
    return height(n.right) - height(n.left);
  }

  public static class Node {
    public long val;
    public int h;
    public long sum;
    public Node parent;
    public Node left;
    public Node right;

    public Node(long val, Node parent) {
      this.val = val;
      this.parent = parent;
      this.h = 1;
      this.sum = val;
    }

    @Override
    public String toString() {
      return "val=" + val +
              ", sum=" + sum;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Node node = (Node) o;
      return val == node.val &&
              sum == node.sum;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, sum);
    }
  }
}