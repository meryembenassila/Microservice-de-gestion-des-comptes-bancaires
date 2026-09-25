package benassila.meryem.ebankservice.repositories;

import benassila.meryem.ebankservice.entities.BanckAccount;
import benassila.meryem.ebankservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource

public interface BankAccountRepository extends JpaRepository<BanckAccount,String> {

    // Expose la méthode sous l'URL personnalisée /byType
    // au lieu de l'URL générée automatiquement par Spring Data REST.
    @RestResource(path = "/byType")
    List<BanckAccount> findBanckAccountByAccountType(@Param("type") AccountType accountType);
}
