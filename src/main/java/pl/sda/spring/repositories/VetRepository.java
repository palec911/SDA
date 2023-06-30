package pl.sda.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.model.Vet;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
