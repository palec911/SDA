package pl.sda.spring;

import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sda.spring.dao.StudentDAO;
import pl.sda.spring.entity.Student;

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
        };
    }
}
