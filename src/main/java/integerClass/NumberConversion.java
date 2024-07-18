package integerClass;

public class NumberConversion {
    public static void main(String[] args) {

        // 테스트를 위한 10진수 값 = 25
        int a = 25;

        System.out.println("10진수 -> 2진수");
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toString(a,2));

        System.out.println("10진수 -> 3진수");
        System.out.println(Integer.toString(a,3));

        System.out.println("10진수 -> 4진수");
        System.out.println(Integer.toString(a,4));

        System.out.println("10진수 -> 5진수");
        System.out.println(Integer.toString(a,5));

        System.out.println("10진수 -> 6진수");
        System.out.println(Integer.toString(a,6));

        System.out.println("10진수 -> 7진수");
        System.out.println(Integer.toString(a,7));

        System.out.println("10진수 -> 8진수");
        System.out.println(Integer.toOctalString(a));
        System.out.println(Integer.toString(a,8));

        System.out.println("10진수 -> 16진수");
        System.out.println(Integer.toString(a,16));
        System.out.println(Integer.toHexString(a));

        System.out.println("================================================");

        // 테스트를 위한 n진수 값 = 25
        String b = "11001"; // <- 25

        System.out.println("2진수 -> 10진수");
        System.out.println(Integer.parseInt(b,2));

        System.out.println("3진수 -> 10진수");
        System.out.println(Integer.parseInt(b,3));

        System.out.println("4진수 -> 10진수");
        System.out.println(Integer.parseInt(b,4));

        System.out.println("5진수 -> 10진수");
        System.out.println(Integer.parseInt(b,5));

        System.out.println("6진수 -> 10진수");
        System.out.println(Integer.parseInt(b,6));

        System.out.println("7진수 -> 10진수");
        System.out.println(Integer.parseInt(b,7));

        System.out.println("8진수 -> 10진수");
        System.out.println(Integer.parseInt(b,8));

        System.out.println("16진수 -> 10진수");;
        System.out.println(Integer.parseInt(b,16));

    }
}
