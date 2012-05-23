/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author piotrkowalski
 */
public class MVCTempConvert {

  public static void main(String args[]) {
    TemperatureModel temperature = new TemperatureModel();
    new FarenheitGUI(temperature, 100, 100);
    new CelsiusGUI(temperature, 100, 250);
    //new CelsiusGUI(temperature,100, 400);
    new GraphGUI(temperature, 400, 200);
    new SliderGUI(temperature, 400, 100);
    new WeatherClient(temperature, 750, 100);
  }
}
