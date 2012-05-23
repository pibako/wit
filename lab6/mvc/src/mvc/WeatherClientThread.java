package mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pi
 */
public class WeatherClientThread extends Thread {

  private TemperatureModel model;
  private boolean active = true;
  private Socket clientSocket = null;
  private PrintWriter out = null;
  private BufferedReader in = null;

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public WeatherClientThread(TemperatureModel model) {
    this.model = model;

    try {
      clientSocket = new Socket("localhost", 4444);
      out = new PrintWriter(clientSocket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host: localhost.");
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to: localhost.");
      System.exit(1);
    }
  }

  @Override
  public void run() {
    String fromServer = null;
    String fromClient = "temperatura";
    try {
      out.println(fromClient);
      while (active && ((fromServer = in.readLine()) != null)) {
        if (fromServer.equals("Bye.")) {
          break;
        }
        model.setC(Double.parseDouble(fromServer));
        out.println(fromClient);
      }
    } catch (IOException ex) {
      Logger.getLogger(WeatherClientThread.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
