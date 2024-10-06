package math;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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

    DistinguishArithmeticGeometricProgressions dAGP = new DistinguishArithmeticGeometricProgressions();

    Scanner scanner = new Scanner(System.in);
    System.out.print("\n\n수열의 항 개수 : ");
    int first = scanner.nextInt();
    System.out.print("\n수열의 증가량 : ");
    int increase = scanner.nextInt();
    System.out.print("\nArithmetic 또는 Geometric 입력");
    String question = scanner.next();
    int[] sequence = dAGP.generateNonArithmeticGeometricSequence(first, increase, question);

    if (dAGP.isArithmeticSequence(sequence)) {
      System.out.println(Arrays.toString(sequence));
      System.out.println("이 수열은 등차수열입니다.");
    } else if (dAGP.isGeometricSequence(sequence)) {
      System.out.println(Arrays.toString(sequence));
      System.out.println("이 수열은 등비수열입니다.");
    } else {
      System.out.println("이 수열은 등차수열도 등비수열도 아닙니다.");
    }
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

class DistinguishArithmeticGeometricProgressions {

  // 랜덤한 등차수열과 등비수열이 아닌 수열 생성
  public int[] generateNonArithmeticGeometricSequence(int first, int increase, String question) {
    int[] sequence = new int[first];

    if (question.equals("Arithmetic")) {
      for (int i = 0; i < first; i++) {
        sequence[i] = (i * increase) + 1;
      }
    } else if (question.equals("Geometric")){
      for (int i = 0; i < first; i++) {
        sequence[i] = (int) Math.pow(increase, i + 1);
      }
    } else {
      Random random = new Random();
      for (int i = 0; i < first; i++) {
        sequence[i] = random.nextInt(20);
      }
    }
    return sequence;
  }

  // 등차수열인지 확인하는 함수
  public boolean isArithmeticSequence(int[] sequence) {
    if (sequence.length < 2) {
      return false;
    }

    int commonDifference = sequence[1] - sequence[0];
    for (int i = 2; i < sequence.length; i++) {
      if (sequence[i] - sequence[i - 1] != commonDifference) {
        return false;
      }
    }
    return true;
  }

  // 등비수열인지 확인하는 함수
  public boolean isGeometricSequence(int[] sequence) {
    if (sequence.length < 2 || sequence[0] == 0) {
      return false;
    }

    double commonRatio = (double) sequence[1] / sequence[0];
    for (int i = 2; i < sequence.length; i++) {
      if ((double) sequence[i] / sequence[i - 1] != commonRatio) {
        return false;
      }
    }
    return true;
  }

}