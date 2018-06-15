package spring_intro.bookshop_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_intro.bookshop_system.models.entities.Book;
import spring_intro.bookshop_system.repositories.BookRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveToDB(List<Book> books) {
        this.bookRepository.saveAll(books);
    }

    @Override
    public List<String> allTitleAfterYear(Date year) {
        return this.bookRepository
                .findAllByReleaseDateAfter(year)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }
}
