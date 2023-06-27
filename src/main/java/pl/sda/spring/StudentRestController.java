package pl.sda.spring;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
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
        return studentsList.get(studentId);
    }

}