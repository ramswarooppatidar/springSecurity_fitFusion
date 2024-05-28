package com.CN.FitFusion.service;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.*;
import com.CN.FitFusion.dto.JwtRequest;
import com.CN.FitFusion.dto.JwtResponse;
import  com.CN.FitFusion.jwt.JwtAuthenticationHelper;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.*;
@Service
public class AuthService {

	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	JwtAuthenticationHelper jwtHelper;
	
	@Autowired
	UserDetailsService userDeatilsService;
	
	public JwtResponse login(JwtRequest jwtRequest) {
		// Authenticate  and Authenticate,anager
		this.doAuthenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		
		UserDetails userDetails = userDeatilsService.loadUserByUsername(jwtRequest.getUsername());
		String token = jwtHelper.generateToken(userDetails);
		
		JwtResponse jwtResponse = new JwtResponse();
		jwtResponse.setJwtToken(token);
		return jwtResponse;
	}

	private void doAuthenticate(String username, String password) {
		
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(username, password);
		try {
			manager.authenticate(authenticationToken);
		}catch(BadCredentialsException e) {
			throw new BadCredentialsException("Invalid username password");
		}
		
	}
}
