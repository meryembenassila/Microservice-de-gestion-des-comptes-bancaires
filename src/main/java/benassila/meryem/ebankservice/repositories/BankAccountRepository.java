package benassila.meryem.ebankservice.repositories;

import benassila.meryem.ebankservice.entities.BanckAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BanckAccount,String> {
}
