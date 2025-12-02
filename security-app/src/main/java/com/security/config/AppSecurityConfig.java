package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import jakarta.annotation.security.PermitAll;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
				req->{
					
					req.requestMatchers("/api/v1/welcome/hello").permitAll()
					.anyRequest().authenticated();
					
				}
				);
		
		return http.build();
				
	}
}
