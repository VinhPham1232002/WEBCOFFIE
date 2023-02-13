function reSend() {
    reSendLoading(contentLoading);
    var email = document.querySelector(".js-heading-email").innerText.trim();
    $.ajax({
        url: "/Coffie/VerifyController",
        type: "get",
        data: {
            emailVerify: email
        },
        success: function (response) {
            removeReSendLoading();
            document.body.insertAdjacentHTML("beforeend", response);
        }
    });
}

//Change username, gender, image, and address
function changeUser(param) {
    var email = document.querySelector(".js-heading-email").innerText.trim();
    var inputValue;
    var dataChange;
    var controller;

    if (param.classList.contains('js-button-user-name')) {
        inputValue = document.querySelector(".ajax__user-name").value;
        dataChange = document.querySelectorAll(".user_NickName");
        controller = "nickName";
    } else if (param.classList.contains("js-button-gender")) {
        var gender = document.querySelector(".radio.checked").getAttribute("value");
        inputValue = gender;
        dataChange = document.querySelectorAll(".user_gender");
        controller = "gender";
    } else if (param.classList.contains("js-button-image")) {
        var base64Img = document.querySelector(".table__change-img .table__changing-current-image").style.backgroundImage;
        base64Img = base64Img.replace(/^url\(["']?/, '').replace(/["']?\)$/, '');
        inputValue = base64Img;
        dataChange = document.querySelectorAll(".user__avatar");
        controller = "image";
    } else if (param.classList.contains('js-button-address')) {
        inputValue = document.querySelector(".ajax__address").value;
        dataChange = document.querySelectorAll(".user-address");
        controller = "address";
    }
    $.ajax({
        url: "/Coffie/ChangingController",
        type: "post",
        data: {
            inputChange: inputValue,
            email: email,
            controller: controller
        },
        success: function (response) {
            document.querySelector(".table__changing-overlay").click();
            if (controller === "image") {
                for (var i = 0; i < dataChange.length; i++) {
                    dataChange[i].src = response;
                }
            } else {
                for (var i = 0; i < dataChange.length; i++) {
                    dataChange[i].innerText = response;
                }
            }
        }
    });
}

//Change email with verify
function changeUserEmail(target) {
    var email = document.querySelector(".js-heading-email").innerText.trim();

    if (target.classList.contains("js-verify-code")) {
//        var changingEmail = document.querySelector(".table__change.table__changing-email");
//        if(changingEmail != null){
//            changingEmail.remove();
//        }
        reSendLoading(waitingProcess);
        $.ajax({
            url: "/Coffie/SendCodeController",
            type: "post",
            data: {
                email: email
            },
            success: function (response) {
                removeReSendLoading();
                if (document.querySelector(".table__changing-email") != null) {
                    document.querySelector(".table__change-email").remove();
                }
                document.querySelector(".side-bar").insertAdjacentHTML("afterend", changingEmailVerify);
                var tableChange = document.querySelector(".table__changing-email");
                var overLayChangeEmailElement = document.querySelector(".table__changing-email .table__changing-overlay");

                if (window.innerWidth < 769) {
                    if (tableChange.style.display === "none") {
                        tableChange.style.display = "block";
                        document.querySelector(".table__change-email .table__changing-overlay").style.transform = "translateX(-100%)";
                        setTimeout(function () {
                            overLayChangeEmailElement.style.transform = "translateX(0%)";
                            document.querySelector(".table__change-email").remove();
                        }, 300);
                    }
                } else {
                    if (tableChange.style.display === "none") {
                        tableChange.style.display = "block";
                        document.querySelector(".table__change-email").remove();
                    }
                }
            }
        });
    } else if (target.classList.contains("js-send-code")) {
        var inputCode = document.querySelector(".table__changing-email .table__changing-input").value;
        $.ajax({
            url: "/Coffie/VerifyCodeController",
            type: "post",
            data: {
                inputCode: inputCode
            },
            success: function (response) {
                if (response === "True") {
                    document.querySelector(".side-bar").insertAdjacentHTML("afterend", settingNewEmail);
                    var tableChange = document.querySelector(".table__changing-email-verify");
                    var overLayChangeEmailElement = document.querySelector(".table__changing-email-verify .table__changing-overlay");

                    if (window.innerWidth < 769) {
                        if (tableChange.style.display === "none") {
                            tableChange.style.display = "block";
                            document.querySelector(".table__changing-email .table__changing-overlay").style.transform = "translateX(-100%)";
                            setTimeout(function () {
                                overLayChangeEmailElement.style.transform = "translateX(0%)";
                                document.querySelector(".table__changing-email").remove();
                            }, 300);
                        }
                    } else {
                        if (tableChange.style.display === "none") {
                            tableChange.style.display = "block";
                            document.querySelector(".table__changing-email").remove();
                        }
                    }
                } else {
                    var tableInputElement = document.querySelector(".table__changing-input-text");
                    if (!tableInputElement.classList.contains("table__msg-error-color")) {
                        var messageError = `<span class="table__msg-error-text"></span>`;
                        tableInputElement.insertAdjacentHTML("beforeend", messageError);
                        tableInputElement.classList.add("table__msg-error-color");
                        tableInputElement.firstElementChild.innerHTML = " - Code do not match!";
                    }
                }
            }
        });
    } else if (target.classList.contains("js-submit-email")) {
        var newEmailElement = document.querySelectorAll(".table__changing-input")[0];
        var newPasswordElement = document.querySelectorAll(".table__changing-input")[1];
        $.ajax({
            url: "/Coffie/ChangingController",
            type: "post",
            data: {
                inputChange: newEmailElement.value,
                email: email,
                password: newPasswordElement.value,
                controller: "email"
            },
            success: function (response) {
                if (response !== "False") {
                    var dataChange = document.querySelectorAll(".user_email");
                    for (var i = 0; i < dataChange.length; i++) {
                        dataChange[i].innerText = response;
                    }
//                    document.querySelector(".process__verify-link-email").value = response;
                    emailUserElement.innerText = (HiddenTextEmail + "@" + DomainEmail);
                    document.querySelector(".table__changing-overlay").click();
                } else {
                    var tableInputElementEmail = document.querySelectorAll(".table__changing-input-text")[0];
                    var tableInputElement = document.querySelectorAll(".table__changing-input-text")[1];
                    var regexEmail = new RegExp("^\\w+([\\.-]?\\w+)+@\\w+([\\.:]?\\w+)+(\\.[a-zA-Z0-9]{2,3})+$");
                    var messageError = `<span class="table__msg-error-text"></span>`;
                    if (!regexEmail.test(newEmailElement.value)) {
                        tableInputElementEmail.insertAdjacentHTML("beforeend", messageError);
                        tableInputElementEmail.classList.add("table__msg-error-color");
                        tableInputElementEmail.firstElementChild.innerHTML = " - Wrong email!";
                    } else {
                        tableInputElementEmail.classList.remove("table__msg-error-color");
                        tableInputElementEmail.firstElementChild.remove();
                    }

                    if (!tableInputElement.classList.contains("table__msg-error-color")) {
                        tableInputElement.insertAdjacentHTML("beforeend", messageError);
                        tableInputElement.classList.add("table__msg-error-color");
                        tableInputElement.firstElementChild.innerHTML = " - Password do not match!";
                    }
                }
            }
        });

    }
}

function deleteUser(param) {
    var email = document.querySelector(".js-heading-email").innerText.trim();
    var inputValue = document.querySelector(".table__changing-input");
    var controller;

    if (param.classList.contains("js-delete")) {
        controller = "checked";
    }
    setTimeout(function () {
        $.ajax({
            url: "/Coffie/DeleteUserController",
            type: "post",
            data: {
                password: inputValue.value,
                email: email,
                controller: controller
            },
            success: function (response) {
                var tableInputElement = document.querySelector(".table__changing-input-text");
                var messageError = `<span class="table__msg-error-text"></span>`;
                if (response === "TRUE") {
                    tableInputElement.classList.remove("table__msg-error-color");
                    if (tableInputElement.firstElementChild !== null) {
                        tableInputElement.firstElementChild.remove();
                    }
                    document.querySelector(".side-bar").insertAdjacentHTML("afterend", deleteAccountVerify);
                    if (document.querySelector(".table__verify").style.display === "none") {
                        document.querySelector(".table__verify").style.display = "block";
                    }
                } else if (response === "FALSE") {
                    if (!tableInputElement.classList.contains("table__msg-error-color")) {
                        tableInputElement.insertAdjacentHTML("beforeend", messageError);
                        tableInputElement.classList.add("table__msg-error-color");
                        tableInputElement.firstElementChild.innerHTML = " - Password do not match!";
                    }
                } else {
                    window.location.href = "http://localhost:8088/Coffie/index.jsp";
                }
            }
        });
    }, 1500);
}
function purchaseOrder() {
    reSendLoading(contentLoading2);
    var email = document.querySelector(".js-heading-email").innerText.trim();
    var name = document.querySelector(".purchase__product-name").innerHTML;
    var type = document.querySelector(".purchase__product-type").innerHTML;
    var quantity = document.querySelector(".purchase__amount-input").value;
    var price = document.querySelector(".purchase__price-title.on-price").getAttribute("value");
    var shippingCost = document.querySelector(".purchase__price-title.on-ship").getAttribute("value");
    var total = document.querySelector(".purchase__price-title.on-total").innerHTML;
    var image = document.querySelector(".purchase__img-item").getAttribute("src");
    var notifyGroup = document.querySelector(".header__notice-group");
    var orderHistory = document.querySelector(".side-bar__order-collection");
    if (orderHistory !== null) {
        orderHistory.innerHTML = "";
        document.querySelector(".side-bar__order-body").insertAdjacentHTML("afterbegin", optionChooseOrder);
    }
    if (document.querySelector(".side-bar__order-navbar") !== null && document.querySelector(".side-bar__order-search") !== null) {
        document.querySelector(".side-bar__order-navbar").remove();
        document.querySelector(".side-bar__order-search").remove();
    }
    notifyGroup.innerHTML = "";
    $.ajax({
        url: "/Coffie/OrderController",
        type: "post",
        data: {
            nameProduct: name,
            type: type,
            quantity: quantity,
            price: price,
            total: total,
            email: email,
            image: image,
            transportCost: shippingCost,
            update: "notify"
        },
        success: function (response) {
            removeReSendLoading();
            if (document.querySelector(".table__purchase.purchase-accept") === null) {
                document.querySelector(".table__change.purchase").remove();
                document.querySelector(".table__purchase.purchase").remove();
                document.querySelector(".side-bar").insertAdjacentHTML("afterend", tablePurchaseSuccess);
                var tablePurchase = document.querySelector(".table__purchase.purchase-accept");
                var tablePurchaseOverLay = document.querySelector(".table__purchase.purchase-accept .purchase__overlay")
                if (tablePurchase.style.display === "none") {
                    tablePurchase.style.display = "block";
                    setTimeout(function () {
                        tablePurchaseOverLay.style.opacity = "1";
                    }, 175);
                    if (document.querySelector(".header__notice-item.no-order") !== null) {
                        document.querySelector(".header__notice-item.no-order").remove();
                    }
                }
            }
            if (document.querySelector(".side-bar__order-navbar") === null && document.querySelector(".side-bar__order-search") === null) {
                document.querySelector(".side-bar__order-body").insertAdjacentHTML("afterbegin", optionChooseOrder);
            }
            notifyGroup.innerHTML += response;
            var numberOfOrders = document.querySelectorAll(".header__notice-heading");
            var count = 0;
            for (var i = 0; i < numberOfOrders.length; i++) {
                count++;
            }
            if (count === 0) {
                document.querySelector(".header__img-box-number").innerHTML = "";
                document.querySelector(".header__img-box-number").style.backgroundColor = "unset";
            } else {
                var sizeNumber = document.querySelector(".header__notice-product-img").getAttribute("data-size");
                var newCount = count - sizeNumber;
                document.querySelector(".header__img-box-number").innerHTML = "+" + newCount;
                document.querySelector(".header__img-box-number").style.backgroundColor = "#c00";
            }
            $.ajax({
                url: "/Coffie/OrderController",
                type: "post",
                data: {
                    nameProduct: name,
                    type: type,
                    quantity: quantity,
                    price: price,
                    total: total,
                    email: email,
                    image: image,
                    transportCost: shippingCost,
                    update: "order"
                },
                success: function (response) {
                    var orderHistory = document.querySelector(".side-bar__order-collection");
                    orderHistory.innerHTML += response;
                }
            });
        }
    });
}

function rateProduct(target) {
    var selectedStars = document.querySelectorAll(".star-selected");
    for (var i = 0; i < selectedStars.length; i++) {
        selectedStars[i].src = "asssets/img/no-star.png";
    }
    var star = 0;
    if (target.classList.contains("five-star")) {
        star = 5;
    } else if (target.classList.contains("four-star")) {
        star = 4;
    } else if (target.classList.contains("three-star")) {
        star = 3;
    } else if (target.classList.contains("two-star")) {
        star = 2;
    } else {
        star = 1;
    }
    for (var i = 0; i < star; i++) {
        selectedStars[i].src = "asssets/img/star.png";
    }
    var nameProduct = document.querySelector(".side-bar__details-product-name").innerHTML;
    var orderID = document.querySelector(".side-bar__details-order-id").innerHTML;
    var email = document.querySelector(".js-heading-email").innerText.trim();

    $.ajax({
        url: "/Coffie/OrderController",
        type: "post",
        data: {
            nameProduct: nameProduct,
            orderID: orderID,
            email: email,
            update: "rateProduct",
            rate: star
        },
        success: function (response) {
            console.log(response);
            document.querySelector(".side-bar__details-total-rate").innerHTML = response;
        }
    });
}

function cancelOrder(target) {
    var orderID = target.parentNode.parentElement.parentNode.parentElement.parentElement.parentElement.parentNode.offsetParent.children[0].firstElementChild.innerText.substring(7, );
    var backgroundStatus = target.offsetParent.parentElement.parentNode.offsetParent.offsetParent.parentNode.parentNode.children[0].lastElementChild;
    var textStatus = target.offsetParent.parentElement.parentNode.offsetParent.offsetParent.parentNode.parentNode.children[0].lastElementChild.firstElementChild;
    var email = document.querySelector(".js-heading-email").innerText.trim();
    var buttonAction = target.parentNode.parentElement.parentNode.parentElement.parentElement.parentElement.parentNode.offsetParent.children[1].firstElementChild.children[2];
    var description = document.querySelector(".purchase__product-cancelled-input:checked").value;
    var notifyGroup = document.querySelector(".header__notice-group");
    notifyGroup.innerHTML = "";
    reSendLoading(waitingProcess3);
    $.ajax({
        url: "/Coffie/CancelOrderController",
        type: "post",
        data: {
            orderID: orderID,
            email: email,
            description: description,
            controller: "notify"
        },
        success: function (response) {
            removeReSendLoading();
            if (response !== "FALSE") {
                document.querySelector(".purchase__overlay").click();
                backgroundStatus.classList.remove("process");
                textStatus.classList.remove("process");
                backgroundStatus.classList.add("cancelled");
                textStatus.classList.add("cancelled");
                textStatus.innerHTML = "CANCELLED";
                buttonAction.innerHTML = "";
                buttonAction.insertAdjacentHTML("beforeend", cancelButton);
                notifyGroup.innerHTML += response;
                var numberOfOrders = document.querySelectorAll(".header__notice-heading");
                var count = 0;
                for (var i = 0; i < numberOfOrders.length; i++) {
                    count++;
                }
                if (count === 0) {
                    document.querySelector(".header__img-box-number").innerHTML = "";
                    document.querySelector(".header__img-box-number").style.backgroundColor = "unset";
                } else {
                    var sizeNumber = document.querySelector(".header__notice-product-img").getAttribute("data-size");
                    var newCount = count - sizeNumber;
                    document.querySelector(".header__img-box-number").innerHTML = "+" + newCount;
                    document.querySelector(".header__img-box-number").style.backgroundColor = "#c00";
                }

                $.ajax({
                    url: "/Coffie/CancelOrderController",
                    type: "post",
                    data: {
                        orderID: orderID,
                        email: email,
                        description: description,
                        controller: "history"
                    },
                    success: function (response) {
                        var orderHistory = document.querySelector(".side-bar__order-collection");
                        orderHistory.innerHTML = response;
                    }
                });
            }
        }
    });
}

function notifyDelete() {
    var notifyNumber = document.querySelector(".header__img-box-number");

    $.ajax({
        url: "/Coffie/numberOrdersController",
        type: "post",
        data: {
            numberOrders: notifyNumber.innerHTML.substring(1, )
        },
        success: function (response) {
            if (response === "TRUE") {
                notifyNumber.innerHTML = "+";
            }
        }
    });
}

function searchByName(target) {
    var input = target.value;
    var email = document.querySelector(".js-heading-email").innerText.trim();
    var typeOrder = document.querySelector(".side-bar__order-item.active-checked").firstElementChild;
    $.ajax({
        url: "/Coffie/SearchProductController",
        type: "get",
        data: {
            input: input,
            email: email,
            typeOrder: typeOrder.innerHTML
        },
        success: function (response) {
            var orderHistory = document.querySelector(".side-bar__order-collection");
            orderHistory.innerHTML = response;
        }
    });
}

function searchOrderByStatus(target) {
    var status = target.innerText;
    var email = document.querySelector(".js-heading-email").innerText.trim();
    var orderHistory = document.querySelector(".side-bar__order-collection");
    orderHistory.innerHTML = "";
    orderHistory.insertAdjacentHTML("beforeend", waitngProcess1);
    document.querySelector(".side-bar__order-search").style.display = "none";
    setTimeout(function () {
        $.ajax({
            url: "/Coffie/FilterOrdersController",
            type: "get",
            data: {
                status: status,
                email: email
            },
            success: function (response) {
                var onLoading = document.querySelector(".on-loading-process");
                if (onLoading !== null) {
                    onLoading.remove();
                }
                var orderHistory = document.querySelector(".side-bar__order-collection");
                orderHistory.innerHTML = response;
                if (document.querySelector(".appearance__no-order") === null) {
                    document.querySelector(".side-bar__order-search").style.display = "flex";
                }
            }
        });
    }, 1750);
}

function trasnportInformation(orderID) {
    var email = document.querySelector(".js-heading-email").innerText.trim();
    var transportName = document.querySelector(".side-bar__name-transport");
    var productRate = document.querySelector(".side-bar__details-total-rate");
    var starRating = document.querySelectorAll(".star-selected");
    var descriptionDelayed = document.querySelector(".side-bar__details-description-text.on-delayed");
    var descriptionCancelled = document.querySelector(".side-bar__details-description-text.on-cancelled");
    var cancelledTime = document.querySelector(".side-bar__details-order-cancelled");
    var delayedTime = document.querySelector(".side-bar__details-order-delayed");
    var completedTime = document.querySelector(".side-bar__details-order-completed");
    var numberRate = document.querySelector(".side-bar__details-total-number-rate");

    $.ajax({
        url: "/Coffie/TransportController",
        type: "post",
        data: {
            orderID: orderID,
            email: email
        },
        success: function (response) {
            var splitItem = response.toString().split("+");

            transportName.innerHTML = splitItem[0];
            productRate.innerHTML = Number(parseFloat(splitItem[3])).toFixed(1);
            numberRate.innerHTML = splitItem[5];
            if (starRating !== null) {
                var starChecked = Number(parseInt(splitItem[4]));
                for (var i = 0; i < starRating.length; i++) {
                    starRating[i].src = "asssets/img/no-star.png";
                }
                for (var i = 0; i < starChecked; i++) {
                    starRating[i].src = "asssets/img/star.png";
                }
            }
            if (descriptionCancelled !== null && cancelledTime !== null) {
                descriptionCancelled.innerHTML = "Reason: " + splitItem[1];
                cancelledTime.innerHTML = splitItem[2];
            } else if (descriptionDelayed !== null && delayedTime !== null) {
                descriptionDelayed.innerHTML = "Reason: " + splitItem[1];
                delayedTime.innerHTML = splitItem[2];
            } else {
                completedTime.innerHTML = splitItem[2];
            }
        }
    });
}

function updateDashboard(target) {
    var email = document.querySelector(".js-heading-email").innerText.trim();
    $.ajax({
        url: "/Coffie/DashBoardController",
        type: "post",
        data: {
            email: email,
            controller: "history"
        },
        success: function (response) {
            if (response !== "FALSE") {
                if (document.querySelector(".dashboard__table-body-overwrite") == null) {
                    document.querySelector(".dashboard__recent-box").innerHTML = "";
                    document.querySelector(".dashboard__recent-box").insertAdjacentHTML("beforeend", tableBodyContent);
                }
                document.querySelector(".dashboard__table-body-overwrite").innerHTML = response;
            }
            $.ajax({
                url: "/Coffie/DashBoardController",
                type: "post",
                data: {
                    email: email,
                    controller: "achivement"
                },
                success: function (response) {
                    var split = response.toString().split(" ");
                    var numberOfOrders = document.querySelectorAll(".side-bar__details-order-time");
                    numberOfOrders[0].innerHTML = split[0];
                    numberOfOrders[1].innerHTML = split[1];
                    numberOfOrders[2].innerHTML = split[2];
                }
            });
        }
    });
}

function reSendLoading(target) {
    document.body.insertAdjacentHTML("beforeend", target);
}

function removeReSendLoading() {
    document.querySelector(".load.load-verify").remove();
}