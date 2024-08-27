package com.agcodes.reactDemo.student;

import com.agcodes.reactDemo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("students")
@Validated
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
//        throw new ApiRequestException("Ops No students with custom exception!");
//        throw new IllegalStateException("Opss No students found!");
        return studentService.getAllStudents();
     }

    @GetMapping("{studentId}/courses")
    public List<StudentCourse> getStudentCourses(@PathVariable UUID studentId) {
        return studentService.getStudentCourses(studentId);
    }

    @PostMapping
    public void addNewStudent(@RequestBody @Valid Student student){
//         System.out.println(student.toString());
         studentService.addNewStudent(student);

     }
//@PostMapping
//public ResponseEntity<String> addNewStudent(@Valid @RequestBody Student student, BindingResult bindingResult) {
//    if (bindingResult.hasErrors()) {
//        // Handle validation errors
//        return ResponseEntity.badRequest().body("Validation error: " + bindingResult.getAllErrors());
//    } else {
//        studentService.addNewStudent(student);
//        return ResponseEntity.ok("Student added successfully");
//    }
//
//    @PostMapping
//    public ResponseEntity<String> addNewStudent(@RequestBody @Valid Student student, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            // Print validation errors for debugging
//            System.out.println("Validation errors: " + bindingResult.getAllErrors());
//            return ResponseEntity.badRequest().body("Validation error: " + bindingResult.getAllErrors());
//        } else {
//            studentService.addNewStudent(student);
//            return ResponseEntity.ok("Student added successfully");
//        }
//    }


}




