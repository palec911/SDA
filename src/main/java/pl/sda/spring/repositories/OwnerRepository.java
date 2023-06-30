package pl.sda.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.spring.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
