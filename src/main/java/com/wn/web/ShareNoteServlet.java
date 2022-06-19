package com.wn.web;
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
@WebServlet(name = "ShareServlet", urlPatterns = {"/share"})
public class ShareNoteServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String noteTitle = request.getParameter("noteToShare");
        String URLtoShare = "http://localhost:8080/demo1_war_exploded/open?noteToOpen=" + noteTitle;
        request.setAttribute("URLtoShare", URLtoShare);
        request.getRequestDispatcher("/WEB-INF/jsp/main_screen.jsp").forward(request, response);
    }
}