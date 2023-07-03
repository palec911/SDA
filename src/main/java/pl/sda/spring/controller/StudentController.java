package pl.sda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.entity.Student;
import pl.sda.spring.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/students/{studentId}")
    public Student getEmployee(@PathVariable Long studentId) {

        Student student = studentService.findById(studentId);

        if (student == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        return student;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {

        student.setId(0L);

        Student savedStudent = studentService.saveStudent(student);

        return savedStudent;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {

        Student savedStudent = studentService.saveStudent(student);

        return savedStudent;
    }


    @DeleteMapping("/students/{studentId}")
    public String deleteEmployee(@PathVariable Long studentId) {

        Student studentToDelete = studentService.findById(studentId);

        // throw exception if null

        if (studentToDelete == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        studentService.deleteById(studentId);

        return "Deleted employee id - " + studentId;
    }

}













