package fr.ing.interview.bankaccountkata.service;

import fr.ing.interview.bankaccountkata.entity.Account;
import fr.ing.interview.bankaccountkata.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountServiceInterface {
    private AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account updateBalance(Long accountId, int amount) {
        return this.repository.updateBalance(accountId, amount);
    }

    @Override
    public Account findAccountById(Long accountId) {
        return this.repository.findById(accountId).get();
    }
}
