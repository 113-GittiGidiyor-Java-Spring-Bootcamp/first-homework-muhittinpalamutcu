package io.github.muhittinpalamutcu.service;

import io.github.muhittinpalamutcu.models.Course;
import io.github.muhittinpalamutcu.models.Student;
import io.github.muhittinpalamutcu.repository.CrudRepository;
import io.github.muhittinpalamutcu.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {

    final String PERSISTENCE_UNIT_NAME = "mysqlPU";

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    @Override
    public Student findById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public void saveToDatabase(Student student) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void updateOnDatabase(int id, Student student) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Student foundStudent = entityManager.find(Student.class, id);
            foundStudent.setName(student.getName());
            foundStudent.setAddress(student.getAddress());
            foundStudent.setBirthDate(student.getBirthDate());
            foundStudent.setGender(student.getGender());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteStudentFromDatabase(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Student student = entityManager.createQuery("from Student s where s.id=:id", Student.class).setParameter("id", id).getSingleResult();
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void updateStudentAddressOnDatabase(int id, String address) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class, id);
            student.setAddress(address);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void enrollInCourse(int id, String courseCode) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class, id);
            Course course = entityManager.createQuery("from Course c where c.courseCode=:courseCode", Course.class).setParameter("courseCode", courseCode).getSingleResult();
            student.getCourses().add(course);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
