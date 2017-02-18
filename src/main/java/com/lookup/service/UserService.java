package com.lookup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.lookup.dao.repository.UserRepository;
import com.lookup.model.User;

public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly=true)
	public User findUserBySsoId(String ssoId){
		if(ssoId == null)
			return null;
		return userRepository.findUserBySsoID(ssoId);
	}

}
