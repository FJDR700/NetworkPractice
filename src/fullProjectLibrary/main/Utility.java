package fullProjectLibrary.main;

public class Utility {
    public static void showCatelog(Library library) {
        for ( Media media: library.getSortedMedia() ) {
            System.out.println(media);
        }
    }

    public static void showDialog(Library library) {
        System.out.println("Lån lyckades "+library.borrow("1","Fausto")+
                "\nLån lyckades "+library.borrow("1","Javier")+
                "\nLån lyckades "+library.borrow("2","Yahya")+
                "\nAlla lånetagare i vårt system "+library.getBorrowers()+
                "\nVåra böcker efter alla lån");
    }
}
