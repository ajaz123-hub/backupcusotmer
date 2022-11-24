package com.customerportalservice.controller;

import com.customerportalservice.dao.UserDao;
import com.customerportalservice.entity.Raise;
import com.customerportalservice.entity.User;
import com.customerportalservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

	
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userdao;
    
    
    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }
    @PostMapping({"/registerAdminUser"})
    public User registerAdmin(@RequestBody User user) {
        return userService.registerAdmin(user);
    }
   

	@PutMapping("/updaterAdminUser/{userName}")
    
    public User updateregisterAdmin(@RequestBody User user,@PathVariable String userName) {
        return userService.registerAdmin(user);
    }
	
	@PutMapping("/updateAdminUser")
	public User updateAdmin(@RequestBody User user) {
		return  userService.registerAdmin(user);
	}
   

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
}
