package com.nagarro.training.springboot.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.springboot.Model.UserRegistration;
import com.nagarro.training.springboot.Service.UserLoginService;

//User Login authentication API

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserLoginController {

	private UserLoginService userloginservice;

	public UserLoginController(UserLoginService userloginservice) {
		super();
		this.userloginservice = userloginservice;
	}

//user  authentication valid or not
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> userAuthentication(@RequestBody UserRegistration userregistration) {

		String val = this.userloginservice.checkLogin(userregistration.getEmail(), userregistration.getPassword());
		if (val != null) {
			return ResponseEntity.ok(userregistration);
		} else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}

	}
}
