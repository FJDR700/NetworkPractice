package fullProjectLibrary.main;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        library.addBook(new Book("1", "Pippi Långstrump", "Astrid Lindgren", 1945));
        library.addBook(new Book("2", "Pippi Långstrump", "Astrid Lindgren", 1945));
        library.addBook(new Book("3", "Sagan om Ringen", "Tolkien", 1954));
        library.addBook(new Book("4", "Emil i Lönneberg", "Astrid Lindgren", 1964));

        System.out.println("");

        for ( var book: library.getSortedBooks()){
            System.out.println(book);
        }

        System.out.println("Lån lyckades: "+ library.borrow("1", "Fausto"));
        System.out.println("Lån lyckades: "+ library.borrow("2", "Emily"));

        System.out.println("Alla lånetagare i vårt system "+ library.getBorrowers());

        System.out.println("");

        //Book book = new Book("1", "Pippi Långstrump", "Astrid Lindgren", 1945);





    }
}
