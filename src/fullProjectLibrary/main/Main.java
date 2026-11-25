package fullProjectLibrary.main;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        library.addMedia(new Book("1", "Pippi Långstrump", "Astrid Lindgren", 1945));
        library.addMedia(new Book("2", "Pippi Långstrump", "Astrid Lindgren", 1945));
        library.addMedia(new Book("3", "Sagan om Ringen", "Tolkien", 1954));
        library.addMedia(new Book("4", "Emil i Lönneberg", "Astrid Lindgren", 1964));

        System.out.println("");

        for ( var book: library.getSortedMedia()){
            System.out.println(book);
        }

        System.out.println("Lån lyckades: "+ library.borrow("1", "Fausto"));
        System.out.println("Lån lyckades: "+ library.borrow("2", "Emily"));

        System.out.println("Alla lånetagare i vårt system "+ library.getBorrowers());

        System.out.println("");

        //Book book = new Book("1", "Pippi Långstrump", "Astrid Lindgren", 1945);





    }

    public static void showCatelog(){

    }

    public static void showDialog(){


    }
}
