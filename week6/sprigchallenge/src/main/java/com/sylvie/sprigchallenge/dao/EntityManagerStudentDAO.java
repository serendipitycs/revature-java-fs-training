package com.sylvie.sprigchallenge.dao;

import com.sylvie.sprigchallenge.domain.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntityManagerStudentDAO implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student insert(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery(
            "FROM Student s ORDER BY s.id", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void delete(Student student) {
        entityManager.remove(student);
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student s WHERE s.lastName = :lastName ORDER BY s.id", Student.class);
        query.setParameter("lastName",lastName);
        return query.getResultList();
    }
}
