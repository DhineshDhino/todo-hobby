package com.example.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.web.client.RestTemplate;

import com.example.todo.Validator.AddNoteRequestValidator;


@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

    @Bean
    AddNoteRequestValidator setAddNoteRequestValidator() {
        return new AddNoteRequestValidator();
    }
    @Bean 
    RestTemplate setRestTemplate() {
    	return new RestTemplate();
    }
}
