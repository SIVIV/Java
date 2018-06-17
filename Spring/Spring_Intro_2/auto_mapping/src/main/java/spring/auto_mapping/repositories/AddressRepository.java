package spring.auto_mapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.auto_mapping.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
