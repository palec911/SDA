package pl.sda.spring.rest;

import jakarta.annotation.PostConstruct;
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
        studentsList.add(new Student("Piotr", "Palczewski"));
        studentsList.add(new Student("Jan", "Kowalski"));
        studentsList.add(new Student("Adam", "Nowak"));
    }

    @RequestMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {
        if (studentId >= studentsList.size() || studentId < 0){
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }
        return studentsList.get(studentId);
    }
}
