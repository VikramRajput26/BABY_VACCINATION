package com.app.dto;

import lombok.Data;

@Data
public class AppointmentDTO {
	private int appointmentId;
	private int childId;
	private int doctorId;
	private String appointmentDate;
	private String reason;
	private String status;
}
