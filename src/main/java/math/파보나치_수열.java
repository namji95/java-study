package math;

public class 파보나치_수열 {
  public static void main(String[] args) {
    /*
    정의: 피보나치 수열은 첫 번째 항과 두 번째 항은 1이며,
    세 번째 항부터는 바로 앞의 두 항을 더한 수열입니다.
     */

    int n = 6;
    System.out.println("-----------파보나치 수열-----------");
    System.out.println("-----------재귀-----------");
    fibonacciRecursive(0, 1, n);

    System.out.println("\n-----------반복-----------");
    fibonacciIterative(0, 1, n);
  }

  // 재귀적 방법
  private static void fibonacciRecursive (int a, int b, int n) {
    if (n == 0) {
      return;
    }
    System.out.print(a + " ");
    fibonacciRecursive(b, a + b, n - 1);
  }

  // 반복적 방법
  private static void fibonacciIterative (int a, int b, int n) {
    int sum;
    for (int i = 0; i < n; i++) {
      System.out.print(a + " ");
      sum = a + b;
      a = b;
      b = sum;
    }
  }
}
