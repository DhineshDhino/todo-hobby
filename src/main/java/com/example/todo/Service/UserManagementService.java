package com.example.todo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.todo.Model.AuthRequest;
import com.example.todo.Model.UserResponse;

@Service
public class UserManagementService {
	
	@Autowired
	RestTemplate restTemplate;

	public boolean userhasAccess() {
		
		AuthRequest authRequest=new AuthRequest("user1", null, "DEVELOPER");
		HttpEntity<AuthRequest> entity=new HttpEntity<>(authRequest);
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("user1","user1"));
		boolean result=restTemplate.postForObject("http://localhost:8081/user/authorize", entity, boolean.class);
		return result;
	}

	public UserResponse getUserCredentials(String userName) {
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("user1","user1"));
		UserResponse user=restTemplate.getForObject("http://localhost:8081/user/get/"+userName, UserResponse.class);
		
		return user;
	}

}
