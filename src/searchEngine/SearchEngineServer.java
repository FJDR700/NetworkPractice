package searchEngine;

import java.io.*;
import java.net.*;
import java.util.*;

public class SearchEngineServer {
    private static void search(String search, List<String> list) {
        List<String> fileLines = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File(Texts.FILE.toString()));
            while(in.hasNextLine()) {fileLines.add(in.nextLine());}
            Collections.sort(fileLines);
            for (var line : fileLines) {
                if (line.toLowerCase().contains(search.toLowerCase().trim())
                    && !search.isBlank()) list.add(line);}
            in.close();
        } catch (Exception e){System.out.println(Texts.DATABASE_NOT_FOUND.toString() + e);}
    }

    static void main(String[] args) throws IOException {
        try (ServerSocket socket = new ServerSocket(9000)) {
            System.out.println(Texts.SEARCH_IS_LIVE);
            while (true) {
                try (Socket client = socket.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    List<String> foundLines = new ArrayList<>();

                    search(in.readLine(), foundLines);
                    for (var line : foundLines) {out.println(line);}
                } catch (IOException e) {}
            }
        }
    }
}
