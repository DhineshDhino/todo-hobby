package com.example.todo.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;

import com.example.todo.Entity.CommentArchive;
import com.example.todo.Entity.Note;
import com.example.todo.Model.AddNoteRequest;
import com.example.todo.Model.CommentArchiveResponse;
import com.example.todo.Repository.CommentArchiveRepository;
import com.example.todo.Repository.NoteListRepository;


@Service
public class TodoListService {

	@Autowired
	NoteListRepository noteListRepository;
	
	@Autowired
	CommentArchiveRepository commentArchiveRepository;
	
	public String addNote(AddNoteRequest addNoteRequest) {
		Note note=new Note(addNoteRequest);
		note.setStatus("NEW");
		noteListRepository.save(note);
		return "SUCCESS";
	}

	public List<Note> getNotesForUser(String userId) {
		List<Note> notesForUser=noteListRepository.findByUserId(Integer.parseInt(userId));
		if(CollectionUtils.isEmpty(notesForUser)) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Element not found");
		}
		return notesForUser;
	}

	@Transactional
	public String addComment(String noteId, String comment) {
		Note note=noteListRepository.findById(Integer.parseInt(noteId)).orElse(null);
		CommentArchive toCommentArchive= new CommentArchive(Integer.parseInt(noteId), comment);
		commentArchiveRepository.save(toCommentArchive);
		note.setComment(comment);
		noteListRepository.save(note);
		return "SUCCESS";
	}

	public List<CommentArchiveResponse> getCommentsFromArchive(String noteId) {
		List<CommentArchiveResponse> response=new ArrayList<CommentArchiveResponse>();
		List<CommentArchive> commentArchiveList= commentArchiveRepository.findCommentByNoteId(Integer.parseInt(noteId));
		Consumer<CommentArchive> mapper=(a)->{response.add(new CommentArchiveResponse(a));};
		commentArchiveList.stream().forEach(mapper::accept);
		return response;
	}

	public void updateNoteStatus(Integer noteId, String status) {
		Note note=noteListRepository.findById(noteId).orElse(null);
		note.setStatus(status);
		noteListRepository.save(note);
	}

	public void deleteNote(Integer noteId) {
		Note note=noteListRepository.findById(noteId).orElse(null);
		noteListRepository.delete(note);
		
	}

	public long getPendingCountForUser(String userId) {
		//List<Note> notesForUser=noteListRepository.findByUserId(Integer.parseInt(userId));
//		List<Note> notesForUser= noteListRepository.findByUserIdAndStatus(Integer.parseInt(userId),"NEW");
//		if(CollectionUtils.isEmpty(notesForUser)) {
//			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Element not found");
//		}
//		if(!notesForUser.isEmpty()) {
//			
//		}
//		return notesForUser.size();
		
		return noteListRepository.countByUserIdAndStatus(Integer.parseInt(userId),"NEW");
	}

}
