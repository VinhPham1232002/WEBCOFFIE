/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "numberOrdersController", urlPatterns = "/numberOrdersController")
public class numberOrdersController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String numberOrders = request.getParameter("numberOrders");
        int numberOrder = 0;
        try {
            if (session.getAttribute("minusNotify") == null) {
                numberOrder = Integer.parseInt(numberOrders);
            }else{
                numberOrder = (int)session.getAttribute("minusNotify") + Integer.parseInt(numberOrders);
            }
        } catch (NumberFormatException numberError) {
            session.setAttribute("minusNotify", numberOrder);
            response.getWriter().print("FALSE");
            return;
        }

        session.setAttribute("minusNotify", numberOrder);
        response.getWriter().print("TRUE");
    }

}
