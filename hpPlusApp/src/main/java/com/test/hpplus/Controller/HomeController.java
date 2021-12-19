package com.test.hpplus.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.test.hpplus.Beans.Login;
import com.test.hpplus.Beans.User;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String goHome() {
		System.out.println("we are in Controller");
		return "index";
	}

	@GetMapping("/goToSearch")
	public String goToSearch() {
		System.out.println("going to search");
		return "search";
	}
	
	@GetMapping("/goToLogin")
	public String goToLogin() {
		System.out.println("going to login");
		return "login";
	}
	
	@GetMapping("/goToRegistration")
	public String goToRegistration() {
		System.out.println("going to register");
		return "register";
	}
	/*
	 * @ModelAttribute("newuser") public User getDefaultUser() { return new User();
	 * }
	 * 
	 * @ModelAttribute("genderItems") public List<String> getGenderItems() { return
	 * Arrays.asList(new String[]{"Male","Female","Other"}); }
	 * 
	 * @ModelAttribute("login") public Login getDefaultLogin() { return new Login();
	 * }
	 */
}
