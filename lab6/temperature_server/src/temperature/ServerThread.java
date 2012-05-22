package temperature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author piotrkowalski
 */
class ServerThread extends Thread {

  private Socket socket = null;
  /*
   * Lokalny model temperatury - dane normalnie pobierane z czujnika.
   */
  int temperature = 10;

  public ServerThread(Socket socket) {
    super("ServerThread");
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
              new InputStreamReader(
              socket.getInputStream()));

      String inputLine, outputLine = null;

      // jezeli klient zamknie polaczenie
      while ((inputLine = in.readLine()) != null) {
        if (inputLine.equals("temperatura")) {
          try {
            sleep(1000);
          } catch (InterruptedException ex) {
            System.err.println("Blad podczas usypiania watka");
          }

          //przypisanie nowej temperatury z przedzialu -20 do 30
          temperature = new Random().nextInt(50) - 20;

          outputLine = Integer.toString(temperature);
          out.println(outputLine);
        } else if (outputLine.equals("Bye")) {
          break;
        }

      }
      out.close();
      in.close();
      socket.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
