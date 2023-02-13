<%-- 
    Document   : settings
    Created on : Jun 30, 2022, 7:47:44 AM
    Author     : phong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Coffie</title>
        <link rel="icon" href="asssets/img/coffie.png" />
        <link href='https://fonts.googleapis.com/css?family=Antic Didone' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link rel="stylesheet" href="asssets/font/themify-icons/themify-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style type="text/css">
            <%@include file="asssets/css/style.css" %>
            <%@include file="asssets/css/base.css" %>
            <%@include file="asssets/css/table.css"%>
            <%@include file="asssets/css/sidebar.css"%>
            <%@include file="asssets/css/responsive.css"%>
        </style>
    </head>
    <body>
        <div class="side-bar" style="display:none">
            <div class="side-bar__container on-settings">
                <div class="side-bar__overlay" onclick="closeTab()"></div>
                <div class="side-bar__box-settings">
                    <div class="side-bar__scroller thin-scoller-bar">
                        <nav class="side-bar__menu">
                            <div class="side-bar__avatar">
                                <img class="side-bar__avatar-img user__avatar" src="${user.getBase64Avatar()}">
                                <img src="asssets/img/coffee-reset.gif" alt="" class="side-bar__avatar-gif">
                            </div>
                            <div class="side-bar__account-main-menu">
                                <h3 class="side-bar__account-heading user_NickName">${user.getNickname()}</h3>
                                <div class="side-bar__account-sub-heading js-heading-email user_email">${user.getEmail()}</div>
                            </div>
                            <div class="side-bar__content">
                                <div class="side-bar__user-settings">
                                    <div class="side-bar__item js-modifier selected hover-den selected-theme flex-item-col-center field-Spacer-Top-10 theme-padding"
                                         onclick="openTab(this)" value="My Account">
                                        <img src="asssets/img/account.png"
                                             class="header__logging-item-img color-image__modifier">
                                        <div class="side-bar__item theme-padding">My Account</div>
                                        <div class="side-bar__item-icon">
                                            <i class="ti-angle-right"></i>
                                        </div>
                                    </div>
                                    <div class="side-bar__item js-modifier hover-den flex-item-col-center theme-padding field-Spacer-Top-10"
                                         onclick="openTab(this)" value="Dashboard">
                                        <img src="asssets/img/dashboard.png"
                                             class="header__logging-item-img color-image__modifier">
                                        <div class="side-bar__item theme-padding">Dashboard</div>
                                        <div class="side-bar__item-icon">
                                            <i class="ti-angle-right"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="side-bar__user-settings">
                                    <div class="side-bar__item js-modifier hover-den flex-item-col-center field-Spacer-Top-10 theme-padding"
                                         onclick="openTab(this)" onclick="openOrder()" value="Order">
                                        <img src="asssets/img/order-list.png"
                                             class="header__logging-item-img color-image__modifier">
                                        <div class="side-bar__item theme-padding">Order</div>
                                        <div class="side-bar__item-icon">
                                            <i class="ti-angle-right"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="side-bar__app-settings">
                                    <div class="side-bar__item js-modifier hover-den flex-item-col-center theme-padding field-Spacer-Top-10"
                                         onclick="openTab(this)" value="Appearance">
                                        <img src="asssets/img/flashlight.png"
                                             class="header__logging-item-img color-image__modifier">
                                        <div class="side-bar__item theme-padding">Appearance</div>
                                        <div class="side-bar__item-icon">
                                            <i class="ti-angle-right"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="side-bar__other-settings">
                                    <div class="side-bar__item hover-den flex-item-col-center field-Spacer-Top-10 theme-padding"
                                         onclick="onClickSignOut()">
                                        <img src="asssets/img/logout.png"
                                             class="header__logging-item-img color-image__modifier">
                                        <div class="side-bar__item theme-padding">Sign out</div>
                                    </div>
                                </div>
                            </div>
                        </nav>
                    </div>
                    <div class="side-bar__extend-settings" value="closeDown" onclick="openAndCloseNavbar()">
                        <div>
                            <i class="side-bar__extend-settings-icon ti-arrow-right"></i>
                        </div>
                    </div>
                    <div class="side-bar__extend-settings-mobile" value="closeDownMobile" onclick="closeSettings()">
                        <div>
                            <i class="side-bar__extend-settings-icon ti-close"></i>
                        </div>
                    </div>
                </div>
                <div class="side-bar__information">
                    <div class="side-bar__container">
                        <div class="side-bar__show-side-bar thin-scoller-bar">
                            <div class="side-bar__show-content">
                                <jsp:include page="Account.jsp" /> 
                                <jsp:include page="Dashboard.jsp" /> 
                                <jsp:include page="Order.jsp" /> 
                                <jsp:include page="Appearance.jsp" /> 
                            </div>
                            <div class="side-bar__close-container">
                                <div class="side-bar__close-box fixed-position">
                                    <div class="side-bar__close-content">
                                        <div class="side-bar__close-button" onclick="closeSettings()">
                                            <svg aria-hidden="true" width="18" height="18" viewBox="0 0 24 24">
                                            <path fill="currentColor"
                                                  d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                                            </path>
                                            </svg>
                                        </div>
                                        <div class="side-bar__close-text">EXIT</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
