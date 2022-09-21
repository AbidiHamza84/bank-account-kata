package fr.ing.interview.bankaccountkata.service;

import fr.ing.interview.bankaccountkata.entity.Account;

public interface AccountServiceInterface {
    Account updateBalance(Long accountId, int amount);

    Account findAccountById(Long accountId) throws Exception;
}
