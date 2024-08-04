package com.app.dto;

import lombok.Data;

@Data
public class ChildDTO {
	private int childId;
	private int parentId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String bloodType;
}
