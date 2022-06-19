package com.wn.dao.impl.inmemory;

import com.wn.dao.DaoFactory;
import com.wn.model.Note;
import com.wn.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {


    Map<Integer, Note> notes;
    Map<Integer, User> users;

    public InMemoryDatabase() {
        notes = new HashMap<>();
        users = new HashMap<>();
    }

    public DaoFactory getDaoFactory() {
        return new InMemoryDaoFactory(this);
    }

}
