package com.sylvie.sprigchallenge.dao;

import com.sylvie.sprigchallenge.domain.School;
import com.sylvie.sprigchallenge.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByLastName(String lastName);

    List<Student> findBySchool_Name(String name);

    Page<Student> findAll(Pageable pageable);
}
