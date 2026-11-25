package fullProjectLibrary.test;

import fullProjectLibrary.main.medias.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {


    @Test
    void borrowShouldMakeBookUnavailable() {

        //Arrange
        Book book = new Book("1", "Pippi Långstrump", "Astrid Lindgren", 1945);

        //Act
        boolean success = book.borrow();

        //Assert
        assertTrue(success);
        assertFalse(book.isAvailable());
    }
}
