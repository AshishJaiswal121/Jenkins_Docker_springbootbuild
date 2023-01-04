package com.nagarro.training.springboot.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.springboot.Model.UserRegistration;
import com.nagarro.training.springboot.Service.UserRegistrationService;

//user Registration API
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserRegistrationController {
	private UserRegistrationService userregistrationservice;

	public UserRegistrationController(UserRegistrationService userregistrationservice) {
		super();
		this.userregistrationservice = userregistrationservice;
	}

	// user registration if not Registrated
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<?> userRegistration(@RequestBody UserRegistration userregistration) {
		String val = this.userregistrationservice.checkRegistration(userregistration.getEmail());
		if (val == null) {
			this.userregistrationservice.saveUser(userregistration);
			return ResponseEntity.ok(userregistration);
		} else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}

	}

}
