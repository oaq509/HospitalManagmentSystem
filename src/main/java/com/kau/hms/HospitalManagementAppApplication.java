package com.kau.hms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kau.hms.repository.PatientRepository;

@SpringBootApplication
public class HospitalManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementAppApplication.class, args);
	}

	@Autowired
	private PatientRepository patientRepository;

	public void run(String... args) throws Exception {

	}

}
