package com.kau.hms.service;

import java.util.List;

import com.kau.hms.entity.Appointment;

import org.springframework.data.domain.Page;

public interface AppointmentService {
	List<Appointment> getAllAppointments();
	
	Appointment saveAppointment(Appointment appointment);
	
	Appointment getAppointmentById(Long id);
	
	Appointment updateAppointment(Appointment appointment);
	
	void deleteAppointmentById(Long id);

	Page<Appointment> findPaginated(int pageNo, int pageSize);
}
