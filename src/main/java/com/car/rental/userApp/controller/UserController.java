package com.car.rental.userApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.car.rental.userApp.dao.UserRepository;
import com.car.rental.userApp.model.Users;

@RequestMapping("/CarRental")
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/MyEnd")
	public String MyEnd() {
		return "Hello";
	}

	@PostMapping("/users")
	public /* ResponseEntity */ Users createUser(@RequestBody Users user) {

		return userRepository.save(user);
		// return ResponseEntity.status(HttpStatus.CREATED);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable("id") long id, @RequestBody Users user) {
		Optional<Users> userInfo = userRepository.findById(id);

		if (userInfo.isPresent()) {
			Users userdata = userInfo.get();
			userdata.setAddress(user.getAddress());
			userdata.setContactNo(user.getContactNo());
			return new ResponseEntity<>(userRepository.save(userdata), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/usersDeleteByID/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
		try {
			userRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/usersDetailsById/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable("id") long id) {
		Optional<Users> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/usersDetails")
	public ResponseEntity<List<Users>> getAllUserDetails() {
		try {
			List<Users> users = new ArrayList<Users>();

			userRepository.findAll().forEach(users::add);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
