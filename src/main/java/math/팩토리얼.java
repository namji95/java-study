package math;

public class 팩토리얼 {
  public static void main(String[] args) {
    /*
    정의: 팩토리얼은 1부터 n까지의 모든 수를 곱한 값입니다.
    수학적으로 n! = n × (n-1) × ... × 1입니다.
     */

    int n = 5;
    int i = 1;
    System.out.println("-----------팩토리얼-----------");
    System.out.println("-----------재귀-----------");
    factorialRecursive(n, i);

    System.out.println("\n-----------반복-----------");
    factorialIterative(n, i);
  }

  // 재귀적 방법
  private static void factorialRecursive (int n, int i) {
    if (n == 0) {
      System.out.println(i);
      return;
    }
    i *= n;
    System.out.println(n + " 번째 : " + i);
    factorialRecursive(n - 1, i);
  }

  // 반복적 방법
  private static void factorialIterative (int n, int i) {
    for (int j = n; j >= 1; j--) {
      i *= j;
      System.out.println(j + " 번째 : " + i);
    }
    System.out.println(i);
  }
}
