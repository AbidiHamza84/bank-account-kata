package fr.ing.interview.bankaccountkata.service;

import fr.ing.interview.bankaccountkata.entity.Account;
import fr.ing.interview.bankaccountkata.entity.Customer;
import fr.ing.interview.bankaccountkata.entity.Transaction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerServiceInterface {
    @Transactional
    Account makeTransaction(int amount, Long accountId) throws Exception;
    List<Account> checkBalance(Long customerId);
    List<Transaction> history(Long accountId) throws Exception;
}
