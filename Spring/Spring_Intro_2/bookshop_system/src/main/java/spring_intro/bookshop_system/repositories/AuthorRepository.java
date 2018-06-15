package spring_intro.bookshop_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_intro.bookshop_system.models.entities.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    //@Query(value = "SELECT a FROM Author AS a WHERE a.firstName=:firstName ORDER BY a.firstName DESC")
    //List<Author> findAllByFirstNameOrdered(@Param("firstName") String firstName);
}
