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
            saveStudent(student);
            retrieveStudentById(student.getId());
            getAllStudents();
            getAllStudentsByLastName("Palczewski");
//            updateStudentById(3L);
//            updateAllLastNames("Kowalski");
//            removeById(10L);
//            deleteAll();
        };
    }
    public void saveStudent(Student student) {
        System.out.println("Saving " + student.toString() + " in database");
        studentDAO.save(student);
        System.out.println("Student with id " + student.getId() + " saved");
    }

    public void retrieveStudentById(Long id) {
        System.out.println("Getting student with id " + id);
        Student studentRetrieved = studentDAO.findById(id);
        System.out.println("Retrieved student :" + studentRetrieved);
    }

    public void getAllStudents() {
        System.out.println("Getting all students as a list");
        List<Student> allStudents = studentDAO.findAll();
        allStudents.forEach(System.out::println);
    }

    public void getAllStudentsByLastName(String lastName) {
        List<Student> studentsWithLastName = studentDAO.findByLastName(lastName);
        studentsWithLastName.forEach(System.out::println);
    }

    public void updateStudentById(Long id) {
        Student studentToBeUpdated = studentDAO.findById(id);
        studentToBeUpdated.setFirstName("Andrzej");
        studentDAO.updateOne(studentToBeUpdated);
        System.out.println("Updated student : " + studentToBeUpdated);
    }

    public void updateAllLastNames(String lastName) {
        System.out.println("Updating all last names to " + lastName);
        System.out.println(studentDAO.updateAllByLastName(lastName));
    }

    public void removeById(Long id) {
        System.out.println("Removing student with id "+ id);
        studentDAO.deleteOne(id);
    }

    public void deleteAll() {
        System.out.println("WARNING removing all from DB");
        studentDAO.deleteAll();
        System.out.println("DB is clear");
    }
}
