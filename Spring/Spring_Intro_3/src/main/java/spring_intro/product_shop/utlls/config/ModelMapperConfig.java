package spring_intro.product_shop.utlls.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_intro.product_shop.models.dtos.binding.product.ProductBindingModel;
import spring_intro.product_shop.models.entities.Product;
import spring_intro.product_shop.models.repositories.UserRepository;

@Component
public class ModelMapperConfig {
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    @Autowired
    public ModelMapperConfig(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.initialize();
    }

    private void initialize() {
        this.createProductBindingConfiguration();
    }

    private void createProductBindingConfiguration() {
        this.mapper.addConverter(new Converter<ProductBindingModel, Product>() {
            @Override
            public Product convert(MappingContext<ProductBindingModel, Product> context) {
                Product p = context.getDestination();
                Long buyer = context.getSource().getBuyer();
                if (buyer != null) {
                    p.setBuyer(userRepository.findOne(buyer));
                }
                p.setSeller(userRepository.findOne(context.getSource().getSeller()));
                p.setName(context.getSource().getName());
                p.setPrice(context.getSource().getPrice());
                return p;
            }
        });
    }
}
