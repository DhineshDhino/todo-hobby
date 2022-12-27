package com.example.todo.Model;

import javax.validation.constraints.NotNull;

public class AddNoteRequest {
	int userId;
	@NotNull(message="Note should not be null")
	String note;
	
	public AddNoteRequest() {
		super();
	}
	
	public AddNoteRequest(int userId, String note) {
		super();
		this.userId = userId;
		this.note = note;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "AddNoteRequest [userId=" + userId + ", note=" + note 
				+ "]";
	}
	
	
}
