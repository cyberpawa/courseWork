package com.wn.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wn.services.*;
import com.wn.model.Note;
import com.wn.model.User;

/**
 *
 * @author user
 */
import javax.servlet.ServletConfig;

@WebServlet(name = "DeleteServlet", urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        String noteTitle = request.getParameter("noteToDelete");
        Note note = noteService.getByTitle(noteTitle);
        noteService.deleteNote(note);
        User user = (User) request.getSession().getAttribute("user");
        request.getSession().setAttribute("ownedNotes", userService.getOwnedNotes(user));
        request.getRequestDispatcher("/WEB-INF/jsp/main_screen.jsp").forward(request, response);
    }
}