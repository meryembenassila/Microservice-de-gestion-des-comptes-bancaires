package benassila.meryem.ebankservice.entities;


import benassila.meryem.ebankservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types=BanckAccount.class , name = "p1")


public interface BankAccountProjection {
    public String getId() ;
    public AccountType getAccountType();
}
