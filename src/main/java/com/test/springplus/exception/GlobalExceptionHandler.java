package com.test.springplus.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.test.springplus.model.Login;
import com.test.springplus.model.User;

@ControllerAdvice
public class GlobalExceptionHandler {

	
		@ExceptionHandler(com.test.springplus.exception.ApplicationException.class)
		public String handleLoginException()
		{
			System.out.println("Inside Global Exception Handler");
			return "error";
		}
		
		@ModelAttribute("newuser")
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
}