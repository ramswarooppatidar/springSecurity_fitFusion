package com.CN.FitFusion.controller;
import org.springframework.web.bind.annotation.*;
import com.CN.FitFusion.dto.*;
import com.CN.FitFusion.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	//  POST “/auth/login” (@RequestBody JwtRequest jwtRequest)
	@Autowired
	AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
		JwtResponse jwtResponse = authService.login(jwtRequest);
		return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
	}
}
