package fr.ing.interview.bankaccountkata.controller;

import fr.ing.interview.bankaccountkata.entity.Account;
import fr.ing.interview.bankaccountkata.entity.Transaction;
import fr.ing.interview.bankaccountkata.service.CustomerServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerServiceInterface customerService;

    public CustomerController(CustomerServiceInterface customerService) {
        this.customerService = customerService;
    }

    @PutMapping("/api/customers/transactions")
    public Account makeTransaction(@RequestParam Long accountId, @RequestParam int amount) throws Exception {
        return this.customerService.makeTransaction(amount, accountId);
    }

    @GetMapping("/api/customers/{customerId}/accounts")
    public List<Account> getAccounts(@PathVariable Long customerId) {
        return this.customerService.checkBalance(customerId);
    }

    @GetMapping("api/customers/accounts/{accountId}/transactions")
    public List<Transaction> getHistory(@PathVariable Long accountId) throws Exception {
        return this.customerService.history(accountId);
    }
}
