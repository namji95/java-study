package OOPTEST;

public class Main2 {

  public static void main(String[] args) {
    Car2 car2 = new Car2();
    MotorBike1 motorBike1 = new MotorBike1();
    Driver driver = new Driver();


    driver.drive(car2);
    driver.drive(motorBike1);
  }
}
