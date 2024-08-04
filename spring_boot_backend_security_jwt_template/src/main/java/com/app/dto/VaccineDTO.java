package com.app.dto;

import lombok.Data;

@Data
public class VaccineDTO {
	private int vaccineId;
	private String vaccineName;
	private String description;
	private int recommendedAge;
	private String sideEffects;
}
