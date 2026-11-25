package fullProjectLibrary.main;

public class Book implements Comparable<Book> {

    private String id, title, author;
    private int year, createdBooks;
    boolean borrowed;
    private static Status status;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.status = Status.AVAILABLE;
        createdBooks++;
    }

    public int getCreatedBooks() {return createdBooks;}
    public String getId() {return id;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public int getYear() {return year;}

    public boolean isAvailable() {return status == Status.AVAILABLE;}

    public static boolean borrow() {
        if (status != Status.AVAILABLE) {return false;}
        status = Status.BORROWED;
        return true;
    }

    public boolean returnItem() {
        if ( status != Status.BORROWED) {return false;}
        status = status.AVAILABLE;
        return true;
    }

    @Override
    public String toString() {return id+" | "+title+" | "+author+" | "+status;}

    @Override
    public int compareTo(Book other) {
        return getTitle().compareToIgnoreCase(other.getTitle());
    }
}
