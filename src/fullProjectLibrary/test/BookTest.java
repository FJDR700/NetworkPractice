package fullProjectLibrary.test;

import fullProjectLibrary.main.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {


    @Test
    void borrowShouldMakeBookUnavailable() {

        //Arrange
        Book book = new Book("1", "Pippi Långstrump", "Astrid Lindgren", 1945);

        //Act
        boolean success = Book.borrow();

        //Assert
        assertTrue(success);
        assertFalse(book.isAvailable());
    }
}
