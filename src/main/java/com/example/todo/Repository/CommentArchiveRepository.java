package com.example.todo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todo.Entity.CommentArchive;

public interface CommentArchiveRepository extends JpaRepository<CommentArchive,Integer>{

	List<CommentArchive> findCommentByNoteId(Integer noteId);

}
