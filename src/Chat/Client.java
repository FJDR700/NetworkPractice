package Chat;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

    private final BufferedReader in;
    public Client(BufferedReader in) {this.in = in;}

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {System.out.println("Connection is closed.");}
    }

    static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 7000)) {
            Scanner scan = new Scanner(System.in);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Write your name: ");

            String name = scan.nextLine();
            out.println(name);

            Thread receiver = new Thread(new Client(in));

            receiver.setDaemon(true);
            receiver.start();

            while (scan.hasNextLine()) {
                String message = scan.nextLine();
                out.println(message);
                if (message.equalsIgnoreCase("/quit")) break;
            }

        } catch (IOException e) {
            System.out.println("Couldn't connect: "+e.getMessage());
        }
    }
}
