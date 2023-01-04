package com.nagarro.training.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.training.springboot.Model.UserRegistration;
import com.nagarro.training.springboot.Repository.UserRegistrationRepository;
import com.nagarro.training.springboot.ServiceInterface.UserRegistrationServiceInterface;

@Service
public class UserRegistrationService implements UserRegistrationServiceInterface {

	private UserRegistrationRepository userregistrationrepository;

	public UserRegistrationService(UserRegistrationRepository userregistrationrepository) {
		super();
		this.userregistrationrepository = userregistrationrepository;
	}

// save user record in DataBase
	@Override
	public String saveUser(UserRegistration userregistration) {
		List<UserRegistration> checkuser = this.userregistrationrepository.findAll();
		Optional<UserRegistration> userReg = checkuser.stream()
				.filter(user -> (userregistration.getEmail().equalsIgnoreCase(user.getEmail()))).findFirst();

		if (userReg.isPresent()) {
			return null;
		} else {
			UserRegistration userregistrationobj = new UserRegistration();
			userregistrationobj.setFirstname(userregistration.getFirstname());
			userregistrationobj.setLastname(userregistration.getLastname());
			userregistrationobj.setEmail(userregistration.getEmail());
			userregistrationobj.setPassword(userregistration.getPassword());
			userregistrationobj.setConfirmpassword(userregistration.getConfirmpassword());
			this.userregistrationrepository.save(userregistrationobj);
			return "registration successfull";
		}

	}

//fetch all record of user
	@Override
	public String findAll() {
		this.userregistrationrepository.findAll();
		return null;
	}

// user registration if not Registrated
	@Override
	public String checkRegistration(String email) {
		List<UserRegistration> checkuser = this.userregistrationrepository.findAll();
		Optional<UserRegistration> userReg = checkuser.stream()
				.filter(user -> (email.equalsIgnoreCase(user.getEmail()))).findFirst();

		if (userReg.isPresent()) {
			return "user is already have a account";
		} else {
			return null;
		}
	}

//check user email is valid or not
	@Override
	public String checkemail(String email) {
		List<UserRegistration> checkuser = this.userregistrationrepository.findAll();
		Optional<UserRegistration> userReg = checkuser.stream()
				.filter(user -> (email.equalsIgnoreCase(user.getEmail()))).findFirst();

		if (userReg.isPresent()) {
			System.out.println(userReg);
			return "user is already have  a account";
		} else {

			return null;
		}
	}

//update old password to new password and save it
	@Override
	public void savePassword(UserRegistration userRegistration) {
		List<UserRegistration> checkuser = this.userregistrationrepository.findAll();
		checkuser.stream().forEach((user) -> {
			if (userRegistration.getEmail().equalsIgnoreCase(user.getEmail())) {
				user.setConfirmpassword(userRegistration.getConfirmpassword());
				user.setPassword(userRegistration.getPassword());
				this.userregistrationrepository.save(user);
				return;
			}
		});

	}
}
