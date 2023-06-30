package pl.sda.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.model.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long> {
}
