package com.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Vaccine_Schedules")
@Data
public class VaccineSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scheduleId;

	@ManyToOne
	@JoinColumn(name = "child_id", referencedColumnName = "childId")
	private Child child;

	@ManyToOne
	@JoinColumn(name = "vaccine_id", referencedColumnName = "vaccineId")
	private Vaccine vaccine;

	private Date scheduledDate;
	private Date administeredDate;

	@Enumerated(EnumType.STRING)
	private Status status;

	public enum Status {
		pending, administered, missed
	}
}
