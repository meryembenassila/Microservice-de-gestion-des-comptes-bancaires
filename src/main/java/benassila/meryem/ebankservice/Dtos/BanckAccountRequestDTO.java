package benassila.meryem.ebankservice.Dtos;

import benassila.meryem.ebankservice.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BanckAccountRequestDTO {

    private Double balance ;
    private  String  currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
