package com.SmartContactManager_2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.SmartContactManager_2.Repository.UserRepository;
import com.SmartContactManager_2.model.User;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	 System.out.println("c-2");
	 User user = userRepository.getUserByEmail(email);
	  if (user == null) {
          throw new UsernameNotFoundException("Could not find user");
      }
	    System.out.println("c2_>2");
		return new MyUserDetails(user);
		
	}

}
