package pl.sda.spring.dao;

import pl.sda.spring.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(Long id);

}
