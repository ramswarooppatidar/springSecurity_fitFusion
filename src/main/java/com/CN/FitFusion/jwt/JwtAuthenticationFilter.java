package com.CN.FitFusion.jwt;
//package com.CN.FitFusion.jwt;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.*;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;

import org.springframework.security.authentication.*;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	JwtAuthenticationHelper jwtHelper;
	
	@Autowired
	UserDetailsService userDetailsService;
	protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException{
		String requestHeader = request.getHeader("Authorization");
		//Bearer  gdayuhjsadhJDSKDBsjkkjKJJsjka
		String username= null;
		String token = null;
		
		if(requestHeader != null && requestHeader.startsWith("Bearer")) {
			 token= requestHeader.substring(7);
			 username = jwtHelper.getUsernameFromToken(token);
			 
			 if(username != null &&  SecurityContextHolder.getContext().getAuthentication() == null) {
				 UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				 
				 if(!jwtHelper.isTokenExpired(token)) {
					 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
							 new UsernamePasswordAuthenticationToken(token , null, userDetails.getAuthorities());
						
					 usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						
					 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				 }
			 }
			
		}
		filterChain.doFilter(request, response);
	}

}

