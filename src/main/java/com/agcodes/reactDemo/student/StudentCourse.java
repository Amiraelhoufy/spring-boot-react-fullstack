package com.agcodes.reactDemo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
public class StudentCourse {
    private UUID student_id;
    private LocalDate start_date;
    private LocalDate end_date;

    private Integer grade;
    private List<Course> courses; // Change to a collection of courses


    public StudentCourse(UUID studentId, UUID courseId, LocalDate startDate, LocalDate endDate, Integer grade,List<Course> courses) {
        student_id = studentId;
        start_date = startDate;
        end_date = endDate;
        this.grade = grade;
        this.courses = courses;
    }

    public  StudentCourse(){

    }
    public UUID getStudent_id() {
        return student_id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public Integer getGrade() {
        return grade;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setStudent_id(UUID student_id) {
        this.student_id = student_id;
    }


    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }


    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
