package com.wn.dao.impl.inmemory;

import com.wn.dao.DaoFactory;
import com.wn.dao.NoteDao;
import com.wn.dao.UserDao;

public class InMemoryDaoFactory implements DaoFactory {
    InMemoryDatabase database;

    NoteDao noteDao;
    UserDao userDao;

    InMemoryDaoFactory(InMemoryDatabase database) {
        this.database = database;

        noteDao = new InMemoryNoteDao(database);
        userDao = new InMemoryUserDao(database);
    }

    @Override
    public NoteDao getNoteDao() {
        return noteDao;
    }

    @Override
    public UserDao getUserDao() {
        return userDao;
    }


}
