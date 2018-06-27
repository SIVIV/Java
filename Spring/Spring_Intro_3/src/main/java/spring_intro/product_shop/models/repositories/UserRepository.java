package spring_intro.product_shop.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_intro.product_shop.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
