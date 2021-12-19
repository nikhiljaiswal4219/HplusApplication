package com.test.hpplus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.hpplus.Beans.Login;
import com.test.hpplus.Beans.User;
import com.test.hpplus.Exception.ApplicationException;
import com.test.hpplus.ProductRepository.UserRepository;

@Controller
@SessionAttributes("login")
public class LoginController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public String login(@ModelAttribute("login")Login login) {
		User user = userRepository.searchByName(login.getUsername());
		if(user==null) {
			throw new ApplicationException("User is found");
		}
		return "forward:/userprofile";
	}
	
	
	 @ExceptionHandler(ApplicationException.class) public String handleException()
	 { 
		 System.out.println("inside exception handler of Login Controller"); 
		 return "error"; 
		 }
	
}
