package lambdaExample;

import java.util.*;

public class LambdaBasic3 {
  public static void main(String[] args) {
    System.out.println("\n------------------Stream 기본 자료형------------------");
    BasicDataStream basicDataStream = new BasicDataStream();
    basicDataStream.basicDataStream();

    System.out.println("\n------------------Stream 기본 자료형2------------------");
    BasicDataStream2 basicDataStream2 = new BasicDataStream2();
    basicDataStream2.basicDataStream2();
  }
}

class BasicDataStream2 {
  public void basicDataStream2 () {
    ListEx listEx = new ListEx();

//    Optional<Integer> max = listEx.cities.stream()
//        .max(CityEx::getPopulation)
//        .stream().reduce(Integer::max);

    OptionalInt max = listEx.cities.stream()
        .mapToInt(CityEx::getPopulation)
        .max();

    System.out.println(max);
  }
}

class BasicDataStream {
  public void basicDataStream () {
    ListEx listEx = new ListEx();

    int sum = listEx.cities.stream()
        .mapToInt(CityEx::getPopulation) // IntStream으로 변환
        .sum();

    System.out.println(sum);
  }
}

class CityEx {
  private String name;
  private double area;     // 면적
  private int population;  // 인구
  private String areaCode; // 지역 번호

  // 필드 전체를 파라미터로 받는 생성자
  public CityEx (String name, double area, int population, String areaCode) {
    this.name = name;
    this.area = area;
    this.population = population;
    this.areaCode = areaCode;
  }

  // getter
  public String getName () {
    return name;
  }
  public double getArea () {
    return area;
  }
  public int getPopulation() {
    return population;
  }
  public String getAreaCode () {
    return areaCode;
  }
}

class ListEx {
  List<CityEx> cities = new ArrayList<>(
      Arrays.asList(
          new CityEx("Seoul", 605.2, 9720846, "02"),
          new CityEx("Incheon", 1063.3, 2947217, "032"),
          new CityEx("Ulsan", 1062, 1142190, "052"),
          new CityEx("Daegu", 883.5, 2427954, "053"),
          new CityEx("Gwangju", 501.1, 1455048, "062"),
          new CityEx("Busan", 770.1, 3404423, "051"))
  );
}
