<%-- 
    Document   : Dashboard
    Created on : Jun 30, 2022, 8:07:35 AM
    Author     : ADMIN
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="js-side-bar side-bar__dashboard-boxing" value="Dashboard" style="display:none">
            <div class="side-bar__header color-modifier">
                <div class="side-bar__title">
                    <div class="side-bar__title-heading-box">
                        <h1 class="side-bar__title-heading">Dashboard</h1>
                    </div>
                    <div class="side-bar__overview" onclick="closeTabMobile()">
                        <i class="ti-angle-left"></i>
                        <span class="side-bar__overview-text">Overview</span>
                    </div>
                </div>
            </div>
            <div class="dashboard__details">
                <div class="dashboard__details-group on-grid-1">
                    <div class="dashboard__details-sub-group on-grid-1 field-Spacer-Top-16">
                        <div class="dashboard__details-delivery-date on-grid-1">
                            <div class="dashboard__details-box">
                                <div class="dashboard__details-title-box">
                                    <h5 class="dashboard__details-heading">Orders</h5>
                                    <img src="asssets/img/location-1.png" alt=""
                                         class="dashboard__details-img-icon">
                                </div>
                                <div class="dashboard__details-alt-box">
                                    <div class="flex-item-col-center flex-between-center-col">
                                        <div class="dashboard__title">Order Process</div>
                                        <div class="side-bar__details-order-time">${ordersAchivement[0]}</div>
                                    </div>
                                    <div class="flex-item-col-center flex-between-center-col">
                                        <div class="dashboard__title">Order Cancelled</div>
                                        <div class="side-bar__details-order-time">${ordersAchivement[1]}</div>
                                    </div>
                                    <div class="flex-item-col-center flex-between-center-col">
                                        <div class="dashboard__title">Order Completed</div>
                                        <div class="side-bar__details-order-time">${ordersAchivement[2]}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="dashboard__details-delivery-date on-grid-1">
                            <div class="dashboard__details-box">
                                <div class="dashboard__details-title-box">
                                    <h5 class="dashboard__details-heading">Total Spend (Completed Order)
                                    </h5>
                                    <img src="asssets/img/delivery.png" alt=""
                                         class="side-bar__details-img-icon">
                                </div>
                                <div class="dashboard__details-alt-box">
                                    <div class="flex-item-col-center flex-between-center-col">
                                        <div class="dashboard__title">In Day</div>
                                        <div class="dashboard__details-data on-day">$${daySpend}</div>
                                    </div>
                                    <div class="flex-item-col-center flex-between-center-col">
                                        <div class="dashboard__title">In Month</div>
                                        <div class="dashboard__details-data on-day">$${monthSpend}</div>
                                    </div>
                                    <div class="flex-item-col-center flex-between-center-col">
                                        <div class="dashboard__title">In Year</div>
                                        <div class="dashboard__details-data on-day">$${yearSpend}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="dashboard__details-delivery-date on-grid-1">
                            <div class="dashboard__details-box">
                                <div class="dashboard__details-title-box">
                                    <h5 class="dashboard__details-heading">Account</h5>
                                    <img src="asssets/img/calendar.png" alt=""
                                         class="side-bar__details-img-icon">
                                </div>
                                <div class="dashboard__details-alt-box">
                                    <div class="flex-item-col-center flex-between-center-col">
                                        <div class="dashboard__title">Join</div>
                                        <div class="dashboard__details-data on-join-date">${joinDate}</div>
                                    </div>
                                    <div class="flex-item-col-center flex-between-center-col">
                                        <div class="dashboard__title">Active Time</div>
                                        <div class="dashboard__details-data on-active-day">${activeDay}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="dashboard__details-sub-group field-Spacer-Top-16">
                        <div class="dashboard__details-box">
                            <div class="dashboard__details-title-box">
                                <h5 class="dashboard__details-heading">Recent Orders (Last 8 Orders)</h5>
                                <img src="asssets/img/product.png" alt=""
                                     class="dashboard__details-img-icon">
                            </div>
                        </div>
                        <div class="dashboard__recent-box">
                            <%if(session.getAttribute("ordersHistory") != null){%>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Product</th>
                                        <th>Price</th>
                                        <th>Total</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody class="dashboard__table-body-overwrite">
                                    <c:forEach items="${sessionScope.ordersHistory}" begin="0" end="7" var="order">
                                        <tr>
                                            <td>${order.getNameProduct()}</td>
                                            <td>${order.getPrice()}</td>
                                            <td>${order.getTotal()}</td>
                                            <td class="${fn:toLowerCase(order.getStatus())}">${order.getStatus()}</td>                                                    
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <%}else{%>
                            <div class="dashboard__appearance">
                                <div class="dashboard__appearance-message-box">
                                    <img src="asssets/img/sorry.gif" alt=""
                                         class="dashboard__appearance-gif">
                                    <div class="dashboard__appearance-message">
                                        <p>"Oh no, you haven't order anything. Please return to main page to order in order to watch your history."
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
