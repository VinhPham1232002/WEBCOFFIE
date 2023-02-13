<%-- 
    Document   : index
    Created on : Jun 4, 2022, 11:02:06 AM
    Author     : phong
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
        <div class="main thin-scoller-bar">
            <%if(session.getAttribute("loadingScreen") == null){
                session.setAttribute("loadingScreen", "loading");
            }
              if(session.getAttribute("loadingScreen").equals("loading")){
            %>
            <div class="load" id="load" style="background-color: #f9f1c9">
                <img src="asssets/img/coffie-load.gif" alt="" class="load-gif">
            </div>
            <%}%>
            <header class="header">
                <div class="header__container">
                    <a href="#" class="header__coffie-content">
                        <svg xmlns="http://www.w3.org/2000/svg" class="header__coffie-logo-icon" width="24" height="24">
                        <path
                            d="M5 2h2v3H5zm4 0h2v3H9zm4 0h2v3h-2zm6 7h-2V7H3v11c0 1.654 1.346 3 3 3h8c1.654 0 3-1.346 3-3h2c1.103 0 2-.897 2-2v-5c0-1.103-.897-2-2-2zm-4 9a1 1 0 0 1-1 1H6a1 1 0 0 1-1-1V9h10v9zm2-2v-5h2l.002 5H17z">
                        </path>
                        </svg>
                        <h3 class="header__coffie-heading">COFFIE</h3>
                    </a>
                    <ul class="header__navbar-list">
                        <li class="header__navbar-item">
                            <a href="#Home" class="header__navbar-item-link">
                                <img src="asssets/img/home.png" alt="" class="header__navbar-item-img">
                                <p class="header__navbar-item-text">
                                    Home
                                </p>
                            </a>
                        </li>
                        <li class="header__navbar-item">
                            <a href="#about" class="header__navbar-item-link">
                                <img src="asssets/img/about.png" alt="" class="header__navbar-item-img">
                                <p class="header__navbar-item-text">
                                    About
                                </p>
                            </a>
                        </li>
                        <li class="header__navbar-item">
                            <a href="#Products" class="header__navbar-item-link">
                                <img src="asssets/img/product.png" alt="" class="header__navbar-item-img">
                                <p class="header__navbar-item-text">
                                    Products
                                </p>
                            </a>
                        </li>
                        <li class="header__navbar-item">
                            <a href="#Premium" class="header__navbar-item-link">
                                <img src="asssets/img/premium.png" alt="" class="header__navbar-item-img">
                                <p class="header__navbar-item-text">
                                    Premium
                                </p>
                            </a>
                        </li>
                        <li class="header__navbar-item">
                            <a href="#Blog" class="header__navbar-item-link">
                                <img src="asssets/img/blog.png" alt="" class="header__navbar-item-img">
                                <p class="header__navbar-item-text">
                                    Blog
                                </p>
                            </a>
                        </li>
                    </ul>
                    <div class="header__data">
                        <%if(session.getAttribute("status") == null){%>
                        <div class="header__loggout">
                            <a href="login.jsp" target="_self" class="header__loggout-link">
                                <button class="header__navbar-btn">Log in</button>
                            </a>
                            <a href="signin.jsp" target="_self" class="header__loggout-link">
                                <button class="header__navbar-btn button-radius">Sign up</button>
                            </a>
                        </div> 
                        <%}else{%>
                        <div class="header__logging">
                            <div class="header__logging-title">
                                <div class="header__logging-notify">
                                    <div class="header__img-box" onmouseover="notifyDelete()">
                                        <img src="asssets/img/bell.png" alt="" class="header__img">
                                        <div class="header__img-box-number">+${numberOrder}</div>
                                    </div>
                                    <ul class="header__notice-list">
                                        <div class="header__notice-title">
                                            <h5>Notification</h5>
                                        </div>
                                        <div class="header__notice-group thin-scoller-bar">
                                            <%if(session.getAttribute("orders") != null){%>
                                            <c:forEach items="${sessionScope.orders}" var="order">
                                                <li class="header__notice-item">
                                                    <div class="header__notice-product-img">
                                                        <img src="${order.getProductImage()}" alt="">
                                                    </div>
                                                    <div class="header__notice-body">
                                                        <c:choose>
                                                            <c:when test="${order.getStatus().equals('CANCELLED')}">
                                                                <div class="header__notice-heading"> Your order <span style="font-weight:bold">${order.getIdOrder()}</span> of product <span style="font-weight:bold">${order.getNameProduct()}</span> has been cancelled.
                                                                </div>       
                                                            </c:when>
                                                            <c:when test="${order.getStatus().equals('PROCESS')}">
                                                                <div class="header__notice-heading"> Your order <span style="font-weight:bold">${order.getIdOrder()}</span> of product <span style="font-weight:bold">${order.getNameProduct()}</span> is being processed. Our courier will contact you for delivery schedule.
                                                                </div>          
                                                            </c:when>
                                                            <c:when test="${order.getStatus().equals('DELAYED')}">
                                                                <div class="header__notice-heading"> Your order <span style="font-weight:bold">${order.getIdOrder()}</span> of product <span style="font-weight:bold">${order.getNameProduct()}</span> has been delayed. Please check your order details in settings or contact us to receive a support.
                                                                </div>          
                                                            </c:when>
                                                            <c:otherwise>
                                                                <div class="header__notice-heading"> Your order <span style="font-weight:bold">${order.getIdOrder()}</span> of product <span style="font-weight:bold">${order.getNameProduct()}</span> has been completed. Please contact us for our best assistance within 48 hours of receipt of the product for any sign of damage.
                                                                </div>       
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <div class="header__notice-time-remaining">${order.getDistanceTime()}</div>
                                                    </div>
                                                    <div class="header__notice-action">
                                                        <img src="asssets/img/close-icon.png" onclick="closeNotify()" alt="">
                                                    </div>
                                                </li>
                                            </c:forEach>
                                            <%}else{%>
                                            <li class="header__notice-item no-order">
                                                <div class="header__notice-body">
                                                    <img src="asssets/img/sorry.gif" class="no-order-img" alt="">
                                                    <div class="header__notice-heading no-order-heading"> No orders available in the cart.</div>
                                                </div>
                                            </li>
                                            <%}%>
                                        </div>
                                    </ul>
                                </div>
                                <div class="header__avatar-box">
                                    <img src="${user.getBase64Avatar()}" alt="" class="header__avatar user__avatar" onclick="openSettings()">                                
                                </div>
                            </div>
                        </div>
                        <%}%>
                    </div>
                </div>
            </header>
            <section class="home" id="Home">
                <div class="home__container">
                    <div class="home__slide">
                        <img src="asssets/img/home-1.jpg" alt="" class="home__img">
                    </div>
                    <div class="home__content">
                        <div class="home__introduce">
                            <img src="asssets/img/logocoffee4.png" class="home__logo" alt="">
                            <h1 class="home__title">
                                <p class="home__title-highlight-text">Life of Coffie
                            </h1>
                            <img src="asssets/img/title-separator.png" class="home__separator" alt="">
                            <p class="home__description">
                                The highest quality coffees from farms around the world, freshly roasted by hand to bring
                                out every nuance, so you can taste the craft in every cup.
                            </p>
                            <div class="home__button">
                                <a href="#about" class="home__button-btn">
                                    <span>Explore Now</span>
                                    <img src="asssets/img/scroll-mouse.png" alt="">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <div class="grid-column wide">
                <section class="about section" id="about">
                    <div class="about__container">
                        <div class="about__content container">
                            <div class="about__box" style="text-align:center">
                                <h2 class="section__title" style="color:var(--black-color)">
                                    Who we really are & why choose us
                                </h2>
                                <img src="asssets/img/title-separator.png" class="home__separator" style="filter:unset; margin-bottom:2rem" alt="">
                            </div>
                            <div class="about__category">
                                <div class="about__group">
                                    <img src="asssets/img/selected-3.png" alt="" class="about__img">
                                    <h3 class="about__title">
                                        Selected Coffee
                                    </h3>
                                    <p class="about__description">
                                        We select the best premium coffe, for a true taste.
                                    </p>
                                </div>
                                <div class="about__group">
                                    <img src="asssets/img/selected-2.png" alt="" class="about__img">
                                    <h3 class="about__title">
                                        Delicious Cake
                                    </h3>
                                    <p class="about__description">
                                        Enjoy your coffee with some delicious cake.
                                    </p>
                                </div>
                                <div class="about__group">
                                    <img src="asssets/img/selected-1.png" alt="" class="about__img">
                                    <h3 class="about__title">
                                        Enjoy at home
                                    </h3>
                                    <p class="about__description">
                                        Order at home and enjoy your best coffee in the comfort of your home.
                                    </p>
                                </div>
                                <div class="about__group">
                                    <img src="asssets/img/selected-4.png" alt="" class="about__img">
                                    <h3 class="about__title">
                                        Bean varieties
                                    </h3>
                                    <p class="about__description">
                                        We ensure that our coffee was made from 100% coffee bean. So we can create our special coffee to you.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section class="products section" id="Products">
                    <div class="products__container">
                        <div class="products__container container">
                            <div class="products__box" style="text-align: center">
                                <h2 class="section__title" style="color:var(--black-color)">
                                    Choose our delicious and your best coffees and cakes
                                </h2>
                                <img src="asssets/img/title-separator.png" class="home__separator" style="filter:unset; margin-bottom:2rem" alt="">
                            </div>
                            <ul class="products__category">
                                <li class="products__arrow">
                                    <i class="ti-arrow-circle-left"></i>
                                </li>
                                <li class="products__group" data-filter=".delicacies" style="display:block;">
                                    <div class="products__item-group">
                                        <h3 class="products__title">Cookies</h3>
                                        <p class="products__description">
                                            3 products
                                        </p>
                                    </div>
                                </li>
                                <li class="products__group" data-filter=".hot-coffee" style="display:none;">
                                    <div class="products__item-group">
                                        <h3 class="products__title">Hot coffee</h3>
                                        <p class="products__description">
                                            4 products
                                        </p>
                                    </div>
                                </li>
                                <li class="products__group" data-filter=".cold-coffee" style="display:none;">
                                    <div class="products__item-group">
                                        <h3 class="products__title">Cold coffee</h3>
                                        <p class="products__description">
                                            2 products
                                        </p>
                                    </div>
                                </li>
                                <li class="products__group" data-filter=".cake" style="display:none;">
                                    <div class="products__item-group">
                                        <h3 class="products__title">Cakes</h3>
                                        <p class="products__description">
                                            4 products
                                        </p>
                                    </div>
                                </li>
                                <li class="products__arrow">
                                    <i class="ti-arrow-circle-right"></i>
                                </li>
                            </ul>
                            <!-- Cookies -->
                            <div class="products__list">
                                <div class="mixitup-page-list">
                                    <button type="button" class="mixitup-control mixitup-control-prev"
                                            data-page="prev"></button>
                                    <button type="button" class="mixitup-control mixitup-control-next"
                                            data-page="next"></button>
                                </div>
                                <div class="products__content">
                                    <sql:setDataSource
                                        var = "products"
                                        driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                                        url="jdbc:sqlserver://localhost:1433;databaseName=User"
                                        user="sa" password="123"
                                        />
                                    <sql:query var="product" dataSource="${products}">
                                        SELECT IDPRODUCT, NAME, PRICE, TYPE, CAST('' as xml).value(
                                        'xs:base64Binary(sql:column("PRODUCT.IMAGE"))', 'VARCHAR(MAX)') as IMAGE, IMAGETYPE
                                        from PRODUCT                            
                                    </sql:query>
                                    <c:forEach items="${product.rows}" var="productItem">
                                        <c:choose>
                                            <c:when test="${productItem.type == 'COOKIES'}">
                                                <div class="products__card delicacies" style="display:block;">
                                                    <div class="products__shape">
                                                        <img src="data:image/${productItem.IMAGETYPE};base64, ${productItem.IMAGE}" alt="" class="products__img">
                                                    </div>
                                                    <div class="products__data">
                                                        <h2 class="products__price">$${productItem.PRICE}</h2>
                                                        <h3 class="products__name" value="Cookie">${productItem.NAME}</h3>
                                                        <a href="login.jsp" class="button products__button">
                                                            <i class="products_button-icon ti-shopping-cart"></i>
                                                        </a>
                                                        <a href="login.jsp" class="button products__button" style="right:4rem;">
                                                            <img src="asssets/img/non-favorite.png" alt=""
                                                                 style="height:24px; width:24px;">
                                                        </a>
                                                    </div>
                                                </div>                                            
                                            </c:when>
                                            <c:when test="${productItem.type == 'COFFEE'}">
                                                <div class="products__card hot-coffee" style="display:none">
                                                    <div class="products__shape">
                                                        <img src="data:image/${productItem.IMAGETYPE};base64, ${productItem.IMAGE}" alt="" class="products__img">
                                                    </div>
                                                    <div class="products__data">
                                                        <h2 class="products__price">$${productItem.PRICE}</h2>
                                                        <h3 class="products__name" value="Coffee">${productItem.NAME}</h3>
                                                        <a href="login.jsp" class="button products__button">
                                                            <i class="products_button-icon ti-shopping-cart"></i>
                                                        </a>
                                                        <a href="login.jsp" class="button products__button" style="right:4rem;">
                                                            <img src="asssets/img/non-favorite.png" alt=""
                                                                 style="height:24px; width:24px;">
                                                        </a>
                                                    </div>
                                                </div>                                          
                                            </c:when>
                                            <c:when test="${productItem.type == 'COLD COFFEE'}">
                                                <div class="products__card cold-coffee" style="display:none">
                                                    <div class="products__shape">
                                                        <img src="data:image/${productItem.IMAGETYPE};base64, ${productItem.IMAGE}" alt="" class="products__img">
                                                    </div>
                                                    <div class="products__data">
                                                        <h2 class="products__price">$${productItem.PRICE}</h2>
                                                        <h3 class="products__name" value="Coffee">${productItem.NAME}</h3>
                                                        <a href="login.jsp" class="button products__button">
                                                            <i class="products_button-icon ti-shopping-cart"></i>
                                                        </a>
                                                        <a href="login.jsp" class="button products__button" style="right:4rem;">
                                                            <img src="asssets/img/non-favorite.png" alt=""
                                                                 style="height:24px; width:24px;">
                                                        </a>
                                                    </div>
                                                </div>                                          
                                            </c:when>
                                            <c:when test="${productItem.type == 'CAKE'}">
                                                <div class="products__card cake" style="display:none">
                                                    <div class="products__shape">
                                                        <img src="data:image/${productItem.IMAGETYPE};base64, ${productItem.IMAGE}" alt="" class="products__img">
                                                    </div>
                                                    <div class="products__data">
                                                        <h2 class="products__price">$${productItem.PRICE}</h2>
                                                        <h3 class="products__name" value="Cake">${productItem.NAME}</h3>
                                                        <a href="login.jsp" class="button products__button">
                                                            <i class="products_button-icon ti-shopping-cart"></i>
                                                        </a>
                                                        <a href="login.jsp" class="button products__button" style="right:4rem;">
                                                            <img src="asssets/img/non-favorite.png" alt=""
                                                                 style="height:24px; width:24px;">
                                                        </a>
                                                    </div>
                                                </div>                                          
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                </section>
                <section class="premium section" id="Premium">
                    <div class="premium__container container">
                        <div class="premium__box" style="text-align:center;">
                            <h2 class="section__title" style="color:var(--black-color)">
                                We offer a premium and better quality just for you.
                            </h2>
                            <img src="asssets/img/title-separator.png" class="home__separator" style="filter:unset; margin-bottom:2rem" alt="">
                        </div>
                        <div class="premium__content grid">
                            <div class="premium__images">
                                <img src="asssets/img/quality1.png" alt="" class="premium__img-big">
                                <img src="asssets/img/quality2.png" alt="" class="premium__img-small">
                            </div>
                            <div class="premium__data">
                                <h1 class="premium__title">Premium Coffee</h1>
                                <h2 class="premium__price">$30.99</h2>
                                <span class="premium__special-text">Especial Price</span>
                                <p class="premium__description">
                                    We are delighted with our coffee. That's why we choose your best coffee to service for
                                    your
                                    best quality that you see in the image, for a special price.
                                </p>
                                <div class="premium__buttons">
                                    <a href="" class="premium__button-btn">
                                        <span>Buy Now</span>
                                    </a>
                                    <a href="" class="premium__button-btn">
                                        <span>View More</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section class="blog section" id="Blog">
                    <div class="blog__container container">
                        <div class="blog__box" style="text-align:center;">
                            <h2 class="section__title" style="color:var(--black-color)">
                                Our Blogs Coffee with trending top for this week.
                            </h2>
                            <img src="asssets/img/title-separator.png" class="home__separator" style="filter:unset; margin-bottom:2rem" alt="">
                        </div>
                        <div class="blog__content">
                            <div class="blog__card">
                                <div class="blog__image">
                                    <img src="asssets/img/blog1.png" alt="" class="blog__img">
                                    <a href="#" class="blog__button">
                                        <i class="blog__button-icon ti-arrow-circle-right"></i>
                                    </a>
                                </div>
                                <div class="blog__data">
                                    <h2 class="blog__title">
                                        10 Coffee Recommendations
                                    </h2>
                                    <p class="blog__description">
                                        The blogs about coffee will help you a lot about how it is prepared, its waiting
                                        time,
                                        for a good quality coffee.
                                    </p>
                                    <div class="blog__footer">
                                        <div class="blog__reaction">
                                            <i class="blog__reaction-icon center-align ti-comment"></i>
                                            <span class="blog__reaction-number">12</span>
                                        </div>
                                        <div class="blog__reaction">
                                            <i class="blog__reaction-icon ti-eye"></i>
                                            <span class="blog__reaction-number">75K</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="blog__card">
                                <div class="blog__image">
                                    <img src="asssets/img/blog2.png" alt="" class="blog__img">
                                    <a href="#" class="blog__button">
                                        <i class="blog__button-icon ti-arrow-circle-right"></i>
                                    </a>
                                </div>
                                <div class="blog__data">
                                    <h2 class="blog__title">
                                        12 Coffee Recommendations
                                    </h2>
                                    <p class="blog__description">
                                        The blogs about coffee will help you a lot about how it is prepared, its waiting
                                        time,
                                        for a good quality coffee.
                                    </p>
                                    <div class="blog__footer">
                                        <div class="blog__reaction">
                                            <i class="blog__reaction-icon center-align ti-comment"></i>
                                            <span class="blog__reaction-number">35</span>
                                        </div>
                                        <div class="blog__reaction">
                                            <i class="blog__reaction-icon ti-eye"></i>
                                            <span class="blog__reaction-number">20K</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="blog__credit">
                            <div class="blog__box" style="text-align:center;">
                                <h2 class="blog__title-credit">Special thanks to everyone who support us</h2>
                                <img src="asssets/img/title-separator.png" class="home__separator" style="filter:unset; margin-bottom:2rem" alt="">
                            </div>
                            <div class="blog__group">
                                <div class="blog__data">
                                    <a href="#" class="blog__credit-link">
                                        <img src="asssets/img/logocoffee1.png" alt="" class="blog__credit-img">
                                    </a>
                                </div>
                                <div class="blog__data">
                                    <a href="#" class="blog__credit-link">
                                        <img src="asssets/img/logocoffee2.png" alt="" class="blog__credit-img">
                                    </a>
                                </div>
                                <div class="blog__data">
                                    <a href="#" class="blog__credit-link">
                                        <img src="asssets/img/logocoffee3.png" alt="" class="blog__credit-img">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <footer class="footer">
                <div class="footer_container container">
                    <div class="footer__box">
                        <h1 class="footer__title">COFFIE</h1>
                        <div class="footer__content grid">
                            <div class="footer__data">
                                <p class="footer__description">
                                    Subcribe to our newsletter
                                </p>
                                <div class="footer__newsletter">
                                    <input type="email" placeholder="Your email address" class="footer__input">
                                    <button class="footer__button">
                                        <i class="footer__button-icon ti-arrow-circle-right"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="footer__data">
                                <h2 class="footer__subtitle">
                                    Address
                                </h2>
                                <p class="footer__information">
                                    9765 Hachidenia Sr. <br>
                                    Lima, La Liberian 123, Scotland
                                </p>
                            </div>
                            <div class="footer__data">
                                <h2 class="footer__subtitle">
                                    Contact
                                </h2>
                                <p class="footer__information">
                                    +987654321<br>
                                    lifeofcoffie@gmail.com
                                </p>
                            </div>
                            <div class="footer__data">
                                <h2 class="footer__subtitle">
                                    Office
                                </h2>
                                <p class="footer__information">
                                    Monday - Satruday <br>
                                    9AM - 10PM
                                </p>
                            </div>
                        </div>
                        <div class="footer__group">
                            <div class="footer__social">
                                <a href="#" class="footer__social-link">
                                    <ti class="footer__social-link-icon ti-facebook"></ti>
                                </a>
                                <a href="#" class="footer__social-link">
                                    <ti class="footer__social-link-icon ti-instagram"></ti>
                                </a>
                                <a href="#" class="footer__social-link">
                                    <ti class="footer__social-link-icon ti-twitter"></ti>
                                </a>
                            </div>
                            <span class="footer__copy">
                                @ PhongNguyen. All rights reserved
                            </span>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
        <%if(session.getAttribute("status") != null){%>
        <jsp:include page="settings.jsp" /> 
        <%}%>

        <script src="asssets/js/jquery.min.js"></script>
        <script src="asssets/js/mixitup.min.js"></script>
        <script src="asssets/js/mixitup-pagination.min.js"></script>
        <script src="asssets/js/userStorage.js"></script>
        <script src="asssets/js/closeOpen.js"></script>
        <script src="asssets/js/inputUser.js"></script>
        <script src="asssets/js/hideAndShow.js"></script>
        <script src="asssets/js/main.js"></script>
        <script type="text/javascript">
            <%@include file="asssets/js/inputUser.js" %>
        </script>
        <script type="text/javascript">
            <%@include file="asssets/js/hideAndShow.js" %>
        </script>
        <script type="text/javascript">
            <%@include file="asssets/js/closeOpen.js" %>
        </script>
        <script type="text/javascript">
            <%@include file="asssets/js/AJAX.js" %>
        </script>
    </body>

</html>