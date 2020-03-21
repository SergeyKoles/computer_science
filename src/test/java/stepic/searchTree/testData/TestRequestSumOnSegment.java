package stepic.searchTree.testData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TestRequestSumOnSegment {

  private static ArrayList<Long> list = new ArrayList<>();
  public static String addingOrder = "";

  public static final int MOD = 1_000_000_001;
  public static long s = 0;

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

  public static void add(String value) {
    long fi = getFi(value);

    if (!list.contains(fi)) {
      addingOrder += " +" + fi;
      list.add(fi);
      Collections.sort(list);
    }
  }

  public static void delete(String value) {
    long fi = getFi(value);
    addingOrder += " -" + fi;
    list.remove(fi);
  }

  public static String find(String value) {
    long fi = getFi(value);

    if (list.contains(fi))
      return "Found";
    return "Not found";
  }

  public static long sum(String left, String right) {
    long l = getFi(left);
    long r = getFi(right);

    long sum = 0;
    for (Long i : list) {
      if (i >= l) {
        if (i <= r) {
          sum += i;
        } else {
          s = sum;
          return sum;
        }
      }
    }

    s = sum;
    return sum;
  }

  private static long getFi(String value) {
    long val = Integer.parseInt(value);
    return (val + (s % MOD)) % MOD;
  }

  public static String print() {
    return list.stream().map(Object::toString).collect(Collectors.joining(" "));
  }
}
