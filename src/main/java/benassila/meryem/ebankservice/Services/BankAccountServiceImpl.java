package benassila.meryem.ebankservice.Services;

import benassila.meryem.ebankservice.Dtos.BanckAccountRequestDTO;
import benassila.meryem.ebankservice.Dtos.BanckAccountResponseDTO;
import benassila.meryem.ebankservice.entities.BanckAccount;
import benassila.meryem.ebankservice.mappers.BankAccountMapppers;
import benassila.meryem.ebankservice.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@AllArgsConstructor

public class BankAccountServiceImpl implements BankAccountService {
    BankAccountRepository bankAccountRepository;
    BankAccountMapppers mapppers;


    @Override
    public List<BanckAccountResponseDTO> getBanckAccounts() {
        List<BanckAccountResponseDTO> banckAccountResponseDTOS = new ArrayList<>();
        bankAccountRepository.findAll().forEach( banckAccount -> {
            banckAccountResponseDTOS.add(mapppers.BanckAccounttoResponse(banckAccount));
        });
        return banckAccountResponseDTOS;
    }

    @Override
    public BanckAccountResponseDTO getBanckAccountById(String id) {
        BanckAccount banckAccount = bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s Not Found",id)));
        return mapppers.BanckAccounttoResponse(banckAccount);
    }

    @Override
    public BanckAccountResponseDTO createBankAccount(BanckAccountRequestDTO banckAccountRequestDTO){
       BanckAccount banckAccount = new BanckAccount();
       banckAccount=bankAccountRepository.save(mapppers.RequestDtotoBanckAccount(banckAccountRequestDTO));

        return mapppers.BanckAccounttoResponse(banckAccount);

    }




    public BanckAccountResponseDTO updateBankAccount(BanckAccountRequestDTO banckAccountRequestDTO , String id){

        BanckAccount account = bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s Not Found",id)));

        if(banckAccountRequestDTO.getBalance()!=null) account.setBalance(banckAccountRequestDTO.getBalance());
        if(banckAccountRequestDTO.getAccountType()!=null) account.setAccountType(banckAccountRequestDTO.getAccountType());
        if(banckAccountRequestDTO.getCurrency()!=null) account.setCurrency(banckAccountRequestDTO.getCurrency());

        return mapppers.BanckAccounttoResponse(bankAccountRepository.save(account));

    }

    @Override
    public void deleteBanckAccount(String id) {
        bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s Not Found",id)));
        bankAccountRepository.deleteById(id);

    }
}
