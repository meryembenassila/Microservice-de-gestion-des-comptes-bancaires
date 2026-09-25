package benassila.meryem.ebankservice.web;

import benassila.meryem.ebankservice.entities.BanckAccount;
import benassila.meryem.ebankservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountController {
   private BankAccountRepository bankAccountRepository;

   @GetMapping("/bankaccounts/{id}")
   private BanckAccount getbankAccount(@PathVariable String id ){
       return bankAccountRepository.findById(id).orElse(null);
   }


}
