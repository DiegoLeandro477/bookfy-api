package com.ferruje.bookfy.endPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ferruje.bookfy.entities.Login;
import com.ferruje.bookfy.entities.User;
import com.ferruje.bookfy.service.LoginService;
import com.ferruje.bookfy.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginEndPoint {

	@Autowired
	private LoginService serviceLogin;

	@Autowired
	private UserService serviceUser;

	@GetMapping("/autenticator")
	public ResponseEntity<User> autenticator(@RequestBody Login login) {
		Login loginId = serviceLogin.hasLogin(login.getEmail(), login.getPassword());
		
		if (loginId != null) {
			User user = serviceUser.findByLoginId(loginId.getId());
			if (user != null) {
				return ResponseEntity.ok().body(user);
			}
		}
		return ResponseEntity.ok().body(null);
	}

}
