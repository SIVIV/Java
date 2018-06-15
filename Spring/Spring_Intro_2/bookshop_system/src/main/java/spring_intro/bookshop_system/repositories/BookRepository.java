package spring_intro.bookshop_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_intro.bookshop_system.models.entities.Author;
import spring_intro.bookshop_system.models.entities.Book;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByReleaseDateAfter(Date year);
}
