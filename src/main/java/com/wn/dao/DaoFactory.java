package com.wn.dao;

public interface DaoFactory {


    NoteDao getNoteDao();

    UserDao getUserDao();
}
