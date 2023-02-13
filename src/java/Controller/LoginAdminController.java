/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.Staff;
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
@WebServlet(name = "AdminController", urlPatterns = "/AdminController")
public class LoginAdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Staff staff = Manager.searchStaff(email);
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        if (staff.getName() != null) {
            if (staff.getPassword().equals(password)) {
                out.print("<div class=\"loading-screen__title\">\n"
                        + "    <img src=\"" + staff.getStaffImage() + "\" alt=\"\" class=\"welcone-staff-img\" style=\"width:100px;height:100px;\">\n"
                        + "<h5 class=\"loading-screen__heading js-login-loading\" style=\"font-size:2rem;margin-top:1rem;opacity:0;\">WELCOME BACK</h5>\n"
                        + "     <div class=\"loading-screen__sub-heading welcome-staff-name\" style=\"font-size:1.5rem;margin-top:-4rem;\">" + staff.getName() + "</div>\n"
                        + "</div>");
                session.setAttribute("staff", staff);
            } else {
                out.print("FALSE");
                session.removeAttribute("staff");
            }
        } else {
            out.print("FALSE");
            session.removeAttribute("staff");
        }
    }

}
