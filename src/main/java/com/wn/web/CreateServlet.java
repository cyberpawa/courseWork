package com.wn.web;

import com.wn.model.User;
import com.wn.services.NoteService;
import com.wn.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CreateServlet", urlPatterns = {"/create"})
public class CreateServlet extends HttpServlet {

    NoteService noteService;
    UserService userService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        this.noteService = (NoteService) config.getServletContext().getAttribute("noteService");
        this.userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("newNoteTitle");
        User user = (User) request.getSession().getAttribute("user");
        noteService.createNote(title, user);
        request.getSession().setAttribute("ownedNotes", userService.getOwnedNotes(user));
        request.getRequestDispatcher("/WEB-INF/jsp/main_screen.jsp").forward(request, response);
    }
}