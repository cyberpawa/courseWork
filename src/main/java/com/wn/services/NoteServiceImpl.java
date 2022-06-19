package com.wn.services;

import com.wn.dao.DaoFactory;
import com.wn.model.Note;
import com.wn.model.User;

public class NoteServiceImpl implements NoteService {


    DaoFactory daoFactory;

    public NoteServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void saveNote(Note note, String text) {
        note.setText(text);
    }

    @Override
    public void deleteNote(Note note) {
        daoFactory.getNoteDao().delete(note);

    }

    @Override
    public String shareNote(Note note) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Note getByTitle(String title){
        return daoFactory.getNoteDao().getAllNotes().stream().filter(note->note.getTitle().equals(title)).findFirst().orElse(null);
    }


    @Override
    public void createNote(String title, User owner){
        daoFactory.getNoteDao().insert(new Note(-1,owner,"",title),true);
    }


}
