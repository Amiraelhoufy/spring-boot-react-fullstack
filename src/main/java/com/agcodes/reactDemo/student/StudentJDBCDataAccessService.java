package com.agcodes.reactDemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("jdbc")
public class StudentJDBCDataAccessService implements StudentDao{

    private final JdbcTemplate jdbcTemplate;

    private final StudentRowMapper studentRowMapper;

    private final StudentCourseMapper studentCourseMapper;

    @Autowired
    public StudentJDBCDataAccessService(JdbcTemplate jdbcTemplate, StudentRowMapper studentRowMapper, StudentCourseMapper studentCourseMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentRowMapper = studentRowMapper;
        this.studentCourseMapper = studentCourseMapper;
    }

     public List<Student> selectAllStudents() {

        var sql = """
                SELECT student_id,first_name,last_name,email,gender
                FROM student
                """;

        return jdbcTemplate.query(sql, studentRowMapper);
    }

     public int addNewStudent(UUID studentId, Student student) {

        var sql = """
                INSERT INTO student(student_id,first_name,last_name,email,gender)
                VALUES(?,?,?,?,?::gender)
                """;
        int result= jdbcTemplate.update(sql,
                studentId,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getGender().name().toUpperCase());

        System.out.println("jdbcTemplate.update= " + result);
        return result;

    }

    public boolean isEmailTaken(String email) {

        var sql = """
                SELECT EXISTS(
                SELECT 1 
                FROM Student
                WHERE email = ?
                )
                """;

        return jdbcTemplate.queryForObject(
                sql
                ,new Object[] {email},
                (resultSet,i)->resultSet.getBoolean(1));

    }

    public List<StudentCourse> getStudentCourses(UUID studentId) {

        List<StudentCourse> studentCourses = new ArrayList<>();

        var sql = """
                SELECT 
                sc.student_id
                ,sc.course_id
                ,sc.start_date
                ,sc.end_date
                ,sc.grade
                ,c.name
                ,c.description
                ,c.department
                ,c.teacher_name
                FROM student_course sc 
                INNER JOIN course c on sc.course_id = c.course_id
                WHERE sc.student_id = ?
                """;

        return jdbcTemplate.query(sql,new Object[]{studentId}, studentCourseMapper);

    }

    //
//        return List.of(
//                new Student(UUID.randomUUID(),"Alexa","Daver","Alexa@gmail.com", Student.Gender.FEMALE),
//                new Student(UUID.randomUUID(),"Leen","Adams","lean@gmail.com", Student.Gender.FEMALE),
//                new Student(UUID.randomUUID(),"James","Bond","James@gmail.com", Student.Gender.MALE)
//
//        );

}
