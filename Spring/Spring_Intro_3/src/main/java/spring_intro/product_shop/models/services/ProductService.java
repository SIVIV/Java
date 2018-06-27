package spring_intro.product_shop.models.services;

import spring_intro.product_shop.models.dtos.binding.product.ProductBindingModel;
import spring_intro.product_shop.models.dtos.views.product.ProductViewInRangeModel;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    void save(ProductBindingModel model);

    void save(Collection<ProductBindingModel> models);

    List<ProductViewInRangeModel> getAllInRangeWithoutBuyer(Long from, Long to);
}
