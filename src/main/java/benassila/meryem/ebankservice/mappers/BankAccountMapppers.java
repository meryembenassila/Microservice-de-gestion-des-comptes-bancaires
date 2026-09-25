package benassila.meryem.ebankservice.mappers;


import benassila.meryem.ebankservice.Dtos.BanckAccountRequestDTO;
import benassila.meryem.ebankservice.Dtos.BanckAccountResponseDTO;
import benassila.meryem.ebankservice.entities.BanckAccount;
import benassila.meryem.ebankservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BankAccountMapppers {

    BankAccountRepository bankAccountRepository;
    //ajout
    public BanckAccount RequestDtotoBanckAccount(BanckAccountRequestDTO banckAccountRequestDTO){
        BanckAccount banckAccount = new BanckAccount();
        banckAccount.setId(UUID.randomUUID().toString());
        banckAccount.setBalance(banckAccountRequestDTO.getBalance());
        banckAccount.setAccountType(banckAccountRequestDTO.getAccountType());
        banckAccount.setCurrency(banckAccountRequestDTO.getCurrency());
        banckAccount.setCreatedAt(new Date());
        return  banckAccount;

    }

    public BanckAccountResponseDTO BanckAccounttoResponse(BanckAccount banckAccount){
        BanckAccountResponseDTO banckAccountResponseDTO = new BanckAccountResponseDTO();
        banckAccountResponseDTO.setId(banckAccount.getId());
        banckAccountResponseDTO.setBalance(banckAccount.getBalance());
        banckAccountResponseDTO.setAccountType(banckAccount.getAccountType());
        banckAccountResponseDTO.setCurrency(banckAccount.getCurrency());
        banckAccountResponseDTO.setCreatedAt(banckAccount.getCreatedAt());
        return  banckAccountResponseDTO;

    }
}
