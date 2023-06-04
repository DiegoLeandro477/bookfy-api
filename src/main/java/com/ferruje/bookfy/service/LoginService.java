package com.ferruje.bookfy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferruje.bookfy.entities.Login;
import com.ferruje.bookfy.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository rep;

	public Optional<Login> getLogin(Long id) {
		return rep.findById(id);
	}

	public Login hasLogin(String email, String password) {
		System.out.println(rep.findByEmailAndPassword(email, password));
		return rep.findByEmailAndPassword(email, password);
	}
	
}
