package org.example.librarybackend.services;

import org.example.librarybackend.Book;
import org.example.librarybackend.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        //create a new book
        return bookRepository.save(book);
    }

    public Book findBookByTitle(String theGreatGatsby) {
        //find a book by title
        return bookRepository.findBookByTitle(theGreatGatsby);
    }

    public Book findBookById(String id) {
        //find a book by id
        return bookRepository.findBookById(id);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author);
    }
}
