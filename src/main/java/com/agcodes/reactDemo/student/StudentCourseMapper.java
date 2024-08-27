package com.agcodes.reactDemo.student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
public class StudentCourseMapper implements RowMapper<StudentCourse> {

   @Override
    public StudentCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudent_id(UUID.fromString(rs.getString("student_id")));
        studentCourse.setStart_date(rs.getDate("start_date").toLocalDate());
        studentCourse.setEnd_date(rs.getDate("end_date").toLocalDate());
        studentCourse.setGrade(Optional.ofNullable(rs.getString("grade"))
                        .map(Integer::parseInt)
                        .orElse(null));
//        studentCourse.setGrade(rs.getInt("grade"));

/*  ResultSet does not directly support the stream() method. Instead, we need to manually iterate over the result set rows using a loop. */

       // Initialize list to hold courses for this student course
       List<Course> courses = new ArrayList<>();

       // Iterate over the result set to get courses
       do {
           Course course = new Course();
           course.setCourseId(UUID.fromString(rs.getString("course_id")));
           course.setName(rs.getString("name"));
           course.setDescription(rs.getString("description"));
           course.setDepartment(rs.getString("department"));
           course.setTeacherName(rs.getString("teacher_name"));
           // Add course to the list
           courses.add(course);
       } while (rs.next()); // Continue until all rows for this student course are processed

       // Set the list of courses for this student course
       studentCourse.setCourses(courses);

        return studentCourse;
    }

}
