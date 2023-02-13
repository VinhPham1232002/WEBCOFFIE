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
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author phong
 */
public class VerifyContinueController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("emailVerify");
        String titleMessage;
        String subMessage;
        String buttonText;
        String pathLink;
        Manager manager = null;

        if (email != null) {
            titleMessage = "Email Verify!";
            buttonText = "Continue to Coffie";
            pathLink = "index.jsp";
            session.removeAttribute("subMsg");
            session.setAttribute("titleMsg", titleMessage);
            session.setAttribute("buttonMsg", buttonText);
            session.setAttribute("pathLink", pathLink);
            session.setAttribute("loadingScreen", "loading");
            int status = manager.verifyAccount(email);
            if (status > 0) {
                User user = manager.searchAccount(email);
                session.setAttribute("verifyAccount", user.getVerify());
            }
        } else {
            titleMessage = "Email verification link has expired.";
            subMessage = "Please login and resend the link";
            buttonText = "Login";
            pathLink = "login.jsp";
            session.setAttribute("titleMsg", titleMessage);
            session.setAttribute("subMsg", subMessage);
            session.setAttribute("buttonMsg", buttonText);
            session.setAttribute("pathLink", pathLink);
        }
        response.sendRedirect("verify.jsp");
    }
}
