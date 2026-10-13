package com.sylvie.sprigchallenge.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student")
@Schema(description = "Student information")
public class Student {
    @Schema(description = "Unique student identifier", example = "7")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(
        mappedBy = "student",
        orphanRemoval = true,
        cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Enrollment> enrollments = new ArrayList<>();


    @Schema(description = "Student's first name", example = "Kimi")
    @Size(max=20)
    @Column(name = "first_name", length = 45)
    private String firstName;

    @Schema(description = "Student's last name", example = "Aaron")
    @Size(max=20)
    @Column(name = "last_name", length = 45)
    private String lastName;

    @Schema(description = "Student's email address", example = "johnny@gmail.com")
    @Email
    @NotBlank
    @Column(name = "email", length = 45, nullable = false, unique = true)
    private String email;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student(String firstName, String lastName, String email, School school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.school = school;
    }

    public Student() {

    }

    public Integer getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public School getSchool() { return this.school; }
    public void setSchool(School school) {this.school = school; }
    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
        enrollment.setStudent(this);
    }
    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
        enrollment.setStudent(null);
    }
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
}
