import org.example.librarybackend.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTests {

    //tests for the Book class
    @Test
    public void testBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Assertions.assertEquals("The Great Gatsby", book.getTitle());
        Assertions.assertEquals("F. Scott Fitzgerald", book.getAuthor());
        Assertions.assertEquals(1925, book.getYearPublished());
    }
}
