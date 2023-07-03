package pl.sda.spring.service;

import org.springframework.stereotype.Service;
import pl.sda.spring.entity.Student;
import pl.sda.spring.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
