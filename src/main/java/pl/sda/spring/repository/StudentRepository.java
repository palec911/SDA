package pl.sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
