package com.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppointmentDTO;
import com.app.services.AppointmentService;

@RestController
@RequestMapping("/appointments")
@CrossOrigin("*")
public class AppointmentController {

	private final AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	@PostMapping
	public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
		return ResponseEntity.ok(appointmentService.createAppointment(appointmentDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable int id) {
		return ResponseEntity.ok(appointmentService.getAppointmentById(id));
	}

	@GetMapping
	public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
		return ResponseEntity.ok(appointmentService.getAllAppointments());
	}

    @PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable int id,
			@RequestBody AppointmentDTO appointmentDTO) {
		return ResponseEntity.ok(appointmentService.updateAppointment(id, appointmentDTO));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAppointment(@PathVariable int id) {
		appointmentService.deleteAppointment(id);
		return ResponseEntity.noContent().build();
	}
}
