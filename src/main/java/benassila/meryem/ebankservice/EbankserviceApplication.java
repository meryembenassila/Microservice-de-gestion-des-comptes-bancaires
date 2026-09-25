package benassila.meryem.ebankservice;

import benassila.meryem.ebankservice.entities.BanckAccount;
import benassila.meryem.ebankservice.enums.AccountType;
import benassila.meryem.ebankservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EbankserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankserviceApplication.class, args);

    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){
        return args ->{
            for (int i =0 ; i<10 ; i ++){
                BanckAccount banckAccount = new BanckAccount();
                banckAccount.setId(UUID.randomUUID().toString());
                banckAccount.setBalance(Math.random()*90000+100000);
                banckAccount.setAccountType(Math.random()<0.5?AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT);
                banckAccount.setCurrency("MAD");
                banckAccount.setCreatedAt(new Date());
                bankAccountRepository.save(banckAccount);

            }
        };
    }

}
