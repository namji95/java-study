package OOPTEST;

public class MotorBike1 extends Vehicle1{
  boolean isRaceable;

  @Override
  void moveForward() {
    System.out.println("오토바이가 앞으로 갑니다.");
  }

  public void stunt() {
    System.out.println("오토바이로 묘기를 부립니다.");
  }
}
