package stringClass;

public class StringRepeat {
  public static void main(String[] args) {
    String s = "Hello";
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 3; i++) {
      sb.append(s);
    }

    System.out.println("for문 이용 : " + sb);
    System.out.println("repeat : " + s.repeat(3));
  }
}
