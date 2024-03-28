package OOPTEST.Encapsulation4;

public class Car {

  private String model;
  private String color;

  public Car (String model, String color) {
    this.model = model;
    this.color = color;
  }

  public void startEngine () {
    System.out.println("시동을 겁니다.");
  }

  public void moveForward () {
    System.out.println(color + " " + model + "가 앞으로 갑니다.");
  }

  public void openWindow () {
    System.out.println("창문을 엽니다.");
  }

}
