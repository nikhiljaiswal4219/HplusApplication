package com.test.hpplus.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.hpplus.Beans.Product;
import com.test.hpplus.ProductRepository.ProductRepository;

@Controller
public class SearchController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/search")
	public Callable<String> search(@RequestParam("search") String search, Model model,HttpServletRequest request) {
		System.out.println("we are in Search Controller");
		System.out.println("search criteria :"+ search);
		System.out.println(request.isAsyncSupported());
		System.out.println("Current Thread servlet Container"+Thread.currentThread().getName());
		
		return ()->{
			Thread.sleep(3000);
			System.out.println("Current Thread spring mvc task executor:"+Thread.currentThread().getName());
			List<Product> products = new ArrayList<>();
			products = productRepository.searchByName(search);
			model.addAttribute("products", products);
			return "search";
		};
	}
	
}
