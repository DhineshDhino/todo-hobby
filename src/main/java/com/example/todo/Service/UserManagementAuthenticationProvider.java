//package com.example.todo.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import com.example.todo.Model.UserResponse;
//
//@Service
//public class UserManagementAuthenticationProvider  implements AuthenticationProvider{
//
//	@Autowired
//	UserManagementService userManagementService;
//	
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		 String username = authentication.getPrincipal().toString(); // (1)
//         String password = authentication.getCredentials().toString(); // (1)
//
//         UserResponse user = userManagementService.getUserCredentials(username); // (2)
//         if (user == null) {                                     // (3)
//             throw new ResponseStatusException(HttpStatus.FORBIDDEN,"could not login");
//         }
//         List<GrantedAuthority> authList=new ArrayList<>();
//	      user.getRoleList().stream().forEach(role-> authList.add(new SimpleGrantedAuthority(role)));
//	      
//         return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), authList); // (4)
//
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		 return authentication.equals(UsernamePasswordAuthenticationToken.class);
//	}
//
//}
