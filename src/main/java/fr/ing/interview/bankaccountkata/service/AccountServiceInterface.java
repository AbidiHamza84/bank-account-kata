package fr.ing.interview.bankaccountkata.service;

import fr.ing.interview.bankaccountkata.entity.Account;

import java.math.BigDecimal;

public interface AccountServiceInterface {
    Account updateBalance(Long accountId, BigDecimal amount);

    Account findAccountById(Long accountId) throws Exception;
}
