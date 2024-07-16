package org.example.librarybackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryBackendApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(LibraryBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        bookRepository.save(book);
        bookRepository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        bookRepository.save(new Book("1984", "George Orwell", 1949));

        //fetch all books
        System.out.println("Books found with findAll():");
        System.out.println("-------------------------------");
        for (Book b : bookRepository.findAll()) {
            System.out.println(b);
        }
        System.out.println();

        //fetch an individual book
        System.out.println("Book found with findBookByTitle('The Great Gatsby'):");
        System.out.println("--------------------------------");
        System.out.println(bookRepository.findBookByTitle("The Great Gatsby"));

        System.out.println("Books found with findBooksByAuthor('George Orwell'):");
        System.out.println("--------------------------------");
        for (Book b : bookRepository.findBooksByAuthor("George Orwell")) {
            System.out.println(b);
        }



    }


}
