<%-- 
    Document   : settings
    Created on : Jun 30, 2022, 7:47:44 AM
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
        <div class="js-side-bar side-bar__order-boxing" value="Order"
             style="display:none; max-width: 900px;">
            <div class="side-bar__header color-modifier">
                <div class="side-bar__title">
                    <div class="side-bar__title-heading-box">
                        <h1 class="side-bar__title-heading">Order History</h1>
                        <div class="side-bar__overview" onclick="closeTabMobile()">
                            <i class="ti-angle-left"></i>
                            <span class="side-bar__overview-text">Overview</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="side-bar__order-body field-Spacer-Top-10" id="side-bar__order-body">
                <%if(session.getAttribute("ordersHistory") != null){%>
                <div class="side-bar__order-navbar">
                    <div class="side-bar__order-item active-checked checked-theme"
                         onclick="openOtherOrder(this)">
                        <span>All</span>
                        <img src="asssets/img/to-do-list.png" alt="" class="side-bar__order-show-img">
                    </div>
                    <div class="side-bar__order-item" onclick="openOtherOrder(this)">
                        <span>Process</span>
                        <img src="asssets/img/delivery.png" alt="" class="side-bar__order-show-img">
                    </div>
                    <div class="side-bar__order-item" onclick="openOtherOrder(this)">
                        <span>Cancelled</span>
                        <img src="asssets/img/cancel.png" alt="" class="side-bar__order-show-img">
                    </div>
                    <div class="side-bar__order-item" onclick="openOtherOrder(this)">
                        <span>Delayed</span>
                        <img src="asssets/img/delivery-delay.png" alt="" class="side-bar__order-show-img">
                    </div>
                    <div class="side-bar__order-item" onclick="openOtherOrder(this)">
                        <span>Completed</span>
                        <img src="asssets/img/package.png" alt="" class="side-bar__order-show-img">
                    </div>
                </div>
                <div class="side-bar__order-search" style="margin-top: 1rem;">
                    <img class="side-bar__order-search-icon" src="asssets/img/search.png"
                         style="width:20px;margin-right: 1rem;" alt="">
                    <input oninput="searchByName(this)" autocomplete="off" placeholder="Find product by name" value=""
                           style="outline: none;background: none;border: none;">
                </div>
                <div class="side-bar__order-collection" id="side-bar__order-collection">
                    <c:forEach items="${sessionScope.ordersHistory}" var="order">
                        <div class="side-bar__order-box-data field-Spacer-Top-24">
                            <div class="side-bar__order-navbar-header">
                                <div class="side-bar__order-navbar-item identity"><span>Order
                                        #${order.getIdOrder()}</span></div>
                                <div class="side-bar__order-navbar-item delivery" style="font-size: 0.8rem;">
                                    ${order.getOrderTime()}
                                </div>
                                <div class="side-bar__order-navbar-item status ${fn:toLowerCase(order.getStatus())} on-status">
                                    <span class="${fn:toLowerCase(order.getStatus())}">${order.getStatus()}</span>
                                </div>
                            </div>
                            <div class="side-bar__order-data">
                                <div class="side-bar__order-group">
                                    <div class="side-bar__order-group-box field-Spacer-Top-16">
                                        <div class="flex-container">
                                            <div class="side-bar__order-product-box-information">
                                                <div>
                                                    <img src="${order.getProductImage()}" alt=""
                                                         class="side-bar__order-product-img">
                                                </div>
                                                <div class="side-bar__order-group-data">
                                                    <div class="side-bar__order-heading">
                                                        <h5>${order.getNameProduct()}</h5>
                                                    </div>
                                                    <div class="side-bar__order-sub-heading">
                                                        <span class="purchase__product-type">${order.getType()}</span>
                                                    </div>
                                                    <div class="side-bar__order-quantity">x${order.getQuantity()}
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="side-bar__order-details">
                                        <div class="side-bar__order-address">
                                            <div class="flex-item-col-center field-Spacer-Bottom-16" style="column-gap:0.5rem">
                                                <h5 class="side-bar__order-address-title">Delivery Location
                                                </h5>
                                                <div class="side-bar__delivery-img">
                                                    <img src="asssets/img/location.png" alt="">
                                                </div>
                                            </div>
                                            <div class="side__bar-delivery-body">
                                                <div class="side-bar__order-details-delivery">
                                                    <div>${order.getAddressCustomer()}
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="side-bar__order-summary">
                                            <div class="flex-item-col-center field-Spacer-Bottom-16" style="column-gap:0.5rem">
                                                <h5 class="side-bar__order-summary-title">Summary
                                                </h5>
                                                <div class="side-bar__delivery-img">
                                                    <img src="asssets/img/price-tag.png" alt="">
                                                </div>
                                            </div>
                                            <div class="side__bar-delivery-body">
                                                <div class="side-bar__price">
                                                    <div class="side-bar__price-group">
                                                        <div class="side-bar__price-list">
                                                            <div class="side-bar__sub-title">Price:</div>
                                                            <div class="side-bar__price-list-box">
                                                                <div class="side-bar__price-icon">$</div>
                                                                <div class="side-bar__price-title on-price" value="${order.getPrice()}">${order.getPrice()}</div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="side-bar__price-group">
                                                        <div class="side-bar__price-list">
                                                            <div class="side-bar__sub-title">Total:</div>
                                                            <div class="side-bar__price-list-box">
                                                                <div class="side-bar__price-icon">$</div>
                                                                <div class="side-bar__price-title" value="${order.getTotal()}">${order.getTotal()}</div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="side-bar__order-btn">
                                        <c:choose>
                                            <c:when test="${order.getStatus().equals('CANCELLED')}">
                                                <button class="side-bar__order-btn-buy" onclick="onclickProduct(this)">Buy again</button>
                                                <button class="side-bar__order-btn-other" onclick="onclickDetails(this)">Details</button>
                                            </c:when>
                                            <c:when test="${order.getStatus().equals('PROCESS')}">
                                                <button class="side-bar__order-btn-buy" style="opacity: 0.3;cursor: default;" ">Process</button>
                                                <button class="side-bar__order-btn-other" onclick="onclickCancelOrder(this)">Cancel</button>
                                            </c:when>
                                            <c:when test="${order.getStatus().equals('DELAYED')}">
                                                <button class="side-bar__order-btn-buy" style="opacity: 0.3;cursor: default;" ">Process</button>
                                                <button class="side-bar__order-btn-other" onclick="onclickDetails(this)">Details</button>
                                            </c:when>
                                            <c:otherwise>
                                                <button class="side-bar__order-btn-buy" onclick="onclickProduct(this)">Buy again</button>
                                                <button class="side-bar__order-btn-other" onclick="onclickDetails(this)">Details</button>
                                            </c:otherwise>
                                        </c:choose> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>               
                <%}else{%>
                <div class="side-bar__order-collection on-message-error">
                    <div class="side-bar__appearance-group">
                        <div class="side-bar__appearance-message-box">
                            <img src="asssets/img/sorry.gif" alt=""
                                 class="side-bar__appearance-gif">
                            <div class="side-bar__appearance-message">
                                <p>"Oh no, you haven't order anything. Please return to main page to order in order to watch your history."
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <%}%>
            </div>
        </div>
    </body>
</html>
