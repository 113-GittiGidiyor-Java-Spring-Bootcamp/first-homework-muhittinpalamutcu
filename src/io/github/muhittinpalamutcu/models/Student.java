package io.github.muhittinpalamutcu.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student extends Person {
    private LocalDate birthDate;
    private String gender;

    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    public Student(String name, String address, LocalDate birthDate, String gender) {
        super(name, address);
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Student(LocalDate birthDate, String gender) {
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Student(){

    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(birthDate, student.birthDate) &&
                Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), birthDate, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                '}';
    }
}
