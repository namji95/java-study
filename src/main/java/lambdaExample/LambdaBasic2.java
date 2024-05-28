package lambdaExample;

import java.nio.file.spi.FileSystemProvider;
import java.util.*;
import java.util.stream.Collectors;
import javax.xml.transform.Source;

public class LambdaBasic2 {
  public static void main(String[] args) {
    System.out.println("\n------------------Stream 데이터 선별------------------");
    DataSelect dataSelect = new DataSelect();
    dataSelect.dataSelect();

    System.out.println("\n------------------Stream 데이터 선별2------------------");
    DataSelect2 dataSelect2 = new DataSelect2();
    dataSelect2.dataSelect2();

    System.out.println("\n------------------Stream 데이터 선별3------------------");
    DataSelect3 dataSelect3 = new DataSelect3();
    dataSelect3.dataSelect3();

    System.out.println("\n------------------Stream 데이터 개수 조절------------------");
    DataCountControl dataCountControl = new DataCountControl();
    dataCountControl.dataCountControl();

    System.out.println("\n------------------Stream 데이터 변환------------------");
    DataConversion dataConversion = new DataConversion();
    dataConversion.dataConversion();

    System.out.println("\n------------------Stream 데이터 변환2------------------");
    DataConversion2 dataConversion2 = new DataConversion2();
    dataConversion2.dataConversion2();

    System.out.println("\n------------------Stream 데이터 일치 여부------------------");
    DataMatch dataMatch = new DataMatch();
    dataMatch.dataMatch();

    System.out.println("\n------------------Stream 데이터 검색------------------");
    DataSearch dataSearch = new DataSearch();
    dataSearch.dataSearch();

    System.out.println("\n------------------Stream 데이터 연산------------------");
    DataOperation dataOperation = new DataOperation();
    dataOperation.dataOperation();

    System.out.println("\n------------------Stream 최종 연산------------------");
    FinalStream finalStream = new FinalStream();
    finalStream.finalStream();
  }
}

class FinalStream {
  public void finalStream() {
    ListClass listClass = new ListClass();

    List<String> streamList = listClass.cities.stream()
        .filter(exCity -> exCity.getArea() > 800)
        .sorted(Comparator.comparing(ExCity::getArea))
        .map(ExCity::getName)
        .collect(Collectors.toList());

    System.out.println("\nStream List");
    System.out.println(streamList);

    Map<String, List<ExCity>> streamMap = listClass.cities.stream()
        .filter(exCity -> exCity.getArea() > 800)
        .collect(Collectors.groupingBy(ExCity::getName));

    System.out.println("\nStream Map");
    streamMap.forEach((city, exCities) -> {
      System.out.println("City : " + city);
      exCities.forEach(exCity -> System.out.println(
          exCity.getName() + " " +
          exCity.getArea() + " " +
          exCity.getAreaCode() + " " +
          exCity.getPopulation()
          ));
    });

    Set<ExCity> streamSet = listClass.cities.stream()
        .filter(exCity -> exCity.getArea() > 800)
        .collect(Collectors.toSet());

    System.out.println("\nStream Set");
    for (ExCity exCity : streamSet) {
      System.out.println(
          exCity.getName() + " " +
          exCity.getArea() + " " +
          exCity.getAreaCode() + " " +
          exCity.getPopulation());
    }

    System.out.println("\nStream Count");
    System.out.println(listClass.cities.stream().count());

    System.out.println("\nStream forEach");
    listClass.cities.stream().map(ExCity::getName).forEach(System.out::println);
  }
}

class DataOperation {
  public void dataOperation () {
    Random random = new Random();

    int[] arr = new int[100];
    for (int i = 0; i < 100; i++) {
      arr[i] = random.nextInt(100);
    }

    int sum = 0;
    for (int num : arr) {
      sum += num;
    }

    System.out.println("일반 연산");
    System.out.println(sum);

    int streamSum = Arrays.stream(arr)
        .reduce(0, Integer::sum);

    System.out.println("스트림 연산");
    System.out.println(streamSum);
  }
}

class DataSearch {
  public void dataSearch () {
    ListClass listClass = new ListClass();

    Optional<ExCity> findAny = listClass.cities.stream()
        .filter(exCity -> exCity.getArea() > 500)
        .findAny();

    System.out.println("Stream Find Any");
    System.out.println(findAny.get().getName());

    Optional<ExCity> findFirst = listClass.cities.stream()
        .filter(exCity -> exCity.getArea() > 500)
        .findFirst();

    System.out.println("Stream Find First");
    System.out.println(findFirst.get().getName());
  }
}

class DataMatch {
  public void dataMatch () {
    ListClass listClass = new ListClass();

    boolean streamAnyMatch = listClass.cities.stream()
        .anyMatch(exCity -> exCity.getArea() > 1000);

    boolean streamAnyMatch2 = listClass.cities.stream()
        .anyMatch(exCity -> exCity.getArea() > 2000);

    System.out.println("Stream Any Math 1000");
    System.out.println(streamAnyMatch);
    System.out.println("Stream Any Math 2000");
    System.out.println(streamAnyMatch2);

    boolean streamAllMatch = listClass.cities.stream()
        .allMatch(exCity -> exCity.getArea() > 100);

    boolean streamAllMatch2 = listClass.cities.stream()
        .allMatch(exCity -> exCity.getArea() > 1000);

    System.out.println("Stream All Match 100");
    System.out.println(streamAllMatch);
    System.out.println("Stream All Match 1000");
    System.out.println(streamAllMatch2);

    boolean streamNoneMatch = listClass.cities.stream()
        .noneMatch(exCity -> exCity.getArea() > 1000);
    boolean streamNoneMatch2 = listClass.cities.stream()
        .noneMatch(exCity -> exCity.getArea() > 2000);

    System.out.println("Stream None Match 1000");
    System.out.println(streamNoneMatch);
    System.out.println("Stream None Match 2000");
    System.out.println(streamNoneMatch2);
  }
}

class DataConversion2 {
  public void dataConversion2 () {
    ListClass listClass = new ListClass();

    List<String> streamMap2 = listClass.cities.stream()
        .map(ExCity::getAreaCode)
        .collect(Collectors.toList());

    System.out.println("Stream Map2");
    System.out.println(streamMap2);

    List<String> streamSplit = streamMap2.stream()
        .map(areaCode -> areaCode.split(""))
        .flatMap(Arrays::stream)
        .distinct()
        .collect(Collectors.toList());

    System.out.println("Stream Split");
    System.out.println(streamSplit);
  }
}

class DataConversion {
  public void dataConversion () {
    ListClass listClass = new ListClass();

    List<String> streamMap = listClass.cities.stream()
        .filter(exCity -> exCity.getArea() > 800)
        .sorted(Comparator.comparing(ExCity::getArea))
        .map(exCity -> exCity.getName())
//        .map(ExCity::getName) 위와 똑같은 역할입니다.
        .collect(Collectors.toList());

    System.out.println("Stream Map");
    System.out.println(streamMap);
  }
}

class DataCountControl {
  public void dataCountControl() {
    ListClass listClass = new ListClass();

    // limit을 이용하여 수집 개수 조절
    List<String> streamLimit = listClass.cities.stream()
        .filter(exCity -> exCity.getArea() > 800)
        .sorted(Comparator.comparing(ExCity::getArea))
        .map(ExCity::getName)
        .limit(2)                               // 최소 2개의 원소만 반환합니다.
        .collect(Collectors.toList());

    System.out.println("Stream Limit");
    System.out.println(streamLimit);

    // skip을 이용하여 데이터 건너뛰기
    List<String> streamSkip = listClass.cities.stream()
        .filter(exCity -> exCity.getArea() > 800)
        .sorted(Comparator.comparing(ExCity::getArea))
        .map(ExCity::getName)
        .skip(1)                                      // 첫 번째 원소는 뛰어넘습니다.
        .collect(Collectors.toList());

    System.out.println("Stream Skip");
    System.out.println(streamSkip);
  }
}

class DataSelect3 {
  public void dataSelect3 () {
    ListClass listClass = new ListClass();

    // dropWhile은 true가 되면 멈추고 나머지 데이터는 버립니다.
    List<String> streamSelectAsc = listClass.cities.stream()
        .sorted(Comparator.comparing(ExCity::getArea))
        .dropWhile(exCity -> exCity.getArea() > 700)
        .map(ExCity::getName)
        .collect(Collectors.toList());

    System.out.println("dropWhile 오름차순 정렬");
    System.out.println(streamSelectAsc);

    List<String> streamSelectDesc = listClass.cities.stream()
        .sorted(Comparator.comparing(ExCity::getArea).reversed())
        .dropWhile(exCity -> exCity.getArea() > 700)
        .map(ExCity::getName)
        .collect(Collectors.toList());

    System.out.println("dropWhile 내림차순 정렬");
    System.out.println(streamSelectDesc);
  }
}

class DataSelect2 {
  public void dataSelect2 () {
    ListClass listClass = new ListClass();

    // takeWhile은 false가 되면 멈추고 나머지 데이터는 버립니다.
    List<String> streamSelectAsc = listClass.cities.stream()
        .sorted(Comparator.comparing(ExCity::getArea))
        .takeWhile(exCity -> exCity.getArea() > 700)
        .map(ExCity::getName)
        .collect(Collectors.toList());

    System.out.println("takeWhile 오름차순 정렬");
    System.out.println(streamSelectAsc);

    // area를 역순 정렬하여 비교해 보겠습니다.
    List<String> streamSelectDesc = listClass.cities.stream()
        .sorted(Comparator.comparing(ExCity::getArea).reversed())
        .takeWhile(exCity -> exCity.getArea() > 700)
        .map(ExCity::getName)
        .collect(Collectors.toList());

    System.out.println("takeWhile 내림차순 정렬");
    System.out.println(streamSelectDesc);
  }
}

class DataSelect {
  public void dataSelect () {
    ListClass listClass = new ListClass();
    listClass.cities.add(new ExCity("Seoul", 0, 0, "02"));

    System.out.println("배열 추가 시");
    for (ExCity city : listClass.cities) {
      System.out.println(
          city.getName() + " " +
          city.getArea() + " " +
          city.getPopulation() + " " +
          city.getAreaCode());
    }

    List<ExCity> streamSelect = listClass.cities.stream()
        .filter(exCity -> exCity.getArea() > 600) // 데이터 필터링
        .distinct()                           // 중복 제거
        .collect(Collectors.toList());

    System.out.println("\n중복 제거 시");
    for (ExCity city : streamSelect) {
      System.out.println(
          city.getName() + " " +
          city.getArea() + " " +
          city.getPopulation() + " " +
          city.getAreaCode());
    }
  }
}

class ExCity {
  private String name;
  private double area;     // 면적
  private int population;  // 인구
  private String areaCode; // 지역 번호

  // 필드 전체를 파라미터로 받는 생성자
  public ExCity (String name, double area, int population, String areaCode) {
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

class ListClass {
  List<ExCity> cities = new ArrayList<>(
      Arrays.asList(
          new ExCity("Seoul", 605.2, 9720846, "02"),
          new ExCity("Incheon", 1063.3, 2947217, "032"),
          new ExCity("Ulsan", 1062, 1142190, "052"),
          new ExCity("Daegu", 883.5, 2427954, "053"),
          new ExCity("Gwangju", 501.1, 1455048, "062"),
          new ExCity("Busan", 770.1, 3404423, "051"))
  );
}
