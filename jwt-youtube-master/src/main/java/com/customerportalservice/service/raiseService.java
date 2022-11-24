package com.customerportalservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerportalservice.dao.raiseDao;
import com.customerportalservice.entity.Product;
import com.customerportalservice.entity.Raise;

@Service
public class raiseService {
	
	@Autowired
	raiseDao servicedao;
	
	public Raise raiseRequest(Raise service)
	{
		return servicedao.save(service);
	}
	 public List<Raise> getItemByUser(Integer ticketNumber){
		 servicedao.findById(ticketNumber);
	        return (List<Raise>) servicedao.findAll();
	    }
	public void deleteraise(Integer ticketNumber) {
		servicedao.deleteById(ticketNumber);
	}
	
	public Raise updateraise(Raise raise) {
		Integer ticketNumber = raise.getTicketNumber();
		Raise std = servicedao.findById(ticketNumber).get();
		std.setTicketNumber(raise.getTicketNumber());
		std.setSummary(raise.getSummary());
		std.setStatus(raise.getStatus());
		std.setDate(raise.getDate());
		std.setType(raise.getType());
		std.setCustomername(raise.getCustomername());
		
		return servicedao.save(std);
		 
	}
	public List<Raise> getRaise(){
		return (List<Raise>) servicedao.findAll();		 
	}
	
	
	public List<Raise> getRequestStatus(String status) throws Exception{
        List<Raise> optional =
              (List<Raise>) servicedao.findByStatus(status);
        
        
        List<Raise> count;
        if (((List<Raise>) optional).size() > 0)
            count=(List<Raise>) optional;   
        else
            count=null;            
        return count;

//      if(optional.isEmpty()){
//          throw new Exception("Service Request not found with id: "+status);
//      } else {
//          return (List<CustomerRequest>) optional.get();
//      }
    }
}
