/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author phong
 */
public class SignInController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(false);
        Manager manager = new Manager();
        User searchUser = null;
        String message = "This email has already been registered.";

        if (email.length() > 0 && password.length() > 0) {
            searchUser = Manager.searchAccount(email);
            if (searchUser == null) {
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                response.sendRedirect("info.jsp");
            } else {
                if (session.getAttribute("email") != null && session.getAttribute("password") != null) {
                    session.removeAttribute("email");
                    session.removeAttribute("password");
                }
                session.setAttribute("msg__error", message);
                response.sendRedirect("signin.jsp");
            }
        } else {
            session.invalidate();
        }
    }

}
