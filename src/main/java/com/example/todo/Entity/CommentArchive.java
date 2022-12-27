package com.example.todo.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table
public class CommentArchive {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int archiveId;
	
	int noteId;
	String comment;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	Date createdDate;
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public CommentArchive() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentArchive(int noteId, String comment) {
		super();
		this.noteId = noteId;
		this.comment = comment;
	}
	public int getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(int archiveId) {
		this.archiveId = archiveId;
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
		return "CommentArchive [archiveId=" + archiveId + ", noteId=" + noteId + ", comment=" + comment
				+ ", createdDate=" + createdDate + "]";
	}
	
	
}
