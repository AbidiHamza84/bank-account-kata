package fr.ing.interview.bankaccountkata.service;

import fr.ing.interview.bankaccountkata.entity.Account;
import fr.ing.interview.bankaccountkata.entity.Customer;
import fr.ing.interview.bankaccountkata.entity.Transaction;
import fr.ing.interview.bankaccountkata.repository.CustomerRepository;
import fr.ing.interview.bankaccountkata.service.Exeption.InsufficientBalanceException;
import fr.ing.interview.bankaccountkata.service.Exeption.LowAmountException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface {
    private final CustomerRepository repository;
    private final AccountServiceInterface accountService;
    private final TransactionServiceInterface transactionService;

    public CustomerService(CustomerRepository repository, AccountServiceInterface accountService, TransactionServiceInterface transactionService) {
        this.repository = repository;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @Override
    public Account deposit(BigDecimal amount, Long accountId) throws Exception {
        // check amount
        if (amount.compareTo(BigDecimal.valueOf(0.1)) <= 0) {
            throw new LowAmountException("Expected amount to be greater than 0.1. Passed amount " + amount);
        }

        // update account balance
        Account account = this.accountService.updateBalance(accountId, amount);

        // save transaction
        Transaction transaction = new Transaction(amount, account);
        this.transactionService.register(transaction);

        // return updated account
        return account;
    }

    @Override
    public Account withdraw(BigDecimal amount, Long accountId) throws Exception {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Expected amount to be greater than 0. Passed amount " + amount);
        }

        // check balance
        if (this.accountService.findAccountById(accountId).getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        // update account balance
        Account account = this.accountService.updateBalance(accountId, amount);

        // save transaction
        Transaction transaction = new Transaction(amount, account);
        this.transactionService.register(transaction);

        // return updated account
        return account;
    }

    @Override
    public List<Account> checkBalance(Long customerId) {
        return this.repository.findById(customerId).get().getAccounts();
    }

    @Override
    public List<Transaction> history(Long accountId) throws Exception {
        Account account = this.accountService.findAccountById(accountId);

        if (null == account) {
            throw new Exception("AccountNotFound");
        }

        return account.getTransactions();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) this.repository.findAll();
    }
}
