package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Parents")
@Data
public class Parent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parentId;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	private String name;
	private String email;
	private String contactNumber;
}
