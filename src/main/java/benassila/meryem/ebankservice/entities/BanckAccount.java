package benassila.meryem.ebankservice.entities;

import benassila.meryem.ebankservice.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data //setters et getters
@AllArgsConstructor
@NoArgsConstructor
public class BanckAccount {
    @Id
    private String id ;
    private Date createdAt;
    private Double balance ;
    private  String  currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @ManyToOne
    private Customer customer;
}
