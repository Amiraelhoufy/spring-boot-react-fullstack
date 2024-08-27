package com.agcodes.reactDemo.student;

import java.util.UUID;

public class Course {

    private UUID courseId;
    private String name;
    private String description;
    private String department;
    private String teacherName;


    public Course(UUID courseId, String name, String description, String department, String teacherName) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.department = department;
        this.teacherName = teacherName;
    }
    public Course(){

    }

    public UUID getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartment() {
        return department;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
