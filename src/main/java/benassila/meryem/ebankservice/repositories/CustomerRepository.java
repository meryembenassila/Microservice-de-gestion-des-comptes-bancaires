package benassila.meryem.ebankservice.repositories;

import benassila.meryem.ebankservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {

}
