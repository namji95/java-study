package OOPTEST.Encapsulation; // 패키지명

class Test {
  // Test 클래스의 접근 제어자는 default 입니다.
  public static void main(String[] args) {
    SuperClass superClass = new SuperClass();

//    System.out.println(superClass.a); // 동일 클래스가 아니기 때문에 에러발생합니다.
    System.out.println(superClass.b);
    System.out.println(superClass.c);
    System.out.println(superClass.d);
  }
}

public class SuperClass {
  // SuperClass 클래스의 접근제어자는 public 입니다.
  private int a = 1;
  int b = 2;
  protected int c = 3;
  public int d = 4;
  // a, b, c, d에 각각 다른 접근 제어자 정의

  public void printEach() {
    // 동일 클래스이기 때문에 에러 발생하지 않습니다.
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
  }
}

/*
출력
2
3
4
 */
