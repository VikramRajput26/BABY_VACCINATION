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

import com.app.dto.VaccineScheduleDTO;
import com.app.services.VaccineScheduleService;

@RestController
@RequestMapping("/vaccine-schedules")
public class VaccineScheduleController {

	private final VaccineScheduleService vaccineScheduleService;

	public VaccineScheduleController(VaccineScheduleService vaccineScheduleService) {
		this.vaccineScheduleService = vaccineScheduleService;
	}

	@PostMapping
	public ResponseEntity<VaccineScheduleDTO> createVaccineSchedule(
			@RequestBody VaccineScheduleDTO vaccineScheduleDTO) {
		return ResponseEntity.ok(vaccineScheduleService.createVaccineSchedule(vaccineScheduleDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<VaccineScheduleDTO> getVaccineScheduleById(@PathVariable int id) {
		return ResponseEntity.ok(vaccineScheduleService.getVaccineScheduleById(id));
	}

	@GetMapping
	public ResponseEntity<List<VaccineScheduleDTO>> getAllVaccineSchedules() {
		return ResponseEntity.ok(vaccineScheduleService.getAllVaccineSchedules());
	}

	@PutMapping("/{id}")
	public ResponseEntity<VaccineScheduleDTO> updateVaccineSchedule(@PathVariable int id,
			@RequestBody VaccineScheduleDTO vaccineScheduleDTO) {
		return ResponseEntity.ok(vaccineScheduleService.updateVaccineSchedule(id, vaccineScheduleDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVaccineSchedule(@PathVariable int id) {
		vaccineScheduleService.deleteVaccineSchedule(id);
		return ResponseEntity.noContent().build();
	}
}
