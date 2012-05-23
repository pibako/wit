package temperature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author piotrkowalski
 */
public class Client {

  public Client() throws IOException {
    Socket clientSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;

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

    String fromServer;
    String fromClient = "temperatura";

    out.println(fromClient);

    while ((fromServer = in.readLine()) != null) {
      System.out.println("Server: " + fromServer);
      if (fromServer.equals("Bye.")) {
        break;
      }

      out.println(fromClient);
    }
    out.close();
    in.close();
    clientSocket.close();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {
    new Client();
  }
}
