package com.agcodes.reactDemo.student;

import com.agcodes.reactDemo.exception.ApiRequestException;
import com.agcodes.reactDemo.utils.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;
    private final EmailValidator emailValidator;

    @Autowired
    public StudentService(@Qualifier("jdbc") StudentDao studentDao, EmailValidator emailValidator) {
        this.studentDao = studentDao;
        this.emailValidator = emailValidator;
    }

     List<Student> getAllStudents(){

     return studentDao.selectAllStudents();
    }

    void addNewStudent(Student student) {
        addNewStudent(null,student);
    }

     void addNewStudent(UUID studentId,Student student) {

        // Validate Email
         if(!emailValidator.test(student.getEmail())){
            throw new ApiRequestException("Student Email: " + student.getEmail() + "is not Valid!");
         }
         // Verify Email is not taken
         if(studentDao.isEmailTaken(student.getEmail())){
             throw  new ApiRequestException("This email address: " + student.getEmail() + " already exists");

         }

             UUID newStudentId = Optional.ofNullable(studentId)
                     .orElse(UUID.randomUUID());
             studentDao.addNewStudent(newStudentId,student);

    }

    List<StudentCourse> getStudentCourses(UUID studentId){

        return studentDao.getStudentCourses(studentId);
    }
}
