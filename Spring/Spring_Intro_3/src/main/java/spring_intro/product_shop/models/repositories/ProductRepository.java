package spring_intro.product_shop.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_intro.product_shop.models.dtos.views.product.ProductViewInRangeModel;
import spring_intro.product_shop.models.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("" +
            "SELECT new spring_intro.product_shop.models.dtos.views.product.ProductViewInRangeModel(p.name,p.price,TRIM(CONCAT(COALESCE(p.seller.firstName,''), ' ',p.seller.lastName))) " +
            "FROM Product AS p " +
            "WHERE (p.price BETWEEN :from AND :to) AND p.buyer IS NULL " +
            "ORDER BY p.price ASC")
    List<ProductViewInRangeModel> getAllByRangeWithoutBuyer(@Param("from") BigDecimal from, @Param("to") BigDecimal to);
}