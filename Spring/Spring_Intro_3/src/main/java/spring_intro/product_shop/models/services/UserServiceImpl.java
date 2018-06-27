package spring_intro.product_shop.models.services;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_intro.product_shop.models.dtos.binding.user.UserBindingModel;
import spring_intro.product_shop.models.dtos.binding.user.UserBindingModelX;
import spring_intro.product_shop.models.dtos.binding.user.UserXMLWrapper;
import spring_intro.product_shop.models.entities.User;
import spring_intro.product_shop.models.repositories.UserRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(UserBindingModel model) {
        User user = mapper.map(model, User.class);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void save(Collection<UserBindingModelX> models) {
        Type collectionType = new TypeToken<List<User>>(){}.getType();
        Collection<User> users = mapper.map(models, collectionType);
        this.userRepository.save(users);
    }
//    @Override
//    public void save(Collection<UserBindingModel> models) {
//        Type collectionType = new TypeToken<List<User>>(){}.getType();
//        Collection<User> users = mapper.map(models, collectionType);
//        this.userRepository.save(users);
//    }


}
