package com.test.hpplus.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.hpplus.Beans.Product;
import com.test.hpplus.ProductRepository.ProductRepository;

//@Controller
@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository productRepository;
	/*
	 * @GetMapping("/hplus/rest/products")
	 * 
	 * @ResponseBody public List<Product> getProducts(){
	 * 
	 * List<Product> products = new ArrayList<>();
	 * productRepository.findAll().forEach(product -> products.add(product)); return
	 * products; }
	 */
	
	@GetMapping("/hplus/rest/products")
	public ResponseEntity getProductsByRequestParam(@RequestParam("name") String name) {
		List<Product> products = productRepository.searchByName(name);
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	

	@GetMapping("/hplus/rest/products/{name}")
	public ResponseEntity getProductsByPathVariable(@PathVariable("name") String name) {
		List<Product> products = productRepository.searchByName(name);
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
}
