package pl.sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.sda.spring.entity.Student;

@RepositoryRestResource(path = "members")
public interface StudentRepository extends JpaRepository<Student, Long> {
}
