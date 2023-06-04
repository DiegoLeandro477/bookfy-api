package com.ferruje.bookfy.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ferruje.bookfy.entities.Login;
import com.ferruje.bookfy.entities.User;
import com.ferruje.bookfy.repository.LoginRepository;
import com.ferruje.bookfy.repository.UserRepository;

@SpringBootApplication
public class Initialization implements CommandLineRunner {
	
	@Autowired
	private LoginRepository repLog;
	
	@Autowired
	private UserRepository repUser;

	@Override
	public void run(String... args) throws  Exception, NoSuchAlgorithmException{
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		System.err.println("\n\n=-=- BEGIN CONFIG -=-=");
		
		repLog.deleteAll();
		repUser.deleteAll();
		
		Login login = new Login("admin@gmail.com", "admin");
//		md.update(login.getPassword().getBytes());
//		login.setPassword(new String(md.digest()));
		repLog.save(login);
		
		System.out.println(login.getPassword());
		
		User root = new User("Administrador", login);
		repUser.save(root);
		
		System.out.println(root.getId());
	}

}
