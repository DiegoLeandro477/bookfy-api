package com.ferruje.bookfy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferruje.bookfy.entities.User;
import com.ferruje.bookfy.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository rep;

	public Optional<User> findById(Long id) {
		return rep.findById(id);
	}

	public User findByLoginId(Long loginId) {
		System.out.println(rep.findByLoginId(loginId));
		return rep.findByLoginId(loginId);
	}
	
}
