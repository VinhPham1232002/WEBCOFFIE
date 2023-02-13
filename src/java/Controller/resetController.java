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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class resetController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("emailReSign");
        String newPassword = request.getParameter("newPassword");
        String message = null;

        if (newPassword != null && email != null) {
            if (newPassword.length() < 6) {
                message = "Must be 6 or more in length";
                session.removeAttribute("resetStatus");
                session.setAttribute("currentPassword", newPassword);
                session.setAttribute("messageReseting", message);
                response.sendRedirect("reset.jsp");
                return;
            } else if (email == null) {
                message = "Token has expired";
                session.removeAttribute("resetStatus");
                session.setAttribute("currentPassword", newPassword);
                session.setAttribute("messageReseting", message);
                response.sendRedirect("reset.jsp");
                return;
            } else {
                Manager manager = new Manager();
                User user = manager.searchAccount(email);

                if (user != null) {
                    int status = manager.changedPassword(email, newPassword);

                    if (status > 0) {
                        session.removeAttribute("email");
                        session.removeAttribute("messageReseting");
                        session.removeAttribute("currentPassword");
                        session.setAttribute("resetStatus", true);
                        response.sendRedirect("login.jsp");
                    } else {
                        message = "There are some error unexpected. Please try again.";
                        session.removeAttribute("resetStatus");
                        session.setAttribute("currentPassword", newPassword);
                        session.setAttribute("messageReseting", message);
                        response.sendRedirect("reset.jsp");
                    }
                } else {
                    message = "Your account doesn't exist.";
                    session.removeAttribute("resetStatus");
                    session.setAttribute("currentPassword", newPassword);
                    session.setAttribute("messageReseting", message);
                    response.sendRedirect("reset.jsp");
                }

            }
        } else {
            message = "Token has expired";
            session.removeAttribute("resetStatus");
            session.setAttribute("currentPassword", newPassword);
            session.setAttribute("messageReseting", message);
            response.sendRedirect("reset.jsp");
        }
    }

}
