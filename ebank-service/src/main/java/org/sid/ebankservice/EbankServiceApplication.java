package org.sid.ebankservice;

import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.entities.Customer;
import org.sid.ebankservice.enums.AccountType;
import org.sid.ebankservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sid.ebankservice.repository.BankAccountRepository;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(EbankServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
        return args -> {
            Stream.of("Reda","Yassine","Mouad","Zineb").forEach(c->{
                Customer customer= Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                for (int i =0; i<10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .createdAt(new Date())
                    .balance(Math.random() * 90000)
                    .type(Math.random()>0.5?AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                    .currency("MAD")
                    .customer(customer)
                    .build();
                    bankAccountRepository.save(bankAccount);
                }
            });


        };
    }
}
