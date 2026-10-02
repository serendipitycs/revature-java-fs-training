package com.sylvie.sprigchallenge.rest;

import com.sylvie.sprigchallenge.domain.School;
import com.sylvie.sprigchallenge.domain.Student;
import com.sylvie.sprigchallenge.dto.StudentWriteDTO;
import com.sylvie.sprigchallenge.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int count,
            @RequestParam(defaultValue = "true") boolean asc) {
        return studentService.getAllStudents(page, count, asc);
    }

    @PostMapping
    public ResponseEntity<Student> insertStudent(@Valid @RequestBody StudentWriteDTO student) {
        Student savedStudent = studentService.insertStudent(student);

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedStudent.getId())
                        .toUri()
            ).body(savedStudent);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping(params = "lastName")
    public List<Student> getStudentByLastName(@RequestParam String lastName) {
        return studentService.getStudentsByLastName(lastName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @Valid @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @GetMapping(params = "school")
    public List<Student> getStudentsBySchoolName(@RequestParam String school) {
        return studentService.findStudentsBySchoolName(school);
    }
}