package OOPTEST.Encapsulation2;

import OOPTEST.Encapsulation.SuperClass;

class SubClass extends SuperClass {
  // package OOPTEST.Encapsulation2;
  public void printEach() {
//    System.out.println(a);
//    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
  }
}

public class Test2 {

  public static void main(String[] args) {
    SuperClass parent = new SuperClass();

//    System.out.println(parent.a);
//    System.out.println(parent.b);
//    System.out.println(parent.c);
    // public을 제외한 모든 호출 에러 발생합니다.
    System.out.println(parent.d);
  }
}

/*
출력
4
 */
