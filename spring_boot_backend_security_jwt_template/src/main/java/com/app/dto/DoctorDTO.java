package com.app.dto;

import lombok.Data;

@Data
public class DoctorDTO {
	private int doctorId;
	private int userId;
	private String name;
	private String email;
	private String contactNumber;
}
