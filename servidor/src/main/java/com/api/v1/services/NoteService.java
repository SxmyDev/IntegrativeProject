package com.api.v1.services;

// import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.api.v1.models.NoteModel;
import com.api.v1.repositories.INoteRepository;

import java.util.List;

@Service
public class NoteService {
    @Autowired    
    private INoteRepository noteRepository;

    @Async
    public CompletableFuture<List<NoteModel>> getNotes() {
        return CompletableFuture.completedFuture(noteRepository.findAll());
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
