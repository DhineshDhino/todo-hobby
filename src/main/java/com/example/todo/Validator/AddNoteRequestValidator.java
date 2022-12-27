package com.example.todo.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.todo.Model.AddNoteRequest;

public class AddNoteRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return AddNoteRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AddNoteRequest request= (AddNoteRequest) target;
		if(request.getUserId()<=0) {
			errors.rejectValue("userId", "InvalidUserId", "UserId is not valid");
		}
		if(request.getNote()==null) {
			errors.rejectValue("Note", "EmptyNote", "Note is empty, Please provide valid note to save");
		}
		
	}

}
