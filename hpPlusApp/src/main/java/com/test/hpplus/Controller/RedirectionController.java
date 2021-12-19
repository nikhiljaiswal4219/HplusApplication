package com.test.hpplus.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectionController {

	@GetMapping("/linkdin")
	public String redirectOut() {
		System.out.println("in redirect Controller");
		return "redirect:http://linkedin.com";
	}
}
