package com.kau.hms.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.kau.hms.entity.Doctor;
import com.kau.hms.repository.DoctorRepository;
import com.kau.hms.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;

	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	};

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	};

	@Override
	public Doctor getDoctorById(Long id) {
		return doctorRepository.findById(id).get();
	};

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	};

	@Override
	public void deleteDoctorById(Long id) {
		doctorRepository.deleteById(id);
	}

	@Override
	public Page<Doctor> findPaginated(int pageNo, int pageSize) {
		// first page 1 it will be pass 0 instead
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return this.doctorRepository.findAll(pageable);
	}

}
