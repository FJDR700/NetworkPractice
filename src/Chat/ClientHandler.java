package Chat;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {

    private final Socket socket;
    private final List<PrintWriter> clients;

    public ClientHandler(Socket socket, List<PrintWriter> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    @Override
    public void run() {

        PrintWriter out = null;
        String name = "Unknown: ";
        try (Socket client = socket){

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
            String message = in.readLine(),userMessage;

            if (message == null|| message.isBlank()) return;
            name = message.trim();
            clients.add(out);

            out.println("Welcome "+name+" Write /quit to leave.");
            System.out.println(name+" was connected. Online: "+clients.size());

            while ((userMessage = in.readLine()) != null) {
                if (userMessage.equalsIgnoreCase("/quit")) break;
            }
            for (var receiver : clients) {
                synchronized (receiver) {
                    receiver.println(name+": "+userMessage);
                }
            }
        } catch (IOException e) {System.out.println("Client error: " + e.getMessage());}
        finally {if (out != null) clients.remove(out);
            System.out.println(name+" has left: Online: "+ clients.size());
        }
    }
}
