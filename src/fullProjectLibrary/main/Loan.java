package fullProjectLibrary.main;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private String borrower;
    private LocalDate borrowDate, dueDate;
    private int userId;

    public Loan(Book book, String borrowed) {
        this.book = book;
        this.borrower = borrowed;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(28);
    }

    public String getBorrower() {return borrower;}
    public LocalDate getBorrowDate() {return borrowDate;}
    public LocalDate getDueDate() {return dueDate;}

    @Override
    public String toString() {
        return book.getTitle()+" lånades av: "+ borrower +" "+ userId+ " åter senast " +dueDate;
    }
}
