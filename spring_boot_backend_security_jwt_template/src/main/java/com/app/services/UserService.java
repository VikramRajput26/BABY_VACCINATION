package com.app.services;

import java.util.Optional;

import com.app.dto.UserDTO;
import com.app.entity.User;

public interface UserService {
	Optional<User> findByEmail(String email);

	UserDTO registerUser(UserDTO userDTO);
}
