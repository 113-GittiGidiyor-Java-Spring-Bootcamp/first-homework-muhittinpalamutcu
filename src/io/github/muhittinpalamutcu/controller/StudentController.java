package io.github.muhittinpalamutcu.controller;

import io.github.muhittinpalamutcu.models.Student;
import io.github.muhittinpalamutcu.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService = new StudentService();

    public Student findById(int id){
        return studentService.findById(id);
    }

    public List<Student> findAll(){
        return studentService.findAll();
    }


}
