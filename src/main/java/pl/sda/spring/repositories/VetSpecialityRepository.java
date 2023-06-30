package pl.sda.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.model.VetSpeciality;

public interface VetSpecialityRepository extends JpaRepository<VetSpeciality, Long> {
}
