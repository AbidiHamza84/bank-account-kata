package fr.ing.interview.bankaccountkata.service;

import fr.ing.interview.bankaccountkata.entity.Transaction;
import fr.ing.interview.bankaccountkata.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements TransactionServiceInterface {
    private TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(Transaction transaction) {
        this.repository.save(transaction);
    }
}
