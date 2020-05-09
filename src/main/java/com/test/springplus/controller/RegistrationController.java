package com.test.springplus.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.springplus.model.User;
import com.test.springplus.repository.UserRepository;

@Controller
public class RegistrationController {
	
	
			@Autowired
			UserRepository userRepository;
			
			@PostMapping("/registerUser")
			public String registerUser(@Valid @ModelAttribute("newuser")User user,BindingResult result,Model model) {
				
				System.out.println("In Registration Controller");
				System.out.println("Date of Birth  "+user.getDateOfBirth());
				if(result.hasErrors())
				{
					return "register";
				}
				userRepository.save(user);
				model.addAttribute("dataSaved", "User Registered !");
				return "login";
			}
			
			@InitBinder
			public void initBinder(WebDataBinder binder) {
				
					binder.registerCustomEditor(Date.class, "dateOfBirth",new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
			}
}
