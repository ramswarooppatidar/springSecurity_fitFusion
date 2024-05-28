package com.CN.FitFusion.security;
import com.CN.FitFusion.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return this.userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
	}

	
}

