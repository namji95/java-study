package math;

public class ArithmeticSequence_GeometricSequence {
  public static void main(String[] args) {
    int firstTerm = 2;  // 첫 번째 항
    int numberOfTerms = 10;  // 출력할 항의 개수

    int commonDifference = 2;  // 공차
    int commonRatio = 2;  // 공비

    ArithmeticSequence arithmeticSequence = new ArithmeticSequence();
    arithmeticSequence.ArithmeticSequence(firstTerm, commonDifference, numberOfTerms);

    GeometricSequence geometricSequence = new GeometricSequence();
    geometricSequence.GeometricSequence(firstTerm, commonRatio, numberOfTerms);
  }
}

class ArithmeticSequence {
  public void ArithmeticSequence (int firstTerm, int commonDifference, int numberOfTerms) {
    /*
    등차수열 구하는 방법
    등차수열이란 연속되는 수의 차이가 일정한 수열을 말합니다.
    */
    System.out.println("\n-------------------등차수열 2씩 증가하는 예시-------------------");

    for (int i = 0; i < numberOfTerms; i++) {
      int term = firstTerm + i * commonDifference;
      System.out.print(term + " ");
    }

  }
}

class GeometricSequence {
  public void GeometricSequence (int firstTerm, int commonRatio, int numberOfTerms) {
    /*
    등비수열 구하는 방법
    등비수열이란 연속되는 수의 비율이 일정한 수열을 말합니다.
     */
    System.out.println("\n\n-------------------등비수열 2의 배수로 증가하는 예시-------------------");

    for (int i = 0; i < numberOfTerms; i++) {
      int term = (int)(firstTerm * Math.pow(commonRatio, i));
      System.out.print(term + " ");
    }
  }
}