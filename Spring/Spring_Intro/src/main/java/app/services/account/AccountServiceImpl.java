package app.services.account;

import app.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import app.repositories.AccountRepo;

import java.math.BigDecimal;

@Service
@Primary
public class AccountServiceImpl implements AccountService {
    private AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) {
        if (!this.accountRepo.exists(id)) {
            throw new IllegalArgumentException("No such account exists.");
        }
        Account account = accountRepo.findOne(id);

        BigDecimal newBalance = account.getBalance().subtract(amount);

        account.setBalance(newBalance);

        accountRepo.save(account);
    }

    @Override
    public void transferMoney(BigDecimal amount, Long id) {
        Account account = accountRepo.findOne(id);
        if (account == null) {
            throw new IllegalArgumentException("No such account exists.");
        }
        if (account.getUser() == null) {
            throw new IllegalArgumentException("No user owns this account.");
        }
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalArgumentException("You cannot transfer a negative amount");
        }

        BigDecimal newBalance = account.getBalance().add(amount);

        account.setBalance(newBalance);

        accountRepo.save(account);
    }
}
