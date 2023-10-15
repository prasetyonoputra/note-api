package com.kurupuxx.notesapi.controllers;

import com.kurupuxx.notesapi.entities.Note;
import com.kurupuxx.notesapi.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/note")
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping
    public Iterable<Note> getAllNote() {
        return noteRepository.findAll();
    }

    @PostMapping
    public String addNote(@RequestBody Note newNote) {
        noteRepository.save(newNote);
        return "Saved";
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNote (@PathVariable Long id, @RequestBody Note newNote) {
        Note theNote = noteRepository.findById(id).orElse(null);

        if (theNote != null) {
            theNote.setTitle(newNote.getTitle());
            theNote.setNote(newNote.getNote());

            return ResponseEntity.ok("Note with ID " + id + " has been updated.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note with ID " + id + " not found.");
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteNoteById(@PathVariable Long id) {
        Note note = noteRepository.findById(id).orElse(null);

        if (note != null) {
            noteRepository.deleteById(id);
            return ResponseEntity.ok("Note with ID " + id + " has been deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note with ID " + id + " not found.");
        }
    }
}
