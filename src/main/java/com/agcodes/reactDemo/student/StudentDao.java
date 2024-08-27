package com.agcodes.reactDemo.student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {
     List<Student> selectAllStudents();

     int addNewStudent(UUID studentId,Student student);

    boolean isEmailTaken(String email);

    List<StudentCourse> getStudentCourses(UUID studentId);
}
