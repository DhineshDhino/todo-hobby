//package com.example.todo.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Consumer;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.todo.Model.UserResponse;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService{
//
//	@Autowired
//	UserManagementService userManagementService;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserResponse user=  userManagementService.getUserCredentials(username);
//		 if (user == null) {
//	          throw new UsernameNotFoundException(username);
//	      }
//	      List<GrantedAuthority> authList=new ArrayList<>();
//	      user.getRoleList().stream().forEach(role-> authList.add(new SimpleGrantedAuthority(role)));
//	      return new User(user.getUsername(),user.getPassword(), true, true, true, true, authList);
//	}
//	
//}
