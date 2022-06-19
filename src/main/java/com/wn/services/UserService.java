package com.wn.services;

import com.wn.model.Note;
import com.wn.model.User;

import java.util.Collection;

public interface UserService {


    User getByLogin(String login);

    boolean checkPassword(User user, String password);
    public Collection<Note> getOwnedNotes(User user);
    boolean isOwner(User user,Note note);

}
