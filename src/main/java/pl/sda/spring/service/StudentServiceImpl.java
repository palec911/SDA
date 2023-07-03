package pl.sda.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.spring.dao.StudentDAO;
import pl.sda.spring.entity.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    StudentDAO studentDAO;

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(Long studentId) {
        return studentDAO.findById(studentId);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Long studentId) {
        studentDAO.deleteOne(studentId);
    }
}
