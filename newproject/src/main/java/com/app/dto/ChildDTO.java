package com.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChildDTO {
	private int childId;
	private UserDTO parent;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Gender gender;
	private String bloodType;
}
