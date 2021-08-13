package io.github.muhittinpalamutcu.clients;

import io.github.muhittinpalamutcu.controller.StudentController;
import io.github.muhittinpalamutcu.models.*;
import io.github.muhittinpalamutcu.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class SchoolManagementApiClient {
    public static void main(String[] args) {
        //saveTestData();

        StudentController studentController = new StudentController();

        List<Student> students = studentController.findAll();

        for (Student student : students) {
            System.out.println(student);
        }

    }

    private static void saveTestData() {
        Person student1 = new Student("Muhittin Palamutcu", "Gaziemir Izmir", LocalDate.of(1998, Month.JANUARY, 13), "MALE");
        Person student2 = new Student("Berke Edis", "Kusadasi Aydin", LocalDate.of(1996, Month.AUGUST, 12), "MALE");

        Instructor permanentInstructor1 = new PermanentInstructor("Ipek Demir", "Izmir", "5071234551", 5000);
        Instructor permanentInstructor2 = new PermanentInstructor("Isıl Parlak", "Antalya", "5553524576", 7000);
        Instructor visitingResearcher1 = new VisitingResearcher("Ayhan Kaya", "Antalya", "5329123234", 3200);

        Course course1 = new Course("Operating System Concepts", "CE323", 7);
        Course course2 = new Course("Digital Design", "EEE242", 5);
        Course course3 = new Course("Principles of Software Engineering", "SE302", 5);

        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(permanentInstructor2);
        course3.setInstructor(visitingResearcher1);

        ((Student) student1).getCourses().add(course1);
        ((Student) student1).getCourses().add(course2);
        ((Student) student1).getCourses().add(course3);
        ((Student) student2).getCourses().add(course1);
        ((Student) student2).getCourses().add(course2);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(student1);
            em.persist(student2);

            em.persist(permanentInstructor1);
            em.persist(permanentInstructor2);
            em.persist(visitingResearcher1);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);

            em.getTransaction().commit();

            System.out.println("All data persisted...");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }


    }
}
