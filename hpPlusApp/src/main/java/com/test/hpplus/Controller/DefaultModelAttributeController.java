package com.test.hpplus.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.test.hpplus.Beans.Login;
import com.test.hpplus.Beans.User;

@ControllerAdvice
public class DefaultModelAttributeController {


	@ModelAttribute("newuser")
	public User getDefaultUser() {
		return new User();
	}
	
	@ModelAttribute("genderItems")
	public List<String> getGenderItems() {
		return Arrays.asList(new String[]{"Male","Female","Other"});
	}
	
	@ModelAttribute("login")
	public Login getDefaultLogin() {
		return new Login();
	}
}
