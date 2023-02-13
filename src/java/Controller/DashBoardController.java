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
 * @author phong
 */
@WebServlet(name = "DashBoardController", urlPatterns = "/DashBoardController")
public class DashBoardController extends HttpServlet { 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String controller = request.getParameter("controller");
        User user = Manager.searchAccount(email);
        ArrayList<Order> order = Manager.getAllOrders(user.getID());
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int count = 0;

        if (controller.equals("history")) {
            LoginController updateController = new LoginController();
            updateController.updateDistanceTime(user.getID(), session);
            updateController.updateOrderHistory(user, session);
            updateController.updateDashBoard(user, session);
            updateController.updateDashBoardTotalSpend(user, session);
            if (!order.isEmpty()) {
                for (Order orders : order) {
                    if (count < 8) {
                        out.print("<tbody>\n"
                                + "<td>" + orders.getNameProduct() + "</td>\n"
                                + "<td>" + orders.getPrice() + "</td>\n"
                                + "<td>" + orders.getTotal() + "</td>\n"
                                + "<td class=\"" + orders.getStatus().toLowerCase() + "\">" + orders.getStatus() + "</td>\n"
                                + "</tbody>");
                        count++;
                    }
                }
            } else {
                out.print("FALSE");
            }
        } else if (controller.equals("achivement")) {
            out.print(getNumberOfOrders(user));
        }
    }

    private String getNumberOfOrders(User user) {
        ArrayList<Integer> listOrders = Manager.getOrdersAchivement(user.getID());
        int numberOfProcess = 0;
        int numberOfCancelled = 0;
        int numberOfCompleted = 0;
        if (!listOrders.isEmpty()) {
            numberOfProcess = listOrders.get(0);
            numberOfCancelled = listOrders.get(1);
            numberOfCompleted = listOrders.get(2);
        }
        String toStringValue = String.valueOf(numberOfProcess) + " " + String.valueOf(numberOfCancelled) + " " + String.valueOf(numberOfCompleted);
        return toStringValue;
    }
}
