package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
public class InfoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String nickname = request.getParameter("nickname");
        Manager manager = new Manager();
        User user;
        int status = 0;
        HttpSession session = request.getSession(false);

        if (email != null && password != null && gender != null
                && phone != null && nickname != null) {
            user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setGender(gender);
            user.setPhoneNumber(Integer.parseInt(phone));
            user.setNickname(nickname);
            status = Manager.saveUserSignIn(user);
            if (status > 0) {
                session.setAttribute("statusSignIn", status);
                response.sendRedirect("login.jsp");
                return;
            } else {
                session.removeAttribute("statusSignIn");
                response.sendRedirect("login.jsp");
                return;
            }
        } else {
            session.removeAttribute("status");
        }
        response.sendRedirect("login.jsp");
    }

}
