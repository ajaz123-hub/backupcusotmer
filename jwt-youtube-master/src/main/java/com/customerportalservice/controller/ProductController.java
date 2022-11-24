package com.customerportalservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerportalservice.entity.Product;
import com.customerportalservice.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("/addproducts")
	public Product addproducts( @RequestBody Product product) {
		
		return productservice.addproducts(product);
}
}
