package org.example.librarybackend;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Getter
@Setter

public class Book {

    @MongoId
    @Id
    public String id;


    private String title;
    private String author;
    private int yearPublished;

    public Book() {}

    public Book(String title, String author, int yearPublished) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setYearPublished(yearPublished);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }
}
