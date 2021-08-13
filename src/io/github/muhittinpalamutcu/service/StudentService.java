package io.github.muhittinpalamutcu.service;

import io.github.muhittinpalamutcu.models.Student;
import io.github.muhittinpalamutcu.repository.CrudRepository;
import io.github.muhittinpalamutcu.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");


    @Override
    public List<Student> findAll() {
        return em.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class,id);
    }
}
