package com.wn.dao;

import java.util.Collection;

public interface AbstractDao<T> {
    T get(Integer id);

    Collection<T> findAll();

    void insert(T entity, boolean generateID);

    void delete(T entity);

    void update(T entity);

}
