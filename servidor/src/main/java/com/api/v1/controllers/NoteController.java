package com.api.v1.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.v1.models.NoteModel;
import com.api.v1.services.NoteService;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:5173")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public ArrayList<NoteModel> getNotes(){
        return this.noteService.getNotes();
    }

    @PostMapping
    public NoteModel saveNote(@RequestBody NoteModel note){
        return this.noteService.saveNote(note);
    }

    @GetMapping("/{id}")
    public Optional<NoteModel> getNoteById(@PathVariable Long id){
        return this.noteService.getById(id);
    }

    @PutMapping("/{id}")
    public NoteModel updateNoteById(@RequestBody NoteModel request,@PathVariable Long id){
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
