<%-- 
    Document   : verify
    Created on : Jun 17, 2022, 8:49:38 PM
    Author     : phong
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
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
        <style type="text/css">
            <%@include file="asssets/css/style.css" %>
            <%@include file="asssets/css/base.css" %>
            <%@include file="asssets/css/responsive.css"%>
            <%@include file="asssets/css/table.css"%>
            <%@include file="asssets/css/sidebar.css"%>
        </style>
        <link rel="stylesheet" href="asssets/font/themify-icons/themify-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body>
        <div class="main">
            <div class="table">
                <div class="table__container">
                    <div class="table__side">
                        <div class="table__img" style="background-image:url('asssets/img/coffie-verify.jpg')"></div>
                    </div>
                    <div class="table__box">
                        <div class="table__body table__verify-body-continue">
                            <div class="table__title">
                                <%if(session.getAttribute("subMsg") == null){%>
                                <img src="asssets/img/email_verify_completed.svg" alt="" class="table__verify-continue-img">
                                <%}else{%>
                                <img src="asssets/img/email_verify-not-completed.svg" alt="" class="table__verify-continue-img">
                                <%}%>                                
                                <h2 class="table__title-sub-heading table__reset-sub-heading" style="font-size:25px;">${titleMsg}</h2>
                            </div>
                            <div class="table__input-field">
                                <p class="table__error-reseting" style="margin-bottom:12px;"><span class="table__msg-error-reseting" style="font-size:1rem;">${subMsg}</span></p>
                                <a href="${pathLink}">
                                    <button type="button"
                                            class="table__verify-btn table__verify-continue-btn">
                                        ${buttonMsg}
                                    </button>
                                </a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>