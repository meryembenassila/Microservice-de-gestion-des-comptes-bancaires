package benassila.meryem.ebankservice.web;


import benassila.meryem.ebankservice.Dtos.BanckAccountRequestDTO;
import benassila.meryem.ebankservice.Dtos.BanckAccountResponseDTO;
import benassila.meryem.ebankservice.Services.BankAccountService;
import benassila.meryem.ebankservice.entities.BanckAccount;
import benassila.meryem.ebankservice.entities.Customer;
import benassila.meryem.ebankservice.repositories.BankAccountRepository;
import benassila.meryem.ebankservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BanckAccountGraphQLController {
    private final CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private BankAccountService bankAccountService;

    @QueryMapping
    public List<BanckAccount> accountsList(){
        return  bankAccountRepository.findAll();
    }

    @QueryMapping
    public BanckAccount accountById(@Argument String id ){
        return  bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s Not Found",id)));
    }


    @MutationMapping
    public BanckAccountResponseDTO createaccount(@Argument BanckAccountRequestDTO bankAccount ){
        return bankAccountService.createBankAccount(bankAccount);
    }
    /*
    record BankAccountDto(Double balance , String Type , String current );
    */

    @MutationMapping
    public BanckAccountResponseDTO updateaccount(@Argument BanckAccountRequestDTO bankAccount,@Argument String id ){
        return bankAccountService.updateBankAccount(bankAccount,id);
    }

    @MutationMapping
    public boolean deleteaccount(@Argument String id ){
      bankAccountService.deleteBanckAccount(id);
      return true;
    }

    @QueryMapping
    public List<Customer> customersList(){
        return  customerRepository.findAll();
    }

}
