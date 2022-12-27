package com.example.todo.Model;

import com.example.todo.Entity.CommentArchive;

public class CommentArchiveResponse {
	int noteId;
	String comment;
	
	public CommentArchiveResponse(CommentArchive commentArchive) {
		super();
		this.noteId = commentArchive.getNoteId();
		this.comment = commentArchive.getComment();;
	}
	public CommentArchiveResponse(int noteId, String comment) {
		super();
		this.noteId = noteId;
		this.comment = comment;
	}
	public CommentArchiveResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "CommentArchiveResponse [noteId=" + noteId + ", comment=" + comment + "]";
	}
	

}
