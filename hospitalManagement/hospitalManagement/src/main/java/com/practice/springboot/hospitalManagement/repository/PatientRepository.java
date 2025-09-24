package com.practice.springboot.hospitalManagement.repository;

import com.practice.springboot.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
