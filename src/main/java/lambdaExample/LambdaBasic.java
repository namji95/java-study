package lambdaExample;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaBasic {
  public static void main(String[] args) {
    System.out.println("\n------------------Collection 이용------------------");
    CollectionExample collectionExample = new CollectionExample();
    collectionExample.collectionExample();

    System.out.println("\n------------------Lambda 이용------------------");
    UsingLambda usingLambda = new UsingLambda();
    usingLambda.usingLambda();
  }
}

class UsingLambda {
  public void usingLambda() {
    ListBox listBox = new ListBox();

    List<String> streamNameList = listBox.cities.stream()
        .filter(city -> city.getArea() > 800)
        .sorted(Comparator.comparing(City::getArea))
        .map(City::getName)
        .collect(Collectors.toList());

    System.out.println(streamNameList);
  }
}

class CollectionExample {
  public void collectionExample() {
    ListBox listBox = new ListBox();
    List<City> largeCities = new ArrayList<>();

    for (City city : listBox.cities) {
      if (city.getArea() > 800) {
        largeCities.add(city);
      }
    }

    Collections.sort(largeCities, new Comparator<City>() {
      @Override
      public int compare(City o1, City o2) {
        return (int)(o1.getArea() - o2.getArea());
      }
    });

    List<String> largeCityNames = new ArrayList<>();
    for (City city : largeCities) {
      largeCityNames.add(city.getName());
    }

    System.out.println(largeCityNames);
  }
}

class City {
  private String name;
  private double area;     // 면적
  private int population;  // 인구
  private String areaCode; // 지역 번호

  // 필드 전체를 파라미터로 받는 생성자
  public City (String name, double area, int population, String areaCode) {
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
  public int getPopulation () {
    return population;
  }
  public String getAreaCode () {
    return areaCode;
  }
}

class ListBox {
  List<City> cities = Arrays.asList(
      new City("Seoul", 605.2, 9720846, "02"),
      new City("Incheon", 1063.3, 2947217, "032"),
      new City("Busan", 770.1, 3404423, "051"),
      new City("Gwangju", 501.1, 1455048, "062"),
      new City("Daegu", 883.5, 2427954, "053"),
      new City("Ulsan", 1062, 1142190, "052"));
}
