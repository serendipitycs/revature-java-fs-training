package com.sylvie.sprigchallenge.rest;

import com.sylvie.sprigchallenge.domain.Course;
import com.sylvie.sprigchallenge.domain.Enrollment;
import com.sylvie.sprigchallenge.domain.Student;
import com.sylvie.sprigchallenge.dto.EnrollmentWriteDTO;
import com.sylvie.sprigchallenge.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final StudentService studentService;

    public CourseController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Course> insertCourse(@Valid @RequestBody String name) {
        Course savedCourse = studentService.insertCourse(name);

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedCourse.getId())
                        .toUri()
        ).body(savedCourse);
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return studentService.getAllCourses();
    }
}
