package fr.ing.interview.bankaccountkata;

import fr.ing.interview.bankaccountkata.entity.Account;
import fr.ing.interview.bankaccountkata.entity.Customer;
import fr.ing.interview.bankaccountkata.repository.AccountRepository;
import fr.ing.interview.bankaccountkata.repository.CustomerRepository;
import fr.ing.interview.bankaccountkata.service.CustomerServiceInterface;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@EnableConfigurationProperties
public class BankAccountKataApplication {
	private CustomerServiceInterface customerService;
	private CustomerRepository customerRepository;
	private AccountRepository accountRepository;

	public BankAccountKataApplication(CustomerServiceInterface customerService, CustomerRepository customerRepository, AccountRepository accountRepository) {
		this.customerService = customerService;
		this.customerRepository = customerRepository;
		this.accountRepository = accountRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BankAccountKataApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		Customer user1 = new Customer(
				"Hamza",
				"ABIDI",
				LocalDate.of(1995, 7, 14)
		);

		Customer user2 = new Customer(
				"Matthieu",
				"NOURRY",
				LocalDate.of(1995, 7, 13)
		);


		return () -> {

			Account account1 = new Account(user1);
			Account account2 = new Account(user2);

			customerRepository.save(user1);
			customerRepository.save(user2);


			customerService.deposit(BigDecimal.TEN, account1.getId());
			customerService.deposit(BigDecimal.TEN, account2.getId());
		};
	}

}
