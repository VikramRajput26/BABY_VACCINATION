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

import com.app.dto.ChildDTO;
import com.app.services.ChildService;

@RestController
@RequestMapping("/children")
public class ChildController {

	private final ChildService childService;

	public ChildController(ChildService childService) {
		this.childService = childService;
	}

	@PostMapping
	public ResponseEntity<ChildDTO> createChild(@RequestBody ChildDTO childDTO) {
		return ResponseEntity.ok(childService.createChild(childDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ChildDTO> getChildById(@PathVariable int id) {
		return ResponseEntity.ok(childService.getChildById(id));
	}

	@GetMapping
	public ResponseEntity<List<ChildDTO>> getAllChildren() {
		return ResponseEntity.ok(childService.getAllChildren());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ChildDTO> updateChild(@PathVariable int id, @RequestBody ChildDTO childDTO) {
		return ResponseEntity.ok(childService.updateChild(id, childDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteChild(@PathVariable int id) {
		childService.deleteChild(id);
		return ResponseEntity.noContent().build();
	}
}
