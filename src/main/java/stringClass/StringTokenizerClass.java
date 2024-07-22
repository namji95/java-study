package stringClass;

import java.util.StringTokenizer;

public class StringTokenizerClass {
  public static void main(String[] args) {
    String s = "StringTokenizer, 작성법! 및, 사용법! 예시~";
    System.out.println("\n----------StringTokenizer 띄어쓰기 기준으로 문자열 분리----------");
    StringTokenizer1 stringTokenizer1 = new StringTokenizer1();
    stringTokenizer1.stringTokenizerEx(s);

    System.out.println("\n----------StringTokenizer 구분자 기준으로 문자열 분리----------");
    StringTokenizer2 stringTokenizer2 = new StringTokenizer2();
    stringTokenizer2.stringTokenizerEx(s);

    System.out.println("\n----------StringTokenizer 구분자 기준으로 문자열 분리하고 구분자 출력 여부----------");
    StringTokenizer3 stringTokenizer3 = new StringTokenizer3();
    stringTokenizer3.stringTokenizerEx(s);

    System.out.println("\n----------StringTokenizer 여러 개의 구분자 기준으로 문자열 분리----------");
    StringTokenizer4 stringTokenizer4 = new StringTokenizer4();
    stringTokenizer4.stringTokenizerEx(s);
  }
}

class StringTokenizer1 {
  public void stringTokenizerEx(String s) {
    System.out.println("구분 전 문자열 : " + s);
    StringTokenizer st = new StringTokenizer(s);

    System.out.println("\n띄어쓰기 기준 : ");
    while (st.hasMoreTokens()) {
      System.out.println(st.nextToken());
    }
  }
}

class StringTokenizer2 {
  public void stringTokenizerEx(String s) {
    System.out.println("구분 전 문자열 : " + s);
    StringTokenizer st = new StringTokenizer(s, "!");

    System.out.println("\n느낌표(!) 기준 : ");
    while (st.hasMoreTokens()) {
      System.out.println(st.nextToken());
    }
  }
}

class StringTokenizer3 {
  public void stringTokenizerEx(String s) {
    System.out.println("구분 전 문자열 : " + s);
    StringTokenizer stTrue = new StringTokenizer(s, "!", true);

    System.out.println("\n느낌표(!) 기준 구분자 출력 : ");
    while (stTrue.hasMoreTokens()) {
      System.out.println(stTrue.nextToken());
    }

    StringTokenizer stFalse = new StringTokenizer(s, "!", false);

    System.out.println("\n느낌표(!) 기준 문자열만 출력 : ");
    while (stFalse.hasMoreTokens()) {
      System.out.println(stFalse.nextToken());
    }
  }
}

class StringTokenizer4 {
  public void stringTokenizerEx(String s) {
    System.out.println("구분 전 문자열 : " + s);
    StringTokenizer st = new StringTokenizer(s, ",!");

    System.out.println("\n느낌표(!)와 쉼표(,) 기준 : ");
    while (st.hasMoreTokens()) {
      System.out.println(st.nextToken());
    }
  }
}
