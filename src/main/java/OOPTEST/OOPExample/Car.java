package OOPTEST.OOPExample;

public class Car implements Vehicle{

  @Override
  public void moveForward() {
    System.out.println("자동차가 앞으로 갑니다.");
  }

  @Override
  public void moveBackward() {
    System.out.println("자동차가 뒤로 갑니다.");
  }

}
