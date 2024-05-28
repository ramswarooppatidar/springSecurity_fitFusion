package com.CN.FitFusion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.Optional;
import com.CN.FitFusion.repository.*;
import com.CN.FitFusion.model.*;
import com.CN.FitFusion.dto.*;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Autowired
	private DietRepository dietRepository;

	public void createUser(UserDto userDto) {
		// Assuming you have a method to convert UserDto to User entity
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());

		User user = convertDtoToUser(userDto);
		user.setPassword(encodedPassword);
		
		Role role = new Role();
		Set<Role> roles = new HashSet<>();
		if (userDto.getUserType() != null) {
			if (userDto.getUserType().equalsIgnoreCase("ADMIN")) {
				role.setRoleName("ROLE_ADMIN");
				roles.add(role);
				user.setRoles(roles);
			} else if (userDto.getUserType().equalsIgnoreCase("TRAINER")) {
				role.setRoleName("ROLE_TRAINER");
				roles.add(role);
				user.setRoles(roles);
			} else {
				role.setRoleName("ROLE_CUSTOMER");
				roles.add(role);
				user.setRoles(roles);
			}

		} else {
			role.setRoleName("ROLE_CUSTOMER");
			roles.add(role);
			user.setRoles(roles);
		}

		userRepository.save(user);
	}

	public List<User> fetchAllUsers() {
		return userRepository.findAll();
	}

	public User fetchUserById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		return userOptional.orElse(null);
	}

	public void updateUsersById(UserDto userDto, Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		// Assuming you have a method to update user details based on UserDto
		// Implement according to your requirements
		userRepository.save(user);
	}

	public void deleteUsersById(Long id) {
		userRepository.deleteById(id);
	}

	public Exercise getExerciseByUserId(Long userId) {
		return exerciseRepository.findByUserId(userId); // Assuming you have a method in ExerciseRepository to find
														// exercise by user id
	}

	public Diet getDietByUserId(Long userId) {
		return dietRepository.findByUserId(userId); // Assuming you have a method in DietRepository to find diet by user
													// id
	}

	// Method to convert UserDto to User entity - implement according to your
	// requirements
	private User convertDtoToUser(UserDto userDto) {
		// Implement conversion logic here
		User user = new User();
		user.setAge(userDto.getAge());
		user.setContactNo(userDto.getContactNo());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setGender(userDto.getGender());
		return user;

	}
}
