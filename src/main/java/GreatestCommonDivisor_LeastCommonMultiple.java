import java.util.Scanner;

public class GreatestCommonDivisor_LeastCommonMultiple {

  public static void main(String[] args) {
    /*
    최대 공약수와 최소 공배수 구하는 방법 실습
    최대공약수 : 0이 아닌 두 개 이상의 정수의 공통되는 약수 중 가장 큰 수입니다.
    따라서 a와 b의 최대공약수는 a의 약수인 동시에 b의 약수인 수 중에서 큰 수를 의미합니다.
    초소공배수 : 0이 아닌 두 개 이상의 정수의 양의 공배수 중에서 가장 작은 수입니다.
     */
    System.out.println("------------------최대 공약수 & 최소 공배수------------------");
    Scanner in = new Scanner(System.in);
    System.out.print("숫자1 >>> ");
    int num1 = in.nextInt();

    System.out.print("숫자2 >>> ");
    int num2 = in.nextInt();

    for (int i = 1; i <= num1; i++) {
      if (num1 % i == 0) {
        System.out.println("num1의 약수 : " + i);
      }
    }

    for (int i = 1; i <= num2; i++) {
      if (num2 % i == 0) {
        System.out.println("num2의 약수 : " + i);
      }
    }

    int max = 0; // 최대 공약수
    for (int i = 1; i <= num1 && i <= num2; i++) {
      if (num1 % i == 0 && num2 % i == 0) {
        max = i;
      }
    }

    int min = (num1 * num2) / max; // 최소 공백수

    System.out.println("최대 공약수 : " + max);
    System.out.println("최소 공배수 : " + min);
    System.out.println("유클리드 호제법 최대공약수 : " +
        EuclideanAlgorithmGreatestCommonDivisor(num1, num2));
    System.out.println("유클리드 호제법 최소공배수 : " +
        EuclideanAlgorithmLeastCommonMultiple(num1, num2));
  }

  /*---------------------------------------------------------------------------------------*/

  static int EuclideanAlgorithmGreatestCommonDivisor (int num1, int num2) {
    // 유클리드 호제법 최대공약수
    if (num1 < num2) { // 유클리드 호제법 조건
      int temp = num1;
      num1 = num2;
      num2 = temp;
    }
    while (num2 != 0) {
      int r = num1 % num2;
      num1 = num2;
      num2 = r;
    }
    return num1;
  }

  static int EuclideanAlgorithmLeastCommonMultiple (int num1, int num2) {
    // 유클리드 호제법 최소공배수
    return num1 * num2 / EuclideanAlgorithmGreatestCommonDivisor(num1, num2);
  }
}
