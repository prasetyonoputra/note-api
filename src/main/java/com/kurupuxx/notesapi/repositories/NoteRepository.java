package com.kurupuxx.notesapi.repositories;

import com.kurupuxx.notesapi.entities.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
