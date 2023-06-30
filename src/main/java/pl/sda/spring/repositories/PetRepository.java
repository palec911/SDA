package pl.sda.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.model.Pet;


public interface PetRepository extends JpaRepository<Pet, Long> {

}
