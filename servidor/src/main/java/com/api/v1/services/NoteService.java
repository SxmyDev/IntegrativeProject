package com.api.v1.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.models.NoteModel;
import com.api.v1.repositories.INoteRepository;

@Service
public class NoteService {
    @Autowired    
    INoteRepository noteRepository;

    public ArrayList<NoteModel> getNotes() {
        return (ArrayList<NoteModel>) noteRepository.findAll();
    }

    public NoteModel saveNote(NoteModel note) {
        return noteRepository.save(note);
    }

    public Optional<NoteModel> getById(Long id) {
        return noteRepository.findById(id);
    }

    public NoteModel updateById(NoteModel request, Long id) {
        NoteModel note = noteRepository.findById(id).get();
        
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setModificationDate(request.getModificationDate());

        noteRepository.save(note);

        return note;
    }

    public Boolean deleteNote(Long id){
        try {
            noteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
