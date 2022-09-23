package fr.ing.interview.bankaccountkata.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private BigDecimal balance;

    @Column
    @NotNull
    private LocalDateTime createdAt;

    @ManyToOne
    @NotNull
    private Customer customer;

    @OneToMany
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(Customer customer) {
        this.customer = customer;
        this.customer.addAccount(this);

        this.balance = BigDecimal.ZERO;
        this.transactions = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void update(Transaction transaction) {
        this.balance.add(transaction.getAmount());
    }
}
