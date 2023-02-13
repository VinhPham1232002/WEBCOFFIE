<%-- 
    Document   : login
    Created on : Jun 10, 2022, 8:45:40 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Coffie</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Gloria+Hallelujah&display=swap" rel="stylesheet">
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
        <div class="main">
            <div class="table">
                <div class="table__container">
                    <div class="table__side">
                        <div class="table__img" style="background-image:url('asssets/img/sliceOfLife.png')"></div>
                    </div>
                    <div class="table__box">
                        <div class="table__body">
                            <div class="table__title">
                                <h2 class="table__title-heading">COFFIE</h2>
                                <h3 class="table__title-sub-heading">Spice up your creating process</h3>
                            </div>
                            <form action="LoginController" method="post" onsubmit="return validateFormLogin()">
                                <div class="table__input-field">
                                    <input type="text" name="email" class="table__input js-input-email"
                                           onKeyPress="checkInputUser()" onKeyUp="checkInputUser()"
                                           placeholder="E-mail address" value="" autocomplete="off">
                                </div>
                                <div class="table__input-field">
                                    <input type="password" name="password" class="table__input js-input-password"
                                           onKeyPress="checkInputUser()" onKeyUp="checkInputUser()" placeholder="Password"
                                           value="" autocomplete="off">
                                    <div class="table__password" style="display:inline-block;">
                                        <span class="table__password-icon">
                                            <coffie-icon>
                                                <svg class="table__password-icon-svg" width="24" height="24" fill="none"
                                                     xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                                <path d="M14.5 12a2.5 2.5 0 11-5 0 2.5 2.5 0 015 0z"
                                                      fill="currentColor"></path>
                                                <path fill-rule="evenodd" clip-rule="evenodd"
                                                      d="M1 12c3.143-5.333 6.81-8 11-8s7.857 2.667 11 8c-3.143 5.333-6.81 8-11 8s-7.857-2.667-11-8zm11 4.5a4.5 4.5 0 100-9 4.5 4.5 0 000 9z"
                                                      fill="currentColor"></path>
                                                </svg>
                                            </coffie-icon>
                                        </span>
                                    </div>
                                </div>
                                <ul class="table__input-error" style="margin:12px auto 8px">
                                    <%if(session.getAttribute("message") != null){%>
                                    <li class="table__error-item" style="display:block;">
                                        <%=session.getAttribute("message")%>
                                    </li>
                                    <%session.removeAttribute("message");}%>
                                </ul>
                                <input type="submit" class="table__input-submit" disabled value="Login">
                                <button type="button" class="table__input-forget-btn" style="background-color: #13dfd8;"
                                        onclick="onClickForgetPassword()">Forget your password?</button>
                                <div class="table__seperate">
                                    <div class="seperate__left"></div>
                                    <div class="seperate__middle">or</div>
                                    <div class="seperate__right"></div>
                                </div>
                                <a href="#">
                                    <button type="button" class="table__input-connect">
                                        <i class="table__input-connect-icon ti-google"
                                           style="font-size:25px;color:#1da1f2;"></i>
                                        <span class="table__input-connect-text" style="font-family:var(--Lucida);">
                                            Connect with Google
                                        </span>
                                    </button>                                    
                                </a>
                                <a href="signin.jsp" class="table__sign-in" style="background-color:#61c3bb;">Become a life of Coffie</a>
                            </form>
                            <div class="table__footer">
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

        <%if(session.getAttribute("process") != null){
            if(session.getAttribute("emailReSign") != null && session.getAttribute("process").equals("completed")){
        %>
        <div class="process alert js-process" style="display:none;">
            <div class="processUpdate">
                <div class="processUpdate-box">
                    <div class="processUpdate__text">We're sending an email to your email. Please check your email to
                        continue.</div>
                    <img src="asssets/img/checked.png" class="processUpdate__img" alt="" style="height:28px;width:28px;">
                </div>
            </div>
        </div>
        <%}else{%>
        <div class="process alert js-process" style="display:none;">
            <div class="processUpdate">
                <div class="processUpdate-box" style="background-color:#e79999;border:2px solid #c1734d7a">
                    <div class="processUpdate__text" style="color: #a76943;">Sorry, your coffie account doesn't exist.</div>
                    <img src="asssets/img/close.png" class="processUpdate__img" alt="" style="height:28px;width:28px;">
                </div>
            </div>
        </div>
        <%}session.removeAttribute("process");}%>
        <%if(session.getAttribute("resetStatus") != null){%>
        <div class="process alert js-process" style="display:none;">
            <div class="processUpdate">
                <div class="processUpdate-box">
                    <div class="processUpdate__text">Changed password successfully.</div>
                    <img src="asssets/img/checked.png" class="processUpdate__img" alt="" style="height:28px;width:28px;">
                </div>
            </div>
        </div>
        <%session.removeAttribute("resetStatus");session.removeAttribute("emailReSign");}%>
        <%if(session.getAttribute("statusSignIn") != null){%>
        <div class="process alert js-process" style="display:none;">
            <div class="processUpdate">
                <div class="processUpdate-box">
                    <div class="processUpdate__text">Completed. Welcome to the life of Coffie.</div>
                    <img src="asssets/img/checked.png" class="processUpdate__img" alt="" style="height:28px;width:28px;">
                </div>
            </div>
        </div>
        <%session.removeAttribute("statusSignIn");}%>
        <script src="asssets/js/userStorage.js"></script>
        <script type="text/javascript">
            <%@include file="asssets/js/inputUser.js"%>
        </script>
        <script type="text/javascript">
            <%@include file="asssets/js/login.js" %>
        </script>
    </body>
</html>
