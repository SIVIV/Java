package app;

import app.models.Account;
import app.models.User;
import app.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import app.services.account.AccountServiceImpl;
import app.services.user.UserServiceImpl;

import java.math.BigDecimal;
import java.util.Collections;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserServiceImpl userService;
    private AccountServiceImpl accountService;
    private UserRepo userRepo;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService, AccountServiceImpl accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUsername("Fry");
        user.setAge(25);

        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(11));
        account.setUser(user);

        user.setAccounts(Collections.singletonList(account));

        userService.registerUser(user);
    }
}
