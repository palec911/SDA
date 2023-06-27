package pl.sda.spring.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.spring.entity.Student;

import java.util.ArrayList;

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

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleExcception(StudentNotFoundException exc) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(404);
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
