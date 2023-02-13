<%-- 
    Document   : Appearance
    Created on : Jun 30, 2022, 8:06:45 AM
    Author     : phong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="js-side-bar side-bar__appearance-boxing" value="Appearance"
             style="display:none">
            <div class="side-bar__header color-modifier">
                <div class="side-bar__title">
                    <div class="side-bar__title-heading-box">
                        <h1 class="side-bar__title-heading">Appearance</h1>
                        <div class="side-bar__overview" onclick="closeTabMobile()">
                            <i class="ti-angle-left"></i>
                            <span class="side-bar__overview-text">Overview</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="side-bar__appearance-body field-Spacer-Top-24">
                <div class="side-bar__appearance-group">
                    <div class="side-bar__appearance-message-box">
                        <img src="asssets/img/sorry.gif" alt="" class="side-bar__appearance-gif">
                        <div class="side-bar__appearance-message">
                            <p>"I'm so sorry that you had to comeback in another moment because
                                this
                                content is under maintain. I'll see you very soon, <span class="user_NickName">${user.getNickname()}</span>"
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
