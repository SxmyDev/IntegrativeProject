package com.api.v1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.v1.models.NoteModel;
import com.api.v1.services.NoteService;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:5173")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public CompletableFuture<List<NoteModel>> getNotes(){
        return noteService.getNotes();
    }

    @PostMapping
    public NoteModel saveNote(@Valid @RequestBody NoteModel note){
        return noteService.saveNote(note);
    }

    @GetMapping("/{id}")
    public Optional<NoteModel> getNoteById(@PathVariable Long id){
        return this.noteService.getById(id);
    }

    @PutMapping("/{id}")
    public NoteModel updateNoteById(@RequestBody NoteModel request, @PathVariable Long id){
        return this.noteService.updateById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        boolean ok = this.noteService.deleteNote(id);

        if(ok){
            return "Note with id " + id + " deleted";
        } else {
            return "Unable to delete note with id " + id;
        }
    }
}
