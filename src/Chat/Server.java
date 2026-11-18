package Chat;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.concurrent.*;

public class Server {
    static void main(String[] args) {

        List<PrintWriter> clients = new CopyOnWriteArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(6000)) {
            System.out.println("Server is ready on port 6000");
            while (true) {
                Socket socket = server.accept();
                ClientHandler handler = new ClientHandler(socket, clients);
                pool.execute(handler);
            }
        } catch (IOException e) {System.out.println("Server error: "+e);}
        finally {pool.shutdown();}
    }
}
