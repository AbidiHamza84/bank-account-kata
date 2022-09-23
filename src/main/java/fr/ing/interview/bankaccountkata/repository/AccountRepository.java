package fr.ing.interview.bankaccountkata.repository;

import fr.ing.interview.bankaccountkata.entity.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("update Account a set a.balance = a.balance + :amount where a.id = :accountId")
    @Modifying
    @Transactional
    void updateBalance(@Param("accountId") Long accountId, @Param("amount") BigDecimal amount);
}
