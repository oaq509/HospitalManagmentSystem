package com.kau.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kau.hms.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
