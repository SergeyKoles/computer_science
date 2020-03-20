package stepic.divideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://ru.stackoverflow.com/questions/375825/��������-�-��������-�������-����������-��������-�-�������/375841#375841
 * <p>
 * ������ ������ �������� ����� 1<=n<=10^5, ������ � ������ A[1�n], ���������� ����������� �����, �� ������������� 10^9.
 * ���������� ��������� ����� ��� �������� 1<=i<j<=n, ��� ������� A[i]>A[j].
 * (����� ���� ��������� ���������� ��������� �������.
 * ���������� �������� � ������� �������� � ��������� ������ ��� ����� �����������������: ��������,
 * � ������������� �� ���������� ������� �������� ��� ������, � � �������,
 * ������������� �� ��������, �������� �������� ������ ��� ��������.)
 * <p>
 * Sample Input:
 * 5
 * 2 3 9 2 9
 * Sample Output:
 * 2
 */
public class InversionNumber {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] A = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      System.out.println(inversionCounter(A, 0, A.length - 1));
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  public static long inversionCounter(int[] A, int l, int r) {
    long counter = 0;
    if (l < r) {
      int m = (l + r) / 2;
      counter += inversionCounter(A, l, m);
      counter += inversionCounter(A, m + 1, r);
      counter += merge(A, l, r, m);
    }

    return counter;
  }

  private static long merge(int[] A, int l, int r, int m) {
    long swap = 0;
    int[] leftA = Arrays.copyOfRange(A, l, m + 1);
    int[] rightA = Arrays.copyOfRange(A, m + 1, r + 1);
    int j = 0;
    int i = 0;
    int k = l;

    while (i < leftA.length && j < rightA.length) {
      if (leftA[i] <= rightA[j])
        A[k++] = leftA[i++];
      else {
        A[k++] = rightA[j++];
        swap += (m + 1) - (l + i);
      }
    }

    while (i < leftA.length)
      A[k++] = leftA[i++];
    while (j < rightA.length)
      A[k++] = rightA[j++];

    return swap;
  }
}
