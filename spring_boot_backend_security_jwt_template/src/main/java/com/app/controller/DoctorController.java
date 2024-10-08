package com.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DoctorDTO;
import com.app.services.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	private final DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	@PostMapping
	public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
		return ResponseEntity.ok(doctorService.createDoctor(doctorDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable int id) {
		return ResponseEntity.ok(doctorService.getDoctorById(id));
	}

	@GetMapping
	public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
		return ResponseEntity.ok(doctorService.getAllDoctors());
	}

	@PutMapping("/{id}")
	public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable int id, @RequestBody DoctorDTO doctorDTO) {
		return ResponseEntity.ok(doctorService.updateDoctor(id, doctorDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable int id) {
		doctorService.deleteDoctor(id);
		return ResponseEntity.noContent().build();
	}
}
