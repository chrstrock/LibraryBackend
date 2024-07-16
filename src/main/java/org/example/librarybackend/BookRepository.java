package org.example.librarybackend;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String>{

    Book findBookById(String id);
    Book findBookByTitle(String title);
    List<Book> findBooksByAuthor(String author);

}

