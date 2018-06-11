package app.services.user;

import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import app.repositories.UserRepo;

@Service
@Primary
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void registerUser(User user) {
        if (user.getId() != null){
            if(this.userRepo.exists(user.getId())){
                throw new IllegalArgumentException("UserID already exists.");
            }
        }

        if(userRepo.getByUsername(user.getUsername()) != null){
            throw new IllegalArgumentException("Username already exists.");
        }

        userRepo.save(user);
    }
}
