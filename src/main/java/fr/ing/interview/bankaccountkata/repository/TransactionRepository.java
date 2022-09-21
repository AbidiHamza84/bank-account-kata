package fr.ing.interview.bankaccountkata.repository;

import fr.ing.interview.bankaccountkata.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
