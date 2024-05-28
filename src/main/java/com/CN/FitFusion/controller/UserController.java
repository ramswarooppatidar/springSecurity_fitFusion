package com.CN.FitFusion.controller;
import org.springframework.web.bind.annotation.*;
import com.CN.FitFusion.dto.*;
import com.CN.FitFusion.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import java.util.*;
import com.CN.FitFusion.service.*;

@RestController
@RequestMapping("/user")
public class UserController {

	/*
	 * ADMIN APIs:
	 * 
	 * • GET “/user/all”: This API lets the admin fetch all users. It returns an OK
	 * response status.
	 * 
	 * • GET “/user/{id}” (@PathVariable Long id): This API allows the admin to
	 * fetch a user by its ID. It returns an OK response status.
	 * 
	 * • PUT “/user/{id}” (@RequestBody UserDto userDto, @PathVariable Long id):
	 * This API allows the admin to update a user by its ID. It returns an OK
	 * response status.
	 * 
	 * • DELETE “/user/{id}” (@PathVariable Long id): This API allows the admin to
	 * delete a user by its ID. It returns an OK response status.
	 * 
	 * CUSTOMER APIs:
	 * 
	 * • GET “/user/exercise/{id}" (@PathVariable Long id): This API lets the
	 * customer fetch all his/her exercises by the userId. It returns an OK response
	 * status.
	 * 
	 * • GET “/user/diet/{id}" (@PathVariable Long id): This API lets the customer
	 * fetch all his/her diets by the userId. It returns an OK response status.
	 * 
	 * PUBLIC APIs:
	 * 
	 * • POST “/user/register” (@RequestBody UserDto userDto): This API allows the
	 * user to register and be assigned a role. (Take reference from the Gym
	 * Application)
	 * 
	 * 5. Create the following classes in the service package for the APIs and
	 * implement the business logic:
	 */
	@Autowired
	UserService userService;

	@GetMapping("/all")
	public List<User> fetchAllUsers() {
		return userService.fetchAllUsers();
	}

	@GetMapping("/{id}")
	public User grtUsersById(@PathVariable Long id) {
		return userService.fetchUserById(id);
	}
	
	@PutMapping("/{id}")
	public void updateUsersById(@RequestBody UserDto userDto,@PathVariable Long id) {
		userService.updateUsersById(userDto, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsersById(@PathVariable Long id) {
		userService.deleteUsersById(id);
	}
	
	//customer api
	
	@GetMapping("/exercise/{id}")
	public Exercise getExerciseByUserId(@PathVariable Long id) {
		return userService.getExerciseByUserId(id);
	}
	
	@GetMapping("/diet/{id}")
	public Diet getDietByUserId(@PathVariable Long id) {
		return userService.getDietByUserId(id);
	}
	
	
	//public 
	@PostMapping("/register")
	public void createUser(@RequestBody UserDto userDto) {
		userService.createUser(userDto);
	}

}
