package com.kau.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kau.hms.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
}
