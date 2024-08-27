package com.agcodes.reactDemo.student;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
@Component
public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student(
                UUID.fromString(rs.getString("student_id")),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                Student.Gender.valueOf(rs.getString("gender").toUpperCase()
                        )
        );
        return student;
    }
}
