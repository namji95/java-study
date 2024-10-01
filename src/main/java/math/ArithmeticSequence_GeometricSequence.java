package math;

public class arithmeticSequence_geometricSequence {
  public static void main(String[] args) {
    /*
    등차수열 구하는 방법
    등차수열이란 연속되는 수의 차이가 일정한 수열을 말합니다.
   */

    int firstTerm = 2;  // 첫 번째 항
    int commonDifference = 3;  // 공차
    int numberOfTerms = 10;  // 출력할 항의 개수

    for (int i = 0; i < numberOfTerms; i++) {
      int term = firstTerm + i * commonDifference;
      System.out.print(term + " ");
    }
  }
}
