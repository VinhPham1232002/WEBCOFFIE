/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.*;
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
import java.util.Random;

/**
 *
 * @author phong
 */
@WebServlet(name = "OrderController", urlPatterns = "/OrderController")
public class OrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String productname = request.getParameter("nameProduct");
        String controller = request.getParameter("update");

        User user = Manager.searchAccount(email);
        Product product = Manager.searchProduct(productname);
        HttpSession session = request.getSession();

        Clock currentClock = Clock.systemDefaultZone();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDate = LocalDateTime.now(currentClock).withNano(0);

        if (controller.equals("notify")) {
            float price = Float.parseFloat(request.getParameter("price"));
            float shippingCost = Float.parseFloat(request.getParameter("transportCost"));
            float total = Float.parseFloat(request.getParameter("total"));
            String base64Image = request.getParameter("image");
            String quantity = request.getParameter("quantity");
            String type = request.getParameter("type");
            if (user != null && product != null) {
                loopNotify(user, product, productname, type, quantity, price, shippingCost, total, base64Image, session, dateFormat, currentDate, out);
            }
        } else if (!controller.equals("rateProduct")) {
            if (user != null && product != null) {
                loopHistory(Manager.getAllOrders(user.getID()), dateFormat, out, user.getID(), session);
            }
        } else if (controller.equals("rateProduct")) {
            String rate = request.getParameter("rate");
            String orderID = request.getParameter("orderID");
            Order order = Manager.searchOrder(orderID);
            Manager.updateRateOrder(user.getID(), product.getNameProduct(), order.getIdOrder(), rate);
            String rateAverage = Manager.getProductAverageRate();
            Manager.updateRateProduct(product.getIdProduct(), product.getNameProduct(), rateAverage);
            out.print(rateAverage);
        }
    }

    private String distanceChronoUnit(String message, String messageAlt, long distance) {
        String contentTime = "";
        if (distance > 1) {
            contentTime = distance + messageAlt;
        } else {
            contentTime = distance + message;
        }

        return contentTime;
    }

    private String randomID() {
        Random random = new Random();
        String IDrandom = "";
        String numberCharacters = "0123456789";

        char character = 'A';

        for (int i = 1; i < 26; i++) {
            numberCharacters += Character.toString(character).toLowerCase() + character;
            character += 1;
        }
        do {
            for (int i = 0; i < 6; i++) {
                int characterIndex = random.nextInt(numberCharacters.length());
                IDrandom += numberCharacters.charAt(characterIndex) + "";
            }
            if (IDrandom.length() == 6) {
                break;
            }
        } while (true);
        return IDrandom;
    }

    public void loopHistory(ArrayList<Order> orders, DateTimeFormatter dateFormat, PrintWriter out, int userID, HttpSession session) {
        String cancelButton = "<button class=\"side-bar__order-btn-buy\" onclick=\"onclickProduct(this)\">Buy again</button>\n"
                + "<button class=\"side-bar__order-btn-other\" onclick=\"onclickDetails(this)\">Details</button>";
        String delayedButton = "<button class=\"side-bar__order-btn-buy\" style=\"opacity: 0.3;cursor: default;\" \">Process</button>\n"
                + "<button class=\"side-bar__order-btn-other\" onclick=\"onclickDetails(this)\">Details</button>";
        String processButton = "<button class=\"side-bar__order-btn-buy\" style=\"opacity: 0.3;cursor: default;\" \">Process</button>\n"
                + "<button class=\"side-bar__order-btn-other\" onclick=\"onclickCancelOrder(this)\">Cancel</button>";
        String completedButton = "<button class=\"side-bar__order-btn-buy\" onclick=\"onclickProduct(this)\">Buy\n again</button>\n"
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
                    + "                                                            <div class=\"side-bar__price-title\" value=\"" + order.getTotal() + "\">" + order.getTotal() + "</div>\n"
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
            Manager.updateTime(order.getIdOrder(), localTime, "UPDATE [ORDERCUSTOMER] SET [ORDERTIME] = ? WHERE [IDORDER] = ?");
        }
        orders = Manager.getAllOrders(userID);
        session.setAttribute("ordersHistory", orders);
    }

    private void loopNotify(User user, Product product, String productname, String type, String quantity, float price, float shippingCost, float total, String base64Image, HttpSession session, DateTimeFormatter dateFormat, LocalDateTime currentDate, PrintWriter out) {
        int userID = user.getID();
        int productID = product.getIdProduct();
        String orderID = randomID();
        int status = Manager.addOrder(orderID, userID, productID, productname, type, Integer.parseInt(quantity), price, total, base64Image, user.getAddress());
        int transportStatus = Manager.transportUpdate(user.getID(), orderID, productID, user.getNickname(), user.getPhoneNumber(), shippingCost);
        int removeNotifyNumber = 0;
        int count = 0;
        if (session.getAttribute("minusNotify") != null) {
            removeNotifyNumber = (int) session.getAttribute("minusNotify");
        }
        if (status > 0) {
            ArrayList<Order> orders = Manager.getAllOrders(userID);
            for (Order order : orders) {
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

}
