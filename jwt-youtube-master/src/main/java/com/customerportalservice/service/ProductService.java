package com.customerportalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.customerportalservice.dao.ProductDao;
import com.customerportalservice.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDao productdao;
	
	public Product addproducts(Product product)
	{
		return productdao.save(product);
	}

}
