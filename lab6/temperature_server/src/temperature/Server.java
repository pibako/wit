package temperature;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author piotrkowalski
 */
public class Server {
  private ServerSocket serverSocket = null;

  public Server() {
    try {
      serverSocket = new ServerSocket(4444);
    } catch (IOException e) {
      System.err.println("Could not listen on port: 4444.");
      System.exit(1);
    }
  }

  public void startThread() throws IOException {
    while (true) {
      new ServerThread(serverSocket.accept()).start();
    }
  }

  public static void main(String[] args) {
    Server server = new Server();
    try {
      server.startThread();
    } catch (IOException ex) {
      System.err.println("IOException!");
      System.exit(1);
    }

  }
}
