package com.sylvie.sprigchallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollmentWriteDTO {
    @JsonProperty("course_id")
    private Integer courseId;
    @JsonProperty("student_id")
    private Integer studentId;
    @JsonProperty("grade")
    private String grade;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
