package com.sylvie.sprigchallenge.rest;

import com.sylvie.sprigchallenge.domain.Course;
import com.sylvie.sprigchallenge.domain.Enrollment;
import com.sylvie.sprigchallenge.domain.Student;
import com.sylvie.sprigchallenge.dto.EnrollmentWriteDTO;
import com.sylvie.sprigchallenge.dto.StudentWriteDTO;
import com.sylvie.sprigchallenge.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final StudentService studentService;

    public EnrollmentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Enrollment> insertEnrollment(@Valid @RequestBody EnrollmentWriteDTO enrollment) {
        Enrollment savedEnrollment = studentService.insertEnrollment(enrollment);

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedEnrollment.getId())
                        .toUri()
        ).body(savedEnrollment);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments(){
        return studentService.getAllEnrollments();
    }
}
