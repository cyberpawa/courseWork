package com.wn.services;

import com.wn.model.Note;
import com.wn.model.User;

public interface NoteService {

    void saveNote(Note note, String text);
    void deleteNote(Note note);
    String shareNote(Note note);
    Note getByTitle(String title);
    void createNote(String title, User owner);

}
