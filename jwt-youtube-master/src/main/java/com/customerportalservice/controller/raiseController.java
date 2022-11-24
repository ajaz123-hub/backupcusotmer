package com.customerportalservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customerportalservice.entity.Product;
import com.customerportalservice.entity.Raise;
import com.customerportalservice.service.ProductService;
import com.customerportalservice.service.raiseService;

@RestController
public class raiseController {
	@Autowired
	raiseService requestservice;
	
	@PostMapping("/raiserequest")
	public Raise raise( @RequestBody Raise request) {
		
		return requestservice.raiseRequest(request);
}
	@DeleteMapping("/deleteraise")
	public String deleteraise(@RequestParam Integer ticketNumber) {
		requestservice.deleteraise(ticketNumber);
		return "deleted Suceesfully";
	}
	
	@PutMapping("/updateraise")
	public Raise updateraise(@RequestBody Raise raise) {
		return  requestservice.raiseRequest(raise);
	}
	@GetMapping("/getraises")
	public List<Raise> getRaises(){
		return 	requestservice.getRaise();
	}
	@GetMapping("/search/{status}")
    public List<Raise> getRequestStatus(@PathVariable String status) throws Exception{
        return requestservice.getRequestStatus(status);
    }
}
