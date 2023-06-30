package pl.sda.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
