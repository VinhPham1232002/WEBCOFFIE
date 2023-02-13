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

/**
 *
 * @author phong
 */
@WebServlet(name = "StaffAdminController", urlPatterns = "/StaffAdminController")
public class ChangeStaffPassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String controller = request.getParameter("controller");
        String staffEmail = request.getParameter("staffEmail");
        String staffNewPassword = request.getParameter("staffNewPassword");
        Staff staff = Manager.searchStaff(staffEmail);
        PrintWriter out = response.getWriter();

        if (controller.equalsIgnoreCase("changePassword")) {
            String password = request.getParameter("staffPassword");
            if (staff.getName() != null && staff.getPassword().equals(password)) {
                Manager.updateStaffPassWord(staffEmail, staff.getName(), staffNewPassword);
                out.print("SUCCESS");
            } else {
                out.print("FAILED");
            }
        } else if (controller.equalsIgnoreCase("resetPassword")) {
            String staffSpecialCode = request.getParameter("staffSpecialCode");
            if (staff.getName() != null && staffSpecialCode.equals("lifeofcoffie")) {
                Manager.updateStaffPassWord(staffEmail, staff.getName(), staffNewPassword);
                out.print("SUCCESS");
            } else {
                out.print("FAILED");
            }
        }
    }

}
