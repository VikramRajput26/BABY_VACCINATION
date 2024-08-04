package com.app.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

	@NotBlank(message = "Password is Mandatory!!!")
	private String password;

	@NotBlank(message = "Email is Mandatory!!!")
	@Email(message = "Email format is Invalid!!!")
	private String email;

	@NotNull(message = "Role is Mandatory!!!")
	private Set<RoleDTO> roles = new HashSet<>();
}
