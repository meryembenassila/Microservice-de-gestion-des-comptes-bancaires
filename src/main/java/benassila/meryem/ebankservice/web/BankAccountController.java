package benassila.meryem.ebankservice.web;

import benassila.meryem.ebankservice.Dtos.BanckAccountRequestDTO;
import benassila.meryem.ebankservice.Dtos.BanckAccountResponseDTO;
import benassila.meryem.ebankservice.Services.BankAccountService;
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
   private BankAccountService bankAccountService;

    @GetMapping("/bankaccounts")
    private List<BanckAccountResponseDTO> getbankAccounts( ){
        return bankAccountService.getBanckAccounts();
    }


   @GetMapping("/bankaccounts/{id}")
   private BanckAccountResponseDTO getbankAccount(@PathVariable String id ){
       return bankAccountService.getBanckAccountById(id);
   }

    @PostMapping("/bankaccounts")
    private BanckAccountResponseDTO createAccount(@RequestBody BanckAccountRequestDTO banckAccountRequestDTO){
        return bankAccountService.createBankAccount(banckAccountRequestDTO);

    }

    @PutMapping("/bankaccounts/{id}")
    private BanckAccountResponseDTO updateAccount(@PathVariable String id,@RequestBody BanckAccountRequestDTO banckAccountRequestDTO){//cette fonction pour out et patch
      return  bankAccountService.updateBankAccount(banckAccountRequestDTO,id);
    }

    @DeleteMapping("/bankaccounts/{id}")
    private void deletebankAccount(@PathVariable String id ){
       bankAccountService.deleteBanckAccount(id);

    }


}
