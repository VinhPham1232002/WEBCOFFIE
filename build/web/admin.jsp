<%-- 
    Document   : admin
    Created on : Jul 10, 2022, 10:49:50 PM
    Author     : phong
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Coffie Managerment</title>
        <link rel="icon" href="asssets/img/coffie.png" />
        <link href='https://fonts.googleapis.com/css?family=Antic Didone' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link rel="stylesheet" href="asssets/font/themify-icons/themify-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Bellefair&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="asssets/css/style.css">
        <link rel="stylesheet" href="asssets/css/base.css">
        <link rel="stylesheet" href="asssets/css/table.css">
        <link rel="stylesheet" href="asssets/css/sidebar.css">
        <link rel="stylesheet" href="asssets/css/admin.css">
        <link rel="stylesheet" href="asssets/css/responsive.css">
        <style type="text/css">
            <%@include file="asssets/css/table.css"%>
            <%@include file="asssets/css/admin.css" %>
            <%@include file="asssets/css/responsive.css"%>
        </style>
    </head>

    <body>
        <div class="loading-screen">
            <div class="loading-sceen__seperate" style="bottom:47rem;">
                <div class="loading-screen-background on-size-fixed">
                    <div class="loading-screen__title">
                        <img src="${staff.getStaffImage()}" class="welcone-staff-img" style="width:100px;height:100px;" alt="">
                        <h5 class="loading-screen__heading js-login-loading" style="font-size:2rem;margin-top:1rem;opacity:0;">Welcome Back</h5>
                        <div class="loading-screen__sub-heading welcome-staff-name" style="font-size:1.5rem;margin-top:-4rem;">${staff.getName()}</div>
                    </div>
                </div>
            </div>
            <div class="loading-sceen__seperate on-logout" style="bottom:47rem;">
                <div class="loading-screen-background on-size-fixed">
                    <div class="loading-screen__title">
                        <img src="${staff.getStaffImage()}" class="logout-staff-img" alt="" style="width:100px;height:100px;">
                        <h5 class="loading-screen__heading js-logout-loading" style="font-size:2rem;margin-top:1rem;opacity:0;">See You Later</h5>
                        <div class="loading-screen__sub-heading logout-staff-name" style="font-size:1.5rem;margin-top:-4rem;">${staff.getName()}</div>
                    </div>
                </div>
            </div>
            <div class="loading-screen__overlay on-forget" onclick="closeStaff()" style="right:100%;">
                <div class="loading-sceen__seperate on-forget" style="right:100%;" onclick="event.stopPropagation()">
                    <div class="loading-screen-background on-size-fixed">
                        <div class="loading-screen__title on-forget">
                            <div class="loading-screen__title" style="margin-bottom:unset;">
                                <img src="asssets/img/logocoffee4.png" alt="" style="width:200px;height:200px;">
                            </div>
                            <h5 class="loading-screen__heading js-forget-loading on-forget" style="margin-top:8.5rem;">Forget Password</h5>
                            <div class="loading-screen__forget-action">
                                <div class="loading-screen__forget-action-group js-change-password" style="margin-left:0;">
                                    <h5 class="loading-screen__sub-heading on-forget" style="font-size:1.4rem;margin:1rem 0;opacity:1;">Change your password</h5>
                                    <button type="button" onclick="changeStaffPassword(this)" class="loading__screen-button one-button js-staff-change">Change</button>
                                </div>
                                <div class="loading-screen__forget-action-group js-reset-password">
                                    <h5 class="loading-screen__sub-heading on-forget" style="font-size:1.4rem;margin:1rem 0;opacity:1;">Reset your password</h5>
                                    <button type="button" onclick="changeStaffPassword(this)" class="loading__screen-button one-button js-staff-reset" style="background-color:var(--white-color);">Reset</button>
                                </div>
                            </div>
                            <div class="loading-screen__input-box on-forget">
                                <div class="loading-screen__input-field">
                                    <input type="text" class="loading-screen__input js-staff-forget js-staff-input-email" placeholder="E-mail Address">
                                </div>
                                <div class="loading-screen__input-field">
                                    <input type="password" class="loading-screen__input js-staff-forget js-staff-reset-password" placeholder="Password">
                                </div>
                                <div class="loading-screen__input-field">
                                    <input type="password" class="loading-screen__input js-staff-forget js-staff-reset-new" placeholder="New Password">
                                </div>
                                <div class="loading-screen__input-field">
                                    <input type="text" class="loading-screen__input js-staff-forget js-staff-special-code" placeholder="Special Code">
                                </div>
                                <div class="loading-screen__action-btn">
                                    <button type="button" onclick="staffChange(this)" class="loading__screen-button js-loading-submit">Change</button>
                                    <button type="button" onclick="closeChangeStaff()" class="loading__screen-button js-loading-cancel-reset">Not now</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%if(session.getAttribute("staff") == null){%>
            <div class="loading-screen__login-screen">
                <div class="loading-screen__container">
                    <div class="loading-screen__background"></div>
                </div>
                <div class="loading-screen-main">
                    <div class="loading-screen-background">
                        <div class="loading-screen__title">
                            <img src="asssets/img/logocoffee4.png" alt="" style="width:200px;height:200px">
                            <h5 class="loading-screen__heading">LIFE OF COFFIE</h5>
                            <div class="loading-screen__sub-heading">Bring the best we could</div>
                        </div>
                        <div class="loading-screen__input-box">
                            <div class="loading-screen__input-field">
                                <input type="text" class="loading-screen__input js-staff-input-name" placeholder="E-mail Address">
                            </div>
                            <div class="loading-screen__input-field">
                                <input type="password" class="loading-screen__input js-staff-input-password" placeholder="Password">
                            </div>
                        </div>
                        <div class="loading-screen__action-btn">
                            <button type="button" onclick="loginStaff()" class="loading__screen-button js-login-password">Login</button>
                            <button type="button" onclick="forgetStaff()" class="loading__screen-button js-forget-password">Forget Your Password?</button>
                        </div>
                    </div>
                </div>
                <div class="loading-screen__credit">
                    @ 2022 Life of Coffie
                </div>             
            </div>
            <%}%>
        </div>

        <div class="main admin-table">
            <div class="table table__admin">
                <div class="table__container">
                    <div class="table__admin-background">
                        <div class="table__admin-background-img"></div>
                    </div>
                    <div class="table__admin-box" onclick="closeAdminSettings()">
                        <div class="table__admin-main">
                            <div class="table__admin-title" onclick="event.stopPropagation();">
                                <img src="${staff.getStaffImage()}" alt="" class="table__admin-avatar staff-img" onclick="adminSettings()">
                                <div class="table__admin-navbar" style="height:0;" onclick="event.stopPropagation();">
                                    <div class="table__admin-navbar-item">
                                        <img src="${staff.getStaffImage()}" alt="" class="table__admin-avatar staff-img">
                                        <div class="table__admin-navbar-staff-box flex-container flex-direction-col">
                                            <div class="table__admin-name-staff staff-email">${staff.getEmailStaff()}</div>
                                            <div class="table__admin-name-staff staff-name">${staff.getName()}</div>
                                        </div>
                                    </div>
                                    <div class="table__admin-navbar-item" data-set="${staff.getEmailStaff()}" onclick="logoutStaff(this)">
                                        <img src="asssets/img/logout.png" alt="" class="table__admin-logout-icon">
                                        <div class="table__admin-action">Logout</div>
                                    </div>
                                </div>
                            </div>
                            <div class="table__main-navbar">
                                <div class="table__navbar-item js-navbar-checked-tap table__checked-tap" onclick="onClickTabAdmin(this)">
                                    <img src="asssets/img/product.png" alt="" class="table__navbar-item-img">
                                    <div class="table__navbar-item-text">Product</div>
                                </div>
                                <div class="table__navbar-item" onclick="onClickTabAdmin(this)">
                                    <img src="asssets/img/order-list.png" alt="" class="table__navbar-item-img">
                                    <div class="table__navbar-item-text">Order</div>
                                </div>
                                <div class="table__navbar-item" onclick="onClickTabAdmin(this)">
                                    <img src="asssets/img/id-card.png" alt="" class="table__navbar-item-img">
                                    <div class="table__navbar-item-text">Staff</div>
                                </div>
                            </div>
                        </div>
                        <div class="table__admin-body">
                            <div class="table__navbar-body">
                                <div class="js-admin-tab table__navbar-product" id="Product" style="display:block;">
                                    <div class="table__admin-content">
                                        <div class="table__navbar-product-main" style="margin-top:0rem;">
                                            <div class="table__admin-introduced">
                                                <h5 class="table__admin-introduced-title">Products</h5>
                                                <img src="asssets/img/title-separator.png" alt=""
                                                     style="width:200px;height:30px;filter: brightness(0) invert(1);">
                                            </div>
                                            <div class="table__product-main-collection-action">
                                                <div class="table__product-main-action on-main-action-modifier">
                                                    <button class="table__product-action-btn one-button js-add-new" onclick="onClickOrderView(this)">New
                                                        Product</button>
                                                </div>
                                                <div class="table__product-navbar">
                                                    <div class="table__product-navbar-item active-checked checked-theme product-type js-type-all" onclick="openProductsTab(this)">
                                                        <span>All</span>
                                                        <img src="asssets/img/to-do-list.png" alt="" class="side-bar__order-show-img">
                                                    </div>
                                                    <div class="table__product-navbar-item product-type js-type-cake" onclick="openProductsTab(this)"><span>Cake</span>
                                                        <img src="asssets/img/piece-of-cake.png" alt="" class="side-bar__order-show-img">
                                                    </div>
                                                    <div class="table__product-navbar-item product-type js-type-coffee" onclick="openProductsTab(this)"><span>Coffee</span>
                                                        <img src="asssets/img/coffee.png" alt="" class="side-bar__order-show-img">
                                                    </div>
                                                    <div class="table__product-navbar-item product-type js-type-cookie" onclick="openProductsTab(this)"><span>Cookie</span>
                                                        <img src="asssets/img/cookie.png" alt="" class="side-bar__order-show-img">
                                                    </div>
                                                </div>
                                                <div class="table__product-search">
                                                    <img class="table__product-search-icon" src="asssets/img/search.png"
                                                         style="width:20px;margin-right: 1rem;" alt="">
                                                    <input oninput="searchProduct(this)" class="table__product-search-input" spellcheck="false"
                                                           autocomplete="off" placeholder="Find product by Name" value="">
                                                </div>
                                            </div>
                                            <div class="table__product-main-box">
                                                <sql:setDataSource
                                                    var = "products"
                                                    driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                                                    url="jdbc:sqlserver://localhost:1433;databaseName=User"
                                                    user="sa" password="123"
                                                    />
                                                <sql:query var="product" dataSource="${products}">
                                                    SELECT IDPRODUCT, NAME, CAST('' as xml).value(
                                                    'xs:base64Binary(sql:column("PRODUCT.IMAGE"))', 'VARCHAR(MAX)') as IMAGE, IMAGETYPE
                                                    from PRODUCT  
                                                </sql:query>
                                                <div class="table__product-main">
                                                    <ul class="table__product-main-list js-list-order thin-scoller-bar">
                                                        <c:forEach items="${product.rows}" var="productItem">
                                                            <div class="table__product-main-item" onclick="orderSelect(this)">
                                                                <img src="data:image/${productItem.IMAGETYPE};base64, ${productItem.IMAGE}" alt="" style="width:150px;height:150px">
                                                                <div class="table__product-main-item-box">
                                                                    <h5 class="table__product-main-item-title">${productItem.NAME}</h5>
                                                                    <div class="table__product-main-item-sub-title">Product #${productItem.IDPRODUCT}
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                                <div class="table__product-arrow-action">
                                                    <div class="table__product-arrow-left">
                                                        <i class="ti-angle-left table__arrow"></i>
                                                    </div>
                                                    <div class="table__product-arrow-right">
                                                        <i class="ti-angle-right table__arrow"></i>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="table__product-body" style="opacity:0;">
                                            <div class="table__product-item-product-group">
                                                <div class="table__product-main-group">
                                                    <div class="table__admin-introduced" style="margin-top:1rem;">
                                                        <h5 class="table__admin-introduced-title on-product-id">Product Number #1</h5>
                                                        <img src="asssets/img/title-separator.png" alt=""
                                                             style="width:200px;height:30px;filter: brightness(0) invert(1);">
                                                    </div>
                                                    <div class="table__product-main-information">
                                                        <div>
                                                            <div class="table__product-main-primary">
                                                                <img src="asssets/img/cake2.png" alt=""
                                                                     class="table__product-main-img on-img-product">
                                                            </div>
                                                            <div
                                                                class="flex-item-col-center table__customer-avatar flex-direction-col">
                                                                <h5 class="table__main-product-name">Creame Cake</h5>
                                                                <div class="table__main-product-type">Cake</div>
                                                            </div>
                                                        </div>
                                                        <div class="table__product-main-action">
                                                            <button class="table__product-action-btn js-update-product" onclick="onClickOrderView(this)">Update Order</button>
                                                            <button class="table__product-action-btn js-delete-product" onclick="onClickOrderView(this)">Delete Order</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="table__product-item-product-group">
                                                <div class="table__product-group-information">
                                                    <div class="table__product-merge-group">
                                                        <div class="table__product-first-group">
                                                            <div class="table__product-group-title-box">
                                                                <h5 class="table__product-group-title">Information</h5>
                                                                <img src="asssets/img/portfolio.png" alt=""
                                                                     class="table__product-group-img">
                                                            </div>
                                                            <div class="table__product-group-box">
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">Name</div>
                                                                    <div class="table__product-data on-name">Creame Cake
                                                                    </div>
                                                                </div>
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">Type</div>
                                                                    <div
                                                                        class="table__product-data on-modifier-ground on-type">
                                                                        Cake</div>
                                                                </div>
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">Price</div>
                                                                    <div class="table__product-data on-price">$5.00</div>
                                                                </div>
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">Rate</div>
                                                                    <div class="table__product-data on-rate">4.5</div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="table__product-first-group">
                                                            <div class="table__product-group-title-box">
                                                                <h5 class="table__product-group-title">Order Summary</h5>
                                                                <img src="asssets/img/location-1.png" alt=""
                                                                     class="table__product-group-img">
                                                            </div>
                                                            <div class="table__product-group-box">
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">Order Process</div>
                                                                    <div class="table__product-data on-order-process">13
                                                                    </div>
                                                                </div>
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">Order Cancelled</div>
                                                                    <div class="table__product-data on-order-cancelled">13
                                                                    </div>
                                                                </div>
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">Order Delayed</div>
                                                                    <div class="table__product-data on-order-delayed">13
                                                                    </div>
                                                                </div>
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">Order Completed</div>
                                                                    <div class="table__product-data on-order-completed">13
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="table__product-group-information">
                                                    <div class="table__product-merge-group">
                                                        <div class="table__product-first-group">
                                                            <div class="table__product-group-title-box">
                                                                <h5 class="table__product-group-title">Update Order</h5>
                                                                <img src="asssets/img/update.png" alt=""
                                                                     class="table__product-group-img">
                                                            </div>
                                                            <div class="table__product-group">
                                                                <div class="table__product-title">Create On</div>
                                                                <div class="table__product-data on-create">25-04-2012
                                                                    14:05:23</div>
                                                            </div>
                                                            <div class="table__product-group">
                                                                <div class="table__product-title">First Create By</div>
                                                                <div class="table__product-data on-creater">Jonathan</div>
                                                            </div>
                                                            <div class="table__product-group">
                                                                <div class="table__product-title">Last Update</div>
                                                                <div class="table__product-data on-update">25-04-2012
                                                                    14:05:23</div>
                                                            </div>
                                                            <div class="table__product-group">
                                                                <div class="table__product-title">Last Update By</div>
                                                                <div class="table__product-data on-updater">Jonathan</div>
                                                            </div>
                                                        </div>
                                                        <div class="table__product-first-group">
                                                            <div class="table__product-group-title-box">
                                                                <h5 class="table__product-group-title">Revenue Collection
                                                                </h5>
                                                                <img src="asssets/img/money.png" alt=""
                                                                     class="table__product-group-img">
                                                            </div>
                                                            <div class="table__product-group-box">
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">In Day</div>
                                                                    <div class="table__product-data on-total-day">$13.00
                                                                    </div>
                                                                </div>
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">In Month</div>
                                                                    <div class="table__product-data on-total-month">$15.00
                                                                    </div>
                                                                </div>
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">In Year</div>
                                                                    <div class="table__product-data on-total-year">$70.92
                                                                    </div>
                                                                </div>
                                                                <div class="table__product-group">
                                                                    <div class="table__product-title">Total</div>
                                                                    <div class="table__product-data on-total">$1300.50</div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="js-admin-tab table__navbar-order" id="Order" style="display:none">
                                    <div class="table__order-main-group">
                                        <div class="table__admin-introduced">
                                            <h5 class="table__admin-introduced-title">Order</h5>
                                            <img src="asssets/img/title-separator.png" alt=""
                                                 style="width:200px;height:30px;filter: brightness(0) invert(1);">
                                        </div>
                                        <div class="table__order-navbar">
                                            <div class="table__order-navbar-item active-checked checked-theme js-order-delivery"
                                                 onclick="openOrdersTab(this)">
                                                <span>All</span>
                                                <img src="asssets/img/to-do-list.png" alt=""
                                                     class="side-bar__order-show-img">
                                            </div>
                                            <div class="table__order-navbar-item js-order-delivery" onclick="openOrdersTab(this)">
                                                <span>Process</span>
                                                <img src="asssets/img/delivery.png" alt="" class="side-bar__order-show-img">
                                            </div>
                                            <div class="table__order-navbar-item js-order-delivery" onclick="openOrdersTab(this)">
                                                <span>Delayed</span>
                                                <img src="asssets/img/delivery-delay.png" alt="" class="side-bar__order-show-img">
                                            </div>
                                            <div class="table__order-navbar-item js-order-delivery" onclick="openOrdersTab(this)"><span>Cancelled</span>
                                                <img src="asssets/img/cancel.png" alt="" class="side-bar__order-show-img">
                                            </div>
                                            <div class="table__order-navbar-item js-order-delivery" onclick="openOrdersTab(this)"><span>Completed</span>
                                                <img src="asssets/img/package.png" alt="" class="side-bar__order-show-img">
                                            </div>
                                        </div>
                                        <div class="table__order-filter" style="margin-top: 1rem;">
                                            <img class="table__order-search-icon" src="asssets/img/search.png"
                                                 style="width:20px;margin-right: 1rem;" alt="">
                                            <input oninput="searchOrderByID(this)" class="table__order-send-input on-filter" spellcheck="false"
                                                   autocomplete="off" placeholder="Find order by ID Order"
                                                   value="">
                                        </div>
                                    </div>
                                    <div class="table__order-body-group" style="margin-top:4rem">
                                        <div class="table__admin-introduced">
                                            <h5 class="table__admin-introduced-title">Orders List</h5>
                                            <img src="asssets/img/title-separator.png" alt=""
                                                 style="width:200px;height:30px;filter: brightness(0) invert(1);">
                                        </div>

                                        <div class="table__order-navbar-list js-order-navbar-list"></div>
                                    </div>
                                </div>
                                <div class="js-admin-tab table__navbar-order" id="Staff" style="display:none">
                                    <div class="table__staff-main-group">
                                        <div class="table__admin-introduced">
                                            <h5 class="table__admin-introduced-title">Staff</h5>
                                            <img src="asssets/img/title-separator.png" alt=""
                                                 style="width:200px;height:30px;filter: brightness(0) invert(1);">
                                        </div>
                                        <div class="table__staff-navbar">
                                            <div class="table__staff-navbar-item active-checked checked-theme js-staff-all js-staff-role"
                                                 onclick="openStaffTab(this)">
                                                <span>All</span>
                                                <img src="asssets/img/process.png" alt="" class="side-bar__order-show-img">
                                            </div>
                                            <div class="table__staff-navbar-item js-staff-role"
                                                 onclick="openStaffTab(this)">
                                                <span>Admin</span>
                                                <img src="asssets/img/process.png" alt="" class="side-bar__order-show-img">
                                            </div>
                                            <div class="table__staff-navbar-item js-staff-role" onclick="openStaffTab(this)">
                                                <span>Manager</span>
                                                <img src="asssets/img/conversation.png" alt=""
                                                     class="side-bar__order-show-img">
                                            </div>
                                            <div class="table__staff-navbar-item js-staff-role" onclick="openStaffTab(this)">
                                                <span>Staff</span>
                                                <img src="asssets/img/id-card.png" alt="" class="side-bar__order-show-img">
                                            </div>
                                        </div>
                                        <div class="table__staff-search" style="margin-top: 1rem;">
                                            <img class="table__staff-search-icon" src="asssets/img/search.png"
                                                 style="width:20px;margin-right: 1rem;" alt="">
                                            <input oninput="searchStaffByName(this)" class="table__staff-search-input" spellcheck="false"
                                                   autocomplete="off" placeholder="Search staff by ID or Name" value="">
                                        </div>
                                        <div class="table__staff-main-action on-main-action-modifier">
                                            <button class="table__staff-action-btn one-button js-update-staff js-new-staff" onclick="onClickOrderView(this)">New Staff</button>
                                        </div>
                                    </div>
                                    <div class="table__staff-body" style="margin-top:4rem">
                                        <div class="table__admin-introduced">
                                            <h5 class="table__admin-introduced-title">Manager Staffs</h5>
                                            <img src="asssets/img/title-separator.png" alt=""
                                                 style="width:200px;height:30px;filter: brightness(0) invert(1);">
                                        </div>
                                        <div class="table__staff-navbar-list">
                                            <div class="table__staff-list-item">
                                                <div class="table__staff-navbar-item-body">
                                                    <img src="asssets/img/avatar.webp" alt="" class="table__staff-user-img">
                                                    <div class="table__staff-navbar-item-data">
                                                        <div class="flex-direction-col flex-item-col-center">
                                                            <h5 class="table__main-product-name on-staff on-staff-name">Jensen</h5>
                                                            <div class="table__main-product-name on-staff on-email">jensennicolas@gmail.com</div>
                                                        </div>
                                                        <div class="table__staff-view">
                                                            <div class="table__staff-view-group">
                                                                <div class="table__staff-view-title">Role</div>
                                                                <div class="table__main-product-type on-staff-role">Admin</div>
                                                            </div>
                                                            <div class="table__staff-view-group">
                                                                <div class="table__staff-view-title">Gender</div>
                                                                <div class="table__staff-view-data on-staff-gender">Male</div>
                                                            </div>
                                                            <div class="table__staff-view-group">
                                                                <div class="table__staff-view-title">Birth Day</div>
                                                                <div class="table__staff-view-data on-staff-gender">03-07-2012</div>
                                                            </div>
                                                            <div class="table__staff-view-group">
                                                                <div class="table__staff-view-title">Phone Number</div>
                                                                <div class="table__staff-view-data on-staff-number">0374817587</div>
                                                            </div>
                                                            <div class="table__staff-view-group">
                                                                <div class="table__staff-view-title">Address</div>
                                                                <div class="table__staff-view-data on-staff-address">90 Sanfoudry
                                                                </div>
                                                            </div>
                                                            <div class="table__staff-view-group">
                                                                <div class="table__staff-view-title">Join Date</div>
                                                                <div class="table__staff-view-data on-staff-join">25-04-2012 17:05:30</div>
                                                            </div>
                                                        </div>
                                                        <div class="table__product-main-action on-order">
                                                            <button class="table__product-action-btn js-update-staff" onclick="onClickOrderView(this)">Update Staff</button>
                                                            <button class="table__product-action-btn js-remove-staff" onclick="onClickOrderView(this)">Remove Staff</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Admin -->
        <div class="table__admin-settings-up add-order" style="display: none;">
            <div class="table__admin-settings-overlay" style="opacity: 0; z-index: 245 !important;" onclick="closeOrderView()">
                <div class="table__admin-container" style="width: 35em;max-width: calc(100% - 12px);"
                     onclick="event.stopPropagation();">
                    <button type="button" class="table__changing-close" style="top:26px;left:unset;z-index:250" onclick="closeOrderView()">
                        <div class="table__changing-close-icon">
                            <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24" viewBox="0 0 24 24">
                            <path fill="currentColor"
                                  d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                            </path>
                            </svg>
                        </div>
                    </button>
                    <div class="table__order-box">
                        <div class="table__order-header">
                            <div class="table__order-title ">New Product</div>
                        </div>
                        <div class="table__order-background">
                            <div class="table__order-body">
                                <div class="table__order-group">
                                    <div class="table__product-order-group-box flex-between-center-col flex-item-col-center">
                                        <div class="table__product-group-title-box">
                                            <h5 class="table__product-group-title">Product</h5>
                                            <img src="asssets/img/open-box.png" alt="" class="table__product-group-img">
                                        </div>
                                        <div class="table__changing-close-icon table__order-close" onclick="closeOrderView()">
                                            <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24" viewBox="0 0 24 24">
                                            <path fill="currentColor"
                                                  d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                                            </path>
                                            </svg>
                                        </div>
                                    </div>
                                    <div class="table__order-group-information">
                                        <div class="table__order-group">
                                            <div class="table__order-box-group">
                                                <div class="table__order-box-header">
                                                    <div class="table__settings-up-title">Name Product</div>
                                                    <input type="text" class="table__order-group-input js-update-name"
                                                           placeholder="Product name" onKeyPress="checkProductInput()" onKeyUp="checkProductInput()" value="">
                                                </div>
                                                <div class="table__order-group-image">
                                                    <div class="table__settings-up-title">Product Image</div>
                                                    <img src="asssets/img/question-mark.png" alt="" class="table__order-group-product-image">
                                                    <input class="file-input Primary-font table__order-add-file" type="file" tabindex="-1" multiple="false" accept=".jpg,.jpeg,.png,.gif" onchange="getImageFileProduct(this)">
                                                    <div class="table__order-group-image-icon">
                                                        <img src="asssets/img/add.png" alt="">
                                                    </div>
                                                </div>
                                                <div class="table__order-box-body">
                                                    <div class="table__order-group-input-field">
                                                        <div class="table__settings-up-title">Type</div>
                                                        <div class="table__select-choose">
                                                            <select class="table__order-group-input js-update-type" name="js-update-type" onchange="checkProductInput()" style="padding:0.2rem">
                                                                <option>Type</option>
                                                                <option value="Cookie">Cookie</option>
                                                                <option value="Cake">Cake</option>
                                                                <option value="Coffee">Coffee</option>
                                                                <option value="Cold Coffee">Cold Coffee</option>
                                                            </select>
                                                            <div class="table__select-choose-icon">
                                                                <i class="ti-angle-down"></i>
                                                            </div>
                                                        </div>
                                                        <div class="table__order-box-action on-pc">
                                                            <button type="button" class="table__order-action-btn js-save-product on-one-button" onclick="saveProduct(this)" disabled>Save</button>
                                                        </div>
                                                    </div>
                                                    <div class="table__order-group-input-field">
                                                        <div class="table__settings-up-title price">Price</div>
                                                        <input type="text" class="table__order-group-input js-update-price" onKeyPress="checkProductInput()" onKeyUp="checkProductInput()" placeholder="Price" value="">
                                                        <div class="table__order-box-action on-pc">
                                                            <button type="button" class="table__order-action-btn" onclick="closeOrderView()">Not now</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="table__order-box-action on-mobile">
                                                <button type="button" class="table__order-action-btn js-save-product" onclick="saveProduct(this)" disabled>Save</button>
                                                <button type="button" class="table__order-action-btn" onclick="closeOrderView()">Not now</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Second -->
        <div class="table__admin-settings-up delete-order" style="display: none;">
            <div class="table__admin-settings-overlay" style="opacity: 0; z-index: 300 !important;" onclick="closeOrderView()">
                <div class="table__admin-container" style="width: 35em;max-width: calc(100% - 12px);"
                     onclick="event.stopPropagation();">
                    <button type="button" class="table__changing-close" style="top:26px;left:unset;z-index:250"
                            onclick="closeOrderView()">
                        <div class="table__changing-close-icon" style="display:block;">
                            <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24" viewBox="0 0 24 24">
                            <path fill="currentColor"
                                  d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                            </path>
                            </svg>
                        </div>
                    </button>
                    <div class="table__order-box">
                        <div class="table__order-header">
                            <div class="table__order-title ">Delete Product</div>
                        </div>
                        <div class="table__order-background">
                            <div style="text-align:center;">
                                <img src="asssets/img/cake1.png" alt="" class="table__order-user-img">
                                <div class="flex-direction-col flex-item-col-center">
                                    <h5 class="table__main-product-name on-product"></h5>
                                </div>
                            </div>
                            <div class="table__order-body">
                                <div class="table__order-product">
                                    <span class="table__order-product-sub-heading">Are you sure you want to delete this
                                        product?<br> This product cannot be restore after the process. </span>
                                </div>
                            </div>
                            <div class="table__order-box-action">
                                <button type="button" class="table__order-action-btn js-delete-product" onclick="DeleteProduct(this)">Delete</button>
                                <button type="button" class="table__order-action-btn" onclick="closeOrderView()">Not
                                    now</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Admin --> 
        <div class="table__admin-settings-up remove-staff" style="display: none;">
            <div class="table__admin-settings-overlay" style="opacity: 0; z-index: 300 !important;" onclick="closeOrderView()">
                <div class="table__admin-container" style="width: 35em;max-width: calc(100% - 12px);"
                     onclick="event.stopPropagation();">
                    <button type="button" class="table__changing-close" style="top:26px;left:unset;z-index:250"
                            onclick="closeOrderView()">
                        <div class="table__changing-close-icon" style="display:block;">
                            <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24" viewBox="0 0 24 24">
                            <path fill="currentColor"
                                  d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                            </path>
                            </svg>
                        </div>
                    </button>
                    <div class="table__staff-box">
                        <div class="table__staff-header">
                            <div class="table__staff-title ">Remove Staff</div>
                        </div>
                        <div class="table__staff-background">
                            <div style="text-align:center;">
                                <img src="asssets/img/avatar.webp" alt="" class="table__order-user-img">
                                <div class="flex-direction-col flex-item-col-center">
                                    <h5 class="table__main-product-name on-staff">Jensen</h5>
                                </div>
                            </div>
                            <div class="table__staff-body">
                                <div class="table__staff-wrapper">
                                    <span class="table__staff-sub-heading">Are you sure you want to remove this staff?<br>He/She will receive a email about his/her status so make sure you think carefully before do this process.</span>
                                </div>
                            </div>
                            <div class="table__staff-box-action">
                                <button type="button" class="table__staff-action-btn">Remove Staff</button>
                                <button type="button" class="table__staff-action-btn" onclick="closeOrderView()">Not
                                    now</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Admin --> 
        <div class="table__admin-settings-up update-order-status" style="display: none;">
            <div class="table__admin-settings-overlay" style="opacity: 0; z-index: 300 !important;" onclick="closeOrderView()">
                <div class="table__admin-container" style="width: 35em;max-width: calc(100% - 12px);"
                     onclick="event.stopPropagation();">
                    <button type="button" class="table__changing-close" style="top:26px;left:unset;z-index:250"
                            onclick="closeOrderView()">
                        <div class="table__changing-close-icon" style="display:block;" onclick="closeOrderView()">
                            <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24" viewBox="0 0 24 24">
                            <path fill="currentColor"
                                  d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                            </path>
                            </svg>
                        </div>
                    </button>
                    <div class="table__order-box">
                        <div class="table__order-header">
                            <div class="table__order-title js-order-status-id ">Update Order Status</div>
                        </div>
                        <div class="table__order-background on-status">
                            <div class="purchase__product-cancelled-item" style="margin-left:unset;">
                                <img src="asssets/img/confused.gif" alt="" style="width:60px;height: 45px;">
                                <span class="purchase__product-cancelled-text">Choose one of status to update. Notice that this will immediately send a email to customer after the process complete.</span>
                            </div>
                            <div class="table__order-status-box">
                                <div class="table__order-status-group active-checked checked-theme" onclick="onClickStatusOrder(this)">
                                    <img src="asssets/img/delivery.png" alt="" class="side-bar__order-show-img">
                                    <div class="table__order-status-text">Process</div>
                                </div>
                                <div class="table__order-status-group js-reject" onclick="onClickStatusOrder(this)">
                                    <img src="asssets/img/cancel.png" alt="" class="side-bar__order-show-img">
                                    <div class="table__order-status-text">Reject</div>
                                </div>
                                <div class="table__order-status-group js-delayed" onclick="onClickStatusOrder(this)">
                                    <img src="asssets/img/delivery-delay.png" alt="" class="side-bar__order-show-img">
                                    <div class="table__order-status-text">Delayed</div>
                                </div>
                                <div class="table__order-status-group" onclick="onClickStatusOrder(this)">
                                    <img src="asssets/img/package.png" alt="" class="side-bar__order-show-img">
                                    <div class="table__order-status-text">Completed</div>
                                </div>
                            </div>
                            <div class="table__order-status-message">
                                <div class="table__order-send-message  table__status-message-input">
                                    <img class="table__order-search-icon" src="asssets/img/send.png"
                                         style="width:20px;margin-right: 1rem;" alt="">
                                    <input oninput="" class="table__order-send-input order-update" spellcheck="false"
                                           autocomplete="off" placeholder="Send a message to customer" value="">
                                </div>
                            </div>
                            <div class="table__order-box-action flex-dir-default js-update-status-btn" style="margin-top:-4rem;">
                                <button type="button" class="table__order-action-btn" onclick="updateOrder()">Update Status</button>
                                <button type="button" class="table__order-action-btn" onclick="closeOrderView()">Not now</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        `
        <!--Admin --> 
        <div class="table__admin-settings-up add-staff" style="display: none;">
            <div class="table__admin-settings-overlay" style="opacity: 0; z-index: 300 !important;" onclick="closeOrderView()">
                <div class="table__admin-container" style="width: 35em;max-width: calc(100% - 12px);"
                     onclick="event.stopPropagation();">
                    <button type="button" class="table__changing-close" style="top:26px;left:unset;z-index:250" onclick="closeOrderView()">
                        <div class="table__changing-close-icon">
                            <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24" viewBox="0 0 24 24">
                            <path fill="currentColor"
                                  d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                            </path>
                            </svg>
                        </div>
                    </button>
                    <div class="table__staff-box">
                        <div class="table__staff-header">
                            <div class="table__staff-title js-staff-action-title">Add Staff</div>
                        </div>
                        <div class="table__staff-background">
                            <div class="table__staff-body">
                                <div class="table__staff-group">
                                    <div class="table__staff-order-group-box flex-between-center-col flex-item-col-center">
                                        <div class="table__staff-group-title-box">
                                            <h5 class="table__staff-group-title">Staff</h5>
                                            <img src="asssets/img/id-card.png" alt="" class="table__product-group-img">
                                        </div>
                                        <div class="table__changing-close-icon table__order-close" onclick="closeOrderView()">
                                            <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24" viewBox="0 0 24 24">
                                            <path fill="currentColor"
                                                  d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                                            </path>
                                            </svg>
                                        </div>
                                    </div>
                                    <div class="table__staff-group-information ">
                                        <div class="table__staff-group">
                                            <div class="table__staff-box-header">
                                                <div class="table__settings-up-title js-staff-title">Name / Surname</div>
                                                <input type="text" onKeyPress="checkStaffInput()" onKeyUp="checkStaffInput()" class="table__staff-group-input js-staff-name"
                                                       placeholder="Name / Surname" value="">
                                            </div>
                                            <div class="table__staff-box-group">
                                                <div class="table__staff-group-image">
                                                    <div class="table__settings-up-title">Staff Image</div>
                                                    <img src="asssets/img/avatar.webp" alt="" class="table__staff-group-product-image">
                                                    <input class="file-input Primary-font table__staff-add-file" type="file" tabindex="-1" multiple="false" accept=".jpg,.jpeg,.png,.gif" onchange="getImageFileStaff(this)">
                                                    <div class="table__staff-group-image-icon">
                                                        <img src="asssets/img/add.png" alt="">
                                                    </div>
                                                </div>
                                                <div class="table__staff-group-information">
                                                    <div class="table__staff-group-input-field">
                                                        <div class="table__settings-up-title">Birth Day</div>
                                                        <input type="date" onKeyPress="checkStaffInput()" onKeyUp="checkStaffInput()" class="table__staff-group-input js-staff-birth" value="">
                                                    </div>
                                                    <div class="table__staff-group-input-field">
                                                        <div class="table__settings-up-title">Gender</div>
                                                        <div class="table__select-choose">
                                                            <select class="table__staff-group-input js-staff-gender" onchange="checkStaffInput()" style="padding:0.2rem">
                                                                <option>Gender</option>
                                                                <option value="Male">Male</option>
                                                                <option value="Female">Female</option>
                                                                <option value="Other">Other</option>
                                                            </select>
                                                            <div class="table__select-choose-icon">
                                                                <i class="ti-angle-down"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="table__staff-group-input-field">
                                                        <div class="table__settings-up-title">Role</div>
                                                        <div class="table__select-choose">
                                                            <select class="table__staff-group-input js-staff-role-selected" onchange="checkStaffInput()" style="padding:0.2rem">
                                                                <option>Role</option>
                                                                <option value="Admin">Admin</option>
                                                                <option value="Manager">Manager</option>
                                                                <option value="Staff">Staff</option>
                                                            </select>
                                                            <div class="table__select-choose-icon">
                                                                <i class="ti-angle-down"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="table__staff-group-input-field">
                                                        <div class="table__settings-up-title">Phone Number</div>
                                                        <input type="number" onKeyPress="checkStaffInput()" onKeyUp="checkStaffInput()" class="table__staff-group-input js-staff-phone"
                                                               placeholder="Phone Number" value="">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="table__staff-box-header field-Spacer-Top-16" style="margin-left:unset;">
                                        <div class="table__settings-up-title">Address</div>
                                        <input type="text" onKeyPress="checkStaffInput()" onKeyUp="checkStaffInput()" class="table__staff-group-input js-staff-address"
                                               placeholder="Address" value="">
                                    </div>
                                    <div class="table__staff-box-header field-Spacer-Top-16" style="margin-left:unset;">
                                        <div class="table__settings-up-title">Email</div>
                                        <input type="email" onKeyPress="checkStaffInput()" onKeyUp="checkStaffInput()" class="table__staff-group-input js-staff-email"
                                               placeholder="Email" value="">
                                    </div>
                                    <div class="table__staff-box-action">
                                        <button type="button" class="table__staff-action-btn staff-submit" onclick="updateStaff(this)" disabled>Save Update</button>
                                        <button type="button" class="table__staff-action-btn" onclick="closeOrderView()">Not now</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="asssets/js/jquery.min.js"></script>
        <script src="asssets/js/closeOpen.js"></script>
        <script src="asssets/js/contentUserStorage.js"></script>
        <script src="asssets/js/contentStorageAdmin.js"></script>
        <script src="asssets/js/admin.js"></script>
        <script type="text/javascript">
            <%@include file="asssets/js/admin.js" %>
        </script>
    </body>

</html>
