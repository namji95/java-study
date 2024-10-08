package math;

public class 등차_등비_수열 {
  public static void main(String[] args) {
    /*
    등차수열 (Arithmetic Sequence)
    정의: 등차수열은 각 항이 이전 항에 일정한 값을 더한 수열입니다. 이 일정한 값을 공차라고 합니다.
    등비수열 (Geometric Sequence)
    정의: 등비수열은 각 항이 이전 항에 일정한 값을 곱한 수열입니다. 이 일정한 값을 공비라고 합니다.
     */

    int firstTerm = 2;  // 첫 번째 항
    int commonDifference = 2;  // 공차, 공비
    int n = 5;  // 구하고자 하는 항의 개수

    System.out.println("-----------등차수열 구하기-----------");
    // 재귀적 방법
    System.out.println("-----------재귀-----------");
    arithmeticSequenceRecursion(firstTerm, commonDifference, n);

    // 반복적 방법
    System.out.println("\n-----------반복-----------");
    arithmeticSequenceRepetition(firstTerm, commonDifference, n);

    System.out.println("\n\n-----------등비수열 구하기-----------");
    // 재귀적 방법
    System.out.println("-----------재귀-----------");
    geometricSequenceRecursion(firstTerm, commonDifference, n);

    // 반복적 방법
    System.out.println("\n-----------반복-----------");
    geometricSequenceRepetition(firstTerm, commonDifference, n);
  }

  // 등차수열 재귀
  private static void arithmeticSequenceRecursion (int first, int diff, int n) {
    if (n == 0) {
      return;
    }
    System.out.print(first + " ");
    arithmeticSequenceRecursion(first + diff, diff, n - 1);
  }

  // 등차수열 반복
  private static void arithmeticSequenceRepetition (int first, int diff, int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(first + i * diff + " ");
    }
  }

  // 등비수열 재귀
  private static void geometricSequenceRecursion (int first, int diff, int n) {
    if (n == 0) {
      return;
    }
    System.out.print(first + " ");
    geometricSequenceRecursion(first * diff, diff, n - 1);
  }

  // 등비수열 반복
  private static void geometricSequenceRepetition (int first, int diff, int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(first + " ");
      first *= diff;
    }
  }
}