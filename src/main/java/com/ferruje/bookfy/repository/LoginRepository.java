package com.ferruje.bookfy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferruje.bookfy.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

	
	Login findByEmailAndPassword(String email, String password);

}
