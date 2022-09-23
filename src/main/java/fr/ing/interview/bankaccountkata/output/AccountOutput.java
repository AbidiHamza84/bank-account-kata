package fr.ing.interview.bankaccountkata.output;

import java.math.BigDecimal;

public class AccountOutput {
    private Long id;
    private BigDecimal balance;

    public AccountOutput(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
