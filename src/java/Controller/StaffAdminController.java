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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "StaffAdminController", urlPatterns = "/StaffAdminController")
public class StaffAdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String controller = request.getParameter("controller");
        String typeStaffRole = request.getParameter("typeStaffRole");
        PrintWriter out = response.getWriter();

        String StaffName = request.getParameter("StaffName");
        String StaffIimage = request.getParameter("StaffIimage");
        String StaffDoB = request.getParameter("StaffDoB");
        String StaffGender = request.getParameter("StaffGender");
        String StaffRole = request.getParameter("StaffRole");
        String StaffPhone = request.getParameter("StaffPhone");
        String StaffAddress = request.getParameter("StaffAddress");
        String StaffEmail = request.getParameter("StaffEmail");
        HttpSession session = request.getSession();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (controller.equalsIgnoreCase("showStaff") || controller.equalsIgnoreCase("searchStaff")) {
            ArrayList<Staff> staffs = new ArrayList<>();
            if (controller.equalsIgnoreCase("showStaff")) {
                staffs = Manager.getAllStaff();
            } else {
                String inputStaff = request.getParameter("inputStaff");
                staffs = Manager.searchStaffByName(inputStaff);
            }
            String staffCurrent = request.getParameter("loginStaff");
            Staff staffLogin = Manager.searchStaff(staffCurrent);

            for (Staff staff : staffs) {
                if (staff.getRole().equalsIgnoreCase(typeStaffRole) || typeStaffRole.equalsIgnoreCase("All")) {
                    String getButtonRole = staffButtons(staff, staffLogin);
                    String split[] = staff.getJoinDate().split("\\.");
                    String splitDoB[] = staff.getDoB().split("-");
                    LocalDateTime local = LocalDateTime.parse(split[0], dateFormat);
                    String getDate = getDay(local) + "-" + getMonth(local) + "-" + local.getYear() + " " + local.getHour() + ":" + local.getMinute() + ":" + local.getSecond();
                    String getDoB = splitDoB[2] + "-" + splitDoB[1] + "-" + splitDoB[0];
                    out.print("<div class=\"table__staff-list-item\">\n"
                            + "   <div class=\"table__staff-navbar-item-body\">\n"
                            + "     <img src=\"" + staff.getStaffImage() + "\" alt=\"\" class=\"table__staff-user-img\">\n"
                            + "     <div class=\"table__staff-navbar-item-data\">\n"
                            + "     <div class=\"flex-direction-col flex-item-col-center\">\n"
                            + "         <h5 class=\"table__main-product-name on-staff on-staff-name\">" + staff.getName() + "</h5>\n"
                            + "         <div class=\"table__main-product-name on-staff on-email\">" + staff.getEmailStaff() + "</div>\n"
                            + "     </div>\n"
                            + "<div class=\"table__staff-view\">\n"
                            + "     <div class=\"table__staff-view-group\">\n"
                            + "     <div class=\"table__staff-view-title\">Role</div>\n"
                            + "     <div class=\"table__main-product-type on-staff-role\">" + staff.getRole() + "</div>\n"
                            + "</div>\n"
                            + " <div class=\"table__staff-view-group\">\n"
                            + "     <div class=\"table__staff-view-title\">Gender</div>\n"
                            + "     <div class=\"table__staff-view-data on-staff-gender\">" + staff.getGender() + "</div>\n"
                            + "</div>\n"
                            + "<div class=\"table__staff-view-group\">\n"
                            + "     <div class=\"table__staff-view-title\">Birth Day</div>\n"
                            + "     <div class=\"table__staff-view-data on-staff-gender\">" + getDoB + "</div>\n"
                            + "</div>\n"
                            + "<div class=\"table__staff-view-group\">\n"
                            + "    <div class=\"table__staff-view-title\">Phone Number</div>\n"
                            + "    <div class=\"table__staff-view-data on-staff-number\">" + staff.getPhoneNumber() + "</div>\n"
                            + "</div>\n"
                            + "<div class=\"table__staff-view-group\">\n"
                            + "    <div class=\"table__staff-view-title\">Address</div>\n"
                            + "    <div class=\"table__staff-view-data on-staff-address\">" + staff.getAddress() + "\n"
                            + "</div>\n"
                            + "</div>\n"
                            + "<div class=\"table__staff-view-group\">\n"
                            + "<div class=\"table__staff-view-title\">Join Date</div>\n"
                            + "<div class=\"table__staff-view-data on-staff-join\">" + getDate + "</div>\n"
                            + "</div>\n"
                            + "</div>\n"
                            + getButtonRole
                            + "</div>\n"
                            + "</div>\n"
                            + "</div>");
                }
            }
        } else if (controller.equalsIgnoreCase("updateStaff")) {
            int statusStaff = Manager.updateStaff(StaffName, StaffDoB, StaffGender, StaffAddress, Integer.parseInt(StaffPhone), StaffEmail, StaffRole, StaffIimage);
            if (statusStaff > 0) {
                Staff staff = Manager.searchStaff(StaffEmail);
                String split[] = staff.getJoinDate().split("\\.");
                String splitDoB[] = staff.getDoB().split("-");
                LocalDateTime local = LocalDateTime.parse(split[0], dateFormat);
                String getDate = getDay(local) + "-" + getMonth(local) + "-" + local.getYear() + " " + local.getHour() + ":" + local.getMinute() + ":" + local.getSecond();
                String getDoB = splitDoB[2] + "-" + splitDoB[1] + "-" + splitDoB[0];
                out.print("<div class=\"table__staff-navbar-item-body\">\n"
                        + "     <img src=\"" + staff.getStaffImage() + "\" alt=\"\" class=\"table__staff-user-img\">\n"
                        + "     <div class=\"table__staff-navbar-item-data\">\n"
                        + "     <div class=\"flex-direction-col flex-item-col-center\">\n"
                        + "         <h5 class=\"table__main-product-name on-staff on-staff-name\">" + staff.getName() + "</h5>\n"
                        + "         <div class=\"table__main-product-name on-staff on-email\">" + staff.getEmailStaff() + "</div>\n"
                        + "     </div>\n"
                        + "<div class=\"table__staff-view\">\n"
                        + "     <div class=\"table__staff-view-group\">\n"
                        + "     <div class=\"table__staff-view-title\">Role</div>\n"
                        + "     <div class=\"table__main-product-type on-staff-role\">" + staff.getRole() + "</div>\n"
                        + "</div>\n"
                        + " <div class=\"table__staff-view-group\">\n"
                        + "     <div class=\"table__staff-view-title\">Gender</div>\n"
                        + "     <div class=\"table__staff-view-data on-staff-gender\">" + staff.getGender() + "</div>\n"
                        + "</div>\n"
                        + "<div class=\"table__staff-view-group\">\n"
                        + "     <div class=\"table__staff-view-title\">Birth Day</div>\n"
                        + "     <div class=\"table__staff-view-data on-staff-gender\">" + getDoB + "</div>\n"
                        + "</div>\n"
                        + "<div class=\"table__staff-view-group\">\n"
                        + "    <div class=\"table__staff-view-title\">Phone Number</div>\n"
                        + "    <div class=\"table__staff-view-data on-staff-number\">" + staff.getPhoneNumber() + "</div>\n"
                        + "</div>\n"
                        + "<div class=\"table__staff-view-group\">\n"
                        + "    <div class=\"table__staff-view-title\">Address</div>\n"
                        + "    <div class=\"table__staff-view-data on-staff-address\">" + staff.getAddress() + "\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "<div class=\"table__staff-view-group\">\n"
                        + "<div class=\"table__staff-view-title\">Join Date</div>\n"
                        + "<div class=\"table__staff-view-data on-staff-join\">" + getDate + "</div>\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "<div class=\"table__product-main-action on-order\">\n"
                        + "     <button class=\"table__product-action-btn js-update-staff\" onclick=\"onClickOrderView(this)\">Update Staff</button>\n"
                        + "     <button class=\"table__product-action-btn js-remove-staff\" onclick=\"deleteStaff(this)\">Remove Staff</button>\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "</div>\n");
            } else {
                out.print("FALSE");
            }
        } else if (controller.equalsIgnoreCase("newStaff")) {
            int statusAddStaff = Manager.addStaff(StaffName, StaffDoB, StaffGender, StaffAddress, Integer.parseInt(StaffPhone), StaffEmail, StaffRole, StaffIimage);
            if (statusAddStaff > 0) {
                out.print("SUCCEESS");
            } else {
                out.print("FALSE");
            }
        } else if (controller.equalsIgnoreCase("logoutStaff")) {
            session.removeAttribute("staff");
            out.print("SUCCESS");
        }
    }

    private String getDay(LocalDateTime local) {
        String getDay;
        if (local.getDayOfMonth() < 10) {
            getDay = "0" + local.getDayOfMonth();
        } else {
            getDay = String.valueOf(local.getDayOfMonth());
        }
        return getDay;
    }

    private String getMonth(LocalDateTime local) {
        String getMonth;
        if (local.getMonthValue() < 10) {
            getMonth = "0" + local.getMonthValue();
        } else {
            getMonth = String.valueOf(local.getMonthValue());
        }
        return getMonth;
    }

    private String staffButtons(Staff staff, Staff staffLogin) {
        String button = null;
        if (staffLogin.getRole().equalsIgnoreCase("Admin")) {
            button = "<div class=\"table__product-main-action on-order\">\n"
                    + "     <button class=\"table__staff-action-btn js-update-staff\" onclick=\"onClickOrderView(this)\">Update Staff</button>\n"
                    + "     <button class=\"table__staff-action-btn js-remove-staff\" onclick=\"deleteStaff(this)\">Remove Staff</button>\n"
                    + "</div>\n";
        }
        if (staffLogin.getRole().equalsIgnoreCase("Manager") || staffLogin.getRole().equalsIgnoreCase("Staff") || staffLogin.getRole().equalsIgnoreCase("Admin") && staff.getRole().equalsIgnoreCase("Admin")) {
            button = "<div class=\"table__product-main-action on-order\">\n"
                    + "</div>\n";
        }
        
        if (staff.getName().equals(staffLogin.getName())) {
            button = "<div class=\"table__product-main-action on-order\">\n"
                    + "     <button class=\"table__staff-action-btn js-update-staff show-one\" onclick=\"onClickOrderView(this)\">Update Staff</button>\n"
                    + "</div>\n";
        }
        return button;
    }
}
