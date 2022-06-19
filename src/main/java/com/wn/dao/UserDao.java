package com.wn.dao;

import com.wn.model.User;

public interface UserDao extends AbstractDao<User>{
    User getByLogin(String login);

}
