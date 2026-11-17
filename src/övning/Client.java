package övning;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void client() {
        Scanner scan = new Scanner(System.in);
        boolean open = true;
        while(open) {
            try (Socket socket = new Socket("localhost", 5000)) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String name = "";
                while (name.isBlank()) {
                    System.out.print(Respond.YOUR_NAME);
                    name = scan.nextLine().trim();
                }
                out.println(name);
                System.out.println(Respond.SERVER_CONNECTED);
                while (true){
                    System.out.print(Respond.WRITE_MESSAGE);
                    String message = scan.nextLine();
                    out.println(message);
                    String response = in.readLine();
                    if (response == null){
                        System.out.println(Respond.SERVER_DISCONNECTED);
                        break;
                    }
                    if (message.equalsIgnoreCase("QUIT")) break;
                } break;
            } catch (IOException e){
                System.out.print(Respond.CLIENT_CHOOSE);
                if (scan.nextLine().toLowerCase().trim().equals("q")) open = false;
            }
        }
    }
}
