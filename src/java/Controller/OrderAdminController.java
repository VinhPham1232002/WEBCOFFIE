/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.Order;
import Model.Product;
import Model.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "OrderAdminController", urlPatterns = "/OrderAdminController")
public class OrderAdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String controller = request.getParameter("controller");
        String typeDelivery = request.getParameter("typeOrderStatus");
        PrintWriter out = response.getWriter();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (controller.equals("filterStatusOrder") || controller.equals("searchOrder")) {
            ArrayList<Order> orders = new ArrayList<>();
            if (controller.equals("searchOrder")) {
                String inputOrder = request.getParameter("inputOrder");
                orders = Manager.searchOrdertByID(inputOrder);
            } else {
                orders = Manager.getAllOrders();
            }
            for (Order order : orders) {
                if (order.getStatus().equalsIgnoreCase(typeDelivery) || typeDelivery.equalsIgnoreCase("All")) {
                    String getDateOrder = splitTime(order.getOrder(), dateFormat);
                    String messageStatus = statusDelivery(order.getStatus());
                    String getDateStatus = "-";
                    if (order.getComplete() != null) {
                        getDateStatus = splitTime(order.getComplete(), dateFormat);
                    } else if (order.getCancel() != null) {
                        getDateStatus = splitTime(order.getCancel(), dateFormat);
                    } else if (order.getDelay() != null) {
                        getDateStatus = splitTime(order.getDelay(), dateFormat);
                    }
                    String status = order.getStatus().substring(0, 1) + order.getStatus().substring(1).toLowerCase();
                    out.print("<div class=\"table__order-list-item\">\n"
                            + "<div class=\"table__order-navbar-item-header\">\n"
                            + "      <h5 class=\"table__order-navbar-item-title\">Order #" + order.getIdOrder() + "</h5>\n"
                            + "      <img src=\"" + order.getImageCustomer() + "\" alt=\"\" class=\"table__order-customer-avatar\">\n"
                            + "  </div>\n"
                            + "  <div class=\"table__order-navbar-item-header\" style=\"margin:0.5rem 0 0.25rem\">\n"
                            + "       <div class=\"table__order-date\">Order: " + getDateOrder + "</div>\n"
                            + "       <div class=\"table__order-status " + order.getStatus().toLowerCase() + " on-status\">" + status + "</div>\n"
                            + "  </div>\n"
                            + "  <div class=\"table__order-date\" style=\"text-align:left;margin-bottom:1rem;\">" + messageStatus + getDateStatus + "</div>\n"
                            + "       <div class=\"table__order-navbar-item-body\">\n"
                            + "       <img src=\""+order.getProductImage()+"\" alt=\"\" class=\"table__order-user-img\">\n"
                            + "       <div class=\"table__order-navbar-item-more-content\">\n"
                            + "       <div class=\"flex-direction-col flex-item-col-center\">\n"
                            + "            <h5 class=\"table__main-product-name on-order\">" + order.getNameProduct() + "</h5>\n"
                            + "            <div class=\"table__main-product-type on-order\">" + order.getType() + "</div>\n"
                            + "  </div>\n"
                            + "  <div class=\"table__order-view\">\n"
                            + "       <div class=\"table__order-view-group\">\n"
                            + "       <div class=\"table__order-view-title\">Customer Name</div>\n"
                            + "       <div class=\"table__order-view-data on-name\">" + order.getNameCustomer() + "\n"
                            + "  </div>\n"
                            + "  </div>\n"
                            + "  <div class=\"table__order-view-group\">\n"
                            + "       <div class=\"table__order-view-title\">Quantity</div>\n"
                            + "       <div class=\"table__order-view-data on-quantity\">" + order.getQuantity() + "</div>\n"
                            + "   </div>\n"
                            + "   <div class=\"table__order-view-group\">\n"
                            + "       <div class=\"table__order-view-title\">Address</div>\n"
                            + "       <div class=\"table__order-view-data on-addres\">" + order.getAddressCustomer() + "\n"
                            + "   </div>\n"
                            + "   </div>\n"
                            + "   <div class=\"table__order-view-group\">\n"
                            + "       <div class=\"table__order-view-title\">Total Price</div>\n"
                            + "       <div class=\"table__order-view-data on-total\">$" + order.getTotal() + "</div>\n"
                            + "   </div>\n"
                            + "   <div class=\"table__order-view-group\">\n"
                            + "      <div class=\"table__order-view-title\">Delivery Status</div>\n"
                            + "      <div class=\"table__order-view-data on-check-status " + order.getStatus().toLowerCase() + "\">" + status + "</div>\n"
                            + "    </div>\n"
                            + "       </div>\n"
                            + "       <div class=\"table__product-main-action on-order\">\n"
                            + "    <button class=\"table__product-action-btn one-button js-update-status\" onclick=\"onClickOrderView(this)\" style=\"width:100%\">Update Order</button>\n"
                            + "       </div>\n"
                            + "      </div>\n"
                            + "      </div>\n"
                            + "     </div>");
                }
            }
        } else if (controller.equalsIgnoreCase("updateStatus")) {
            String orderID = request.getParameter("orderID");
            String statusUpdate = request.getParameter("statusUpdate").toUpperCase();
            String description = request.getParameter("description");
            int descriptionStatus = 0;
            if (description != null && description.length() > 0) {
                descriptionStatus = Manager.updateTransportStatus(description, orderID, statusUpdate);
            }
            int status = Manager.updateStatus(orderID, statusUpdate);
            int updateTime = Manager.updateTime(orderID, null, "UPDATE [ORDERCUSTOMER] SET DISTANCE = ?" + transferStatus(statusUpdate) + " WHERE [IDORDER] = ?");
            Order order = Manager.searchOrder(orderID);
            if (descriptionStatus > 0 || (status > 0 && updateTime > 0)) {
                String getDateOrder = splitTime(order.getOrder(), dateFormat);
                String messageStatus = statusDelivery(order.getStatus());
                String getDateStatus = "-";
                if (order.getComplete() != null) {
                    getDateStatus = splitTime(order.getComplete(), dateFormat);
                } else if (order.getCancel() != null) {
                    getDateStatus = splitTime(order.getCancel(), dateFormat);
                } else if (order.getDelay() != null) {
                    getDateStatus = splitTime(order.getDelay(), dateFormat);
                }
                removeStatusTime(statusUpdate, orderID);
                String statusDelivery = order.getStatus().substring(0, 1) + order.getStatus().substring(1).toLowerCase();
                out.print("<div class=\"table__order-navbar-item-header\">\n"
                        + "      <h5 class=\"table__order-navbar-item-title\">Order #" + order.getIdOrder() + "</h5>\n"
                        + "      <img src=\"" + order.getImageCustomer() + "\" alt=\"\" class=\"table__order-customer-avatar\">\n"
                        + "  </div>\n"
                        + "  <div class=\"table__order-navbar-item-header\" style=\"margin:0.5rem 0 0.25rem\">\n"
                        + "       <div class=\"table__order-date\">Order: " + getDateOrder + "</div>\n"
                        + "       <div class=\"table__order-status " + order.getStatus().toLowerCase() + " on-status\">" + statusDelivery + "</div>\n"
                        + "  </div>\n"
                        + "  <div class=\"table__order-date\" style=\"text-align:left;margin-bottom:1rem;\">" + messageStatus + getDateStatus + "</div>\n"
                        + "       <div class=\"table__order-navbar-item-body\">\n"
                        + "       <img src=\""+order.getProductImage()+"\" alt=\"\" class=\"table__order-user-img\">\n"
                        + "       <div class=\"table__order-navbar-item-more-content\">\n"
                        + "       <div class=\"flex-direction-col flex-item-col-center\">\n"
                        + "            <h5 class=\"table__main-product-name on-order\">" + order.getNameProduct() + "</h5>\n"
                        + "            <div class=\"table__main-product-type on-order\">" + order.getType() + "</div>\n"
                        + "  </div>\n"
                        + "  <div class=\"table__order-view\">\n"
                        + "       <div class=\"table__order-view-group\">\n"
                        + "       <div class=\"table__order-view-title\">Customer Name</div>\n"
                        + "       <div class=\"table__order-view-data on-name\">" + order.getNameCustomer() + "\n"
                        + "  </div>\n"
                        + "  </div>\n"
                        + "  <div class=\"table__order-view-group\">\n"
                        + "       <div class=\"table__order-view-title\">Quantity</div>\n"
                        + "       <div class=\"table__order-view-data on-quantity\">" + order.getQuantity() + "</div>\n"
                        + "   </div>\n"
                        + "   <div class=\"table__order-view-group\">\n"
                        + "       <div class=\"table__order-view-title\">Address</div>\n"
                        + "       <div class=\"table__order-view-data on-addres\">" + order.getAddressCustomer() + "\n"
                        + "   </div>\n"
                        + "   </div>\n"
                        + "   <div class=\"table__order-view-group\">\n"
                        + "       <div class=\"table__order-view-title\">Total Price</div>\n"
                        + "       <div class=\"table__order-view-data on-total\">$" + order.getTotal() + "</div>\n"
                        + "   </div>\n"
                        + "   <div class=\"table__order-view-group\">\n"
                        + "      <div class=\"table__order-view-title\">Delivery Status</div>\n"
                        + "      <div class=\"table__order-view-data on-check-status " + order.getStatus().toLowerCase() + "\">" + statusDelivery + "</div>\n"
                        + "    </div>\n"
                        + "       </div>\n"
                        + "       <div class=\"table__product-main-action on-order\">\n"
                        + "    <button class=\"table__product-action-btn one-button js-update-status\" onclick=\"onClickOrderView(this)\" style=\"width:100%\">Update Order</button>\n"
                        + "       </div>\n"
                        + "      </div>\n"
                        + "      </div>\n");
            } else {
                out.print("FAILED");
            }
        }
    }

    private String splitTime(String orderTime, DateTimeFormatter dateFormat) {
        String splitUpdate[] = orderTime.split("\\.");
        LocalDateTime local = LocalDateTime.parse(splitUpdate[0], dateFormat);
        String localGetMonth = local.getMonth().toString().substring(0, 1) + local.getMonth().toString().substring(1, 3).toLowerCase();
        return local.getDayOfMonth() + " " + localGetMonth + ", " + local.getYear() + " " + local.getHour() + ":" + local.getMinute();
    }

    private String statusDelivery(String orderStatus) {
        if (orderStatus.equalsIgnoreCase("PROCESS")) {
            return "Delivery: ";
        } else if (orderStatus.equalsIgnoreCase("CANCELLED")) {
            return "Cancelled: ";
        } else if (orderStatus.equalsIgnoreCase("DELAYED")) {
            return "Delayed: ";
        } else {
            return "Completed: ";
        }
    }

    private String transferStatus(String status) {
        if (status.equalsIgnoreCase("COMPLETED")) {
            return ",COMPLETE = GETDATE()";
        } else if (status.equalsIgnoreCase("DELAYED")) {
            return ",DELAY = GETDATE()";
        } else if (status.equalsIgnoreCase("CANCELLED")) {
            return ",CANCEL = GETDATE()";
        } else {
            return "";
        }
    }

    private void removeStatusTime(String status, String idOrder) {
        if (status.equalsIgnoreCase("PROCESS")) {
            int status1 = Manager.deleteTime(idOrder, status, "UPDATE [ORDERCUSTOMER] "
                    + "SET COMPLETE = NULL, COMPLETETIME = NULL, CANCEL = NULL, "
                    + "CANCELTIME = NULL, DELAY = NULL, "
                    + "DELAYEDTIME = NULL, STATUS = ? WHERE [IDORDER] = ?");
            int status2 = Manager.updateTransportStatus(null, idOrder, status);
        } else if (status.equalsIgnoreCase("DELAYED")) {
            int status1 = Manager.deleteTime(idOrder, status, "UPDATE [ORDERCUSTOMER] "
                    + "SET COMPLETE = NULL, COMPLETETIME = NULL, "
                    + "CANCEL = NULL, CANCELTIME = NULL, STATUS = ? "
                    + "WHERE [IDORDER] = ?");
        } else if (status.equalsIgnoreCase("CANCELLED")) {
            int status1 = Manager.deleteTime(idOrder, status, "UPDATE [ORDERCUSTOMER] "
                    + "SET COMPLETE = NULL, COMPLETETIME = NULL, DELAY = NULL, "
                    + "DELAYEDTIME = NULL, STATUS = ? WHERE [IDORDER] = ?");
        } else {
            int status1 = Manager.deleteTime(idOrder, status, "UPDATE [ORDERCUSTOMER] "
                    + "SET DELAY = NULL, DELAYEDTIME = NULL, CANCEL = NULL, "
                    + "CANCELTIME = NULL, STATUS = ? WHERE [IDORDER] = ?");
            int status2 = Manager.updateTransportStatus(null, idOrder, status);
        }
    }

}
