package pl.sda.spring.rest;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.entity.Student;

import java.util.ArrayList;

@RestController
public class StudentRestController {

    ArrayList<Student> studentsList;

    @PostConstruct
    public void fillList() {
        studentsList = new ArrayList<>();
        studentsList.add(new Student("Piotr", "Palczewski", "aaa@bbb.pl"));
        studentsList.add(new Student("Jan", "Kowalski", "ccc@ddd.pl"));
        studentsList.add(new Student("Adam", "Nowak", "eee@fff.pl"));
    }

    @RequestMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {
        if (studentId >= studentsList.size() || studentId < 0){
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }
        return studentsList.get(studentId);
    }

    @GetMapping(value = "/students", produces = "application/json")
    public ResponseEntity<ArrayList<Student>> getStudents() {
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }

    @PostMapping("/students")
    public HttpEntity createStudent(@Valid @RequestBody Student student) {
        studentsList.add(student);
        return new HttpEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public HttpStatus updateStudent(@PathVariable int id, @RequestBody Student student){
        studentsList.set(id, student);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/students/{id}")
    public HttpStatus deleteStudent(@PathVariable Long id) {
        studentsList.remove(id);
        return HttpStatus.NO_CONTENT;
    }
}
