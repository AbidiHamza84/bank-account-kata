package fr.ing.interview.bankaccountkata.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private int balance;

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
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public int getBalance() {
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
        this.balance += transaction.getAmount();
    }
}
