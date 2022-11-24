package com.customerportalservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.customerportalservice.entity.Product;

public interface ProductDao extends CrudRepository<Product, Integer> {

}
