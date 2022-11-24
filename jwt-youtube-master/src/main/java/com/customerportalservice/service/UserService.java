package com.customerportalservice.service;


import com.customerportalservice.dao.RoleDao;
import com.customerportalservice.dao.UserDao;
import com.customerportalservice.entity.Raise;
import com.customerportalservice.entity.Role;
import com.customerportalservice.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserService {

	 @Autowired
	    private UserDao userDao;

	    @Autowired
	    private RoleDao roleDao;

	    @Autowired
	    private PasswordEncoder passwordEncoder;
//	    int a = ThreadLocalRandom.current().nextInt();
//		int d = Math.abs(98);
	    public void initRoleAndUser() {

	        Role adminRole = new Role();
	        adminRole.setRoleName("Admin");
	        adminRole.setRoleDescription("Admin role");
	        roleDao.save(adminRole);
//----------------------------------------------------------------------------------------------
	        Role userRole = new Role();
	        userRole.setRoleName("User");
	        userRole.setRoleDescription("Default role for newly created record");
	        roleDao.save(userRole);
//-----------------------------------------------------------------------------------------------
	        User adminUser = new User();
	        adminUser.setUserName("sandeep");
	        adminUser.setUserPassword(getEncodedPassword("sandeep@123"));
	       
	        adminUser.setAddress("hyderbaad");
	       adminUser.setContactNumber(9959986);
	        adminUser.setCountry("india");
	        adminUser.setDateOfBirth("28-05-1998");
	        adminUser.setEmail("abd@gmail.com");
	        adminUser.setState("telenagen");
	        adminUser.setCustomerId(786);
	        
	        
	        
	        Set<Role> adminRoles = new HashSet<>();
	        adminRoles.add(adminRole);
	        adminUser.setRole(adminRoles);
	        userDao.save(adminUser);
//------------------------------------------------------------------
	      User user = new User();
	        user.setUserName("amer111");
	        user.setUserPassword(getEncodedPassword("amer111"));
	       
			//System.out.println("random number " + d);
			//book.setGeneratedId(d);
	        user.setAddress("hyderbaad");
	        user.setCustomerId(798);
	        user.setContactNumber(9959986);
	        user.setCountry("india");
	        user.setDateOfBirth("28-05-1998");
	        user.setEmail("abd@gmail.com");
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(userRole);
	        user.setRole(userRoles);
	        userDao.save(user);
	    }
//------------------------------------------------------------------------------------
	    public User registerNewUser(User user) {
	        Role role = roleDao.findById("User").get();
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(role);
	        user.setRole(userRoles);
	        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

	        return userDao.save(user);
	    }

	    
	    public User registerAdmin(User adminUser) {
	        Role role = roleDao.findById("Admin").get();
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(role);
	        adminUser.setRole(userRoles);
	        adminUser.setUserPassword(getEncodedPassword(adminUser.getUserPassword()));
	        adminUser.setAddress(adminUser.getAddress());
	        adminUser.setCountry(adminUser.getCountry());
	        adminUser.setDateOfBirth(adminUser.getDateOfBirth());
	        adminUser.setState(adminUser.getState());
	        adminUser.setContactNumber(adminUser.getContactNumber());
	       
//	        adminUser.setCustomerId(d);
//	        System.out.println("the value of d:"+ d);
	        adminUser.setCustomerId(adminUser.getCustomerId());

	        return userDao.save(adminUser);
	    }
	    
	    public User updaterAdminUser (User adminUser )
	    {
	    	
	    	String email=adminUser.getEmail();
	    	User up = userDao.findByEmail(email).get(0);
	    	up.setEmail(adminUser.getEmail());
	    	up.setUserPassword(getEncodedPassword(adminUser.getUserPassword()));
	    	up.setAddress(adminUser.getAddress());
	    	up.setCountry(adminUser.getCountry());
	    	up.setDateOfBirth(adminUser.getDateOfBirth());
	    	up.setState(adminUser.getState());
	    	up.setContactNumber(adminUser.getContactNumber());

		        return userDao.save(up);
	    	}
	    	
	    
	    /*public Raise updateraise(Raise raise) {
			Integer ticketNumber = raise.getTicketNumber();
			Raise std = servicedao.findById(ticketNumber).get();
			std.setTicketNumber(raise.getTicketNumber());
			std.setSummary(raise.getSummary());
			std.setStatus(raise.getStatus());
			std.setDate(raise.getDate());
			std.setType(raise.getType());
			std.setCustomername(raise.getCustomername());
			
			return servicedao.save(std);
			 
		}*/
	   
	    public String getEncodedPassword(String password) {
	        return passwordEncoder.encode(password);
	    }
}
