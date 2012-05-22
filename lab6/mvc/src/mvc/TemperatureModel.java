/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author piotrkowalski
 */
public class TemperatureModel extends java.util.Observable {

  public double getF() {
    return temperatureF;
  }

  public double getC() {
    return (temperatureF - 32.0) * 5.0 / 9.0;
  }

  public void setF(double tempF) {
    temperatureF = tempF;
    setChanged();
    notifyObservers();
  }

  public void setC(double tempC) {
    temperatureF = tempC * 9.0 / 5.0 + 32.0;
    setChanged();
    notifyObservers();
  }
  private double temperatureF = 32.0;
}
