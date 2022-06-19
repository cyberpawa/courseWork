package com.wn.web;
import com.wn.model.Note;
import com.wn.model.User;
import com.wn.services.NoteService;
import com.wn.services.UserService;
import com.wn.services.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "OpenServlet", urlPatterns = {"/open"})
public class OpenNoteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String noteTitle = request.getParameter("noteToOpen");
        NoteService noteService = (NoteService) request.getServletContext().getAttribute("noteService");
        Note note = noteService.getByTitle(noteTitle);
        request.getSession().setAttribute("note", note);
        request.getRequestDispatcher("/WEB-INF/jsp/main_screen.jsp").forward(request, response);
    }
}