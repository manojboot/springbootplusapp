package com.test.springplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.springplus.model.Login;
import com.test.springplus.model.User;
import com.test.springplus.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login) {

		User user = userRepository.searchByUsername(login.getUsername());
		if (user == null) {
			throw new com.test.springplus.exception.ApplicationException("User Not Found Exception");
		}
		return "search";
	}


	  @ExceptionHandler(com.test.springplus.exception.ApplicationException.class)
	  public String handleLoginException() {
		  
	  System.out.println("Inside Exception Handler of Login Controller"); 
	  return "error"; 
	  }
	 
}
