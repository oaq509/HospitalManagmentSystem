package com.kau.hms.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kau.hms.entity.Appointment;
import com.kau.hms.entity.Patient;
import com.kau.hms.entity.Doctor;
import com.kau.hms.service.AppointmentService;
import com.kau.hms.service.PatientService;
import com.kau.hms.service.DoctorService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AppointmentController {

	private AppointmentService appointmentService;
	private PatientService patientService;
	private DoctorService doctorService;

	public AppointmentController(AppointmentService appointmentService, PatientService patientService,
			DoctorService doctorService) {
		super();
		this.appointmentService = appointmentService;
		this.patientService = patientService;
		this.doctorService = doctorService;
	}

	// handler method to handle list Appointments and return mode and view

	@GetMapping("/")
	public String homePage(Model model) {

		List<Appointment> listAppointments = appointmentService.getAllAppointments();
		List<Patient> listPatients = patientService.getAllPatients();
		List<Doctor> listDoctors = doctorService.getAllDoctors();
		// LocalDateTime currentDate = LocalDateTime.now();
		
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("hh:mm - M/dd/yyyy");
		String currentDate = DateFor.format(date);
		

		model.addAttribute("currentDate", currentDate);
		model.addAttribute("listAppointments", listAppointments.size());
		model.addAttribute("listPatients", listPatients.size());
		model.addAttribute("listDoctors", listDoctors.size());

		return "index";
		// return "Appointments";
	}

	@GetMapping("/appointments")
	public String listAppointments(Model model) {
		// model.addAttribute("Appointments", AppointmentService.getAllAppointments());
		return findPaginated(1, model);
		// return "Appointments";
	}

	@GetMapping("/appointments/new")
	public String createAppointmentForm(Model model) {

		// create Appointment object to hold Appointment form data
		Appointment appointment = new Appointment();

		List<Patient> listPatients = patientService.getAllPatients();
		List<Doctor> listDoctors = doctorService.getAllDoctors();

		model.addAttribute("listPatients", listPatients);
		model.addAttribute("listDoctors", listDoctors);
		model.addAttribute("appointment", appointment);

		return "create_appointment";

	}

	@PostMapping("/appointments")
	public String saveAppointment(@ModelAttribute("appointment") Appointment appointment, HttpServletRequest request,
			HttpServletResponse response) {
		// appointmentService.saveAppointment(appointment);
		String patient_id = request.getParameter("patient_id");
		Patient patient = new Patient();
		patient = patientService.getPatientById(Long.parseLong(patient_id));

		String doctor_id = request.getParameter("doctor_id");
		Doctor doctor = new Doctor();
		doctor = doctorService.getDoctorById(Long.parseLong(doctor_id));

		String patientName = patient.getFirstName() + " " + patient.getLastName();
		String patientPhone = patient.getPhone_number();
		String doctorName = doctor.getFirstName() + " " + doctor.getLastName();
		String date = request.getParameter("date");
		String hour = request.getParameter("hour");

		// save updated Appointment object
		Appointment newAppointment = new Appointment(patientName, patientPhone, doctorName, date, hour);
		appointmentService.saveAppointment(newAppointment);

		return "redirect:/appointments";
	}

	@GetMapping("/appointments/edit/{id}")
	public String editAppointmentForm(@PathVariable Long id, Model model) {
		model.addAttribute("appointment", appointmentService.getAppointmentById(id));
		return "edit_appointment";
	}

	@PostMapping("/appointments/{id}")
	public String updateAppointment(@PathVariable Long id,
			@ModelAttribute("appointment") Appointment Appointment,
			Model model) {

		// get Appointment from database by id
		Appointment existingAppointment = appointmentService.getAppointmentById(id);
		existingAppointment.setId(id);
		existingAppointment.setPatientName(Appointment.getPatientName());
		existingAppointment.setPatientPhone(Appointment.getPatientPhone());
		existingAppointment.setDoctorName(Appointment.getDoctorName());
		existingAppointment.setDate(Appointment.getDate());
		existingAppointment.setHour(Appointment.getHour());

		// save updated Appointment object
		appointmentService.updateAppointment(existingAppointment);
		return "redirect:/appointments";
	}

	// handler method to handle delete Appointment request

	@GetMapping("/appointments/{id}")
	public String deleteAppointment(@PathVariable Long id) {
		appointmentService.deleteAppointmentById(id);
		return "redirect:/appointments";
	}

	@GetMapping("/appointments/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
		int pageSize = 6;
		Page<Appointment> page = appointmentService.findPaginated(pageNo, pageSize);
		List<Appointment> listAppointments = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listAppointments", listAppointments);
		return "appointments";
	}

}
