package com.customerportalservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customerportalservice.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
	
	List<User> findByEmail(String email);
}
