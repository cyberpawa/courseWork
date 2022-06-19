package com.wn.services;

import com.wn.dao.DaoFactory;
import com.wn.model.Note;
import com.wn.model.User;

import java.util.Collection;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{


    DaoFactory daoFactory;
    UnaryOperator<String> passwordHasher;

    public UserServiceImpl(DaoFactory daoFactory, UnaryOperator<String> passwordHasher) {
        this.daoFactory = daoFactory;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public User getByLogin(String login) {
        return daoFactory.getUserDao().getByLogin(login);
    }

    @Override
    public boolean checkPassword(User user, String password) {
        return user.getPassword().equals(password);
    }


    @Override
    public Collection<Note> getOwnedNotes(User user){
        return daoFactory.getNoteDao().getAllNotes().
                stream().filter((note) -> (this.isOwner(user,note))).collect(Collectors.toList());
    }

    public boolean isOwner(User user, Note note){
        return user.equals(note.getOwner());
    }

}
