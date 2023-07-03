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
    public StudentController(StudentService theEmployeeService) {
        studentService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/student")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/student/{studentId}")
    public Student getEmployee(@PathVariable Long studentId) {

        Student theEmployee = studentService.findById(studentId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + studentId);
        }

        return theEmployee;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/student")
    public Student addEmployee(@RequestBody Student student) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        student.setId(0L);

        Student dbEmployee = studentService.saveStudent(student);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/student")
    public Student updateEmployee(@RequestBody Student theEmployee) {

        Student dbEmployee = studentService.saveStudent(theEmployee);

        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/student/{studentId}")
    public String deleteEmployee(@PathVariable Long studentId) {

        Student tempEmployee = studentService.findById(studentId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + studentId);
        }

        studentService.deleteById(studentId);

        return "Deleted employee id - " + studentId;
    }

}













