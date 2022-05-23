package com.kau.hms.service;

import java.util.List;

import com.kau.hms.entity.Patient;

import org.springframework.data.domain.Page;

public interface PatientService {
	List<Patient> getAllPatients();
	
	Patient savePatient(Patient patient);
	
	Patient getPatientById(Long id);
	
	Patient updatePatient(Patient patient);
	
	void deletePatientById(Long id);

	Page<Patient> findPaginated(int pageNo, int pageSize);
}
