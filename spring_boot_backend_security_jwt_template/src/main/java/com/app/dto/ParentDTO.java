package com.app.dto;

import lombok.Data;

@Data
public class ParentDTO {
	private int parentId;
	private int userId;
	private String name;
	private String email;
	private String contactNumber;
}
