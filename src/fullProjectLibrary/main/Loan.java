package fullProjectLibrary.main;

import fullProjectLibrary.main.medias.Media;
import java.time.LocalDate;

public class Loan {
    private Media media;
    private String borrower;
    private LocalDate borrowDate, dueDate;

    public Loan(Media media, String borrowed) {
        this.media = media;
        this.borrower = borrowed;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(media.loanDays());
    }

    public String getBorrower() {return borrower;}
    public LocalDate getBorrowDate() {return borrowDate;}
    public LocalDate getDueDate() {return dueDate;}
    public boolean isOverdue(LocalDate today) {return today.isAfter(dueDate);}

    @Override
    public String toString() {
        return media.getTitle()+" lånades av "+ borrower + " åter senast " +dueDate;
    }
}
