package fr.ing.interview.bankaccountkata.controller;

import fr.ing.interview.bankaccountkata.entity.Account;
import fr.ing.interview.bankaccountkata.output.AccountOutput;
import fr.ing.interview.bankaccountkata.output.CustomerOutput;
import fr.ing.interview.bankaccountkata.output.TransactionOutput;
import fr.ing.interview.bankaccountkata.service.CustomerServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerServiceInterface customerService;

    public CustomerController(CustomerServiceInterface customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customers")
    public List<CustomerOutput> getCustomers() {
        return this.customerService.getAllCustomers()
                .stream()
                .map(customer -> new CustomerOutput(
                                customer.getId(),
                                customer.getFirstname(),
                                customer.getLastname(),
                                customer.getBirthday(),
                                customer.getAccounts()
                        )
                )
                .toList();
    }

    @PutMapping("/api/customers/deposit")
    public AccountOutput deposit(@RequestParam Long accountId, @RequestParam double amount) throws Exception {
        Account account = this.customerService.deposit(BigDecimal.valueOf(amount), accountId);
        return new AccountOutput(account.getId(), account.getBalance());
    }
    @PutMapping("/api/customers/withdraw")
    public AccountOutput withdraw(@RequestParam Long accountId, @RequestParam double amount) throws Exception {
        Account account = this.customerService.withdraw(BigDecimal.valueOf(amount), accountId);
        return new AccountOutput(account.getId(), account.getBalance());
    }

    @GetMapping("/api/customers/{customerId}/accounts")
    public List<AccountOutput> getAccounts(@PathVariable Long customerId) {
        return this.customerService.checkBalance(customerId)
                .stream()
                .map(account -> new AccountOutput(account.getId(), account.getBalance()))
                .toList();
    }

    @GetMapping("api/customers/accounts/{accountId}/transactions")
    public List<TransactionOutput> getHistory(@PathVariable Long accountId) throws Exception {
        return this.customerService.history(accountId)
                .stream()
                .map(transaction -> new TransactionOutput(transaction.getId(), transaction.getAmount(), transaction.getProcessedAt()))
                .toList();
    }
}
