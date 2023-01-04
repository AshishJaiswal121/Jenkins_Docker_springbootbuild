package com.nagarro.training.springboot.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.springboot.Model.UserRegistration;
import com.nagarro.training.springboot.Service.UserRegistrationService;

//New Password API
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ForgetPassword {
	private UserRegistrationService userregistrationservice;

	public ForgetPassword(UserRegistrationService userregistrationservice) {
		super();
		this.userregistrationservice = userregistrationservice;
	}

// check user email is valid or not
	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	public boolean userRegistration(@PathVariable("email") String email) {
		String val = this.userregistrationservice.checkemail(email);
		if (val == null) {

			return false;

		} else {
			return true;
		}

	}

//save new password 
	@RequestMapping(value = "/newpassword", method = RequestMethod.POST)
	public void userRegistration(@RequestBody UserRegistration userRegistration) {
		this.userregistrationservice.savePassword(userRegistration);

	}
}
