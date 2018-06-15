package spring_intro.bookshop_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_intro.bookshop_system.models.entities.Author;
import spring_intro.bookshop_system.models.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
