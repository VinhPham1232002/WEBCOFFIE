<%-- 
    Document   : reset
    Created on : Jun 11, 2022, 1:59:21 PM
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
                        <div class="table__img"
                             style="background-image:url('asssets/img/vecteezy_coffee-stain-background_7872862.jpg')"></div>
                    </div>
                    <div class="table__box">
                        <div class="table__body table__reset-body">
                            <div class="table__title">
                                <h1 class="table__title-heading table__reset-heading">COFFIE</h1>
                                <h2 class="table__title-sub-heading table__reset-sub-heading">Changed your password</h2>
                            </div>
                            <form action="resetController" method="post">
                                <div class="table__input-field">
                                    <input type="password" name="newPassword" class="table__input table__reset-input"
                                           placeholder="Your new password" autocomplete="off" value="${currentPassword}">
                                    <p class="table__error-reseting"><span class="table__msg-error-reseting">${messageReseting}</span></p>
                                </div>
                                <input type="submit" class="table__input-submit table__input-reset field-Spacer-Top-24" value="Changed Password">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
