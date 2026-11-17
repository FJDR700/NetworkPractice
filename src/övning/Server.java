package övning;
import java.io.*;
import java.net.*;

public class Server {
    public void server() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println(Respond.SERVER_STARTED);
            Boolean open = true;
            while (open) {
                System.out.println(Respond.WAIT_NEXT_CLIENT);
                try (Socket client = serverSocket.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    System.out.println(Respond.CLIENT_CONNECTED);
                    String message, name;
                    name = in.readLine();
                    while ((message = in.readLine()) != null) {
                        System.out.println(name +": " + message);
                        if (message.equalsIgnoreCase("quit")) break;
                        out.println("You wrote: " + message);
                    }
                    System.out.println(Respond.SERVER_DISCONNECTED);
                    open = false;
                } catch (IOException e) {
                    System.out.println("Server error " + e.getMessage());
                }
            }
        }
    }
}
