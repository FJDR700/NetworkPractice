package övning;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Server server = new Server();
        Client client = new Client();
        Scanner sc = new Scanner(System.in);
        boolean end = false;

        while (!end){
            System.out.print(Respond.MAIN_CHOOSE);
            switch (sc.nextLine()) {
                case "1": {server.server(); break;}
                case "2": {client.client(); break;}
                default: end = true;
            }
        }
    }
}
