package com.example.todo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todo.Entity.Note;

public interface NoteListRepository extends JpaRepository<Note,Integer>{

	List<Note> findByUserId(int i);

	List<Note> findByUserIdAndStatus(int parseInt, String string);


	long countByUserIdAndStatus(int parseInt, String string);

}
