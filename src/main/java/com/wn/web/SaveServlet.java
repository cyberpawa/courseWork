package com.wn.web;
import com.wn.model.Note;
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

/**
 *
 * @author user
 */
@WebServlet(name = "SaveServlet", urlPatterns = {"/save"})
public class SaveServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Note note = (Note) request.getSession().getAttribute("note");
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !userService.getOwnedNotes(user).contains(note)) {
            request.setAttribute("error", "That's not yours!!!!!");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            return;
        }
        String noteText = request.getParameter("noteText");
        noteService.saveNote(note, noteText);
        request.getRequestDispatcher("/WEB-INF/jsp/main_screen.jsp").forward(request, response);
    }

}