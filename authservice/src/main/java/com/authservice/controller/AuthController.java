package com.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.authservice.dto.APIResponse;
import com.authservice.dto.*;
import com.authservice.entity.User;
import com.authservice.repository.UserRepository;
import com.authservice.service.AuthService;
import com.authservice.service.JwtService;
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	@Autowired
	private AuthService authservice;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public ResponseEntity<APIResponse<String>> register(@RequestBody UserDto dto){
		APIResponse<String> response = authservice.register(dto);
		return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
	}
	
	@PostMapping("/login")
	 public ResponseEntity<APIResponse<String>> loginCheck(@RequestBody LoginDto loginDto){
		 
		 APIResponse<String> response = new APIResponse<>();
		 
		 UsernamePasswordAuthenticationToken token = 
				 new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword());
		 
		try {
			 Authentication authenticate = authManager.authenticate(token);
			 
			 if(authenticate.isAuthenticated()) {
				 String jwtToken = jwtService.generateToken(loginDto.getUserName(),
			                authenticate.getAuthorities().iterator().next().getAuthority());
				 response.setMessage("Login Sucessful");
				 response.setStatus(200);
				 response.setData(jwtToken);
				 
				 return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 response.setMessage("Failed");
		 response.setStatus(401);
		 response.setData("Un-Authorized Access");
		 return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
	 }
	
	 @GetMapping("/get-user")
	 public User getUser(@RequestParam String username) {
		 return userRepository.findByUserName(username);
	 }

}


