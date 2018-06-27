package spring_intro.product_shop.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_intro.product_shop.models.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
