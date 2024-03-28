package OOPTEST.Encapsulation3;

import java.awt.event.MouseWheelListener;

public class Car {
  private String model;
  private String color;
  private int wheel;

  public String getModel () {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor () {
    return color;
  }

  public void setColor (String color) {
    this.color = color;
  }

  public int getWheel () {
    return wheel;
  }

  public void setWheel (int wheel) {
    this.wheel = wheel;
  }

}
