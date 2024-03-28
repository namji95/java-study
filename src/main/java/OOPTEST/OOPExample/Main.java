package OOPTEST.OOPExample;

public class Main {
  public static void main(String[] args) {
    Car car = new Car();
    MotorBike motorBike = new MotorBike();
    Driver driver = new Driver();

    driver.drive(car);
    driver.drive(motorBike);
  }
}
