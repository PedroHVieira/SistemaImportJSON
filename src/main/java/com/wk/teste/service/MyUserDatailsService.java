package com.wk.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wk.teste.model.MyUserDetails;
import com.wk.teste.model.User;
import com.wk.teste.repository.UserRepository;

@Service
public class MyUserDatailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Username ou password não encontrado");
		}
		
		return new MyUserDetails(user);
	}
}
