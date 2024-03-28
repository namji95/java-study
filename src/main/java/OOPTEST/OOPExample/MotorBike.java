package OOPTEST.OOPExample;

public class MotorBike implements Vehicle{

  @Override
  public void moveForward() {
    System.out.println("오토바이가 앞으로 갑니다.");
  }

  @Override
  public void moveBackward() {
    System.out.println("오토바이가 뒤로 갑니다.");
  }
}
