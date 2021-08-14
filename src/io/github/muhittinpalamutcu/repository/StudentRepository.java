package io.github.muhittinpalamutcu.repository;

import io.github.muhittinpalamutcu.models.Course;
import io.github.muhittinpalamutcu.models.Student;

public interface StudentRepository {
    void deleteStudentFromDatabase(int id);

    void updateStudentAddressOnDatabase(int id, String address);

    void enrollInCourse(int id, String courseCode);
}
