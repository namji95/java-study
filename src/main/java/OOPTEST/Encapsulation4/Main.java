package OOPTEST.Encapsulation4;

public class Main {

  public static void main(String[] args) {
    Car car = new Car("자동차", "Black");
    Driver driver = new Driver("남지", car);

    driver.drive();
  }
}
