package stepic.searchTree;

import org.junit.jupiter.api.Test;
import stepic.searchTree.testData.TestRequestSumOnSegment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class RequestSumOnSegmentTest {


  @Test
  void process() throws Exception {
    try (BufferedReader in = new BufferedReader(new FileReader(new File("src/test/java/stepic/searchTree/testData/test36Data.txt")))) {
      int n = Integer.parseInt(in.readLine());

      for (int i = 0; i < n; i++) {
        String actualBefore = inOrder(RequestSumOnSegment.root, new StringBuilder());
        String expectedBefore = TestRequestSumOnSegment.print();
        long sBeforeActual = RequestSumOnSegment.s;
        long sBeforeExpect = TestRequestSumOnSegment.s;

        String req = in.readLine();
        RequestSumOnSegment.process(req);
        TestRequestSumOnSegment.process(req);

        String actual = inOrder(RequestSumOnSegment.root, new StringBuilder());
        String expected = TestRequestSumOnSegment.print();

        if (!actual.equals(expected)) {
          String before = "\n\nbefore: " + req + ": \nexpected: " + expectedBefore + "\n  actual: " + actualBefore;
          String after = "\n\nafter: " + req + ": \nexpected: " + expected + "\n  actual: " + actual;
          String s = "\nsBeforeActual: " + sBeforeActual +
                  "\nsBeforeExpect: " + sBeforeExpect;
          throw new Exception("\n\nadding order: " + TestRequestSumOnSegment.addingOrder +
                  "\n\nsum: " + s +
                  "\n\n\n" + "request: " + req + "\n" +
                  before + after + "\n\n\n");
        }
      }
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  public static String inOrder(RequestSumOnSegment.Node v, StringBuilder sb) {
    if (v == null) return "";
    if (v.left != null) {
      inOrder(v.left, sb);
    }
    sb.append(v.val).append(" ");
    if (v.right != null) {
      inOrder(v.right, sb);
    }
    return sb.toString().trim();
  }
}