package com.kau.hms.service;

import java.util.List;
import com.kau.hms.entity.Doctor;
import org.springframework.data.domain.Page;

public interface DoctorService {
	List<Doctor> getAllDoctors();

	Doctor saveDoctor(Doctor doctor);

	Doctor getDoctorById(Long id);

	Doctor updateDoctor(Doctor doctor);

	void deleteDoctorById(Long id);

	Page<Doctor> findPaginated(int pageNo, int pageSize);
}
