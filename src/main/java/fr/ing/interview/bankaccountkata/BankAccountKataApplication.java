package fr.ing.interview.bankaccountkata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class BankAccountKataApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountKataApplication.class, args);
	}

}
