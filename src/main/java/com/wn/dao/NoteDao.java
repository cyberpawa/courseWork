package com.wn.dao;

import com.wn.model.Note;

import java.util.Collection;

public interface NoteDao extends AbstractDao<Note>{

    Collection<Note> getAllNotes();
}
