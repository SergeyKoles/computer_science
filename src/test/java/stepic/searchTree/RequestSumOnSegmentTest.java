package stepic.searchTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stepic.searchTree.testData.TestRequestSumOnSegment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

class RequestSumOnSegmentTest {

  @BeforeEach
  void setUp() {
    RequestSumOnSegment.root = null;
    RequestSumOnSegment.s = 0;
    TestRequestSumOnSegment.s = 0;
    TestRequestSumOnSegment.addingOrder = "";
    TestRequestSumOnSegment.list = new ArrayList<>();
  }

  @Test
  void delete1() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 25");
  }

  @Test
  void delete2() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 12");
  }

  @Test
  void delete3() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 75");
  }

  @Test
  void delete4() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 50");
  }

  @Test
  void delete5() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 100");
  }

  @Test
  void delete6() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 150");
  }

  @Test
  void delete7() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 125");
  }

  @Test
  void delete8() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 175");
  }

  @Test
  void delete9() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 162");
  }

  @Test
  void delete10() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 188");
  }

  @Test
  void delete11() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 183");
  }

  @Test
  void delete12() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 137");
  }

  @Test
  void delete13() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 6");
  }

  @Test
  void delete14() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 37");
  }

  @Test
  void delete15() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 44");
  }


  @Test
  void delete16() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("- 82");
  }

  @Test
  void sum() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/testData.txt");
    processReq("s 1 200");resetSum();
    processReq("s 11 37");resetSum();
    processReq("s 12 38");resetSum();
    processReq("s 12 37");resetSum();
    processReq("s 25 49");resetSum();
    processReq("s 25 50");resetSum();
    processReq("s 50 100");resetSum();
    processReq("s 82 137");resetSum();
    processReq("s 81 138");resetSum();
    processReq("s 75 125");resetSum();
    processReq("s 137 183");resetSum();
    processReq("s 44 82");resetSum();
    processReq("s 100 183");resetSum();
    processReq("s 99 189");resetSum();
    processReq("s 50 150");resetSum();
    processReq("s 125 175");resetSum();
    processReq("s 124 176");resetSum();
  }

  @Test
  void process36() throws Exception {
    processFile("src/test/java/stepic/searchTree/testData/test36Data.txt");
  }

  private static void processReq(String req) throws Exception {
    String actualBefore = inOrder(RequestSumOnSegment.root, new StringBuilder());
    String expectedBefore = TestRequestSumOnSegment.print();
    long sBeforeActual = RequestSumOnSegment.s;
    long sBeforeExpect = TestRequestSumOnSegment.s;

    RequestSumOnSegment.process(req);
    TestRequestSumOnSegment.process(req);

    String actual = inOrder(RequestSumOnSegment.root, new StringBuilder());
    String expected = TestRequestSumOnSegment.print();
    long sAfterActual = RequestSumOnSegment.s;
    long sAfterExpect = TestRequestSumOnSegment.s;

    if (!actual.equals(expected) || sAfterActual != sAfterExpect) {
      String before = "\n\nbefore: " + req +
              ": \nexpected: " + expectedBefore +
              "\n  actual: " + actualBefore;
      String after = "\n\nafter: " + req +
              ": \nexpected: " + expected +
              "\n  actual: " + actual;
      String sBefore = "\nsBeforeActual: " + sBeforeActual +
              "\nsBeforeExpect: " + sBeforeExpect;
      String sAfter = "\nsAfterActual: " + sAfterActual +
              "\nsAfterExpect: " + sAfterExpect;
      throw new Exception("\n\nadding order: " + TestRequestSumOnSegment.addingOrder +
              "\n\nsum: " + sBefore +
              sAfter +
              "\n\n\n" + "request: " + req + "\n" +
              before + after + "\n\n\n");
    }
  }

  private static void processFile(String fileName) throws Exception {
    try (BufferedReader in = new BufferedReader(new FileReader(new File(fileName)))) {
      int n = Integer.parseInt(in.readLine());

      for (int i = 0; i < n; i++) {
        processReq(in.readLine());
      }
    }
  }

  private static void resetSum() {
    RequestSumOnSegment.s = 0;
    TestRequestSumOnSegment.s = 0;
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