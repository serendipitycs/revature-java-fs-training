package com.sylvie.sprigchallenge.service;

import com.sylvie.sprigchallenge.dao.*;
import com.sylvie.sprigchallenge.domain.Enrollment;
import com.sylvie.sprigchallenge.domain.School;
import com.sylvie.sprigchallenge.domain.Student;
import com.sylvie.sprigchallenge.dto.StudentWriteDTO;
import com.sylvie.sprigchallenge.exceptions.RecordNotFoundException;
import com.sylvie.sprigchallenge.exceptions.StudentErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;
    private final SchoolRepository schoolRepo;
    private final EnrollmentRepository enrollmentRepo;

    public StudentService(StudentRepository studentRepo, CourseRepository courseRepo, SchoolRepository schoolRepo, EnrollmentRepository enrollmentRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.schoolRepo = schoolRepo;
        this.enrollmentRepo = enrollmentRepo;
    }

    @Transactional
    public Student insertStudent(StudentWriteDTO student){
        School school = schoolRepo.findById(student.getSchoolId()).orElse(null);
        Student newStudent = new Student(student.getFirstName(),student.getLastName(),student.getEmail(),school);
        return studentRepo.save(newStudent);
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents(int page, int count, boolean asc) {
        Sort.Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;

        Pageable pageable = PageRequest.of(page,count,Sort.by(direction,"id"));
        Page<Student> students = studentRepo.findAll(pageable);
        return students.getContent();
    }

    @Transactional(readOnly = true)
    public Student getStudentById(int id) {
        Student student = studentRepo.findById(id).orElseThrow(() ->  new RecordNotFoundException(("Student Not Found with Id: " + id)));
        return student;
    }

    @Transactional
    public void deleteStudent(int id) {
        studentRepo.delete(getStudentById(id));
    }

    @Transactional(readOnly = true)
    public List<Student> getStudentsByLastName(String lastName) {
        return studentRepo.findByLastName(lastName);
    }

    @Transactional
    public Student updateStudent(int id, Student student) {
        Student existingStudent = getStudentById(id);
        existingStudent.setEmail(student.getEmail());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return existingStudent;
    }

    @Transactional
    public School insertSchool(School school) {
        return schoolRepo.save(school);
    }

    @Transactional(readOnly = true)
    public List<Student> findStudentsBySchoolName(String name) {
        return studentRepo.findBySchool_Name(name);
    }

    @Transactional(readOnly = true)
    public School getSchoolById(int id) {
        School school = schoolRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("School not found with Id " + id));
        return school;
    }
}
