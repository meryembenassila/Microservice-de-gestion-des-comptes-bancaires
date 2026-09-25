package benassila.meryem.ebankservice.Services;

import benassila.meryem.ebankservice.Dtos.BanckAccountRequestDTO;
import benassila.meryem.ebankservice.Dtos.BanckAccountResponseDTO;
import benassila.meryem.ebankservice.entities.BanckAccount;

import java.util.List;

public interface BankAccountService {
    public List<BanckAccountResponseDTO> getBanckAccounts();
    public BanckAccountResponseDTO getBanckAccountById(String id);
    public BanckAccountResponseDTO createBankAccount(BanckAccountRequestDTO banckAccountRequestDTO);

    public void deleteBanckAccount(String id);
    public BanckAccountResponseDTO updateBankAccount(BanckAccountRequestDTO banckAccountRequestDTO,String id);
}
