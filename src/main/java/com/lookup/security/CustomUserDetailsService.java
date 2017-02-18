package com.lookup.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lookup.model.User;
import com.lookup.service.UserService;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		User user = userService.findUserBySsoId(id);
		if(user == null){
			throw new UsernameNotFoundException("userName not found");	
		}
		
		return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),getGrantedAuthorities() );
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }

}
