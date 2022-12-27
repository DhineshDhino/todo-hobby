//package com.example.todo.Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.example.todo.Service.UserManagementAuthenticationProvider;
//
//@Configuration
//@EnableWebSecurity
//public class AuthProviderSecurityConfig{
//
//
//
//    @Autowired
//    private UserManagementAuthenticationProvider authProvider;
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder = 
//            http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.authenticationProvider(authProvider);
//        return authenticationManagerBuilder.build();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable().cors().disable().authorizeRequests()
//        //.antMatchers("/todo/add").hasAnyRole("ROLE_DEVELOPER", "ROLE_ADMIN")
//            .anyRequest()
//            .permitAll();
////            .authenticated()
////            .and()
////            .httpBasic().
////            and().formLogin();
//        return http.build();
//    }
//    
//    @B
//    
//}
//
