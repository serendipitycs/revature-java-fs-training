package com.sylvie.sprigchallenge.dao;

import com.sylvie.sprigchallenge.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

}
