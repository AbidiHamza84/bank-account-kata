package fr.ing.interview.bankaccountkata.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private String firstname;

    @Column
    @NotNull
    private String lastname;

    @Column
    @NotNull
    private Date birthday;

    @OneToMany
    private List<Account> accounts;

    public Customer() {
    }

    public Customer(String firstname, String lastname, Date birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.accounts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
