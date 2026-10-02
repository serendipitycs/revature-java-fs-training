package com.sylvie.sprigchallenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 20)
    @NotBlank
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @OneToMany(
        mappedBy = "school",
        fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

    public School() {}

    public School(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setSchool(this);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
        student.setSchool(null);
    }
}
