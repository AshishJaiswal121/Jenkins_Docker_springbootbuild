package com.nagarro.training.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.training.springboot.Model.UserRegistration;
import com.nagarro.training.springboot.Repository.UserRegistrationRepository;
import com.nagarro.training.springboot.ServiceInterface.UserLoginInterface;

@Service
public class UserLoginService implements UserLoginInterface {
	private UserRegistrationRepository userregistrationrepository;

	public UserLoginService(UserRegistrationRepository userregistrationrepository) {
		super();
		this.userregistrationrepository = userregistrationrepository;
	}

	// user authentication valid or not
	@Override
	public String checkLogin(String email, String password) {
		List<UserRegistration> checkuser = this.userregistrationrepository.findAll();
		Optional<UserRegistration> userReg = checkuser.stream()
				.filter(user -> (email.equalsIgnoreCase(user.getEmail()) && password.equals(user.getPassword())))
				.findFirst();

		if (userReg.isPresent()) {
			return "user login successfull";
		} else {
			return null;
		}
	}

}
