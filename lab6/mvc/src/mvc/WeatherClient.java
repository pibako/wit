/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pi
 */
public class WeatherClient {

  private TemperatureModel model = null;
  private Button button = null;
  private Frame weatherFrame = new Frame("Auto Update");
  private WeatherClientThread weatherClientThread = null;

  public WeatherClient(TemperatureModel m, int h, int v) {
    model = m;
    button = new Button("Stop");
    weatherFrame.add(button);
    button.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent ae) {
        if (button.getLabel().equals("Start")) {
          button.setLabel("Stop");
          weatherClientThread = new WeatherClientThread(model);
          weatherClientThread.start();
        } else {
          button.setLabel("Start");
          weatherClientThread.setActive(false);
        }
      }
    });

    weatherFrame.setSize(250, 70);
    weatherFrame.setLocation(h, v);
    weatherFrame.setVisible(true);
    weatherFrame.addWindowListener(new TemperatureGUI.CloseListener());

    initialize();
  }

  private void initialize() {
    weatherClientThread = new WeatherClientThread(model);
    weatherClientThread.start();
  }

}
