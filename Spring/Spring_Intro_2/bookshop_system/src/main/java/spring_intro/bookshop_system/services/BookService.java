package spring_intro.bookshop_system.services;

import spring_intro.bookshop_system.models.entities.Book;

import java.util.Date;
import java.util.List;

public interface BookService {
    void saveToDB(List<Book> books);
    List<String> allTitleAfterYear(Date year);
}
