package com.kau.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // use this annotation to declare your class as entitiy class
@Table(name = "appointments") // creating appointment table
public class Appointment {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // rule
	private Long id;

	@Column(name = "patient_name", nullable = false)
	private String patientName;

	@Column(name = "patient_phone", nullable = false)
	private String patientPhone;

	@Column(name = "doctor_name", nullable = false)
	private String doctorName;

	@Column(name = "date", nullable = false)
	private String date;

	@Column(name = "hour", nullable = false)
	private String hour;

	public Appointment() {

	}

	public Appointment(String patientName, String patientPhone, String doctorName, String date, String hour) {
		this.patientName = patientName;
		this.patientPhone = patientPhone;
		this.doctorName = doctorName;
		this.date = date;
		this.hour = hour;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

}
