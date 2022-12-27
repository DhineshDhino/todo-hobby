package com.example.todo.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.todo.Constants.StatusConstants;
import com.example.todo.Model.AddNoteRequest;

@Entity
@Table
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int noteId;
	int userId;
	String note;
	String status;
	String comment;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	Date createdDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	Date lastUpdatedDate;
	
	public Note() {
		super();
	}
	
	public Note(int userId, String note, String status, String comment) {
		super();
		this.userId = userId;
		this.note = note;
		this.status = status;
		this.comment=comment;
	}
	
	public Note(AddNoteRequest request) {
		this.userId = request.getUserId();
		this.note = request.getNote();
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", userId=" + userId + ", note=" + note + ", status=" + status + ", comment="
				+ comment + ", createdDate=" + createdDate + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}
	
}
