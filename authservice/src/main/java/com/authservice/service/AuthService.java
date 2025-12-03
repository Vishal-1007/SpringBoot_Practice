package com.authservice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.authservice.AuthserviceApplication;
import com.authservice.dto.APIResponse;
import com.authservice.dto.UserDto;
import com.authservice.entity.User;
import com.authservice.repository.UserRepository;


@Service
public class AuthService {

    private final AuthserviceApplication authserviceApplication;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


    AuthService(AuthserviceApplication authserviceApplication) {
        this.authserviceApplication = authserviceApplication;
    }
	
	
	public APIResponse<String> register(UserDto dto) {
		
		if(userRepository.existsByUserName(dto.getUserName())) {
			APIResponse<String> response = new APIResponse<>();
			response.setMessage("Registration Failed");
			response.setStatus(500);
			response.setData("User with username exists");
			return response;
		}
		if(userRepository.existsByEmail(dto.getEmail())) {
			APIResponse<String> response = new APIResponse<>();
			response.setMessage("Registration Failed");
			response.setStatus(500);
			response.setData("User with Email Id exists");
			return response;
		}
		
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		userRepository.save(user);
		
		APIResponse<String> response = new APIResponse<>();
		response.setMessage("Registration Done");
		response.setStatus(201);
		response.setData("User is registered");
		
		return response;
		
		
	}

}
