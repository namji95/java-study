import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class BigIntegerBigDecimal {
  public static void main(String[] args) {
    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~BIG INTEGER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    System.out.println("\n-----------------BigInteger 선언-----------------");
    BigIntegerDeclaration bigIntegerDeclaration = new BigIntegerDeclaration();
    bigIntegerDeclaration.bigInteger();

    System.out.println("\n-----------------BigInteger 형 변환-----------------");
    BigIntegerTypeConversion bigIntegerTypeConversion = new BigIntegerTypeConversion();
    bigIntegerTypeConversion.bigInteger();

    System.out.println("\n-----------------BigInteger 연산-----------------");
    BigIntegerCalculation bigIntegerCalculation = new BigIntegerCalculation();
    bigIntegerCalculation.binInteger();

    System.out.println("\n-----------------BigInteger 비트 연산-----------------");
    BigIntegerBitCalculation bigIntegerBitCalculation = new BigIntegerBitCalculation();
    bigIntegerBitCalculation.bigInteger();

    System.out.println("\n-----------------BigInteger 숫자 비교-----------------");
    BigIntegerComparison bigIntegerComparison = new BigIntegerComparison();
    bigIntegerComparison.bigInteger();

    System.out.println("\n-----------------BigInteger 상수-----------------");
    BigIntegerConstant bigIntegerConstant = new BigIntegerConstant();
    bigIntegerConstant.bigInteger();

    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~BIG DECIMAL~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    System.out.println("\n-----------------BigDecimal 선언-----------------");
    BigDecimalDeclaration bigDecimalDeclaration = new BigDecimalDeclaration();
    bigDecimalDeclaration.bigDecimal();

    System.out.println("\n-----------------BigDecimal 형변환-----------------");
    BigDecimalTypeConversion bigDecimalTypeConversion = new BigDecimalTypeConversion();
    bigDecimalTypeConversion.bigDecimal();

    System.out.println("\n-----------------BigDecimal 연산-----------------");
    BigDecimalCalculation bigDecimalCalculation = new BigDecimalCalculation();
    bigDecimalCalculation.bigDecimal();

    System.out.println("\n-----------------BigDecimal 숫자 비교-----------------");
    BigDecimalComparison bigDecimalComparison = new BigDecimalComparison();
    bigDecimalComparison.bigDecimal();

    System.out.println("\n-----------------BigDecimal 정밀도 값-----------------");
    BigDecimalPrecision bigDecimalPrecision = new BigDecimalPrecision();
    bigDecimalPrecision.bigDecimal();

    System.out.println("\n-----------------BigDecimal 지수 제거-----------------");
    BigDecimalRemoveExponent bigDecimalRemoveExponent = new BigDecimalRemoveExponent();
    bigDecimalRemoveExponent.bigDecimal();

    System.out.println("\n-----------------BigDecimal Exception 예시-----------------");
    BigDecimalException bigDecimalException = new BigDecimalException();
    bigDecimalException.bigDecimal();

    System.out.println("\n-----------------BigDecimal Exception 해결 방법-----------------");
    BigDecimalExceptionResult bigDecimalExceptionResult = new BigDecimalExceptionResult();
    bigDecimalExceptionResult.bigDecimal();

    System.out.println("\n-----------------BigDecimal 반올림 정책-----------------");
    BigDecimalRoundingMode bigDecimalRoundingMode = new BigDecimalRoundingMode();
    bigDecimalRoundingMode.bigDecimal();

    System.out.println("\n-----------------BigDecimal setScale 이용-----------------");
    BigDecimalSetScale bigDecimalSetScale = new BigDecimalSetScale();
    bigDecimalSetScale.bigDecimal();

    System.out.println("\n-----------------BigDecimal MathContext 이용-----------------");
    BigDecimalMathContext bigDecimalMathContext = new BigDecimalMathContext();
    bigDecimalMathContext.bigDecimal();
  }
}

class BigDecimalMathContext {
  public void bigDecimal() {
    BigDecimal bigDecimal1 = new BigDecimal("10");
    BigDecimal bigDecimal2 = new BigDecimal("3");

    System.out.println("MathContext을 이용하여 전체 자리수를 7개로 제한하고 HALF_EVEN 반올림을 적용 : " +
        bigDecimal1.divide(bigDecimal2, MathContext.DECIMAL32));

    System.out.println("MathContext을 이용하여 전체 자리수를 16개로 제한하고 HALF_EVEN 반올림을 적용 : " +
        bigDecimal1.divide(bigDecimal2, MathContext.DECIMAL64));

    System.out.println("MathContext을 이용하여 전체 자리수를 34개로 제한하고 HALF_EVEN 반올림을 적용한 : " +
        bigDecimal1.divide(bigDecimal2, MathContext.DECIMAL128));

    System.out.println(
        "MathContext을 // 전체 자리수를 제한하지 않게 적용 -> ArithmeticException 예외 발생 : "
            + "bigDecimal1.divide(bigDecimal2, MathContext.UNLIMITED) ");
  }
}

class BigDecimalSetScale {
  public void bigDecimal() {
    System.out.println("setScale을 이용하여 소수점 첫 번째까지 표현, 두번째 자리에서 반올림 지정 : " +
        BigDecimal.valueOf(12.35).setScale(1, RoundingMode.HALF_UP));

    System.out.println("setScale을 이용하여 소수점 이하 모두 제거하고 올림 지정 : " +
        BigDecimal.valueOf(12.34).setScale(0, RoundingMode.CEILING));

    System.out.println("setScale을 이용하여 음수인 경우는 특정 자릿수 이하 제거 지정 : " +
        BigDecimal.valueOf(-12.34).setScale(1, RoundingMode.CEILING));

    System.out.println("setScale을 이용하여 특정 자릿수 이하 버림 지정 : " +
        new BigDecimal("12.37").setScale(1, RoundingMode.FLOOR));

    Scanner in = new Scanner(System.in);
    System.out.println("입력 값을 setScale을 이용하여 소수점 첫 번째까지 표현, 두번째 자리에서 반올림 지정 : " +
        new BigDecimal(in.nextLine()).setScale(1, RoundingMode.HALF_UP));
  }
}

class BigDecimalRoundingMode {
  public void bigDecimal() {
    BigDecimal bigDecimal1 = new BigDecimal("10");
    BigDecimal bigDecimal2 = new BigDecimal("3");

    System.out.println("bigDecimal1.divide(bigDecimal2) -> ArithmeticException");

    System.out.println("반올림 정책으로 나누어 떨어집니다.");
    System.out.println("실수 값과 반올림 정책을 이용 : " +
        bigDecimal1.divide(bigDecimal2, RoundingMode.HALF_EVEN));

    // 반올림 자리값을 명시
    System.out.println("실수 값, 소수점 자리, 반올림 정책 이용 : " +
        bigDecimal1.divide(bigDecimal2, 6, RoundingMode.HALF_EVEN));
  }
}

class BigDecimalExceptionResult {
  public void bigDecimal() {
    BigDecimal bigDecimal1 = new BigDecimal("11");
    BigDecimal bigDecimal2 = BigDecimal.valueOf(3);
    System.out.println("ArithmeticException Result");
    // divide()의 2번째 파라미터는 N 번째 자리까지 표현할 것인가를 뜻하고, 3번째 파라미터는 반올림 정책 처리 방식이다.
    // 소수점 3번째 자리에서 반올림하여 2번째 자리까지 표기한다.
    System.out.println(bigDecimal1.divide(bigDecimal2, 2, RoundingMode.HALF_EVEN));
  }
}

class BigDecimalException {
  public void bigDecimal() {
    BigDecimal bigDecimal1 = new BigDecimal("11");
    BigDecimal bigDecimal2 = BigDecimal.valueOf(3);

//    System.out.println(bigDecimal1.divide(bigDecimal2));
    System.out.println("ArithmeticException 발생");
  }
}

class BigDecimalRemoveExponent {
  public void bigDecimal() {
    String str = "1.0E7";

    BigDecimal exponentBigDecimal = new BigDecimal(str); // 지수 붙음
    System.out.println("지수 붙은 BigDecimal : " + exponentBigDecimal); // 1.0E+7

    BigDecimal removeExponentBigDecimal = new BigDecimal(Double.parseDouble(str)); // 지수 제거
    System.out.println("지수 제거된 BigDecimal : " + removeExponentBigDecimal); // 10000000
  }
}

class BigDecimalPrecision {
  public void bigDecimal() {
    BigDecimal bigDecimal = new BigDecimal("-12345.6789");

    System.out.println("정밀도 bigDecimal.precision : " + bigDecimal.precision()); // 정밀도 : 9
    System.out.println("지수값(스케일) bigDecimal.scale : " + bigDecimal.scale()); // 지수값(스케일) : 4
    System.out.println("부호 bigDecimal.signum : " + bigDecimal.signum()); // 부호 : -1(음수)
  }
}

class BigDecimalComparison {
  public void bigDecimal() {
    BigDecimal bigNumber1 = new BigDecimal("123.45");
    BigDecimal bigNumber2 = new BigDecimal("123.456");

    int compare = bigNumber1.compareTo(bigNumber2); //-1
    System.out.println(compare);
  }
}

class BigDecimalCalculation {
  public void bigDecimal() {
    BigDecimal bigNumber1 = new BigDecimal("100.12345");
    BigDecimal bigNumber2 = new BigDecimal("10");

    System.out.println("덧셈 BigDecimal.add :" +bigNumber1.add(bigNumber2)); // 덧셈(+) :110000.12345
    System.out.println("뺄셈 BigDecimal.subtract :" +bigNumber1.subtract(bigNumber2)); // 뺄셈(-) :90000.12345
    System.out.println("곱셈 BigDecimal.multiply :" +bigNumber1.multiply(bigNumber2)); // 곱셈(*) :1000001234.50000
    System.out.println("나눗셈 BigDecimal.divide :" +bigNumber1.divide(bigNumber2)); // 나눗셈(/) :10.000012345
    System.out.println("나머지 BigDecimal.remainder :" +bigNumber1.remainder(bigNumber2)); // 나머지(%) :0.12345
  }
}

class BigDecimalTypeConversion {
  public void bigDecimal() {
    // double -> BigDecimal
    BigDecimal bigDecimal = BigDecimal.valueOf(123.456789);
    System.out.println("int -> BigDecimal : " + bigDecimal);

    // BigDecimal -> int
    int int_bigDecimal = bigDecimal.intValue();
    System.out.println("BigDecimal -> int : " + int_bigDecimal);

    // BigDecimal -> long
    long long_bigDecimal = bigDecimal.longValue();
    System.out.println("BigDecimal -> long : " + long_bigDecimal);

    // BigDecimal -> float
    float float_bigDecimal = bigDecimal.floatValue();
    System.out.println("BigDecimal -> float : " + float_bigDecimal);

    // BigDecimal -> double
    double double_bigDecimal = bigDecimal.doubleValue();
    System.out.println("BigDecimal -> double : " + double_bigDecimal);

    // BigDecimal -> String
    String String_bigDecimal = bigDecimal.toString();
    System.out.println("BigDecimal -> String : " + String_bigDecimal);
  }
}

class BigDecimalDeclaration {
  public void bigDecimal() {
    // 문자열로 생성
    BigDecimal strBigDecimal = new BigDecimal("123.456");
    System.out.println("문자열로 선언 : " + strBigDecimal);

    // double 타입으로 생성 (오차가 발생할 수 있습니다.) - 비추천
    BigDecimal doubleBigDecimal = new BigDecimal(123.456);
    System.out.println("double로 선언 : " + doubleBigDecimal);

    // valueOf 생성
    BigDecimal valueOfBigDecimal = BigDecimal.valueOf(123.456);
    System.out.println("valueOf로 선언 : " + valueOfBigDecimal);

    // 소수점 아래자리수 지정
    BigDecimal valueOfBigDecimal2 = BigDecimal.valueOf(123456L, 3);
    System.out.println("소수점 아래자리수 지정 : " + valueOfBigDecimal2);
  }
}

class BigIntegerConstant {
  public void bigInteger() {
    System.out.println("BigInteger.ZERO : " + BigInteger.ZERO);
    System.out.println("BigInteger.ONE : " + BigInteger.ONE);
    System.out.println("BigInteger.TWO : " + BigInteger.TWO);
    System.out.println("BigInteger.TEN : " + BigInteger.TEN);

    // 숫자 10을 valueOf를 통해 BigInteger 클래스로 초기화하고 연산을 해야되지만,
    System.out.println(
        "BigInteger.valueOf를 이용한 덧셈 : " +
            new BigInteger("20").add(BigInteger.valueOf(10))); // 30

    // 자주 사용되는 숫자일 경우 BigInteger 상수로 바로 계산이 가능하다는 장점이 있다
    System.out.println(
        "BigInteger.TEN을 이용한 덧셈 : " +
            new BigInteger("20").add(BigInteger.TEN)); // 30
  }
}

class BigIntegerComparison {
  public void bigInteger() {
    BigInteger bigInteger1 = new BigInteger("1000");
    BigInteger bigInteger2 = new BigInteger("10000");

    int bigIntegerCompareTo = bigInteger1.compareTo(bigInteger2);
    System.out.println("compareTo : " + bigIntegerCompareTo);
  }
}

class BigIntegerBitCalculation {
  public void bigInteger() {
    BigInteger bigInteger = new BigInteger("1018"); // 2진수로 표현하면 : 1111111010(2)

    int bitCount = bigInteger.bitCount();
    System.out.println("BitCount : " + bitCount); // 1의 갯수 : 8

    int bitLength = bigInteger.bitLength();
    System.out.println("BitLength : " + bitLength); // 비트 수 : 10

    boolean testBit3 = bigInteger.testBit(3 );
    System.out.println("testBit : " + testBit3); // true

    BigInteger setBit12 = bigInteger.setBit(12);
    System.out.println("setBit : " + setBit12); // 우측에서 13번째 비트를 1로 변경 → 1001111111010(2) → 5114

    BigInteger clearBit3 = bigInteger.clearBit(3);
    System.out.println("clearBit : " + clearBit3); // 1111110010(2) → 1010

    BigInteger flipBit0 = bigInteger.flipBit(0);
    System.out.println("flipBit : " + flipBit0); // 1111111011(2) → 1019

    BigInteger i = new BigInteger("17"); // 2진수 : 10001(2)
    BigInteger j = new BigInteger("7"); // 2진수 : 111(2)

    BigInteger and = i.and(j);
    System.out.println("and : " + and); // 10001(2) & 111(2) = 00001(2) → 1(10)

    BigInteger or = i.or(j);
    System.out.println("or : " + or); // 23

    BigInteger xor = i.xor(j);
    System.out.println("xor : " + xor); // 22

    BigInteger not = j.not();
    System.out.println("not : " + not); // -8

    BigInteger andNot = i.andNot(j);
    System.out.println("andNot : " + andNot); // 16

    BigInteger shiftLeft = i.shiftLeft(1);
    System.out.println("shiftLeft : " + shiftLeft); // 34

    BigInteger shiftRight = i.shiftRight(1);
    System.out.println("shiftRight : " + shiftRight); // 8
  }
}

class BigIntegerCalculation {
  public void binInteger() {
    BigInteger bigInteger = new BigInteger("111111111111");
    BigInteger bigInteger1 = new BigInteger("111111111111");

    System.out.println("덧셈 BigInteger.add : " + bigInteger.add(bigInteger1));
    System.out.println("뺄셈 BigInteger.subtract : " + bigInteger.subtract(bigInteger1));
    System.out.println("곱셈 BigInteger.multiply : " + bigInteger.multiply(bigInteger1));
    System.out.println("나눗셈 BigInteger.divide : " + bigInteger.divide(bigInteger1));
    System.out.println("나머지 BigInteger.remainder : " + bigInteger.remainder(bigInteger1));
  }
}

class BigIntegerTypeConversion {
  public void bigInteger() {
    // int / long -> BigInteger
    int num = 1000000000;
    BigInteger bigInteger = BigInteger.valueOf(num);
    System.out.println("int -> BigInteger : " + bigInteger);

    // BigInteger -> int
    int int_BigInt = bigInteger.intValue();
    System.out.println("BigInteger -> int : " + int_BigInt);

    // BigInteger -> long
    long long_BigLog = bigInteger.longValue();
    System.out.println("BigInteger -> long : " + long_BigLog);

    // BigInteger -> float
    float float_BigFloat = bigInteger.floatValue();
    System.out.println("BigInteger -> float : " + float_BigFloat);

    // BigInteger -> double
    double double_BigDouble = bigInteger.doubleValue();
    System.out.println("BigInteger -> double : " + double_BigDouble);

    // BigInteger -> String
    String string_BigString = bigInteger.toString();
    System.out.println("BigInteger -> String : " + string_BigString);
  }
}

class BigIntegerDeclaration {
  public void bigInteger() {
    // 문자열로 생성
    BigInteger strBigInteger = new BigInteger("111111111111111111111");
    System.out.println("문열로 선언 : " + strBigInteger);

    // 숫자로 생성
    BigInteger numBigInteger = BigInteger.valueOf(222222222);
    System.out.println("숫자로 선언 : " + numBigInteger);

    // n진수로 생성
    BigInteger nBigInteger1 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFF", 16); // 16진수
    System.out.println("16진수로 선언 : " + nBigInteger1);
    
    BigInteger nBigInteger2 = new BigInteger("00010010010010001111", 2);
    System.out.println("2진수로 선언 : " + nBigInteger2);
  }
}

