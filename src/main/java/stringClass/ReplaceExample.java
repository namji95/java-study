package stringClass;

public class ReplaceExample {
  public static void main(String[] args) {
    System.out.println("\n------------------------Replace 메서드------------------------");
    ReplaceEx replaceEx = new ReplaceEx();
    replaceEx.replaceEx();

    System.out.println("\n------------------------ReplaceAll 메서드------------------------");
    ReplaceAllEx replaceAllEx = new ReplaceAllEx();
    replaceAllEx.replaceAllEx();

    System.out.println("\n------------------------ReplaceFirst 메서드------------------------");
    ReplaceFirstEx replaceFirstEx = new ReplaceFirstEx();
    replaceFirstEx.replaceFirstEx();
  }
}

class ReplaceEx {
  public void replaceEx() {
    String replaceTest = "!자바, 문자열, 치환, 테스트!";
    System.out.println("원래 문자열 : " + replaceTest);

    System.out.println(",(쉼표)를 느낌표로 치환");
    System.out.println(replaceTest.replace(",", "!"));
  }
}

class ReplaceAllEx {
  public void replaceAllEx() {
    String replaceAllTest = "!자바, 문자열, 치환, 테스트!";
    System.out.println("원래 문자열 : " + replaceAllTest);

    System.out.println(",(쉼표)와 느낌표를 물음표로 치환");
    System.out.println(replaceAllTest.replaceAll("[,!]", "?"));
  }
}

class ReplaceFirstEx {
  public void replaceFirstEx() {
    String replaceFirstTest = "!자바, 문자열, 치환, 테스트!";
    System.out.println("원래 문자열 : " + replaceFirstTest);

    System.out.println("정규 표현식 중, 처음 나오는 ,(쉼표)나 느낌표를 물음표로 치환");
    System.out.println(replaceFirstTest.replaceFirst(",", "?"));
  }
}
