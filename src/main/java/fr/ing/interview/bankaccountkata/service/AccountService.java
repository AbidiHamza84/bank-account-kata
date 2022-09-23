package fr.ing.interview.bankaccountkata.service;

import fr.ing.interview.bankaccountkata.entity.Account;
import fr.ing.interview.bankaccountkata.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService implements AccountServiceInterface {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account updateBalance(Long accountId, BigDecimal amount) {
        this.repository.updateBalance(accountId, amount);
        return findAccountById(accountId);
    }

    @Override
    public Account findAccountById(Long accountId) {
        return this.repository.findById(accountId).get();
    }
}
