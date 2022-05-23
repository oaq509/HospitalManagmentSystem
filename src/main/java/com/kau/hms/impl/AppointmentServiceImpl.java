package com.kau.hms.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kau.hms.entity.Appointment;
import com.kau.hms.repository.AppointmentRepository;
import com.kau.hms.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentRepository appointmentRepository;

	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment getAppointmentById(Long id) {
		return appointmentRepository.findById(id).get();
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public void deleteAppointmentById(Long id) {
		appointmentRepository.deleteById(id);
	}

	@Override
	public Page<Appointment> findPaginated(int pageNo, int pageSize) {
		// first page 1 it will be pass 0 instead
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return this.appointmentRepository.findAll(pageable);
	}

}
