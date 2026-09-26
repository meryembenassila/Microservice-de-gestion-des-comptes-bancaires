package benassila.meryem.ebankservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    private  String id;
    private String name;
   @OneToMany(mappedBy = "customer")
    private List<BanckAccount> banckAccounts;

}
