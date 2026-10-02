package com.sylvie.sprigchallenge.dao;

import com.sylvie.sprigchallenge.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
