package com.SmartContactManager_2.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.SmartContactManager_2.model.Role;
import com.SmartContactManager_2.model.User;


public class MyUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public MyUserDetails(User user) {
		super();
		System.out.println("MyUserDetails.MyUserDetails()");
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("c->6");
		Set<Role> roles = user.getRoles();
	    List<SimpleGrantedAuthority> auntority = new ArrayList<>();
		for(Role r:roles) {
			auntority.add(new SimpleGrantedAuthority(r.getName()));
		}
		System.out.println("auntority->"+auntority);
		return auntority;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
