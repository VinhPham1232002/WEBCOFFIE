<%-- 
    Document   : signin
    Created on : Jun 4, 2022, 11:02:32 AM
    Author     : ADMIN
--%>

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
            <%@include file="asssets/css/responsive.css"%>
            <%@include file="asssets/css/table.css"%>
            <%@include file="asssets/css/sidebar.css"%>
        </style>
    </head>

    <body>
        <div class="main">
            <div class="table">
                <div class="table__container">
                    <div class="table__side">
                        <div class="table__img" style="background-image:url('asssets/img/signup.jpg')"></div>
                    </div>
                    <div class="table__box-sign-in-info">
                        <div class="table__sign-in-container">
                            <div class="table__title">
                                <h2 class="table__title-heading">COFFIE</h2>
                                <h3 class="table__title-sub-heading">Spice up your creating process</h3>
                                <span class="table__title-text">Create an account</span>
                            </div>
                            <form action="SignInController" method="post" onsubmit="return validateFormUser()">
                                <div class="table__input-field">
                                    <input type="text" name="email" class="table__input" onKeyPress="checkInputUser()"
                                           onKeyUp="checkInputUser()" placeholder="E-mail address" value="" autocomplete="off">
                                    <div class="valid js-check-email"></div>
                                </div>
                                <div class="table__input-field">
                                    <input type="password" name="password" class="table__input"
                                           onKeyPress="checkInputUser()" onKeyUp="checkInputUser()" placeholder="Password"
                                           value="" autocomplete="off">
                                    <div class="valid js-check-password"></div>
                                </div>
                                <ul class="table__input-error" style="margin:12px auto 8px">
                                    <%if(session.getAttribute("msg__error") != null){%>
                                    <li class="table__error-item js-exist-email" style="display:block;">
                                        <%=(String)session.getAttribute("msg__error")%>
                                    </li>
                                    <%session.removeAttribute("msg__error");}%>
                                    <li class="table__error-item js-error-email">
                                        Email address is invalid.
                                    </li>
                                    <li class="table__error-item js-error-password">
                                        Passwords must be between 8 to 20 characters.
                                    </li>
                                </ul>
                                <input type="submit" class="table__input-submit" disabled value="Next">
                                <div class="table__seperate field-Spacer-Left-Right-30">
                                    <div class="seperate__left"></div>
                                    <div class="seperate__middle">or</div>
                                    <div class="seperate__right"></div>
                                </div>
                                <button type="submit" class="table__input-connect" disabled="disabled">
                                    <i class="table__input-connect-icon ti-google"
                                       style="font-size:25px;color:#1da1f2;"></i>
                                    <span class="table__input-connect-text">
                                        Continue with Google
                                    </span>
                                </button>
                            </form>
                            <a href="login.jsp" class="table__sign-in" style="background-color:#61c3bb;">Log in</a>
                            <div class="table__footer" style="padding-bottom:1px;">
                                This site is protected by reCAPTCHA Enterprise and the Google<a
                                    href="https://policies.google.com/privacy" target="_blank" rel="noopener"> Privacy
                                    Policy</a> and <a href="https://policies.google.com/terms" target="_blank"
                                                  rel="noopener"> Terms of Service</a> apply.
                            </div>
                            <a href="index.jsp" class="table__close">
                                <img src="asssets/img/close-icon.png" alt="">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            <%@include file="asssets/js/inputUser.js" %>
        </script>
    </body>

</html>