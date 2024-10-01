package timeClass;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateCalculation {

  public static void main(String[] args) {
    System.out.println("\n-----------------LocalDate 더하기 계산식-----------------");
    PlusLocalDate plusDate = new PlusLocalDate();
    plusDate.plusLocalDate();

    System.out.println("\n-----------------LocalDateTime 더하기 계산식-----------------");
    PlusLocalDateTime plusLocalDateTime = new PlusLocalDateTime();
    plusLocalDateTime.plusLocalDateTime();

    System.out.println("\n-----------------LocalDate 빼기 계산식-----------------");
    MinusLocalDate minusLocalDate  = new MinusLocalDate();
    minusLocalDate.minusLocalDate();

    System.out.println("\n-----------------LocalDateTime 빼기 계산식-----------------");
    MinusLocalDateTime minusLocalDateTime = new MinusLocalDateTime();
    minusLocalDateTime.minusLocalDateTime();
  }
}

class PlusLocalDate {
  public void plusLocalDate() {
    LocalDate nowDate = LocalDate.now();
    LocalDate plusOneDay = nowDate.plusDays(1);
    LocalDate plusOneWeek = nowDate.plusWeeks(1);
    LocalDate plusOneMonth = nowDate.plusMonths(1);
    LocalDate plusOneYear = nowDate.plusYears(1);

    System.out.println("현재 시간 LocalDate.now()) : " + nowDate);
    System.out.println("현재 시간 더하기 1일 nowDate.plusDays(1) : " + plusOneDay);
    System.out.println("현재 시간 더하기 1주일 nowDate.plusWeeks(1) : " + plusOneWeek);
    System.out.println("현재 시간 더하기 1달 nowDate.plusMonths(1) : " + plusOneMonth);
    System.out.println("현재 시간 더하기 1년 nowDate.plusYear(1) : " + plusOneYear);
  }
}

class PlusLocalDateTime {
  public void plusLocalDateTime() {
    LocalDateTime nowDateTime = LocalDateTime.now();
    LocalDateTime plusOneHour = nowDateTime.plusHours(1);
    LocalDateTime plusTenMinutes = nowDateTime.plusMinutes(30);
    LocalDateTime plusFiveSeconds = nowDateTime.plusSeconds(30);
    LocalDateTime plusOneHundredNanos = nowDateTime.plusNanos(100);

    System.out.println("현재 시간 LocalDateTime.now()) : " + nowDateTime);
    System.out.println("현재 시간 더하기 1시간 nowDateTime.plusHours(1) : " + plusOneHour);
    System.out.println("현재 시간 더하기 30분 nowDateTime.plusMinutes(30) : " + plusTenMinutes);
    System.out.println("현재 시간 더하기 30초 nowDateTime.plusSeconds(30) : " + plusFiveSeconds);
    System.out.println("현재 시간 더하기 100나노초(10^6) nowDateTime.plusNanos(100) : " + plusOneHundredNanos);
  }
}

class MinusLocalDate {
  public void minusLocalDate() {
    LocalDate nowDate = LocalDate.now();
    LocalDate minusOneDay = nowDate.minusDays(1);
    LocalDate minusTwoWeeks = nowDate.minusWeeks(1);
    LocalDate minusThreeMonths = nowDate.minusMonths(1);
    LocalDate minusFourYears = nowDate.minusYears(1);

    System.out.println("현재 시간 LocalDate.now() : " + nowDate);
    System.out.println("현재 시간 빼기 1일 nowDate.minusDays(1) : " + minusOneDay);
    System.out.println("현재 시간 빼기 1주일 nowDate.minusWeeks(1) : " + minusTwoWeeks);
    System.out.println("현재 시간 빼기 1달 nowDate.minusMonths(1) : " + minusThreeMonths);
    System.out.println("현재 시간 빼기 1년 nowDate.minusYears(1) : " + minusFourYears);
  }
}

class MinusLocalDateTime {
  public void minusLocalDateTime() {
    LocalDateTime nowDateTime = LocalDateTime.now();
    LocalDateTime minusOneHour = nowDateTime.minusHours(1);
    LocalDateTime minusFiveMinutes = nowDateTime.minusMinutes(30);
    LocalDateTime minusTenSeconds = nowDateTime.minusSeconds(30);
    LocalDateTime minusTenNanos = nowDateTime.minusNanos(100);

    System.out.println("현재 시간 LocalDateTime.now() : " + nowDateTime);
    System.out.println("현재 시간 빼기 1시간 nowDateTime.minusHours(1) : " + minusOneHour);
    System.out.println("현재 시간 빼기 1분 nowDateTime.minusMinutes(5) : " + minusFiveMinutes);
    System.out.println("현재 시간 빼기 1초 nowDateTime.minusSeconds(10) : " + minusTenSeconds);
    System.out.println("현재 시간 빼기 1나노초(10^6) nowDateTime.minusNanos(10) : " + minusTenNanos);
  }
}
