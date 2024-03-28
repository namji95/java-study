package OOPTEST;

public class Main1 {

  public static void main(String[] args) {
    Vehicle1[] vehicles1 = new Vehicle1[2];
    vehicles1[0] = new Car2();
    vehicles1[1] = new MotorBike1();

    for (Vehicle1 vehicle1 : vehicles1) {
      System.out.println(vehicle1.getClass()); // 각각의 클래스를 호출해주는 메서드
    }
  }

}
