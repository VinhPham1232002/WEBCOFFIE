<%-- 
    Document   : Account
    Created on : Jun 30, 2022, 7:58:39 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coffie</title>
    </head>
    <body>
        <div class="js-side-bar side-bar__account-boxing" value="My Account" style="display:block;">
            <div class="side-bar__header color-modifier">
                <div class="side-bar__title">
                    <div class="side-bar__title-heading-box">
                        <h1 class="side-bar__title-heading">My Account</h1>
                        <div class="side-bar__overview" onclick="closeTabMobile()">
                            <i class="ti-angle-left"></i>
                            <span class="side-bar__overview-text">Overview</span>
                        </div>
                    </div>
                </div>
            </div>
            <%if(session.getAttribute("verifyAccount") != null){
                if(session.getAttribute("verifyAccount").equals("UNVERIFY")){
            %>
            <div class="verify">
                <div class="process js-process" style="display:block;">
                    <div class="processUpdate process__verify-update js-process-update">
                        <div class="processUpdate-box processUpdate__verify-box">
                            <img class="process__img" src="asssets/img/warning.png" alt="">
                            <div class="process__verify-box">
                                <div class="processUpdate__text">
                                    <span class="process__message">Please verify your email and follow instructions in order to complete the last step. If you did not receive an email or if it expired, you can resend one.</span>
                                    <span class="process__message-on-mobile">Verify Your Email.</span>
                                </div>
                                <button class="process__verify-link" type="button" onclick="reSend()">
                                    <span class="process__message">Verify your email</span>
                                    <span class="process__message-on-mobile">Verify</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%}else{session.removeAttribute("emailVerify");}}%>
            <div class="side-bar__show-body">
                <div class="side-bar__account">
                    <div class="side-bar__background"></div>
                    <div class="side-bar__user-info">
                        <div class="side-bar__user-avatar">
                            <img src="${user.getBase64Avatar()}" alt="" class="side-bar__avatar-img user__avatar">
                        </div>
                        <div>
                            <div class="side-bar__username-profile">
                                <div class="side-bar__name-tag">
                                    <span class="user-name user_NickName">${user.getNickname()}</span>
                                </div>
                            </div>
                        </div>
                        <button type="button" class="side-bar__edit-btn"
                                onclick="onClickTableChangeImage()">Change Avatar</button>
                    </div>
                    <div class="side-bar_user-image-on-mobile">
                        <h5 class="side-bar__user-header">USER PROFILE</h5>
                        <div class="side-bar__user-profile-background">
                            <div class="side-bar__user-profile">
                                <div class="side-bar__user-profile-boxing" onclick="onClickTableChangeImage()">
                                    <img src="${user.getBase64Avatar()}" alt=""
                                         class="side-bar__user-profile-img user__avatar">
                                    <div class="side-bar__user-profile-icon">
                                        <img src="asssets/img/71581d199cdc2488d0918b917053d8c5.svg"
                                             alt="">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <h5 class="side-bar__user-header field-Spacer-Top-40">ACCOUNT INFORMATION</h5>
                    <div class="side-bar__user-action">
                        <ul class="side-bar__list-action">
                            <li class="side-bar__item-action" onclick="onClickChangingMobile(this)">
                                <div class="side-bar__item-box">
                                    <div class="side-bar__user-name hidden-overflow">
                                        <h5 class="side-bar__user-name-title js-m-username">USERNAME
                                        </h5>
                                        <div>
                                            <div class="side-bar__user-name-text js-nickname user_NickName">
                                                ${user.getNickname()}</div>
                                            <div class="side-bar__item-icon">
                                                <i class="ti-angle-right"
                                                   style="color:var(--black-color);"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="side-bar__action-by-user margin-left-auto">
                                        <button type="button"
                                                class="side-bar__sub-button js-btn-nickname"
                                                onclick="onClickChanging(this)">Edit</button>
                                    </div>
                                </div>
                            </li>
                            <li class="side-bar__item-action field-Spacer-Top-24"
                                onclick="onClickChangingMobile(this)">
                                <div class="side-bar__item-box">
                                    <div class="side-bar__user-name hidden-overflow">
                                        <h5 class="side-bar__user-name-title js-m-gender">Gender
                                        </h5>
                                        <div>
                                            <div class="side-bar__user-name-text user_gender js-gender">${user.getGender()}
                                            </div>
                                            <div class="side-bar__item-icon">
                                                <i class="ti-angle-right"
                                                   style="color:var(--black-color);"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="side-bar__action-by-user margin-left-auto">
                                        <button type="button"
                                                class="side-bar__sub-button js-btn-gender"
                                                onclick="onClickChanging(this)">Edit</button>
                                    </div>
                                </div>
                            </li>
                            <li class="side-bar__item-action field-Spacer-Top-24"
                                onclick="onClickChangingMobile(this)">
                                <div class="side-bar__item-box">
                                    <div class="side-bar__user-name hidden-overflow">
                                        <h5 class="side-bar__user-name-title js-m-address">Address
                                        </h5>
                                        <div>
                                            <div class="side-bar__user-name-text user-address js-get-address">
                                                ${user.getAddress()}
                                            </div>
                                            <div class="side-bar__item-icon">
                                                <i class="ti-angle-right"
                                                   style="color:var(--black-color);"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="side-bar__action-by-user margin-left-auto">
                                        <button type="button"
                                                class="side-bar__sub-button js-btn-address"
                                                onclick="onClickChanging(this)">Edit</button>
                                    </div>
                                </div>
                            </li>
                            <li class="side-bar__item-action field-Spacer-Top-24"
                                onclick="onClickChangingMobile(this)">
                                <div class="side-bar__item-box">
                                    <div class="side-bar__user-name hidden-overflow">
                                        <h5 class="side-bar__user-name-title js-m-email">Email</h5>
                                        <div>
                                            <div class="side-bar__user-name-text js-get-email">
                                                ${user.getEmail()}
                                            </div>
                                            <div class="side-bar__item-icon">
                                                <i class="ti-angle-right"
                                                   style="color:var(--black-color);"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="side-bar__action-by-user margin-left-auto">
                                        <button type="button"
                                                class="side-bar__sub-button js-btn-gmail"
                                                onclick="onClickTableChange()">Edit</button>
                                    </div>
                                </div>
                            </li>
                            <li class="side-bar__item-action field-Spacer-Top-24"
                                onclick="onClickChangingMobile(this)">
                                <div class="side-bar__item-box">
                                    <div class="side-bar__user-name hidden-overflow">
                                        <h5 class="side-bar__user-name-title js-m-phone">Phone
                                            Number</h5>
                                        <div>
                                            <div class="side-bar__user-name-text js-get-phone">
                                                ${user.getPhoneNumber()}</div>
                                            <div class="side-bar__item-icon">
                                                <i class="ti-angle-right"
                                                   style="color:var(--black-color);"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="side-bar__action-by-user margin-left-auto">
                                        <button type="button"
                                                class="side-bar__sub-button js-btn-phone"
                                                onclick="onClickTableChangePhone()">Edit</button>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="side-bar__action-by-user">
                <div class="separate__divider-margin-top field-Spacer-Top-40"></div>
                <h5 class="side-bar__user-header">CHANGED PASSWORD</h5>
                <div class="side-bar__password field-Spacer-Top-40">
                    <div class="side-bar__box flex-container flex-direction-col">
                        <h1 class="side-bar__password-change field-Spacer-Bottom-20">Password</h1>
                        <div class="side-bar__password-box flex-container">
                            <div class="side-bar__password-note field-Spacer-Bottom-20">
                                <div class="side-bar__password-note-text">
                                    <span>
                                        Protect you Coffie account with an extra layer of security.
                                        If you feel your password is unsafe or weren't strong
                                        enough, you can change it
                                        by required to enter your old password and a new password in
                                        order to continue.
                                    </span>
                                </div>
                                <div class="side-bar__edit-box">
                                    <button type="button" onclick="onClickTablePassword()"
                                            class="side-bar__edit-btn">Change
                                        Password</button>
                                </div>
                            </div>
                            <img src="asssets/img/treesure.svg" alt="" class="margin-left-auto">
                        </div>
                    </div>
                </div>
                <div class="separate__divider-margin-top field-Spacer-Top-40">
                    <div class="side-bar__box">
                        <h5 class="side-bar__user-header">ACCOUNT MANAGEMENT</h5>
                        <h5 class="side-bar__removal field-Spacer-Top-40">ACCOUNT REMOVAL</h5>
                        <div class="side-bar__removal-box flex-container flex-direction-col">
                            <div class="side-bar__removal-text">
                                Deleting your account means you cannot access it anymore after
                                taking
                                this
                                action.
                            </div>
                        </div>
                        <div class="side-bar__removal-btn-action">
                            <button type="button" class="side-bar__delete-btn table__hover-default"
                                    onclick="onClickDeleteAccount()">Delete
                                Account</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>    
    </body>
</html>
