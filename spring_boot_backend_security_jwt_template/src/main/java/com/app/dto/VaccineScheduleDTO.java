package com.app.dto;

import lombok.Data;

@Data
public class VaccineScheduleDTO {
	private int scheduleId;
	private int childId;
	private int vaccineId;
	private String scheduledDate;
	private String administeredDate;
	private String status;
}
