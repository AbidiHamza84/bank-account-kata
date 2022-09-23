package fr.ing.interview.bankaccountkata.output;

import fr.ing.interview.bankaccountkata.entity.Account;

import java.time.LocalDate;
import java.util.List;

public class CustomerOutput {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private List<AccountOutput> accounts;

    public CustomerOutput(Long id, String firstname, String lastname, LocalDate birthday, List<Account> accounts) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.accounts = accounts.stream().map(account -> new AccountOutput(account.getId(), account.getBalance())).toList();
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public List<AccountOutput> getAccounts() {
        return accounts;
    }
}
