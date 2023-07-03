package pl.sda.spring.service;

import pl.sda.spring.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long studentId);

    Student saveStudent(Student student);

    void deleteById(Long studentId);

}
