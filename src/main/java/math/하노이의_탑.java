package math;

public class 하노이의_탑 {
  public static void main(String[] args) {
    /*
    정의: 하노이탑 문제는 n개의 원반을 한 기둥에서 다른 기둥으로 옮기는 문제로,
    한 번에 하나의 원반만 이동 가능하며 큰 원반이 작은 원반 위에 놓여서는 안 됩니다.
      1. 한 번에 하나의 원판만 이동할 수 있다.
      2. 큰 원판은 작은 원판 위에 놓을 수 없다.
      3. 모든 원판을 시작 기둥에서 목표 기둥으로 옮겨야 한다.
    */

    int n = 3;  // 원판의 개수
    System.out.println("-----------하노이의 탑-----------");

    System.out.println("-----------재귀-----------");
    hanoiRecursive(n, 'A', 'C', 'B');  // n개의 원판을 A 기둥에서 C 기둥으로 B 기둥을 사용하여 이동

    System.out.println("\n-----------반복-----------");
    hanoiIterative(n);  // 반복적 방법으로 하노이의 탑 문제 해결
  }

  // 재귀적 방법
  private static void hanoiRecursive(int n, char from, char to, char aux) {
    if (n == 1) {
      System.out.println("원판 1을 " + from + "에서 " + to + "으로 이동");
      return;
    }
    hanoiRecursive(n - 1, from, aux, to);  // n-1개 원판을 보조 기둥으로 이동
    System.out.println("원판 " + n + "을 " + from + "에서 " + to + "으로 이동");  // n번째 원판을 목표 기둥으로 이동
    hanoiRecursive(n - 1, aux, to, from);  // 보조 기둥에서 목표 기둥으로 n-1개 원판을 이동
  }

  // 반복적 방법
  private static void hanoiIterative(int n) {
    int totalMoves = (int) Math.pow(2, n) - 1;  // 총 이동 횟수 계산
    char from = 'A', to = 'C', aux = 'B';  // 기둥 이름

    // 짝수 개의 원판이 있는 경우, 시작 기둥과 목표 기둥을 바꿔야 함
    if (n % 2 == 0) {
      char temp = to;
      to = aux;
      aux = temp;
    }

    for (int i = 1; i <= totalMoves; i++) {
      int fromPeg = (i & i - 1) % 3;  // 이동할 기둥 계산
      int toPeg = ((i | i - 1) + 1) % 3;  // 이동할 목표 기둥 계산
      System.out.println("이동: 원판 " + (fromPeg + 1) + "을 " + getPegName(fromPeg) + "에서 " + getPegName(toPeg) + "으로 이동");
    }
  }

  // 기둥 이름을 반환하는 헬퍼 함수
  private static String getPegName(int peg) {
    switch (peg) {
      case 0: return "A";
      case 1: return "B";
      case 2: return "C";
      default: return "";
    }
  }
}
