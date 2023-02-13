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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author phong
 */
@WebServlet(name = "DeleteUserController", urlPatterns = "/DeleteUserController")
public class DeleteUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String controller = request.getParameter("controller");
        User user = Manager.searchAccount(email);
        String content = "FALSE";
        HttpSession session = request.getSession();
        
        if (controller != null && password != null && email != null) {
            if (password.equals(user.getPassword())) {
                content = "TRUE";
            }
            response.getWriter().print(content);
        } else {
            Manager.deleteAccount(email);
            session.removeAttribute("status");
            session.removeAttribute("user");
            session.invalidate();
            response.sendRedirect("index.jsp");
            return;
        }
    }

}
