package com.example.todo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.example.todo.Entity.Note;
import com.example.todo.Model.AddNoteRequest;
import com.example.todo.Model.CommentArchiveResponse;
import com.example.todo.Service.TodoListService;
import com.example.todo.Service.UserManagementService;
import com.example.todo.Validator.AddNoteRequestValidator;


@RestController
@RequestMapping(path="/todo")
public class TodoListController {
	
	private static final  Logger LOGGER=LoggerFactory.getLogger(TodoListController.class);
	
	@Autowired
	TodoListService todoListService;
	
	@Autowired
	AddNoteRequestValidator validator;
	
	@Autowired
	UserManagementService userManagementService;
	
	@GetMapping(path="/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping(path="/getNotesForUser/{userId}")
	public List<Note> getNotesForUser(@PathVariable("userId") String userId) {
		LOGGER.info("Entered GetNotesForUser , userId - "+ userId);
		List<Note> result= todoListService.getNotesForUser(userId);
		LOGGER.info("Exiting GetNotesForUser , result - "+ result);
		return result;
	}
	
	@GetMapping(path="/getPendingCountForUser/{userId}")
	public long getPendingCountForUser(@PathVariable("userId") String userId) {
		LOGGER.info("Entered getPendingCountForUser , userId - "+ userId);
		long result= todoListService.getPendingCountForUser(userId);
		LOGGER.info("Exiting getPendingCountForUser , result - "+ result);
		return result;
	}
	@PostMapping(path="/add")
	public String addNote(@Valid @RequestBody AddNoteRequest addNoteRequest) throws Exception {
		LOGGER.info("Entered Add Note , Request - "+ addNoteRequest);
		if(!userManagementService.userhasAccess()) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User doesnt have access");
		}
		String result= todoListService.addNote(addNoteRequest);
		LOGGER.info("Exiting Add Note , result - "+ result);
		return result;
	}
	
	@PostMapping(path="/addCommentForNote/{noteId}")
	public String addComment(@PathVariable("noteId") String noteId, @RequestBody String comment) {
		return todoListService.addComment(noteId, comment);
	}
	
	@GetMapping(path="/getCommentsFromArchive/{noteId}")
	public List<CommentArchiveResponse> getCommentsFromArchive(@PathVariable("noteId") String noteId) {
		return todoListService.getCommentsFromArchive(noteId);
	}
	@GetMapping(path="/updateStatus/{noteId}/{status}")
	public void updateNoteStatus(@PathVariable("noteId") Integer noteId, @PathVariable("status") String status) {
		 todoListService.updateNoteStatus(noteId, status);
	}
	@DeleteMapping(path="/{noteId}")
	public void deleteNote(@PathVariable("noteId") Integer noteId) {
		LOGGER.info("Entered delete node , noteId - "+ noteId);
		todoListService.deleteNote(noteId);
		LOGGER.info("Exiting delete node");

	}
	
	
}
