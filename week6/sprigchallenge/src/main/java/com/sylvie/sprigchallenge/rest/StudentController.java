package com.sylvie.sprigchallenge.rest;

import com.sylvie.sprigchallenge.domain.School;
import com.sylvie.sprigchallenge.domain.Student;
import com.sylvie.sprigchallenge.dto.StudentWriteDTO;
import com.sylvie.sprigchallenge.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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

    @QueryMapping
    public Student studentById(@Argument int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a student", description = "Returns a student by its ID")
    @ApiResponse(responseCode = "200", description = "Student found")
    @ApiResponse(responseCode = "404", description = "Student not found")
    public Student getStudentById(@Parameter(description = "Unique student ID") @PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping(params = "lastName")
    @Operation(summary = "Get student(s)", description = "Returns all students by their last name")
    @ApiResponse(responseCode = "200", description = "Student found")
    @ApiResponse(responseCode = "404", description = "Student not found")
    public List<Student> getStudentByLastName(@Parameter(description = "Student's last name") @RequestParam String lastName) {
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

    @MutationMapping
    public Student createStudent(@Argument String firstName, @Argument String lastName, @Argument String email, @Argument int schoolId) {
        StudentWriteDTO student = new StudentWriteDTO();
        student.setLastName(lastName);
        student.setFirstName(firstName);
        student.setEmail(email);
        student.setSchoolId(schoolId);
        return studentService.insertStudent(student);
    }

    @GetMapping(params = "school")
    public List<Student> getStudentsBySchoolName(@RequestParam String school) {
        return studentService.findStudentsBySchoolName(school);
    }

    @GetMapping(params = "topFiveFrom")
    public List<Student> getTopFiveStudentsFromSchool(@RequestParam String topFiveFrom) {
        return studentService.getTopFiveStudentsAlphabeticallyBySchool(topFiveFrom);
    }
}