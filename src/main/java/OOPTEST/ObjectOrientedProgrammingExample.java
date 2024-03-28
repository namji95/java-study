package OOPTEST;

public class ObjectOrientedProgrammingExample {

  public static void main(String[] args) {
    Car car = new Car();
    car.startEngine();
    car.moveForward();
    car.moveBackward();

    System.out.println("--------------------------------------");

    Car1 car1 = new Car1();
    car1.start();
    car1.moveForward();
    car1.moveBackward();
    MotorBike motorBike = new MotorBike();
    motorBike.start();
    motorBike.moveForward();
    motorBike.moveBackward();

    System.out.println("--------------------------------------");
  }
}

class Car {
  // 속성 정의
  String company;
  String model;
  String color;
  int wheel;
  boolean isConvertible;

  // 기능 정의
  void startEngine() {
    System.out.println("시동을 겁니다.");
  }

  void moveForward() {
    System.out.println("자동차가 앞으로 갑니다.");
  }

  void moveBackward() {
    System.out.println("자동차가 뒤로 갑니다.");
  }
}

interface Vehicle {
  public abstract void start();

  // public abstract는 생략해도 됩니다.
  void moveForward();
  void moveBackward();
}

class Car1 implements Vehicle {
  @Override
  public void start() {
    System.out.println("자동차 시동을 겁니다.");
  }

  @Override
  public void moveForward() {
    System.out.println("자동차가 앞으로 갑니다.");
  }
  @Override
  public void moveBackward() {
    System.out.println("자동차가 뒤로 갑니다.");
  }
}

class MotorBike implements Vehicle {
  @Override
  public void start() {
    System.out.println("오토바이 시동을 겁니다.");
  }

  @Override
  public void moveForward() {
    System.out.println("오토바이가 앞으로 갑니다.");
  }

  @Override
  public void moveBackward() {
    System.out.println("오토바이가 뒤로 갑니다.");
  }
}
