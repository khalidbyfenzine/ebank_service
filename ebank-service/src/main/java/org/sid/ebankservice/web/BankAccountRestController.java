package org.sid.ebankservice.web;

import org.sid.ebankservice.dto.BankAccountRequestDTO;
import org.sid.ebankservice.dto.BankAccountResponseDTO;
import org.sid.ebankservice.mappers.AccountMapper;
import org.sid.ebankservice.repository.BankAccountRepository;
import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankAccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public BankAccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();

    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount getAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));

    }
    @PostMapping("bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){

        return accountService.addAccount(requestDTO);
    }
    @PutMapping("bankAccounts/{id}")
    public BankAccount update(@RequestBody BankAccount bankAccount, @PathVariable String id){
        bankAccount.setId(id);
        return bankAccountRepository.save(bankAccount);
    }
    @DeleteMapping("bankAccounts/{id}")
    public void delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
