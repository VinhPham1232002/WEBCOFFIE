/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.Order;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CancelOrderController", urlPatterns = "/CancelOrderController")
public class CancelOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderID = request.getParameter("orderID");
        String email = request.getParameter("email");
        String description = request.getParameter("description");
        String controller = request.getParameter("controller");

        User user = Manager.searchAccount(email);
        HttpSession session = request.getSession();
        Order order = Manager.searchOrder(orderID, user.getID());

        Clock currentClock = Clock.systemDefaultZone();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDate = LocalDateTime.now(currentClock).withNano(0);
        PrintWriter out = response.getWriter();

        if (order.getIdOrder() != null && user != null && controller.equals("notify")) {
            int status = Manager.updateStatus(order.getIdOrder(), "CANCELLED");
            int updateStatus = Manager.updateTime(order.getIdOrder(), "", "UPDATE [ORDERCUSTOMER] SET DISTANCE = ?, CANCEL = GETDATE() WHERE [IDORDER] = ?");
            int updateDescription = Manager.updateTransportStatus(description, order.getIdOrder());
            if (status > 0 && updateStatus > 0) {
                updateDistanceTime(user, session, response.getWriter());
            } else {
                response.getWriter().print("FALSE");
            }
        } else {
            OrderController orderController = new OrderController();
            orderController.loopHistory(Manager.getAllOrders(user.getID()), dateFormat, out, user.getID(), session);
        }
    }

    public void updateDistanceTime(User user, HttpSession session, PrintWriter out) {
        int userID = user.getID();
        int removeNotifyNumber = 0;
        int count = 0;

        Clock currentClock = Clock.systemDefaultZone();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDate = LocalDateTime.now(currentClock).withNano(0);
        LoginController actionController = new LoginController();

        if (session.getAttribute("minusNotify") != null) {
            removeNotifyNumber = (int) session.getAttribute("minusNotify");
        }
        ArrayList<Order> orders = Manager.getAllOrders(userID);
        for (Order order : orders) {
            String[] split = order.getOrder().split("\\.");
            if (order.getStatus().equals("CANCELLED")) {
                split = order.getCancel().split("\\.");
            } else if (order.getStatus().equals("COMPLETED")) {
                split = order.getComplete().split("\\.");
            }else if (order.getStatus().equals("DELAYED")) {
                split = order.getDelay().split("\\.");
            }
            LocalDateTime local = LocalDateTime.parse(split[0], dateFormat);
            LocalDateTime tempDateTime = LocalDateTime.from(local).withNano(0);
            long hourDistance = tempDateTime.until(currentDate, ChronoUnit.HOURS);
            long minuteDistance = tempDateTime.until(currentDate, ChronoUnit.MINUTES);
            long secondDistance = tempDateTime.until(currentDate, ChronoUnit.SECONDS);
            long dayDistance = tempDateTime.until(currentDate, ChronoUnit.DAYS);
            long monthDistance = tempDateTime.until(currentDate, ChronoUnit.MONTHS);
            long yearDistance = tempDateTime.until(currentDate, ChronoUnit.YEARS);

            String contentTime = "";
            String message = "";

            if (dayDistance >= 4) {
                continue;
            } else if (dayDistance > 0 && hourDistance > 0 && minuteDistance > 0 && secondDistance > 0) {
                contentTime = actionController.distanceChronoUnit(" day ago", " days ago", dayDistance);
            } else if (hourDistance > 0 && minuteDistance > 0 && secondDistance > 0) {
                contentTime = actionController.distanceChronoUnit(" hour ago", " hours ago", hourDistance);
            } else if (minuteDistance > 0 && secondDistance > 0) {
                contentTime = actionController.distanceChronoUnit(" minute ago", " minutes ago", minuteDistance);
            } else {
                contentTime = actionController.distanceChronoUnit(" second ago", " seconds ago", secondDistance);
            }
            if (order.getStatus().equals("PROCESS")) {
                message = "Your order <span style=\"font-weight:bold\">" + order.getIdOrder() + "</span> of product <span style=\"font-weight:bold\">" + order.getNameProduct() + "</span> is being processed. Our courier will contact you for delivery schedule.";
            } else if (order.getStatus().equals("CANCELLED")) {
                message = "Your order <span style=\"font-weight:bold\">" + order.getIdOrder() + "</span> of product <span style=\"font-weight:bold\">" + order.getNameProduct() + "</span> has been cancelled.";
            } else if (order.getStatus().equals("DELAYED")) {
                message = "Your order <span style=\"font-weight:bold\">" + order.getIdOrder() + "</span> of product <span style=\"font-weight:bold\">" + order.getNameProduct() + "</span> has been delayed. Please check your order details in settings or contact us to receive a support.";
            } else {
                message = "Your order <span style=\"font-weight:bold\">" + order.getIdOrder() + "</span> of product <span style=\"font-weight:bold\">" + order.getNameProduct() + "</span> has been completed. Please contact us for our best assistance within 48 hours of receipt of the product for any sign of damage.";
            }
            out.print("<li class=\"header__notice-item\">\n"
                    + "<div class=\"header__notice-product-img\" data-size=\"" + removeNotifyNumber + "\">\n"
                    + "   <img src=\"" + order.getProductImage() + "\" alt=\"\">\n"
                    + "</div>\n"
                    + "<div class=\"header__notice-body\">\n"
                    + "<div class=\"header__notice-heading\">" + message + " \n"
                    + "</div>\n"
                    + "<div class=\"header__notice-time-remaining\">" + contentTime + "</div>\n"
                    + "</div>\n"
                    + "<div class=\"header__notice-action\">\n"
                    + "<img src=\"asssets/img/close-icon.png\" onclick=\"closeNotify()\" alt=\"\">\n"
                    + "</div>\n"
                    + "</li>");
            Manager.updateTime(order.getIdOrder(), contentTime, "UPDATE [ORDERCUSTOMER] SET [DISTANCE] = ? WHERE [IDORDER] = ?");
            count++;
        }
        count -= removeNotifyNumber;
        orders = Manager.getAllOrders(userID);
        session.setAttribute("orders", orders);
        session.setAttribute("numberOrder", count);
    }
}
