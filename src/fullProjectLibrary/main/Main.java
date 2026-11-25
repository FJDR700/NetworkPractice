package fullProjectLibrary.main;

import static fullProjectLibrary.main.Utility.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addMedia(new Book("1", "Pippi långstrump", "Astrid lindgren", 1945));
        library.addMedia(new Book("2", "Pippi långstrump", "Astrid lindgren", 1945));
        library.addMedia(new Book("3", "Sagan om ringen", "Tolkien", 1954));
        library.addMedia(new Book("4", "Emil i lönneberga", "Astrid lindgren", 1964));
        library.addMedia(new Book("5", "ABC", "Astrid lindgren", 1964));

        System.out.println("Våra böcker inna alla lån");

        showCatelog(library);
        showDialog(library);
        showCatelog(library);

    }
}