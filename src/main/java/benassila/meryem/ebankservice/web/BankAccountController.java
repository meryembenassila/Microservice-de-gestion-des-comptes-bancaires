package benassila.meryem.ebankservice.web;

import benassila.meryem.ebankservice.entities.BanckAccount;
import benassila.meryem.ebankservice.enums.AccountType;
import benassila.meryem.ebankservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping ("/api")
public class BankAccountController {
   private BankAccountRepository bankAccountRepository;

    @GetMapping("/bankaccounts")
    private List<BanckAccount> getbankAccounts( ){
        return bankAccountRepository.findAll();
    }

   @GetMapping("/bankaccounts/{id}")
   private BanckAccount getbankAccount(@PathVariable String id ){
       return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s Not Found",id)));

   }

    @PostMapping("/bankaccounts")
    private BanckAccount createAccount(@RequestBody BanckAccount banckAccount){
        System.out.println("err");
        System.out.println(banckAccount.getId());
        if (banckAccount.getId()== null) {
            banckAccount.setId(UUID.randomUUID().toString());
        }
        System.out.println(banckAccount.getId());
        if (banckAccount.getCreatedAt()== null) banckAccount.setCreatedAt(new Date());

        return bankAccountRepository.save(banckAccount);

    }

    @PutMapping("/bankaccounts/{id}")
    private BanckAccount updateAccount(@PathVariable String id,@RequestBody BanckAccount banckAccount){//cette fonction pour out et patch
        BanckAccount account = bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s Not Found",id)));
        if(banckAccount.getBalance()!=null) account.setBalance(banckAccount.getBalance());//on a odifier double en Double pour valeur null
        if(banckAccount.getAccountType()!=null) account.setAccountType(banckAccount.getAccountType());
        if(banckAccount.getCurrency()!=null) account.setCurrency(banckAccount.getCurrency());
        return bankAccountRepository.save(account);

    }

    @DeleteMapping("/bankaccounts/{id}")
    private void deletebankAccount(@PathVariable String id ){
        BanckAccount account = bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s Not Found",id)));
        bankAccountRepository.deleteById(id);

    }


}
