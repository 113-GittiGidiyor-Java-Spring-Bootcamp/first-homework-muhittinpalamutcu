package io.github.muhittinpalamutcu.controller;

import io.github.muhittinpalamutcu.models.Course;
import io.github.muhittinpalamutcu.models.Student;
import io.github.muhittinpalamutcu.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService = new StudentService();

    public Student findById(int id) {
        return studentService.findById(id);
    }

    public List<Student> findAll() {
        return studentService.findAll();
    }

    public void saveNewStudent(Student student) {
        studentService.saveToDatabase(student);
    }

    public void deleteStudent(int id) {
        studentService.deleteStudentFromDatabase(id);
    }

    public void updateStudent(int id, Student student) {
        studentService.updateOnDatabase(id, student);
    }

    public void updateStudentAddress(int id, String newAddress) {
        studentService.updateStudentAddressOnDatabase(id, newAddress);
    }

    public void studentEnrollInCourse(int id, String courseCode) {
        studentService.enrollInCourse(id, courseCode);
    }


}
