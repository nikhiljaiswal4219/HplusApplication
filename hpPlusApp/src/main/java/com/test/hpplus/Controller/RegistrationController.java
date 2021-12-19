package com.test.hpplus.Controller;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.test.hpplus.Beans.User;
import com.test.hpplus.ProductRepository.UserRepository;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserRepository userRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, "dateOfBirth", (PropertyEditor) new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
	}

	@PostMapping("/registeruser")
	public String registerUser(@Valid @ModelAttribute("newuser")User user,BindingResult result,Model model) {
		System.out.println("inside register Controller");
		System.out.println(user.getDateOfBirth());
		if(result.hasErrors()) {
			return "register";
		}
		userRepository.save(user);
		model.addAttribute("dataSaved", "User Registered Successfully");
		return "login";
	}
}
