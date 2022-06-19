package com.wn.dao.impl.inmemory;

import com.wn.dao.NoteDao;
import com.wn.model.Note;

import java.util.Collection;

public class InMemoryNoteDao  extends InMemoryAbstractDao<Note> implements NoteDao {

    public InMemoryNoteDao(InMemoryDatabase database){
        super(database.notes, Note::getNoteID, Note::setNoteID, database);
    }


    @Override
    public Collection<Note> getAllNotes() {
        return database.notes.values();
    }

}
