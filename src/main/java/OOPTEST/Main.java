package OOPTEST;

public class Main {

  public static void main(String[] args) {
    // 객체 생성
    Car2 car2 = new Car2();
    MotorBike1 motorBike1 = new MotorBike1();

    // car2 객체의 속성 정의
    car2.model = "자동차";
    car2.color = "색상";

    System.out.println("나의 " + car2.color + " " + car2.model + "입니다.");

    // 객체들의 기능 실행
    car2.moveForward();
    motorBike1.moveForward();
    motorBike1.moveBackward();

//    Vehicle1 car3 = new Car2();
  }
}
