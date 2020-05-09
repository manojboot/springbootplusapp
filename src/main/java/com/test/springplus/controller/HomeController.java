package com.test.springplus.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.test.springplus.model.Login;
import com.test.springplus.model.User;

@Controller
public class HomeController {

			@GetMapping("/home")
			public String hello() {
				
				return "index";
			}
			
			@GetMapping("/goToSearch")
			public String goToSearch() {
				
				System.out.println("Going to Search Page");
				return "search";
			}
			
			@GetMapping("/goToLogin")
			public String goToLogin() {
				
				System.out.println("Going to Login Page");
				return "login";
			}
			
			@GetMapping("/goToRegistration")
			public String goToRegistration() {
				
				System.out.println("Going to Registration Page");
				return "register";
			}
			
	/*		@ModelAttribute("newuser")
			public User getUser()
			{
				return new User();
			}
			
			@ModelAttribute("genderItems")
			public List<String> getGenderList()
			{
				return Arrays.asList(new String[]{"Male","Female","Others"});
			}
			
			@ModelAttribute("login")
			public Login getLogin()
			{
				return new Login();
			}
	*/
}
