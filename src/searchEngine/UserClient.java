package searchEngine;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class UserClient {
    public static void main(String[] args) throws IOException {
        while(true){
            Scanner scan = new Scanner(System.in);
            try (Socket socket = new Socket("localhost", 9000)) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                boolean found = false;
                System.out.print(Texts.SEARCH);
                String search = scan.nextLine();
                out.println(search);
                if (search.equalsIgnoreCase("/quit")) break;

                System.out.println(Texts.RESULTS);
                for (var line : in.readAllLines()) {found = true; System.out.println(line);}
                if (!found) System.out.println(Texts.NO_RESULTS);
                System.out.println();
            }catch (IOException e){
                System.out.print(Texts.CLIENT_CHOOSE);
                if (scan.nextLine().toLowerCase().trim().equals("/quit")) break;
            }
        }
        System.out.println(Texts.END_SEARCH);
    }
}
