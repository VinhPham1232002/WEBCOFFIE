/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.Order;
import Model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
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
 * @author phong
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        Manager manager = new Manager();
        User user;
        boolean status = false;
        session.setAttribute("status", status);
        String message = "Please check that your e-mail address and password are correct.";

        if (email != null && password != null) {
            user = Manager.searchAccount(email);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    status = true;
                    session.setAttribute("status", status);
                    session.setAttribute("user", user);
                    session.setAttribute("verifyAccount", user.getVerify());
                    updateDistanceTime(user.getID(), session);
                    updateOrderHistory(user, session);
                    updateDashBoard(user, session);
                    updateDashBoardTotalSpend(user, session);
                    response.sendRedirect("index.jsp");
                } else {
                    session.setAttribute("message", message);
                    response.sendRedirect("login.jsp");
                }
            } else {
                session.setAttribute("message", message);
                response.sendRedirect("login.jsp");
            }
        } else {
            session.invalidate();
        }
    }

    public void updateDashBoard(User user, HttpSession session) {
        ArrayList listOrders = Manager.getOrdersAchivement(user.getID());
        Clock currentClock = Clock.systemDefaultZone();
        LocalDateTime currentDate = LocalDateTime.now(currentClock).withNano(0);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String[] split = user.getJoinDate().split("\\.");
        LocalDateTime local = LocalDateTime.parse(split[0], dateFormat);
        LocalDateTime tempDateTime = LocalDateTime.from(local).withNano(0);
        long dayDistance = tempDateTime.until(currentDate, ChronoUnit.DAYS);

        String getDay;
        String getMonth;

        if (local.getDayOfMonth() < 10) {
            getDay = "0" + local.getDayOfMonth();
        } else {
            getDay = String.valueOf(local.getDayOfMonth());
        }

        if (local.getMonthValue() < 10) {
            getMonth = "0" + local.getMonthValue();
        } else {
            getMonth = String.valueOf(local.getMonthValue());
        }

        String getDateCreate = getDay + "-" + getMonth + "-" + local.getYear() + " at " + local.getHour() + ":" + local.getMinute() + ":" + local.getSecond();
        session.setAttribute("ordersAchivement", listOrders);
        session.setAttribute("joinDate", getDateCreate);
        session.setAttribute("activeDay", dayDistance + 1);
    }

    public void updateDashBoardTotalSpend(User user, HttpSession session) {
        ArrayList<Order> orders = Manager.getAllOrders(user.getID());
        Clock currentClock = Clock.systemDefaultZone();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDate = LocalDateTime.now(currentClock).withNano(0);

        float daySpend = 0.00f;
        float monthSpend = 0.00f;
        float yearSpend = 0.00f;

        for (Order order : orders) {
            if (order.getStatus().equals("COMPLETED")) {
                String[] split = order.getComplete().split("\\.");

                LocalDateTime local = LocalDateTime.parse(split[0], dateFormat);
                LocalDateTime tempDateTime = LocalDateTime.from(local).withNano(0);
                long hourDistance = tempDateTime.until(currentDate, ChronoUnit.HOURS);
                long dayDistance = tempDateTime.until(currentDate, ChronoUnit.DAYS);
                long monthDistance = tempDateTime.until(currentDate, ChronoUnit.MONTHS);
                long yearDistance = tempDateTime.until(currentDate, ChronoUnit.YEARS);

                if (dayDistance > 0 || hourDistance < 23) {
                    daySpend += order.getTotal();
                }
                if (monthDistance > 0) {
                    monthSpend += order.getTotal();
                } 
                if (yearDistance > 0) {
                    yearSpend += order.getTotal();
                }
            }
        };
        session.setAttribute("daySpend", String.format("%.2f", daySpend));
        session.setAttribute("monthSpend", String.format("%.2f", monthSpend));
        session.setAttribute("yearSpend", String.format("%.2f", yearSpend));
    }

    public void updateOrderHistory(User user, HttpSession session) {
        ArrayList<Order> orders = Manager.getAllOrders(user.getID());

        if (!orders.isEmpty()) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            for (Order order : orders) {
                String[] split = order.getOrder().split("\\.");
                LocalDateTime local = LocalDateTime.parse(split[0], dateFormat);
                String localTime = local.getDayOfMonth() + " " + local.getMonth() + " " + local.getYear() + " at " + local.getHour() + ":" + local.getMinute();
                Manager.updateTime(order.getIdOrder(), localTime, "UPDATE [ORDERCUSTOMER] SET [ORDERTIME] = ? WHERE [IDORDER] = ?");
            }
            orders = Manager.getAllOrders(user.getID());
            session.setAttribute("ordersHistory", orders);
        } else {
            session.removeAttribute("ordersHistory");
        }

    }

    public void updateDistanceTime(int userID, HttpSession session) {
        ArrayList<Order> orders = Manager.getAllOrders(userID);
        if (!orders.isEmpty()) {
            Clock currentClock = Clock.systemDefaultZone();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime currentDate = LocalDateTime.now(currentClock).withNano(0);
            int count = 0;
            int removeNotifyNumber = 0;
            if (session.getAttribute("minusNotify") != null) {
                removeNotifyNumber = (int) session.getAttribute("minusNotify");
            }
            for (Order order : orders) {
                String time = order.getDelayedTime();
                String[] split = order.getOrder().split("\\.");
                if (order.getStatus().equals("CANCELLED")) {
                    split = order.getCancel().split("\\.");
                } else if (order.getStatus().equals("COMPLETED")) {
                    split = order.getComplete().split("\\.");
                } else if (order.getStatus().equals("DELAYED")) {
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
                    contentTime = distanceChronoUnit(" day ago", " days ago", dayDistance);
                } else if (hourDistance > 0 && minuteDistance > 0 && secondDistance > 0) {
                    contentTime = distanceChronoUnit(" hour ago", " hours ago", hourDistance);
                } else if (minuteDistance > 0 && secondDistance > 0) {
                    contentTime = distanceChronoUnit(" minute ago", " minutes ago", minuteDistance);
                } else {
                    contentTime = distanceChronoUnit(" second ago", " seconds ago", secondDistance);
                }

                Manager.updateTime(order.getIdOrder(), contentTime, "UPDATE [ORDERCUSTOMER] SET [DISTANCE] = ? WHERE [IDORDER] = ?");
                count++;
            }
            count -= removeNotifyNumber;
            session.setAttribute("numberOrder", count);
            orders = Manager.getAllOrders(userID);
            session.setAttribute("orders", orders);
        } else {
            session.removeAttribute("orders");
        }
    }

    public String distanceChronoUnit(String message, String messageAlt, long distance) {
        String contentTime = "";
        if (distance > 1) {
            contentTime = distance + messageAlt;
        } else {
            contentTime = distance + message;
        }

        return contentTime;
    }
}
