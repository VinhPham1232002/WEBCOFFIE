/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.Order;
import Model.Product;
import Model.Transport;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "TransportController", urlPatterns = "/TransportController")
public class TransportController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderID = request.getParameter("orderID");
        String email = request.getParameter("email");

        User user = Manager.searchAccount(email);
        Transport transport = Manager.searchOrderTransport(user.getID(), orderID);
        PrintWriter out = response.getWriter();
        Order order = Manager.searchOrder(orderID, user.getID());
        Product product = Manager.searchProduct(order.getNameProduct());
        String[] split = null;

        if (order.getStatus().equals("CANCELLED")) {
            split = order.getCancel().split("\\.");
        } else if (order.getStatus().equals("COMPLETED")) {
            split = order.getComplete().split("\\.");
        } else if (order.getStatus().equals("DELAYED")) {
            split = order.getDelay().split("\\.");
        }
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime local = LocalDateTime.parse(split[0], dateFormat);

        if (user != null && transport != null) {
            String getDay;
            String getMonth;
            if (local.getDayOfMonth() < 10) {
                getDay = "0" + String.valueOf(local.getDayOfMonth());
            } else {
                getDay = String.valueOf(local.getDayOfMonth());
            }
            if (local.getMonthValue() < 10) {
                getMonth = "0" + String.valueOf(local.getMonthValue());
            } else {
                getMonth = String.valueOf(local.getMonthValue());
            }
            String getDate = getDay + "-" + getMonth + "-" + local.getYear() + " " + local.getHour() + ":" + local.getMinute();
            String getTransport = transport.getTransportName() + "+" + transport.getDescription() + "+" + getDate + "+" + product.getRate() + "+" + order.getRate() + "+/ " + Manager.getNumberOfRate(product.getIdProduct());
            out.print(getTransport);
        } else {
            out.print("Nothing Here");
        }
    }
}
