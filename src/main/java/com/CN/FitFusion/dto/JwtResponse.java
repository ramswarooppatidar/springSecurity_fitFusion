package com.CN.FitFusion.dto;

public class JwtResponse {

	  String jwtToken;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}
	 
	public JwtResponse() {
		
	}
}
