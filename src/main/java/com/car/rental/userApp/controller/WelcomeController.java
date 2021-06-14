package com.car.rental.userApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.userApp.dao.UserRepository;
import com.car.rental.userApp.model.Users;

//@RequestMapping("/Welcome")
@Controller
public class WelcomeController {
	
	@Autowired
	private UserRepository userRepository;
 
//	@GetMapping("/Welcome")
//	public String MyEnd() {
//		return "Wecome to Home Screen";
//	}

//	@GetMapping("/neha")
//	public String MyName() {
//		String s="";
//		return s.length();
//	}
	
	
	@PostMapping("/users")
	public /* ResponseEntity */ Users createUser(@RequestBody Users user) {

		return userRepository.save(user);
		// return ResponseEntity.status(HttpStatus.CREATED);
	}
	
//	
//	 @GetMapping("/MyPage")
//	    public String viewHomePage() {
//	        return "index";
//	    }

}
