package fr.ing.interview.bankaccountkata.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDateTime processedAt;

    @Column
    private BigDecimal amount;

    @ManyToOne
    @NotNull
    private Account account;

    public Transaction() {
    }

    public Transaction(BigDecimal amount, Account account) {
        this.amount = amount;
        this.processedAt = LocalDateTime.now();
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
