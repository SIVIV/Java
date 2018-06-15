package spring_intro.bookshop_system.services;

import spring_intro.bookshop_system.models.entities.Author;

import java.util.List;

public interface AuthorService {
    void saveAuthorToDB(Author author);
    void saveAuthorToDB(List<Author> authors);
    List<Author> getAll();
}
