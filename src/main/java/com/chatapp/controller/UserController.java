package com.chatapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.dto.UserDTO;
import com.chatapp.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
		String saveUser = userService.saveUser(userDTO);
		if (saveUser.equals("User saved")) {
			return new ResponseEntity<>(saveUser, HttpStatus.OK);
		}
		return new ResponseEntity<>("Some error occured.", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO) {
		String updateUser = userService.updateUser(userDTO);
		if (updateUser.equals("User updated")) {
			return new ResponseEntity<>(updateUser, HttpStatus.OK);
		}
		return new ResponseEntity<>("Some error occured.", HttpStatus.BAD_REQUEST);
	}
}
