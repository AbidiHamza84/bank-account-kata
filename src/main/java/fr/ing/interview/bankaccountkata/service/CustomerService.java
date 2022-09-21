package fr.ing.interview.bankaccountkata.service;

import fr.ing.interview.bankaccountkata.entity.Account;
import fr.ing.interview.bankaccountkata.entity.Customer;
import fr.ing.interview.bankaccountkata.entity.Transaction;
import fr.ing.interview.bankaccountkata.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface {
    private CustomerRepository repository;
    private AccountServiceInterface accountService;
    private TransactionServiceInterface transactionService;

    public CustomerService(CustomerRepository repository, AccountServiceInterface accountService, TransactionServiceInterface transactionService) {
        this.repository = repository;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @Override
    public Account makeTransaction(int amount, Long accountId) throws Exception {
        // check balance
        if (this.accountService.findAccountById(accountId).getBalance() + amount < 0) {
            throw new Exception("Insufficient balance");
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
        return this.accountService.findAccountById(accountId).getTransactions();
    }
}
