package com.nagarro.training.springboot.ServiceInterface;

import com.nagarro.training.springboot.Model.UserRegistration;
//Interface for Performing Operation on User Data
public interface UserRegistrationServiceInterface {
	public String saveUser(UserRegistration userregistration);

	void savePassword(UserRegistration userRegistration);

	String checkemail(String email);

	String checkRegistration(String email);

	String findAll();
}
