package OOPTEST.Encapsulation4;

public class Driver {

  private String name;
  private Car car;

  public Driver (String name, Car car) {
    this.name = name;
    this.car = car;
  }

  public void drive () {
    car.startEngine();
    System.out.println(name + "의 ");
    car.moveForward();
    car.openWindow();
  }

}
