package pl.sda.spring.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.sda.spring.entity.Student;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("FROM Student ", Student.class).getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName=:lastName", Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

}
