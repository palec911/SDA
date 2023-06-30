package pl.sda.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
