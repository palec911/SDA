package pl.sda.spring;

import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sda.spring.dao.StudentDAO;
import pl.sda.spring.entity.Student;

import java.util.List;

@SpringBootApplication
public class Application {

    StudentDAO studentDAO;

    public Application(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            Student student = new Student("Piotr", "Palczewski", "ppalczew@gmail.com");
            System.out.println("Saving " + student.toString() + " in database");
            studentDAO.save(student);
            System.out.println("Student with id " + student.getId() + " saved");
            System.out.println("Getting tudent with id " + student.getId());
            Student studentRetrieved = studentDAO.findById(student.getId());
            System.out.println("Retrieved student :" + studentRetrieved);
            System.out.println("Getting all students as a list");
            List<Student> allStudents = studentDAO.findAll();
            allStudents.forEach(System.out::println);
            List<Student> studentsWithLastName = studentDAO.findByLastName("Palczewski");
            studentsWithLastName.forEach(System.out::println);
        };
    }
}
