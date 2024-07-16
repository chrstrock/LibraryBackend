package org.example.librarybackend;

import org.example.librarybackend.services.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTests {

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private final BookService bookService = new BookService(bookRepository);



    @Test
    public void testCreateBook() {

        Book testBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        when(bookRepository.save(any(Book.class))).thenReturn(testBook);
        bookService.createBook(testBook);
        when(bookRepository.findBookByTitle("The Great Gatsby"))
                .thenReturn(testBook);
        Book foundBook = bookService.findBookByTitle("The Great Gatsby");
        assertEquals("The Great Gatsby", foundBook.getTitle());
        assertEquals("F. Scott Fitzgerald", foundBook.getAuthor());
        assertEquals(1925, foundBook.getYearPublished());

    }

    @Test
    public void testGetBookById() {
        Book testBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        when(bookRepository.findBookById("1")).thenReturn(testBook);
        Book foundBook = bookService.findBookById("1");
        assertEquals("The Great Gatsby", foundBook.getTitle());
        assertEquals("F. Scott Fitzgerald", foundBook.getAuthor());
        assertEquals(1925, foundBook.getYearPublished());
    }

    @Test
    public void testGetBookByTitle() {
        Book testBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        when(bookRepository.findBookByTitle("The Great Gatsby")).thenReturn(testBook);
        Book foundBook = bookService.findBookByTitle("The Great Gatsby");
        assertEquals("The Great Gatsby", foundBook.getTitle());
        assertEquals("F. Scott Fitzgerald", foundBook.getAuthor());
        assertEquals(1925, foundBook.getYearPublished());
    }

    @Test
    public void testGetBookByAuthor() {
        Book testBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        when(bookRepository.findBooksByAuthor("F. Scott Fitzgerald")).thenReturn(List.of(testBook));
        List<Book> foundBooks = bookService.findBooksByAuthor("F. Scott Fitzgerald");
        assertEquals(1, foundBooks.size());
        assertEquals("The Great Gatsby", foundBooks.get(0).getTitle());
        assertEquals("F. Scott Fitzgerald", foundBooks.get(0).getAuthor());
        assertEquals(1925, foundBooks.get(0).getYearPublished());
    }
}
