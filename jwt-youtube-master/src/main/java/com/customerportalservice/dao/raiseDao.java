package com.customerportalservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.customerportalservice.entity.Raise;



//
public interface raiseDao  extends CrudRepository<Raise, Integer> {

	public  List<Raise> findByStatus(String status);

}
