package com.wn.web;

import com.wn.dao.*;
import com.wn.dao.impl.inmemory.*;
import com.wn.services.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.function.UnaryOperator;

public class ApplicationContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        InMemoryDatabase database = new InMemoryDatabase();

        InMemoryTestData.generateTo(database);

        DaoFactory daoFactory = database.getDaoFactory();

        NoteService noteService = new NoteServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("noteService", noteService);

        UserService userService = new UserServiceImpl(daoFactory, UnaryOperator.identity());
        sce.getServletContext().setAttribute("userService", userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
