package spring_intro.product_shop.models.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_intro.product_shop.models.dtos.binding.product.ProductBindingModel;
import spring_intro.product_shop.models.dtos.views.product.ProductViewInRangeModel;
import spring_intro.product_shop.models.entities.Product;
import spring_intro.product_shop.models.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ModelMapper mapper;
    private final ProductRepository productRepository;

//    @Autowired
    public ProductServiceImpl(ModelMapper mapper, ProductRepository productRepository) {
        this.mapper = mapper;
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductBindingModel model) {
        Product product = mapper.map(model, Product.class);
        this.productRepository.saveAndFlush(product);
    }

    @Override
    public void save(Collection<ProductBindingModel> models) {
        Type collectionType = new TypeToken<List<Product>>(){}.getType();
        Collection<Product> products = mapper.map(models, collectionType);
        this.productRepository.save(products);
    }

    @Override
    public List<ProductViewInRangeModel> getAllInRangeWithoutBuyer(Long from, Long to) {
        return this.productRepository.getAllByRangeWithoutBuyer(new BigDecimal(from), new BigDecimal(to));
    }
}
