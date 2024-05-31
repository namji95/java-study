public class IndexOfLastIndexOf {

  public static void main(String[] args) {
    String indexOfTest = "java, spring / SpringBoot";

    System.out.println("indexOf(s) : " + indexOfTest.indexOf("s"));
    System.out.println("indexOf(S) : " + indexOfTest.indexOf("S"));
    System.out.println("indexOf(Z) : " + indexOfTest.indexOf("Z"));

    String lastIndexOfTest = "java, JPA / QueryDsl, java";
    System.out.println("lastIndexOf(A) : " + lastIndexOfTest.lastIndexOf("A"));
    System.out.println("lastIndexOf(a) : " + lastIndexOfTest.lastIndexOf("a"));
    System.out.println("lastIndexOf(z) : " + lastIndexOfTest.lastIndexOf("z"));
  }
}
