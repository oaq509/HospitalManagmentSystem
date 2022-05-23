package com.kau.hms.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kau.hms.entity.Patient;
import com.kau.hms.repository.PatientRepository;
import com.kau.hms.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;

	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient getPatientById(Long id) {
		return patientRepository.findById(id).get();
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);
	}

	@Override
	public Page<Patient> findPaginated(int pageNo, int pageSize) {
		// first page 1 it will be pass 0 instead
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return this.patientRepository.findAll(pageable);
	}

}
