function openOtherOrder(target) {
    var sideBarOtherElements = document.querySelectorAll(".side-bar__order-item");
    for (var i = 0; i < sideBarOtherElements.length; i++) {
        if (!target.classList.contains("active-checked")) {
            sideBarOtherElements[i].classList.remove("active-checked", "checked-theme");
        }
    }
    target.classList.add("active-checked", "checked-theme");
    searchOrderByStatus(target);
}

function openAndCloseNavbar() {
    var sideBarBoxSetting = document.querySelector(".side-bar__box-settings");
    var sideBarMenu = document.querySelector(".side-bar__menu");
    var sideBarContent = document.querySelector(".side-bar__content");
    var extendSetting = document.querySelector(".side-bar__extend-settings");
    var iconExtendSetting = document.querySelector(".side-bar__extend-settings div");

    if (extendSetting.getAttribute('value') === "closeDown") {
        extendSetting.setAttribute('value', "openUp");
        document.querySelector(".side-bar__overlay").style.display = "block";
        sideBarBoxSetting.style.maxWidth = "35%";
        sideBarContent.style.width = "100%";
        sideBarMenu.style.width = "100%";
        iconExtendSetting.style.transform = "rotate(180deg)";
    } else {
        extendSetting.setAttribute('value', "closeDown");
        document.querySelector(".side-bar__overlay").style.display = "none";
        sideBarBoxSetting.style.maxWidth = null;
        sideBarContent.style.width = null;
        sideBarMenu.style.width = null;
        iconExtendSetting.style.transform = null;
    }
}

function openSettings() {
    var sideBarElement = document.querySelector(".side-bar");
    var sideBarContainerElement = document.querySelector(".side-bar__container.on-settings");

    if (window.innerWidth < 769) {
        if (sideBarElement.style.display === 'none') {
            sideBarElement.style.display = 'block';
            sideBarContainerElement.style.display = 'flex';
            sideBarContainerElement.style.opacity = '1';
        }
    } else {
        if (sideBarElement.style.display === 'none') {
            sideBarElement.style.display = 'block';
            sideBarContainerElement.style.display = 'flex';
            sideBarContainerElement.style.opacity = '1';
        }
    }
}

function changeHideSettings() {
    var emailUserElement = document.querySelector(".user_email");
    var emailTextSplit = emailUserElement.innerText.split("@");
    var currentEmailText = emailTextSplit[0].trim();
    var DomainEmail = emailTextSplit[1].trim();
    var HiddenTextEmail = "";

    for (var i in currentEmailText) {
        HiddenTextEmail += "*";
    }
    emailUserElement.innerText = (HiddenTextEmail + "@" + DomainEmail);

    var phoneUserElement = document.querySelector(".js-get-phone");
    var phoneUserTextElement = phoneUserElement.innerText.trim();
    var halfPhoneElement = phoneUserTextElement.substring(0, phoneUserTextElement.length - 4);
    var halfOutPhoneElement = phoneUserTextElement.substring(phoneUserTextElement.length - 4);
    var HiddenTextPhone = "";
    for (var i in halfPhoneElement) {
        HiddenTextPhone += "*";
    }
    phoneUserElement.innerText = (HiddenTextPhone + halfOutPhoneElement);
}

function closeSettings() {
    var sideBarElement = document.querySelector(".side-bar");
    var sideBarContainerElement = document.querySelector(".side-bar__container.on-settings");

    if (window.innerWidth < 769) {
        if (sideBarElement.style.display === 'block') {
            sideBarContainerElement.style.opacity = '0';
            setTimeout(function () {
                sideBarElement.style.display = "none";
                sideBarContainerElement.style.display = 'none';
            }, 275);
        }
    } else {
        if (sideBarElement.style.display === 'block') {
            sideBarContainerElement.style.opacity = '0';
            setTimeout(function () {
                sideBarElement.style.display = "none";
                sideBarContainerElement.style.display = 'none';
            }, 275);
        }
    }
}
var closeButtonElement = document.querySelector(".table__sign-out-btn[type='button']");

function onClickSignOut() {
    document.body.insertAdjacentHTML("beforeend", contentSignOutTableText);
    var tableSignOutElement = document.querySelector(".table__sign-out");
    var overLaySignOutElement = document.querySelector(".table__sign-out-overlay");

    if (tableSignOutElement.style.display === "none") {
        tableSignOutElement.style.display = "block";
        overLaySignOutElement.style.opacity = "1";
    }
}

function closeSignOut() {
    var overLaySignOutElement = document.querySelector(".table__sign-out-overlay");
    var tableSignOutElement = document.querySelector(".table__sign-out");

    if (tableSignOutElement.style.display === "block") {
        overLaySignOutElement.style.opacity = "0";
        setTimeout(function () {
            tableSignOutElement.style.display = 'none';
            tableSignOutElement.remove();
        }, 175);
    }
}

function closeVerify() {
    var overLayVerifyElement = document.querySelector(".table__verify-overlay");
    var tableVerifyElement = document.querySelector(".table__verify");

    if (tableVerifyElement.style.display === "block") {
        overLayVerifyElement.style.opacity = "0";
        setTimeout(function () {
            tableVerifyElement.style.display = 'none';
            tableVerifyElement.remove();
        }, 175);
    }
}

function onClickChangingMobile(target) {
    if (window.innerWidth < 769) {
        if (target.contains(document.querySelector(".js-m-username"))) {
            onClickChanging(document.querySelector(".js-btn-nickname"));
        } else if (target.contains(document.querySelector(".js-m-gender"))) {
            onClickChanging(document.querySelector(".js-btn-gender"));
        } else if (target.contains(document.querySelector(".js-m-email"))) {
            onClickTableChange();
        } else if (target.contains(document.querySelector(".js-m-phone"))) {
            onClickTableChangePhone();
        } else if (target.contains(document.querySelector(".js-m-address"))) {
            onClickChanging(document.querySelector(".js-btn-address"));
        } else {
            return;
        }
    } else {
        return;
    }
}

function onClickChanging(editButton) {
    document.querySelector(".side-bar").insertAdjacentHTML("afterend", contentChangingTableText);
    var tableChangingElement = document.querySelector(".table__changing");
    var overLayChangingElement = document.querySelector(".table__changing-overlay");
    var submitTableChanging = document.querySelector(".table__content .table__changing-submit");

    if (editButton.classList.contains("js-btn-gender")) {
        document.querySelector(".table__changing-heading").innerText = "Change your gender";
        document.querySelector(".table__changing-text").innerText = "Choose your gender";
        document.querySelector(".table__changing-input-box div").innerHTML = fieldSetRadio;
        document.querySelector(".js-side-bar__overview").setAttribute("onclick", "closeChanging()");
        var radioGroups = document.querySelectorAll(".table__radio-group input[type=radio]");
        var currentGender = document.querySelector(".js-gender").innerText.trim();

        if (submitTableChanging.classList.contains("js-button-user-name")) {
            submitTableChanging.classList.remove("js-button-user-name");
        }

        if (submitTableChanging.classList.contains("js-button-address")) {
            submitTableChanging.classList.remove("js-button-address");
        }

        if (!submitTableChanging.classList.contains("js-button-gender")) {
            submitTableChanging.classList.add("js-button-gender");
        }

        for (var i = 0; i < radioGroups.length; i++) {
            if (radioGroups[i].defaultValue === currentGender) {
                radioGroups[i].checked = true;
                radioGroups[i].classList.add("radio-gender-active");
                radioGroups[i].nextElementSibling.children[0].classList.add("checked");
            }
        }
    }

    if (editButton.classList.contains("js-btn-nickname")) {
        var changingInput = document.querySelector(".table__changing-input");
        var nickName = document.querySelector(".js-nickname").innerText.trim();
        changingInput.setAttribute("defaultValue", nickName);
        changingInput.setAttribute("value", nickName);
        changingInput.placeholder = "Enter your username";

        if (submitTableChanging.classList.contains("js-button-gender")) {
            submitTableChanging.classList.remove("js-button-gender");
        }

        if (submitTableChanging.classList.contains("js-button-address")) {
            submitTableChanging.classList.remove("js-button-address");
        }

        if (!submitTableChanging.classList.contains("js-button-user-name")) {
            submitTableChanging.classList.add("js-button-user-name");
        }
    }
    if (editButton.classList.contains("js-btn-address")) {
        var changingInput = document.querySelector(".table__changing-input");
        document.querySelector(".table__changing-heading").innerText = "Change your address";
        document.querySelector(".table__changing-text").innerText = "Please enter your new address";
        document.querySelector(".table__changing-input-text").innerText = "Address";
        changingInput.setAttribute("value", "");
        changingInput.setAttribute("defaultvalue", "");
        changingInput.placeholder = "Enter your address";
        changingInput.value = document.querySelector(".js-get-address").innerHTML.trim();
        if (changingInput.classList.contains("ajax__user-name")) {
            changingInput.classList.remove("ajax__user-name");
            changingInput.classList.add("ajax__address");
        }

        if (submitTableChanging.classList.contains("js-button-gender")) {
            submitTableChanging.classList.remove("js-button-gender");
        }

        if (submitTableChanging.classList.contains("js-button-user-name")) {
            submitTableChanging.classList.remove("js-button-user-name");
        }

        if (!submitTableChanging.classList.contains("js-button-user-name")) {
            submitTableChanging.classList.add("js-button-address");
        }
    }
    if (window.innerWidth < 769) {
        document.querySelector(".table__changing-close").setAttribute("onclick", "");
        if (tableChangingElement.style.display === "none") {
            tableChangingElement.style.display = "block";
            document.querySelector(".side-bar__show-side-bar").style.transform = "translateX(-100%)";
            overLayChangingElement.style.opacity = "1";
            setTimeout(function () {
                overLayChangingElement.style.transform = "translateX(0%)";
            }, 50);
        }
    } else {
        if (editButton.classList.contains("js-btn-nickname") || editButton.classList.contains("js-btn-gender") || editButton.classList.contains("js-btn-address")) {
            document.querySelector(".table__changing-close").setAttribute("onclick", "closeChanging()");
        } else {
            document.querySelector(".table__changing-close").setAttribute("onclick", "closeTableChange()");
        }
        if (tableChangingElement.style.display === "none") {
            tableChangingElement.style.display = "block";
            overLayChangingElement.style.opacity = "1";
        }
    }
}


function closeChanging() {
    var tableChangingElement = document.querySelector(".table__changing");
    var overLayChangingElement = document.querySelector(".table__changing-overlay");

    if (window.innerWidth < 769) {
        if (tableChangingElement.style.display === "block") {
            document.querySelector(".side-bar__show-side-bar").style.transform = "translateX(0%)";
            setTimeout(function () {
                overLayChangingElement.style.transform = "translateX(100%)";
                setTimeout(function () {
                    overLayChangingElement.style.opacity = "0";
                    tableChangingElement.style.display = 'none';
                    tableChangingElement.remove();
                }, 500);
            }, 50);
            return;
        }
    } else {
        if (tableChangingElement.style.display === "block") {
            overLayChangingElement.style.opacity = "0";
            setTimeout(function () {
                tableChangingElement.style.display = 'none';
                tableChangingElement.remove();
            }, 175);
        }
    }
}



function onClickTable() {
    var tableChange = document.querySelector(".table__change");
    var overLayChangeEmailElement = document.querySelector(".table__changing-overlay");

    if (window.innerWidth < 769 && overLayChangeEmailElement.getAttribute("value") !== "js-non-mobile") {
        document.querySelector(".table__changing-close").setAttribute("onclick", "");
        if (tableChange.style.display === "none") {
            document.querySelector(".side-bar__show-side-bar").style.transform = "translateX(-100%)";
            overLayChangeEmailElement.style.opacity = "1";
            tableChange.style.display = "block";
            setTimeout(function () {
                overLayChangeEmailElement.style.transform = "translateX(0%)";
            }, 50);
            return;
        }
    } else {
        if (tableChange.style.display === "none") {
            document.querySelector(".table__changing-close").setAttribute("onclick", "closeTableChange()");
            tableChange.style.display = "block";
            overLayChangeEmailElement.style.opacity = "1";
        }
    }
}

function onClickTableChange() {
    document.querySelector(".side-bar").insertAdjacentHTML("afterend", changeTable);
    document.querySelector(".table__changing-hgl").innerText = document.querySelector(".js-heading-email").innerText.trim();
    onClickTable();
}

function onClickTableChangePhone() {
    document.querySelector(".side-bar").insertAdjacentHTML("afterend", changeTablePhone);
    onClickTable();
}

function onClickTableChangeImage() {
    document.querySelector(".side-bar").insertAdjacentHTML("afterend", changeImage);
    var base64URL = document.querySelector(".side-bar__user-profile-img").src;

    if (window.innerWidth < 769) {
        document.querySelector(".table__change-img .table__changing-close").setAttribute("onclick", "");
    } else {
        document.querySelector(".table__change-img .table__changing-close").setAttribute("onclick", "closeTableChange()");
    }
    document.querySelector(".table__changing-current-image").style.backgroundImage = "url(" + base64URL + ")";
    onClickTable();
}

function onClickTablePassword() {
    document.querySelector(".side-bar").insertAdjacentHTML("afterend", changePassWord);
    onClickTable();
}

function onClickDeleteAccount() {
    document.querySelector(".side-bar").insertAdjacentHTML("afterend", deleteAccount);
    onClickTable();
}

function closeTableChange() {
    var overLayChangeEmailElement = document.querySelector(".table__changing-overlay");
    var tableChange = document.querySelector(".table__change");

    if (window.innerWidth < 769 && overLayChangeEmailElement.getAttribute("value") !== "js-non-mobile") {
        if (tableChange.style.display === "block") {
            document.querySelector(".side-bar__show-side-bar").style.transform = "translateX(0%)";
            setTimeout(function () {
                overLayChangeEmailElement.style.transform = "translateX(100%)";
                setTimeout(function () {
                    overLayChangeEmailElement.style.opacity = "0";
                    tableChange.style.display = 'none';
                    tableChange.remove();
                }, 500);
            }, 50);
            return;
        }
    } else {
        if (tableChange.style.display === "block") {
            overLayChangeEmailElement.style.opacity = "0";
            setTimeout(function () {
                tableChange.style.display = 'none';
                tableChange.remove();
            }, 175);
        }
    }
}

function onclickProduct(target) {
    document.querySelector(".side-bar").insertAdjacentHTML("afterend", buyCart);
    if (!target.classList.contains("side-bar__order-btn-buy")) {
        var tableChange = document.querySelector(".table__change.purchase");
        var overLayChange = document.querySelector(".table__changing-overlay.purchase__overlay");

        if (tableChange.style.display === "none") {
            tableChange.style.display = "block";
            setTimeout(function () {
                overLayChange.style.opacity = "1";
            }, 175);
        }

        var priceBuy = document.querySelector(".purchase__price-title.on-price");
        var totalShip = document.querySelector(".purchase__price-title.on-ship");
        var totalBuy = document.querySelector(".purchase__price-title.on-total");
        var nameProduct = document.querySelector(".purchase__product-name");
        var imageProduct = document.querySelector(".purchase__img img");
        var productType = document.querySelector(".purchase__product-type");
        var address = document.querySelector(".js-get-address").innerHTML.trim();
        var delivaryAddress = document.querySelector(".purchase__delivery-address");

        var nameText = target.offsetParent.children[1];
        var priceText = target.offsetParent.children[0].innerHTML.substring(1, );
        var imageText = target.offsetParent.parentNode.children[0].children[0].src;

        var total = innerHTML = Number(parseFloat(priceText).toFixed(2)) + Number(parseFloat(totalShip.getAttribute("value")).toFixed(2));
        priceBuy.setAttribute("value", parseFloat(priceText).toFixed(2));
        priceBuy.innerHTML = parseFloat(priceText).toFixed(2);
        totalBuy.setAttribute("value", total);
        totalBuy.innerHTML = total;
        productType.innerHTML = nameText.getAttribute("value");
        nameProduct.innerHTML = nameText.innerHTML;
        imageProduct.src = imageText;

        if (address !== "You have not added a address yet.") {
            delivaryAddress.innerHTML = address;
        } else {
            delivaryAddress.innerHTML = "You must add your address in order to continue.";
            document.querySelector(".purchase__submit-btn.on-submit").setAttribute("onclick", "");
            document.querySelector(".purchase__submit-btn.on-submit").style.filter = "brightness(80%)";
            document.querySelector(".purchase__submit-btn.on-submit").style.cursor = "default";
        }
    } else {
        var tableChange = document.querySelector(".table__change.purchase");
        var overLayChange = document.querySelector(".table__changing-overlay.purchase__overlay");

        if (tableChange.style.display === "none") {
            tableChange.style.display = "block";
            setTimeout(function () {
                overLayChange.style.opacity = "1";
            }, 175);
        }

        var priceBuy = document.querySelector(".purchase__price-title.on-price");
        var totalShip = document.querySelector(".purchase__price-title.on-ship");
        var totalBuy = document.querySelector(".purchase__price-title.on-total");
        var nameProduct = document.querySelector(".purchase__product-name");
        var imageProduct = document.querySelector(".purchase__img.on-img-change img");
        var productType = document.querySelector(".purchase__product-type.on-type-change");
        var address = document.querySelector(".js-get-address").innerHTML.trim();
        var delivaryAddress = document.querySelector(".purchase__delivery-address");

        var nameText = target.offsetParent.lastElementChild.children[0].children[0].firstElementChild.children[0].lastElementChild.children[0].innerText;
        var typeText = target.offsetParent.lastElementChild.children[0].children[0].firstElementChild.children[0].lastElementChild.children[1].innerText;
        var imageSrc = target.offsetParent.lastElementChild.children[0].children[0].firstElementChild.children[0].firstElementChild.children[0].src;

        var priceText = target.offsetParent.lastElementChild.children[0].children[0].nextElementSibling.children[1].children[1].children[0].children[0].children[0].children[1].children[1].innerHTML;
        var total = innerHTML = Number(parseFloat(priceText).toFixed(2)) + Number(parseFloat(totalShip.getAttribute("value")).toFixed(2));
        priceBuy.setAttribute("value", parseFloat(priceText).toFixed(2));
        priceBuy.innerHTML = parseFloat(priceText).toFixed(2);
        totalBuy.setAttribute("value", total);
        totalBuy.innerHTML = total;
        productType.innerHTML = typeText;
        nameProduct.innerHTML = nameText;
        imageProduct.src = imageSrc;
        if (address !== "You have not added a address yet.") {
            delivaryAddress.innerHTML = address;
        } else {
            delivaryAddress.innerHTML = "You must add your address in order to continue.";
            document.querySelector(".purchase__submit-btn.on-submit").setAttribute("onclick", "");
            document.querySelector(".purchase__submit-btn.on-submit").style.filter = "brightness(80%)";
            document.querySelector(".purchase__submit-btn.on-submit").style.cursor = "default";
        }
    }
}

function onclickPrice(target) {
    var spinner = jQuery('.quantity'),
            input = spinner.find('input[type="number"]'),
            btnUp = spinner.find('.quantity-up'),
            btnDown = spinner.find('.quantity-down'),
            min = input.attr('min'),
            max = input.attr('max');

    if (target.classList.contains('quantity-up')) {
        var price = document.querySelector(".purchase__price-title.on-price");
        var shipPrice = document.querySelector(".purchase__price-title.on-ship");
        var totalPrice = document.querySelector(".purchase__price-title.on-total");
        var oldValue = parseFloat(input.val());
        var newPrice;
        var newTotal;
        if (oldValue >= max) {
            var newVal = oldValue;
        } else {
            var newVal = oldValue + 1;
        }
        newPrice = price.getAttribute("value") * newVal;
        price.innerText = newPrice.toFixed(2);
        newTotal = Number(parseFloat(newPrice).toFixed(2)) + Number(parseFloat(shipPrice.getAttribute("value")).toFixed(2))
        totalPrice.innerHTML = newTotal.toFixed(2);
        totalPrice.setAttribute("value", "" + newTotal.toFixed(2));
        spinner.find("input").val(newVal);
        spinner.find("input").trigger("change");
    } else {
        var price = document.querySelector(".purchase__price-title.on-price");
        var shipPrice = document.querySelector(".purchase__price-title.on-ship");
        var totalPrice = document.querySelector(".purchase__price-title.on-total");
        var oldValue = parseFloat(input.val());
        var newPrice;
        var newTotal;
        if (oldValue <= min) {
            var newVal = oldValue;
        } else {
            var newVal = oldValue - 1;
        }
        newPrice = price.getAttribute("value") * newVal;
        price.innerText = newPrice.toFixed(2);
        newTotal = Number(parseFloat(newPrice).toFixed(2)) + Number(parseFloat(shipPrice.getAttribute("value")).toFixed(2))
        totalPrice.innerHTML = newTotal.toFixed(2);
        totalPrice.setAttribute("value", "" + newTotal.toFixed(2));
        spinner.find("input").val(newVal);
        spinner.find("input").trigger("change");
    }
}

function onClickPurchase() {
    document.querySelector(".side-bar").insertAdjacentHTML("afterend", buyCartAccept);
    var tablePurchase = document.querySelector(".table__purchase");
    var tablePurchaseOverLay = document.querySelector(".table__purchase .purchase__overlay");

    if (tablePurchase.style.display === "none") {
        tablePurchase.style.display = "block";
        setTimeout(function () {
            tablePurchaseOverLay.style.opacity = "1";
        }, 175);
    }

    var nameProductAlert = document.querySelector(".table__purchase .purchase__product-name");
    var nameProduct = document.querySelector(".table__change.purchase .purchase__product-name");
    var quantity = document.querySelector(".table__purchase .purchase__number");
    var quantityInput = document.querySelector(".purchase__amount-input").value;
    nameProductAlert.innerHTML = nameProduct.innerHTML;
    quantity.innerHTML = quantityInput;
}

function closePurchase() {
    var tablePurchase = document.querySelector(".table__purchase");
    var tablePurchaseOverLay = document.querySelector(".table__purchase .purchase__overlay");
    if (tablePurchase.style.display === "block") {
        tablePurchaseOverLay.style.opacity = "0";
        setTimeout(function () {
            tablePurchase.style.display = "none";
            tablePurchase.remove();
        }, 175);
    }
}

function onclickCancelOrder(target) {
    target.offsetParent.insertAdjacentHTML("beforeend", cancelledMessage);
    var tablePurchase = document.querySelector(".table__purchase");
    var tablePurchaseOverLay = document.querySelector(".table__purchase .purchase__overlay");

    if (tablePurchase.style.display === "none") {
        tablePurchase.style.display = "block";
        setTimeout(function () {
            tablePurchaseOverLay.style.opacity = "1";
        }, 175);
    }
}

function onclickDetails(target) {
    var status = target.offsetParent.firstElementChild.children[2].children[0].innerText;
    var sideBarBody = document.querySelector(".side-bar__order-body");
    
    var orderID;
    if (status === "CANCELLED") {
        sideBarBody.insertAdjacentHTML("beforeend", orderDetailsCancelled);
        orderID = document.querySelector(".side-bar__details-order-id.id-cancelled");
    } else if (status === "COMPLETED") {
        sideBarBody.insertAdjacentHTML("beforeend", orderDetailsSuccess);
        orderID = document.querySelector(".side-bar__details-order-id.id-success");
    } else if (status === "DELAYED") {
        sideBarBody.insertAdjacentHTML("beforeend", detailsDelayed);
        orderID = document.querySelector(".side-bar__details-order-id.id-delayed");
    }

    //Changing Context
    var nameProduct = document.querySelector(".side-bar__details-product-name");
    var typeProduct = document.querySelector(".side-bar__details-product-type");
    var priceProduct = document.querySelector(".side-bar__details-on-price");
    var quantityProduct = document.querySelector(".side-bar__details-on-quantity");
    var totalProduct = document.querySelector(".side-bar__details-on-total");
    var addressProduct = document.querySelector(".side-bar__details-address-text");
    var orderTime = document.querySelectorAll(".side-bar__details-order-time");
    var imageProduct = document.querySelector(".side-bar__details-group-img");
    var shippingProduct = document.querySelector(".side-bar__details-on-shipping");

    var dateOfOrder = target.offsetParent.children[0].children[1].innerText.split(" ");
    var getDay = dateOfOrder[0];
    var getValueMonth = getMonth(dateOfOrder[1].toString().toLowerCase()).toString();
    var getYear = dateOfOrder[2];
    var getTime = dateOfOrder[4];

    if (Number(getDay) < 10) {
        getDay = "0" + getDay;
    }
    if (Number(getValueMonth) < 10) {
        getValueMonth = "0" + getValueMonth;
    }
    var transferDate = getDay + "-" + getValueMonth + "-" + getYear + " " + getTime;

    nameProduct.innerHTML = target.offsetParent.children[1].children[0].firstElementChild.children[0].children[0].lastElementChild.children[0].innerText;
    typeProduct.innerHTML = target.offsetParent.children[1].children[0].firstElementChild.children[0].children[0].lastElementChild.children[1].innerText;
    quantityProduct.innerHTML = target.offsetParent.children[1].children[0].firstElementChild.children[0].children[0].lastElementChild.children[2].innerText;
    addressProduct.innerHTML = target.offsetParent.children[1].children[0].children[1].children[0].children[1].innerText;
    priceProduct.innerHTML = target.offsetParent.children[1].children[0].children[1].children[1].lastElementChild.firstElementChild.children[0].children[0].lastElementChild.innerText.trim();
    totalProduct.innerHTML = target.offsetParent.children[1].children[0].children[1].children[1].lastElementChild.firstElementChild.children[1].children[0].lastElementChild.innerText.trim();
    shippingProduct.innerHTML = "$ " + (Number(parseFloat(totalProduct.innerHTML.substring(2, ))) - Number(parseFloat(priceProduct.innerHTML.substring(2, ))) * Number(parseFloat(quantityProduct.innerHTML.substring(1, )))).toFixed(2);
    orderID.innerHTML = target.offsetParent.children[0].firstElementChild.children[0].innerText.substring(7);
    imageProduct.src = target.offsetParent.children[1].children[0].firstElementChild.children[0].children[0].children[0].children[0].src;
    for (var dateUpdate of orderTime) {
        dateUpdate.innerHTML = transferDate;
    }
    /*AJAX*/
    trasnportInformation(orderID.innerHTML.trim());
    /*Slide Show*/
    var sideBarOrder = document.querySelector(".side-bar__order-details-main");
    var sideBarCollection = document.querySelector(".side-bar__order-collection");
    var navBarCollection = document.querySelector(".side-bar__order-navbar");
    var searchCollection = document.querySelector(".side-bar__order-search");
    var sideBarTitle = document.querySelector(".side-bar__order-boxing .side-bar__title");
    if (sideBarOrder.style.display === "none") {
        sideBarOrder.style.display = "block";
        setTimeout(function () {
            sideBarOrder.style.transform = "translateX(0%)";
            sideBarCollection.style.transform = "translateX(-110%)";
            navBarCollection.style.transform = "translateX(-110%)";
            searchCollection.style.transform = "translateX(-110%)";
            sideBarTitle.style.transform = "translateX(-110%)";
            setTimeout(function () {
                sideBarCollection.style.display = "none";
                navBarCollection.style.display = "none";
                searchCollection.style.display = "none";
                sideBarTitle.style.display = "none";
            }, 500);
        }, 300);
    }
}

function closeDetails() {
    var sideBarOrder = document.querySelector(".side-bar__order-details-main");
    var sideBarCollection = document.querySelector(".side-bar__order-collection");
    var navBarCollection = document.querySelector(".side-bar__order-navbar");
    var searchCollection = document.querySelector(".side-bar__order-search");
    var sideBarTitle = document.querySelector(".side-bar__order-boxing .side-bar__title");

    if (sideBarOrder.style.display === "block") {
        sideBarCollection.style.display = "block";
        navBarCollection.style.display = "flex";
        searchCollection.style.display = "block";
        sideBarTitle.style.display = "block";
        if (window.innerWidth > 768) {
            sideBarOrder.style.transform = "translateX(-110%)";
        } else {
            sideBarOrder.style.transform = "translateX(100%)";
        }

        setTimeout(function () {
            sideBarCollection.style.transform = "translateX(0%)";
            navBarCollection.style.transform = "translateX(0%)";
            searchCollection.style.transform = "translateX(0%)";
            sideBarTitle.style.transform = "translateX(0%)";
            setTimeout(function () {
                sideBarOrder.remove();
                setTimeout(function () {
                    sideBarCollection.style.transform = "unset";
                }, 500)
            }, 300);
        }, 50);
    }
}

function getMonth(monthStr) {
    var getMonth = monthStr.charAt(0).toUpperCase() + monthStr.slice(1);
    return new Date(getMonth + '-1-01').getMonth() + 1;
}

var sideBarMannuals = document.querySelectorAll(".js-side-bar");
var modifiers = document.querySelectorAll(".js-modifier");
var extendSetting = document.querySelector(".side-bar__extend-settings");

function openTab(target) {
    var isSendToMix = false;
    var targetMixIt = null;
    var selectedMixit = null;

    for (var i = 0; i < sideBarMannuals.length; i++) {
        if (sideBarMannuals[i].getAttribute('value') === target.getAttribute('value')) {
            sideBarMannuals[i].style.display = "block";
        } else {
            sideBarMannuals[i].style.display = "none";
        }
    }

    for (var i = 0; i < modifiers.length; i++) {
        if (modifiers[i].classList.contains("selected")) {
            modifiers[i].classList.remove("selected", "selected-theme");
            target.classList.add("selected", "selected-theme");
            if (document.querySelector(".side-bar__overlay").style.display === "block") {
                extendSetting.click();
            }
            break;
        }
    }
    if (target.getAttribute("value") === "Dashboard") {
        updateDashboard(target);
    }

    if (window.innerWidth < 769) {
        document.querySelector(".side-bar__container .side-bar__box-settings").style.transform = "translateX(-100%)";
        phoneUserElement.innerText = (halfPhoneElement + halfOutPhoneElement);
        emailUserElement.innerText = (currentEmailText + "@" + DomainEmail);
    }
}

function closeTabMobile() {
    document.querySelector(".side-bar__container .side-bar__box-settings").style.transform = "translateX(0%)";
}

function closeTab() {
    extendSetting.click();
}

