package spring_intro.product_shop.models.services;

import spring_intro.product_shop.models.dtos.binding.user.UserBindingModel;
import spring_intro.product_shop.models.dtos.binding.user.UserBindingModelX;
import spring_intro.product_shop.models.dtos.binding.user.UserXMLWrapper;

import java.util.Collection;
import java.util.List;

public interface UserService {
    void save(UserBindingModel model);

    //void save(Collection<UserBindingModel> models);
    void save(Collection<UserBindingModelX> models);
}
