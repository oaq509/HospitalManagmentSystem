package com.kau.hms.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import com.kau.hms.entity.Doctor;
import com.kau.hms.service.DoctorService;

@Controller
public class DoctorController {

	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}

	// handler method to handle list students and return mode and view
	@GetMapping("/doctors")
	public String listDoctors(Model model) {
		// model.addAttribute("doctors", doctorService.getAllDoctors());
		return findPaginated(1, model);
		// return "doctors";
	}

	@GetMapping("/doctors/new")
	public String createDoctorsForm(Model model) {

		// create student object to hold student form data
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		return "create_doctor";

	}

	@PostMapping("/doctors")
	public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return "redirect:/doctors";
	}

	@GetMapping("/doctors/edit/{id}")
	public String editDoctorForm(@PathVariable Long id, Model model) {
		model.addAttribute("doctor", doctorService.getDoctorById(id));
		return "edit_doctor";
	}

	@PostMapping("/doctors/{id}")
	public String updateDoctor(@PathVariable Long id,
			@ModelAttribute("doctor") Doctor doctor,
			Model model) {

		// get doctor from database by id
		Doctor existingDoctor = doctorService.getDoctorById(id);
		existingDoctor.setId(id);
		existingDoctor.setFirstName(doctor.getFirstName());
		existingDoctor.setLastName(doctor.getLastName());
		existingDoctor.setEmail(doctor.getEmail());
		existingDoctor.setPhone_number(doctor.getPhone_number());
		existingDoctor.setMajor(doctor.getMajor());

		// save updated doctor object
		doctorService.updateDoctor(existingDoctor);
		return "redirect:/doctors";
	}

	// handler method to handle delete doctor request

	@GetMapping("/doctors/{id}")
	public String deleteDoctor(@PathVariable Long id) {
		doctorService.deleteDoctorById(id);
		return "redirect:/doctors";
	}

	@GetMapping("/doctors/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model) {
		int pageSize = 6;
		Page<Doctor> page = doctorService.findPaginated(pageNo, pageSize);
		List<Doctor> listDoctors = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listDoctors", listDoctors);
		return "doctors";
	}	

}
