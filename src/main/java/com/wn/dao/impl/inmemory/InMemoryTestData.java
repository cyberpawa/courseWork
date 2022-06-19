package com.wn.dao.impl.inmemory;

import com.wn.model.Note;
import com.wn.model.User;

import java.util.*;

public class InMemoryTestData {


    public static void generateTo(InMemoryDatabase database) {
        database.users.clear();
        database.notes.clear();

        User max = new User(1, "Pasha", "chihhh@example.com", "12345678");
        User bogdan = new User(2, "Bogdan", "bogdan@example.com", "passwordhash");
        User yana = new User(3, "Yana", "yana@example.com", "passwordhash");
        User diana = new User(4, "Diana", "diana@example.com", "passwordhash");
        List<User> users = Arrays.asList(max, bogdan, yana, diana);
        users.forEach(user -> database.users.put(user.getUserId(), user));

        Note pokupki=new Note(1,max,"moloko, disk, gematogenka","pokupki");
        Note deadlines=new Note(2,max,"github, kursa4, matan","deadlines");
        Note trr=new Note(3,bogdan,"fmm, fpm, DO NOT TOUCH IASA","trr");
        Note poetry=new Note(4,yana,"*in production here will be some poetry*","poetry");
        Note note_yana=new Note(5,yana,"якби я була співачкою казка, то пісня складалась би лише зі слів поплакала і знов","казка");
        List<Note> notes = Arrays.asList(pokupki,deadlines,trr,poetry,note_yana);
        notes.forEach(note -> database.notes.put(note.getNoteID(), note));



    }

}
