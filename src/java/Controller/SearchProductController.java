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
import java.util.ArrayList;

/**
 *
 * @author phong
 */
@WebServlet(name = "SearchProductController", urlPatterns = "/SearchProductController")
public class SearchProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameProduct = request.getParameter("input");
        String email = request.getParameter("email");
        String typeOrder = request.getParameter("typeOrder");
        ArrayList<Order> orders = Manager.searchOrderByName(nameProduct);
        loopHistory(orders, response.getWriter(), typeOrder);
    }

    private void loopHistory(ArrayList<Order> orders, PrintWriter out, String typeOrder) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String cancelButton = "<button class=\"side-bar__order-btn-buy\" onclick=\"onclickProduct(this)\">Buy again</button>\n"
                + "<button class=\"side-bar__order-btn-other\" onclick=\"onclickDetails(this)\">Details</button>";
        String processButton = "<button class=\"side-bar__order-btn-buy\" style=\"opacity: 0.3;cursor: default;\" \">Process</button>\n"
                + "<button class=\"side-bar__order-btn-other\" onclick=\"onclickCancelOrder(this)\">Cancel</button>";
        String completedButton = "<button class=\"side-bar__order-btn-buy\" onclick=\"onclickProduct(this)\">Buy\n again</button>\n"
                + "<button class=\"side-bar__order-btn-other\" onclick=\"onclickDetails(this)\">Details</button>";
        String delayedButton = "<button class=\"side-bar__order-btn-buy\" style=\"opacity: 0.3;cursor: default;\" \">Process</button>\n"
                + "<button class=\"side-bar__order-btn-other\" onclick=\"onclickDetails(this)\">Details</button>";
        for (Order order : orders) {
            String button = "";
            switch (order.getStatus()) {
                case "CANCELLED":
                    button = cancelButton;
                    break;
                case "PROCESS":
                    button = processButton;
                    break;
                case "DELAYED":
                    button = delayedButton;
                    break;
                case "COMPLETED":
                    button = completedButton;
                    break;
            }
            String[] split = order.getOrder().split("\\.");
            LocalDateTime local = LocalDateTime.parse(split[0], dateFormat);
            String localTime = local.getDayOfMonth() + " " + local.getMonth() + " " + local.getYear() + " at " + local.getHour() + ":" + local.getMinute();
            if (order.getStatus().equalsIgnoreCase(typeOrder) || typeOrder.equalsIgnoreCase("All")) {
                out.print("\n" + "<div class=\"side-bar__order-box-data field-Spacer-Top-24\">\n"
                        + "                        <div class=\"side-bar__order-navbar-header\">\n"
                        + "                            <div class=\"side-bar__order-navbar-item identity\"><span>Order\n"
                        + "                                    #" + order.getIdOrder() + "</span></div>\n"
                        + "                            <div class=\"side-bar__order-navbar-item delivery\" style=\"font-size: 0.8rem;\">\n"
                        + "                                " + localTime + "\n"
                        + "                            </div>\n"
                        + "                            <div class=\"side-bar__order-navbar-item status " + order.getStatus().toLowerCase() + " on-status\">\n"
                        + "                                <span class=\"" + order.getStatus().toLowerCase() + "\">" + order.getStatus() + "</span>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"side-bar__order-data\">\n"
                        + "                            <div class=\"side-bar__order-group\">\n"
                        + "                                <div class=\"side-bar__order-group-box field-Spacer-Top-16\">\n"
                        + "                                    <div class=\"flex-container\">\n"
                        + "                                        <div class=\"side-bar__order-product-box-information\">\n"
                        + "                                            <div>\n"
                        + "                                                <img src=\"" + order.getProductImage() + "\" alt=\"\"\n"
                        + "                                                     class=\"side-bar__order-product-img\">\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"side-bar__order-group-data\">\n"
                        + "                                                <div class=\"side-bar__order-heading\">\n"
                        + "                                                    <h5>" + order.getNameProduct() + " </h5>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"side-bar__order-sub-heading\">\n"
                        + "                                                    <span class=\"purchase__product-type\">" + order.getType() + "</span>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"side-bar__order-quantity\">x" + order.getQuantity() + "\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                                <div class=\"side-bar__order-details\">\n"
                        + "                                    <div class=\"side-bar__order-address\">\n"
                        + "                                        <div class=\"flex-item-col-center field-Spacer-Bottom-16\" style=\"column-gap:0.5rem\">\n"
                        + "                                            <h5 class=\"side-bar__order-address-title\">Delivery Location\n"
                        + "                                            </h5>\n"
                        + "                                            <div class=\"side-bar__delivery-img\">\n"
                        + "                                                <img src=\"asssets/img/location.png\" alt=\"\">\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                        <div class=\"side__bar-delivery-body\">\n"
                        + "                                            <div class=\"side-bar__order-details-delivery\">\n"
                        + "                                                <div>" + order.getAddressCustomer() + "\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                    <div class=\"side-bar__order-summary\">\n"
                        + "                                        <div class=\"flex-item-col-center field-Spacer-Bottom-16\" style=\"column-gap:0.5rem\">\n"
                        + "                                            <h5 class=\"side-bar__order-summary-title\">Summary\n"
                        + "                                            </h5>\n"
                        + "                                            <div class=\"side-bar__delivery-img\">\n"
                        + "                                                <img src=\"asssets/img/price-tag.png\" alt=\"\">\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                        <div class=\"side__bar-delivery-body\">\n"
                        + "                                            <div class=\"side-bar__price\">\n"
                        + "                                                <div class=\"side-bar__price-group\">\n"
                        + "                                                    <div class=\"side-bar__price-list\">\n"
                        + "                                                        <div class=\"side-bar__sub-title\">Price:</div>\n"
                        + "                                                        <div class=\"side-bar__price-list-box\">\n"
                        + "                                                            <div class=\"side-bar__price-icon\">$</div>\n"
                        + "                                                            <div class=\"side-bar__price-title on-price\" value=\"" + order.getPrice() + "\">" + order.getPrice() + "</div>\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"side-bar__price-group\">\n"
                        + "                                                    <div class=\"side-bar__price-list\">\n"
                        + "                                                        <div class=\"side-bar__sub-title\">Total:</div>\n"
                        + "                                                        <div class=\"side-bar__price-list-box\">\n"
                        + "                                                            <div class=\"side-bar__price-icon\">$</div>\n"
                        + "                                                            <div class=\"side-bar__price-title\" style=\"font-size:1.25rem;\" value=\"" + order.getTotal() + "\">" + order.getTotal() + "</div>\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                                <div class=\"side-bar__order-btn\">\n"
                        + "                                     " + button
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>");
            }
        }
    }
}
