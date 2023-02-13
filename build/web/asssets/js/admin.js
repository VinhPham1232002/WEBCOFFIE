document.addEventListener('DOMContentLoaded', function () {
    $.ajax({
        url: "/Coffie/SendSpecialCodeController",
        type: "post",
        success: function (response) {
            console.log(response);
        }
    });
}, false);
function onClickTabAdmin(target) {
    var navbarItems = document.querySelectorAll(".table__navbar-item");
    var targetTab = target.lastElementChild.innerText;
    var adminTab = document.querySelectorAll(".js-admin-tab");

    if (targetTab === "Order" && !target.classList.contains("table__checked-tap")) {
        var orderStatusList = document.querySelector(".js-order-navbar-list");
        orderStatusList.style.transform = "translateX(-110%)";
        setTimeout(function () {
            $.ajax({
                url: "/Coffie/OrderAdminController",
                type: "post",
                data: {
                    controller: "filterStatusOrder",
                    typeOrderStatus: "All"
                },
                success: function (response) {
                    orderStatusList.innerHTML = response;
                    setTimeout(function () {
                        orderStatusList.style.transform = "translateX(0%)";
                    }, 250);
                }
            });
        }, 250);
    } else if (targetTab === "Product" && !target.classList.contains("table__checked-tap")) {
        console.log("Product");
    } else if (targetTab === "Staff" && !target.classList.contains("table__checked-tap")) {
        var loginStaff = document.querySelector(".table__admin-name-staff.staff-email");
        var staffList = document.querySelector(".table__staff-navbar-list");
        staffList.style.transform = "translateX(-110%)";
        setTimeout(function () {
            $.ajax({
                url: "/Coffie/StaffAdminController",
                type: "post",
                data: {
                    controller: "showStaff",
                    loginStaff: loginStaff.innerHTML,
                    typeStaffRole: "All"
                },
                success: function (response) {
                    staffList.innerHTML = response;
                    setTimeout(function () {
                        staffList.style.transform = "translateX(0%)";
                    }, 250);
                }
            });
        }, 250);
    }
    for (var i of adminTab) {
        i.style.display = "none";
    }
    if (targetTab === "") {
        targetTab = "Product";
    }
    document.querySelector("#" + targetTab).style.display = "block";

    for (var i = 0; i < navbarItems.length; i++) {
        if (!target.classList.contains("table__checked-tap")) {
            navbarItems[i].classList.remove("table__checked-tap");
        }
    }
    target.classList.add("table__checked-tap");
}

function openStaffTab(target) {
    var selectors = document.querySelectorAll(".table__staff-navbar-item");
    openTab(target, selectors);
}

function openOrdersTab(target) {
    var selectors = document.querySelectorAll(".table__order-navbar-item");
    openTab(target, selectors);
}

function openProductsTab(target) {
    var selectors = document.querySelectorAll(".table__product-navbar-item");
    openTab(target, selectors);
}

function onClickStatusOrder(target) {
    var selectors = document.querySelectorAll(".table__order-status-group");
    openTab(target, selectors);
}

function openTab(target, selectors) {
    var selectorsElement = selectors;

    for (var i = 0; i < selectorsElement.length; i++) {
        if (!target.classList.contains("active-checked")) {
            selectorsElement[i].classList.remove("active-checked", "checked-theme");
        }
    }
    target.classList.add("active-checked", "checked-theme");
    if (target.classList.contains("js-reject") || target.classList.contains("js-delayed")) {
        document.querySelector(".js-update-status-btn").style.marginTop = "0rem";
        setTimeout(function () {
            document.querySelector(".table__status-message-input").style.transform = "scale(1)";
        }, 200);
    } else {
        document.querySelector(".table__status-message-input").style.transform = "scale(0)";
        setTimeout(function () {
            document.querySelector(".js-update-status-btn").style.marginTop = "-4rem";
        }, 200);
    }
    if (target.classList.contains("js-staff-role")) {
        var staffList = document.querySelector(".table__staff-navbar-list");
        var staffRole = target.firstElementChild.innerText;
        staffList.style.transform = "translateX(-110%)";
        var loginStaff = document.querySelector(".table__admin-name-staff.staff-email");
        setTimeout(function () {
            $.ajax({
                url: "/Coffie/StaffAdminController",
                type: "post",
                data: {
                    controller: "showStaff",
                    loginStaff: loginStaff.innerHTML,
                    typeStaffRole: staffRole
                },
                success: function (response) {
                    staffList.innerHTML = response;
                    setTimeout(function () {
                        staffList.style.transform = "translateX(0%)";
                    }, 250);
                }
            });
        }, 250);
    }

    if (target.classList.contains("js-order-delivery")) {
        var typeOrderStatus = target.firstElementChild.innerText;
        var orderStatusList = document.querySelector(".js-order-navbar-list");
        orderStatusList.style.transform = "translateX(-110%)";

        setTimeout(function () {
            $.ajax({
                url: "/Coffie/OrderAdminController",
                type: "post",
                data: {
                    controller: "filterStatusOrder",
                    typeOrderStatus: typeOrderStatus
                },
                success: function (response) {
                    orderStatusList.innerHTML = response;
                    setTimeout(function () {
                        orderStatusList.style.transform = "translateX(0%)";
                    }, 250);
                }
            });
        }, 250);
    }
    if (target.classList.contains("product-type")) {
        var navbarProduct = document.querySelector(".table__navbar-product .table__navbar-product-main");
        var tableProductBody = document.querySelector(".table__product-body");
        if (navbarProduct.style.marginTop === "0rem") {
            tableProductBody.style.opacity = "0";
            setTimeout(function () {
                tableProductBody.style.display = "none";
            }, 250);
        }
        var typeProduct = target.firstElementChild.innerText;
        var productList = document.querySelector(".js-list-order");
        productList.style.transform = "translateX(110%)";
        setTimeout(function () {
            $.ajax({
                url: "/Coffie/AdminController",
                type: "post",
                data: {
                    controller: "filterProductType",
                    typeProduct: typeProduct
                },
                success: function (response) {
                    productList.innerHTML = response;
                    setTimeout(function () {
                        productList.style.transform = "translateX(0%)";
                    }, 250);
                }
            });
        }, 250);
    }
}

//Scroll Function
var scrollDuration = 300;
var leftPaddle = document.getElementsByClassName('table__product-arrow-left');
var rightPaddle = document.getElementsByClassName('table__product-arrow-right');
var itemsLength = $('.table__product-main-item').length;
var itemSize = $('.table__product-main-item').outerWidth(true);
var paddleMargin = 20;

var getMenuWrapperSize = function () {
    return $('.table__product-main').outerWidth();
};

var menuWrapperSize = getMenuWrapperSize();
$(window).on('resize', function () {
    menuWrapperSize = getMenuWrapperSize();
});
var menuVisibleSize = menuWrapperSize;

var getMenuSize = function () {
    return itemsLength * itemSize;
};
var menuSize = getMenuSize();
var menuInvisibleSize = menuSize - menuWrapperSize;

var getMenuPosition = function () {
    return $('.table__product-main-list').scrollLeft();
};

$('.table__product-main').on('scroll', function () {
    menuInvisibleSize = menuSize - menuWrapperSize;
    var menuPosition = getMenuPosition();
    var menuEndOffset = menuInvisibleSize - paddleMargin;

    if (menuPosition <= paddleMargin) {
        $(leftPaddle).addClass('hidden');
        $(rightPaddle).removeClass('hidden');
    } else if (menuPosition < menuEndOffset) {
        $(leftPaddle).removeClass('hidden');
        $(rightPaddle).removeClass('hidden');
    } else if (menuPosition >= menuEndOffset) {
        $(leftPaddle).removeClass('hidden');
        $(rightPaddle).addClass('hidden');
    }
});
// Scroll to Right
$(rightPaddle).on('click', function () {
    $('.table__product-main-list').animate({
        scrollLeft: getMenuPosition() + 800
    }, scrollDuration);
    var result = getMenuPosition() + 800;
    $(leftPaddle).css('opacity', '1');
    $('.table__product-main').css('-webkit-mask', 'linear-gradient(to right, transparent, rgb(0, 0, 0) 72px) 0px 0px');
    if (getMenuPosition() + 1600 >= getMenuSize()) {
        $(rightPaddle).css('opacity', '0');
        $('.table__product-main-box').css('-webkit-mask', 'unset');
    }
});

// Scroll to Left
$(leftPaddle).on('click', function () {
    $('.table__product-main-list').animate({
        scrollLeft: getMenuPosition() - 800
    }, scrollDuration);
    $(rightPaddle).css('opacity', '1');
    $('.table__product-main-box').css('-webkit-mask', '');
    var result = getMenuPosition() - 800;
    $('.table__product-main-box').css('-webkit-mask', 'linear-gradient(to right, rgb(0, 0, 0) calc(100% - 125px), transparent)');
    if (getMenuPosition() - 800 <= 0) {
        $(leftPaddle).css('opacity', '0');
        $('.table__product-main').css('-webkit-mask', 'unset');
    }
});

function onClickOrderView(target) {
    var tableChange = document.querySelector(".table__admin-settings-up.add-order");
    var overLayOrderElement = document.querySelector(".table__admin-settings-overlay");

    var updateName = document.querySelector(".js-update-name");
    var updateType = document.querySelectorAll(".js-update-type option");
    var updatePrice = document.querySelector(".js-update-price");
    var updateImage = document.querySelector(".table__order-group-product-image");
    var getName = document.querySelector(".table__product-data.on-name");
    var getType = document.querySelector(".table__product-data.on-type");
    var getPrice = document.querySelector(".table__product-data.on-price");
    var getImage = document.querySelector(".table__product-main-img");

    if (target.classList.contains("js-delete-product")) {
        tableChange = document.querySelector(".table__admin-settings-up.delete-order");
        overLayOrderElement = document.querySelector(".table__admin-settings-up.delete-order .table__admin-settings-overlay");
        document.querySelector(".table__admin-settings-up.delete-order .table__main-product-name.on-product").innerText = getName.innerText;
        document.querySelector(".table__admin-settings-up.delete-order .table__order-user-img").src = getImage.src;
    }

    if (target.classList.contains("js-update-status")) {
        tableChange = document.querySelector(".table__admin-settings-up.update-order-status");
        overLayOrderElement = document.querySelector(".table__admin-settings-up.update-order-status .table__admin-settings-overlay");
        var getIdOrder = target.parentNode.children[0].parentElement.previousElementSibling.previousElementSibling.parentElement.parentNode.previousElementSibling.previousElementSibling.previousElementSibling.children[0].innerHTML.substring(6);
        var itemOrder = target.parentNode.parentElement.parentElement.parentNode;
        itemOrder.classList.add("update-selected");
        document.querySelector(".js-order-status-id").innerHTML = "Update Order Status " + getIdOrder;
        var statusList = document.querySelectorAll(".table__order-status");
        for (var status of statusList) {
            status.classList.remove("current-status");
        }
        target.offsetParent.children[0].children[1].lastElementChild.classList.add("current-status");
    }

    if (target.classList.contains("js-update-staff")) {
        tableChange = document.querySelector(".table__admin-settings-up.add-staff");
        overLayOrderElement = document.querySelector(".table__admin-settings-up.add-staff .table__admin-settings-overlay");
        if (target.classList.contains("js-new-staff")) {
            viewStaff(target);
        } else {
            viewStaff(target);
        }
        var staffList = document.querySelectorAll(".table__staff-list-item");
        for (var staff of staffList) {
            staff.classList.remove("checked-staff-current");
        }
        target.parentNode.parentElement.parentElement.parentNode.classList.add("checked-staff-current");
    }

    if (target.classList.contains("js-remove-staff")) {
        tableChange = document.querySelector(".table__admin-settings-up.remove-staff");
        overLayOrderElement = document.querySelector(".table__admin-settings-up.remove-staff .table__admin-settings-overlay");
    }

    if (target.classList.contains("js-add-new") || target.classList.contains("js-update-product")) {
        var producrSubmit = document.querySelector(".table__order-action-btn.js-save-product");
        var priceTitle = document.querySelector(".table__settings-up-title.price");
        priceTitle.style.color = "";
        producrSubmit.disabled = true;
        if (!target.classList.contains("js-add-new")) {
            for (var type of updateType) {
                if (type.getAttribute("value") === getType.innerText) {
                    type.selected = true;
                }
            }
            producrSubmit.classList.add("update-product");
            updateName.value = getName.innerText;
            updatePrice.value = getPrice.innerText;
            updateImage.src = getImage.src;
            if (updatePrice.classList.contains("wrong-info")) {
                updatePrice.classList.remove("wrong-info");
                updatePrice.placeholder = "Price";
            }
            document.querySelector(".table__order-title").innerText = "Update Product";
        } else {
            for (var type of updateType) {
                type.selected = false;
            }
            updateName.value = "";
            updatePrice.value = "$0.00";
            updateImage.src = "asssets/img/open-box.png";
            if (updatePrice.classList.contains("wrong-info")) {
                updatePrice.classList.remove("wrong-info");
                updatePrice.placeholder = "Price";
            }
            if (producrSubmit.classList.contains("update-product")) {
                producrSubmit.classList.remove("update-product");
            }
            document.querySelector(".table__order-title").innerText = "New Product";
        }
    }

    if (tableChange.style.display === "none") {
        tableChange.style.display = "block";
        setTimeout(function () {
            overLayOrderElement.style.opacity = "1";
        }, 175);
    }
}

function closeOrderView() {
    var overLayChangeEmailElement = document.querySelectorAll(".table__admin-settings-overlay");
    var tableChanges = document.querySelectorAll(".table__admin-settings-up");
    var storeQuery;

    for (var tableChange of tableChanges) {
        if (tableChange.style.display === "block") {
            storeQuery = tableChange;
            for (var overlay of overLayChangeEmailElement) {
                overlay.style.opacity = "0";
            }
        }
    }
    setTimeout(function () {
        storeQuery.style.display = 'none';
//        tableChange.remove();
    }, 175);
    var displayImage = document.querySelector(".table__order-group-product-image");

    if (displayImage.classList.contains("checked-image")) {
        displayImage.classList.remove("checked-image");
    }

    var orderListItem = document.querySelectorAll(".table__order-list-item");

    for (var order of orderListItem) {
        order.classList.remove("update-selected");
    }
}

function viewStaff(target) {
    var setTitleStaff = document.querySelector(".js-staff-action-title");
    var setStaffName = document.querySelector(".js-staff-name");
    var setStaffIimage = document.querySelector(".table__staff-group-product-image");
    var setStaffDoB = document.querySelector(".js-staff-birth");
    var setStaffGenderValue = document.querySelector(".js-staff-gender");
    var setStaffGender = document.querySelectorAll(".js-staff-gender option");
    var setStaffRoleValue = document.querySelector(".js-staff-role-selected");
    var setStaffRole = document.querySelectorAll(".js-staff-role-selected option");
    var setStaffPhone = document.querySelector(".js-staff-phone");
    var setStaffAddress = document.querySelector(".js-staff-address");
    var setStaffEmail = document.querySelector(".js-staff-email");
    var staffSubmit = document.querySelector(".staff-submit");

    if (!target.classList.contains("js-new-staff")) {
        var getRole = target.parentElement.previousElementSibling.children[0].lastElementChild.innerText;
        var getGender = target.parentElement.previousElementSibling.children[1].lastElementChild.innerText;
        var getDoB = target.parentElement.previousElementSibling.children[2].lastElementChild.innerText.split("-");
        var getPhone = target.parentElement.previousElementSibling.children[3].lastElementChild.innerText;
        var getAddress = target.parentElement.previousElementSibling.children[4].lastElementChild.innerText;
        var getName = target.parentElement.previousElementSibling.previousElementSibling.children[0].innerText;
        var getEmail = target.parentElement.previousElementSibling.previousElementSibling.children[1].innerText;
        var getImage = target.parentElement.previousElementSibling.previousElementSibling.parentElement.previousElementSibling;

        setTitleStaff.innerHTML = "Update Staff";
        setStaffName.value = getName;
        setStaffName.setAttribute("defaultValue", getName);
        setStaffIimage.src = getImage.src;
        setStaffDoB.value = getDoB[2] + "-" + getDoB[1] + "-" + getDoB[0];
        setStaffDoB.setAttribute("defaultValue", getDoB[2] + "-" + getDoB[1] + "-" + getDoB[0]);
        for (var gender of setStaffGender) {
            if (gender.getAttribute("value") === getGender) {
                gender.selected = true;
                setStaffGenderValue.setAttribute("defaultValue", gender.getAttribute("value"));
                break;
            }
        }
        for (var role of setStaffRole) {
            if (role.getAttribute("value") === getRole) {
                role.selected = true;
                setStaffRoleValue.setAttribute("defaultValue", role.getAttribute("value"));
                break;
            }
        }
        setStaffPhone.value = getPhone;
        setStaffPhone.setAttribute("defaultValue", getPhone);
        setStaffAddress.value = getAddress;
        setStaffAddress.setAttribute("defaultValue", getAddress);
        setStaffEmail.value = getEmail;
        setStaffEmail.setAttribute("defaultValue", getEmail);
        staffSubmit.classList.add("js-submit-staff");
        staffSubmit.setAttribute("onclick", "updateStaff(this)");
    } else {
        setTitleStaff.innerHTML = "Add Staff";
        setStaffName.value = "";
        setStaffName.setAttribute("defaultValue", "");
        setStaffIimage.src = "asssets/img/question-person.png";
        setStaffDoB.value = "";
        setStaffDoB.setAttribute("defaultValue", "");

        for (var gender of setStaffGender) {
            gender.selected = false;
            setStaffGenderValue.setAttribute("defaultValue", "");
        }
        for (var role of setStaffRole) {
            role.selected = false;
            setStaffRoleValue.setAttribute("defaultValue", "");
        }
        setStaffPhone.value = "";
        setStaffPhone.setAttribute("defaultValue", "");
        setStaffAddress.value = "";
        setStaffAddress.setAttribute("defaultValue", "");
        setStaffEmail.value = "";
        setStaffEmail.setAttribute("defaultValue", "");
        staffSubmit.classList.remove("js-submit-staff");
        staffSubmit.setAttribute("onclick", "newStaff(this)");
    }
}

function orderSelect(target) {
    var listProduct = document.querySelectorAll(".table__product-main-item");
    for (var i of listProduct) {
        if (i.classList.contains("active-list")) {
            i.classList.remove("active-list");
        }
    }
    target.classList.add("active-list");
    var productName = target.children[1].children[0];
    var productID = target.children[1].children[1];
    var productImage = target.children[0].src;

    var navbarProduct = document.querySelector(".table__navbar-product .table__navbar-product-main");
    var tableProductBody = document.querySelector(".table__product-body");
    var setProductName = document.querySelector(".table__product-data.on-name");
    var setMainProductName = document.querySelector(".table__main-product-name");
    var setProductType = document.querySelector(".table__product-data.on-type");
    var setMainProductType = document.querySelector(".table__main-product-type");
    var setProductPrice = document.querySelector(".table__product-data.on-price");
    var setProductRate = document.querySelector(".table__product-data.on-rate");
    var setProductCreateTime = document.querySelector(".table__product-data.on-create");
    var setProductCreater = document.querySelector(".table__product-data.on-creater");
    var setProductID = document.querySelector(".table__admin-introduced-title.on-product-id");
    var setImageProduct = document.querySelector(".table__product-main-img.on-img-product");
    var setProductUpdateTime = document.querySelector(".table__product-data.on-update");
    var setProductUpdater = document.querySelector(".table__product-data.on-updater");
    var setTotalDay = document.querySelector(".table__product-data.on-total-day");
    var setTotalMonth = document.querySelector(".table__product-data.on-total-month");
    var setTotalYear = document.querySelector(".table__product-data.on-total-year");
    var setTotalSpend = document.querySelector(".table__product-data.on-total");
    var setProcessProduct = document.querySelector(".table__product-data.on-order-process");
    var setCancelledProduct = document.querySelector(".table__product-data.on-order-cancelled");
    var setCompletedProduct = document.querySelector(".table__product-data.on-order-completed");
    var setDelayedProduct = document.querySelector(".table__product-data.on-order-delayed");

    if (navbarProduct.style.marginTop === "4rem") {
        navbarProduct.style.marginTop = "0rem";
        tableProductBody.style.display = "grid";
        setTimeout(function () {
            tableProductBody.style.opacity = "1";
        }, 500);
    } else {
        tableProductBody.style.opacity = "0";
        navbarProduct.style.marginTop = "4rem";
        setTimeout(function () {
            navbarProduct.style.marginTop = "0rem";
            setTimeout(function () {
                tableProductBody.style.display = "grid";
                setTimeout(function () {
                    tableProductBody.style.opacity = "1";
                }, 300);
            }, 300);
        }, 500);
    }
    setTimeout(function () {
        $.ajax({
            url: "/Coffie/AdminController",
            type: "post",
            data: {
                productName: productName.innerText,
                productID: productID.innerText.substring(9, ),
                controller: "showProduct"
            },
            success: function (response) {
                var split = response.split("+");
                for (var i = 0; i < split.length; i++) {
                    if (split[i] === "null") {
                        split[i] = "-";
                    }
                }
                setProductName.innerHTML = split[0];
                setMainProductName.innerHTML = split[0];
                setProductType.innerHTML = split[1];
                setMainProductType.innerHTML = split[1];
                setProductPrice.innerHTML = "$" + split[2];
                setProductRate.innerHTML = split[3];
                setProductCreateTime.innerHTML = split[4];
                setProductCreater.innerHTML = split[5];
                setProductID.innerHTML = "Product Number #" + split[6];
                setProductUpdater.innerHTML = split[7];
                setProductUpdateTime.innerHTML = split[8];
                setTotalDay.innerHTML = split[9];
                setTotalMonth.innerHTML = split[10];
                setTotalYear.innerHTML = split[11];
                setTotalSpend.innerHTML = split[12];
                setProcessProduct.innerHTML = split[13];
                setCancelledProduct.innerHTML = split[14];
                setCompletedProduct.innerHTML = split[15];
                setDelayedProduct.innerHTML = split[16];
                setImageProduct.src = productImage;
            }
        });
    }, 250);
}

function getImageFileProduct(targetImg) {
    var allowFile = ["jpg", "jpeg", "png"];
    var isFileCorrect = false;
    var finalChecked = false;
    var fileType = null;
    var reader = new FileReader();
    var displayImage = document.querySelector(".table__order-group-product-image");

    for (var i of allowFile) {
        if (targetImg.value.includes(i)) {
            isFileCorrect = true;
            fileType = i;
            break;
        }
    }

    document.querySelector(".table__admin").insertAdjacentHTML("afterend", changeImageError);

    if (isFileCorrect === true) {
        if (targetImg.files[0].size >= 8000000) {
            document.querySelector(".table__msg-file .table__changing-heading").innerText = "Your files are two powerful";
            document.querySelector(".table__msg-file .table__changing-sub-heading").innerText = "The max file size is 8MB";
        } else {
            finalChecked = true;
        }
    } else {
        document.querySelector(".table__msg-file .table__changing-heading").innerText = "Your files are not supported";
        document.querySelector(".table__msg-file .table__changing-sub-heading").innerText = "Files must be a jpg, jpeg, and png file";
    }

    if (finalChecked === true) {
        reader.onload = function (event) {
            displayImage.src = event.target.result;
            displayImage.classList.add("checked-image");
            checkProductInput();
        };
        reader.readAsDataURL(targetImg.files[0]);
        document.querySelector(".table__msg-file").remove();
        return;
    } else {
        document.querySelector(".table__msg-file").style.display = "block";
        displayImage.classList.remove("checked-image");
        checkProductInput();
        setTimeout(function () {
            document.querySelector(".table__msg-file .table__changing-box").style.transform = "scale(1)";
        }, 300);
    }
}

function getImageFileStaff(targetImg) {
    var allowFile = ["jpg", "jpeg", "png", "gif"];
    var isFileCorrect = false;
    var finalChecked = false;
    var fileType = null;
    var reader = new FileReader();
    var displayImage = document.querySelector(".table__staff-group-product-image");

    for (var i of allowFile) {
        if (targetImg.value.includes(i)) {
            isFileCorrect = true;
            fileType = i;
            break;
        }
    }

    document.querySelector(".table__admin").insertAdjacentHTML("afterend", changeImageError);

    if (isFileCorrect === true) {
        if (targetImg.files[0].size >= 8000000) {
            document.querySelector(".table__msg-file .table__changing-heading").innerText = "Your files are two powerful";
            document.querySelector(".table__msg-file .table__changing-sub-heading").innerText = "The max file size is 8MB";
        } else {
            finalChecked = true;
        }
    } else {
        document.querySelector(".table__msg-file .table__changing-heading").innerText = "Your files are not supported";
        document.querySelector(".table__msg-file .table__changing-sub-heading").innerText = "Files must be a jpg, jpeg, png, and gif file";
    }

    if (finalChecked === true) {
        reader.onload = function (event) {
            displayImage.src = event.target.result;
            displayImage.classList.add("checked-image");
            checkStaffInput();
        };
        reader.readAsDataURL(targetImg.files[0]);
        document.querySelector(".table__msg-file").remove();
        return;
    } else {
        document.querySelector(".table__msg-file").style.display = "block";
        displayImage.classList.remove("checked-image");
        checkStaffInput();
        setTimeout(function () {
            document.querySelector(".table__msg-file .table__changing-box").style.transform = "scale(1)";
        }, 300);
    }
}

function checkStaffInput() {
    var StaffName = document.querySelector(".js-staff-name").value;
    var StaffIimage = document.querySelector(".table__staff-group-product-image");
    var StaffDoB = document.querySelector('.js-staff-birth').value;
    var StaffGender = $(".js-staff-gender").val();
    var StaffRole = $(".js-staff-role-selected").val();
    var StaffPhone = document.querySelector(".js-staff-phone").value;
    var StaffAddress = document.querySelector(".js-staff-address").value;
    var StaffEmail = document.querySelector(".js-staff-email").value;
    var staffSubmit = document.querySelector(".staff-submit");

    var checkedForAddNew = StaffName.length > 0 && StaffGender !== "Gender" &&
            StaffRole !== "Role" && StaffDoB.length > 0 &&
            StaffPhone.length > 0 && StaffAddress.length > 0
            && StaffEmail.length > 0;

    var checkedForUpdate = StaffName !== $(".js-staff-name").attr("defaultValue")
            || StaffGender !== $(".js-staff-gender").attr("defaultValue")
            || StaffRole !== $(".js-staff-role-selected").attr("defaultValue")
            || StaffDoB !== $(".js-staff-birth").attr("defaultValue")
            || StaffPhone !== $(".js-staff-phone").attr("defaultValue")
            || StaffAddress !== $(".js-staff-address").attr("defaultValue")
            || StaffEmail !== $(".js-staff-email").attr("defaultValue");

    if (staffSubmit.classList.contains("js-submit-staff")) {
        if (checkedForUpdate || StaffIimage.classList.contains("checked-image")) {
            staffSubmit.disabled = false;
        } else {
            staffSubmit.disabled = true;
        }
    } else {
        if (checkedForAddNew && StaffIimage.classList.contains("checked-image")) {
            staffSubmit.disabled = false;
        } else {
            staffSubmit.disabled = true;
        }
    }
}
function checkProductInput() {
    var productNameInput = document.querySelector(".js-update-name");
    var productTypeInput = $(".js-update-type").val();
    var productPriceInput = document.querySelector(".js-update-price");
    var producrSubmit = document.querySelector(".table__order-action-btn.js-save-product");
    var productImage = document.querySelector(".table__order-group-product-image");
    var checked = productNameInput.value.length > 0 && productTypeInput !== "Type" && productPriceInput.value.length > 0;

    if (producrSubmit.classList.contains("update-product")) {
        if (checked || productImage.classList.contains("checked-image")) {
            producrSubmit.disabled = false;
        } else {
            producrSubmit.disabled = true;
        }
    } else {
        if (checked && productImage.classList.contains("checked-image")) {
            producrSubmit.disabled = false;
        } else {
            producrSubmit.disabled = true;
        }
    }
}

function saveProduct(target) {
    var emailStaff = document.querySelector(".table__admin-name-staff.staff-email").innerHTML;
    var productNameInput = document.querySelector(".js-update-name");
    var productTypeInput = $(".js-update-type").val();
    var productPriceInput = document.querySelector(".js-update-price");
    var productImage = document.querySelector(".table__order-group-product-image");
    var split = productImage.src.toString().split(",");
    var controller;
    var allowFile = ["jpg", "jpeg", "png"];
    var fileType;
    for (var i of allowFile) {
        if (split[0].includes(i)) {
            isFileCorrect = true;
            fileType = i;
            break;
        }
    }
    var productList = document.querySelector(".js-list-order");
    var navbarProduct = document.querySelector(".table__navbar-product .table__navbar-product-main");
    var tableProductBody = document.querySelector(".table__product-body");
    if (navbarProduct.style.marginTop === "0rem") {
        tableProductBody.style.opacity = "0";
        navbarProduct.style.marginTop = "4rem";
        setTimeout(function () {
            tableProductBody.style.display = "none";
        }, 250);
    }

    if (target.classList.contains("update-product")) {
        controller = "updateProduct";
    } else {
        controller = "addProduct";
        productList.style.transform = "translateX(110%)";
    }
    setTimeout(function () {
        $.ajax({
            url: "/Coffie/AdminController",
            type: "post",
            data: {
                productName: productNameInput.value,
                productTypeInput: productTypeInput,
                productPriceInput: productPriceInput.value,
                productImage: split[1],
                imageType: fileType,
                emailStaff: emailStaff,
                controller: controller
            },
            success: function (response) {
                if (response === "Done") {
                    document.querySelector(".table__admin-settings-overlay").click();
                    setTimeout(function () {
                        document.querySelector(".table__product-main-item.active-list").click();
                    }, 250);
                } else {
                    if (response !== "Error") {
                        productList.innerHTML = response;
                        setTimeout(function () {
                            productList.style.transform = "translateX(0%)";
                        }, 250);
                    } else {
                        productPriceInput.classList.add("wrong-info");
                        productPriceInput.value = "";
                        productPriceInput.setAttribute("placeholder", "Enter a real number price");
                        var priceTitle = document.querySelector(".table__settings-up-title.price");
                        priceTitle.style.color = "rgb(255, 43, 0)";
                        setTimeout(function () {
                            productList.style.transform = "translateX(0%)";
                        }, 250);
                    }
                }
            }
        });
    }, 250);
}

function loginStaff() {
    var onSizeLoadingBackGround = document.querySelector(".loading-sceen__seperate");
    var staffInputEmail = document.querySelector(".js-staff-input-name");
    var staffInputPassword = document.querySelector(".js-staff-input-password");
    var jsProductType = document.querySelector(".js-list-order");
    var loadingLoginInput = document.querySelectorAll(".loading-screen__input");
    for (var loginInput of loadingLoginInput) {
        loginInput.classList.remove("loading-screen__login-error");
    }
    jsProductType.style.transform = "translateX(-110%)";
    $.ajax({
        url: "/Coffie/LoginAdminController",
        type: "post",
        data: {
            email: staffInputEmail.value,
            password: staffInputPassword.value
        },
        success: function (response) {
            if (response !== "FALSE") {
                var loadingOnSizeElement = document.querySelector(".loading-screen-background.on-size-fixed");
                loadingOnSizeElement.innerHTML = response;

                var staffLoginName = document.querySelector(".staff-name");
                var staffLoginEmail = document.querySelector(".staff-email");
                var staffLoginImage = document.querySelectorAll(".staff-img");
                for (var staffImg of staffLoginImage) {
                    staffImg.src = document.querySelector(".welcone-staff-img").src;
                }
                document.querySelector(".logout-staff-img").src = document.querySelector(".welcone-staff-img").src;
                staffLoginName.innerHTML = document.querySelector(".welcome-staff-name").innerHTML;
                document.querySelector(".logout-staff-name").innerHTML = document.querySelector(".welcome-staff-name").innerHTML;
                staffLoginEmail.innerHTML = staffInputEmail.value;
                if (onSizeLoadingBackGround.style.bottom === "47rem") {
                    onSizeLoadingBackGround.style.bottom = "0rem";
                    setTimeout(function () {
                        onSizeLoadingBackGround.style.left = "0rem";
                        onSizeLoadingBackGround.style.transform = "translateX(0%)";
                        onSizeLoadingBackGround.style.maxWidth = "100%";
                        document.querySelector(".js-login-loading").style.opacity = "1";
                        document.querySelector(".welcome-staff-name").style.marginTop = "0rem";
                        document.querySelector(".welcone-staff-img").style.width = "150px";
                        document.querySelector(".welcone-staff-img").style.height = "150px";
                        document.querySelector(".js-navbar-checked-tap").click();
                        setTimeout(function () {
                            document.querySelector(".loading-screen__login-screen").style.display = "none";
                            document.querySelector(".loading-screen__login-screen").remove();
                            setTimeout(function () {
                                onSizeLoadingBackGround.style.left = "50%";
                                document.querySelector(".js-login-loading").style.opacity = "0";
                                document.querySelector(".welcome-staff-name").style.marginTop = "-4rem";
                                onSizeLoadingBackGround.style.transform = "translateX(-50%)";
                                document.querySelector(".welcone-staff-img").style.width = "100px";
                                document.querySelector(".welcone-staff-img").style.height = "100px";
                                onSizeLoadingBackGround.style.maxWidth = "9rem";
                                setTimeout(function () {
                                    onSizeLoadingBackGround.style.bottom = "47rem";
                                    setTimeout(function () {
                                        jsProductType.style.transform = "translateX(0%)";
                                    }, 1000);
                                }, 1000);
                            }, 1500);
                        }, 550);
                    }, 1000);
                }
            } else {
                var loginInput = document.querySelectorAll(".loading-screen__input");
                for (var input of loginInput) {
                    input.classList.add("loading-screen__login-error");
                }
            }
        }
    });
}

function adminSettings() {
    var adminNavbar = document.querySelector(".table__admin-navbar");

    if (adminNavbar.style.height === "0px") {
        adminNavbar.style.height = "6rem";
        setTimeout(function () {
            adminNavbar.style.left = "0px";
            adminNavbar.style.width = "18rem";
        }, 500)
    }
}

function closeAdminSettings() {
    var adminNavbar = document.querySelector(".table__admin-navbar");

    if (adminNavbar.style.height === "6rem") {
        adminNavbar.style.width = "1px";
        adminNavbar.style.left = "1rem";
        setTimeout(function () {
            adminNavbar.style.height = "0px";
        }, 500);
    }
}

function DeleteProduct(target) {
    var productID = document.querySelector(".table__admin-introduced-title.on-product-id").innerHTML;
    var productName = document.querySelector(".table__main-product-name.on-product");
    var splitItem = productID.toString().split("#");
    var productList = document.querySelector(".js-list-order");
    var navbarProduct = document.querySelector(".table__navbar-product .table__navbar-product-main");
    var tableProductBody = document.querySelector(".table__product-body");
    if (navbarProduct.style.marginTop === "0rem") {
        tableProductBody.style.opacity = "0";
        setTimeout(function () {
            tableProductBody.style.display = "none";
        }, 250);
    }
    setTimeout(function () {
        $.ajax({
            url: "/Coffie/AdminController",
            type: "post",
            data: {
                productID: splitItem[1],
                productName: productName.innerHTML,
                controller: "deleteProduct"
            },
            success: function (response) {
                document.querySelector(".table__admin-settings-overlay").click();
                document.querySelector(".js-type-all").click();
            }
        });
    }, 250);
}

function searchProduct(target) {
    var input = target.value;
    var productList = document.querySelector(".js-list-order");
    var typeProduct = document.querySelector(".table__product-navbar-item.active-checked span").innerHTML;
    $.ajax({
        url: "/Coffie/AdminController",
        type: "post",
        data: {
            input: input,
            typeProduct: typeProduct,
            controller: "searchProduct"
        },
        success: function (response) {
            productList.innerHTML = response;
        }
    });
}

function searchOrderByID(target) {
    var input = target.value;
    var orderList = document.querySelector(".js-order-navbar-list");
    var typeOrderStatus = document.querySelector(".table__order-navbar-item.active-checked span").innerHTML;
    $.ajax({
        url: "/Coffie/OrderAdminController",
        type: "post",
        data: {
            inputOrder: input,
            typeOrderStatus: typeOrderStatus,
            controller: "searchOrder"
        },
        success: function (response) {
            orderList.innerHTML = response;
        }
    });
}

function updateOrder() {
    var orderID = document.querySelector(".js-order-status-id").innerText.split("#");
    var statusUpdate = document.querySelector(".table__order-status");
    var description = document.querySelector(".table__order-send-input.order-update").value;
    var statusGroup = document.querySelector(".table__order-status-group.active-checked").lastElementChild;
    var selectedOrder = document.querySelector(".table__order-list-item.update-selected");
    var getOrderID = orderID[1];

    var statusDelivery = ["process", "cancelled", "delayed", "completed"];
    for (var status of statusDelivery) {
        if (statusUpdate.classList.contains(status)) {
            statusUpdate.classList.remove(status);
        }
    }

    $.ajax({
        url: "/Coffie/OrderAdminController",
        type: "post",
        data: {
            orderID: getOrderID,
            statusUpdate: statusGroup.innerHTML,
            description: description,
            controller: "updateStatus"
        },
        success: function (response) {
            if (response !== "FAILED") {
                selectedOrder.innerHTML = response;
                document.querySelector(".table__admin-settings-overlay").click();
            }
        }
    });
}

function updateStaff(target) {
    var StaffName = document.querySelector(".js-staff-name").value;
    var StaffIimage = document.querySelector(".table__staff-group-product-image").src;
    var StaffDoB = document.querySelector('.js-staff-birth').value;
    var StaffGender = $(".js-staff-gender").val();
    var StaffRole = $(".js-staff-role-selected").val();
    var StaffPhone = document.querySelector(".js-staff-phone").value;
    var StaffAddress = document.querySelector(".js-staff-address").value;
    var StaffEmail = document.querySelector(".js-staff-email").value;
    var staffItem = document.querySelector(".checked-staff-current");

    var isSamePerson = false;
    if (document.querySelector(".staff-email").innerText === StaffEmail) {
        isSamePerson = true;
    }

    $.ajax({
        url: "/Coffie/StaffAdminController",
        type: "post",
        data: {
            StaffName: StaffName,
            StaffIimage: StaffIimage,
            StaffDoB: StaffDoB,
            StaffGender: StaffGender,
            StaffRole: StaffRole,
            StaffPhone: StaffPhone,
            StaffAddress: StaffAddress,
            StaffEmail: StaffEmail,
            controller: "updateStaff"
        },
        success: function (response) {
            if (response !== "FAILED") {
                staffItem.innerHTML = response;
                document.querySelector(".table__admin-settings-overlay").click();
                if (isSamePerson === true) {
                    document.querySelector(".staff-email").innerHTML = document.querySelector(".on-staff.on-email").innerHTML;
                    document.querySelector(".staff-name").innerHTML = document.querySelector(".on-staff.on-staff-name").innerHTML;
                    var staffImg = document.querySelectorAll(".staff-img");
                    for (var img of staffImg) {
                        img.src = document.querySelector(".table__staff-user-img").src;
                    }
                }
            } else {
                console.log(response);
            }
        }
    });
}

function newStaff(target) {
    var StaffName = document.querySelector(".js-staff-name").value;
    var StaffIimage = document.querySelector(".table__staff-group-product-image").src;
    var StaffDoB = document.querySelector('.js-staff-birth').value;
    var StaffGender = $(".js-staff-gender").val();
    var StaffRole = $(".js-staff-role-selected").val();
    var StaffPhone = document.querySelector(".js-staff-phone").value;
    var StaffAddress = document.querySelector(".js-staff-address").value;
    var StaffEmail = document.querySelector(".js-staff-email").value;
    var staffAll = document.querySelector(".js-staff-all");

    $.ajax({
        url: "/Coffie/StaffAdminController",
        type: "post",
        data: {
            StaffName: StaffName,
            StaffIimage: StaffIimage,
            StaffDoB: StaffDoB,
            StaffGender: StaffGender,
            StaffRole: StaffRole,
            StaffPhone: StaffPhone,
            StaffAddress: StaffAddress,
            StaffEmail: StaffEmail,
            controller: "newStaff"
        },
        success: function (response) {
            if (response !== "FAILED") {
                document.querySelector(".table__admin-settings-overlay").click();
                staffAll.click();
            } else {
                console.log(response);
            }
        }
    });
}

function searchStaffByName(target) {
    var input = target.value;
    var orderList = document.querySelector(".table__staff-navbar-list");
    var typeStaffRole = document.querySelector(".table__staff-navbar-item.active-checked span").innerHTML;
    var loginStaff = document.querySelector(".table__admin-name-staff.staff-email");
    $.ajax({
        url: "/Coffie/StaffAdminController",
        type: "post",
        data: {
            inputStaff: input,
            loginStaff: loginStaff.innerHTML,
            typeStaffRole: typeStaffRole,
            controller: "searchStaff"
        },
        success: function (response) {
            orderList.innerHTML = response;
        }
    });
}

function logoutStaff(target) {
    var loadingScreen = document.querySelector(".loading-sceen__seperate.on-logout");
    if (loadingScreen.style.bottom === "47rem") {
        loadingScreen.style.bottom = "0rem";
        loadingScreen.style.right = "0";
        setTimeout(function () {
            loadingScreen.style.left = "0";
            loadingScreen.style.maxWidth = "100%";
            document.querySelector(".logout-staff-name").style.marginTop = "0rem";
            document.querySelector(".js-logout-loading").style.opacity = "1";
            document.querySelector(".logout-staff-img").width = "";
            document.querySelector(".logout-staff-img").height = "";
            setTimeout(function () {
                loadingScreen.style.left = "75%";
                loadingScreen.style.right = "";
                loadingScreen.style.maxWidth = "9rem";
                document.querySelector(".logout-staff-name").style.marginTop = "-4rem";
                document.querySelector(".js-logout-loading").style.opacity = "0";
                document.querySelector(".logout-staff-img").width = "100px";
                document.querySelector(".logout-staff-img").height = "100px";
                document.querySelector(".loading-screen").insertAdjacentHTML("beforeend", storageLogin);
                document.querySelector(".loading-screen__login-screen").style.display = "block";
                setTimeout(function () {
                    loadingScreen.style.bottom = "47rem";
                    setTimeout(function () {
                        loadingScreen.style.left = "";
                        loadingScreen.style.right = "";
                    }, 750);
                }, 750);
            }, 1500);
        }, 500);
    }

    $.ajax({
        url: "/Coffie/StaffAdminController",
        type: "post",
        data: {
            controller: "logoutStaff"
        },
        success: function (response) {
            closeAdminSettings();
        }
    });
}

function forgetStaff() {
    var loadingForget = document.querySelector(".loading-sceen__seperate.on-forget");
    var forgetTitle = document.querySelector(".js-forget-loading");
    var loadingForgetOverlay = document.querySelector(".loading-screen__overlay.on-forget");
    var loadingForgetAction = document.querySelector(".loading-screen__forget-action");
    forgetTitle.innerHTML = "Forget Password";

    if (loadingForget.style.right === "100%") {
        loadingForget.style.right = "0%";
        loadingForgetOverlay.style.right = "0%";
        setTimeout(function () {
            loadingForget.style.maxHeight = "35%";
            forgetTitle.style.marginTop = "4rem";
            loadingForgetAction.style.opacity = "1";
        }, 1500);
    }
}

function closeStaff() {
    var loadingForget = document.querySelector(".loading-sceen__seperate.on-forget");
    var forgetTitle = document.querySelector(".js-forget-loading");
    var loadingForgetAction = document.querySelector(".loading-screen__forget-action");
    var loadingForgetOverlay = document.querySelector(".loading-screen__overlay.on-forget");

    if (loadingForget.style.right === "0%") {
        forgetTitle.style.marginTop = "8.5rem";
        loadingForget.style.maxHeight = "6rem";
        loadingForgetAction.style.opacity = "0";
        setTimeout(function () {
            loadingForget.style.right = "100%";
            loadingForgetOverlay.style.right = "100%";
        }, 1000);
    }
}

function changeStaffPassword(target) {
    var forgetTitle = document.querySelector(".js-forget-loading");
    var loadingForget = document.querySelector(".loading-sceen__seperate.on-forget");
    var changePassWordLayout = document.querySelector(".js-change-password");
    var resetPassWordLayout = document.querySelector(".js-reset-password");
    var inputBox = document.querySelector(".loading-screen__input-box");
    var loadingTitle = document.querySelector(".loading-screen__heading.js-forget-loading");
    var loadingForgetAction = document.querySelector(".loading-screen__forget-action");
    var specialLayout = document.querySelector(".js-staff-special-code");
    var loadingSubmit = document.querySelector(".js-loading-submit");
    var loadingInput = document.querySelectorAll(".js-staff-forget");

    for (var inputField of loadingInput) {
        inputField.classList.remove("loading-screen__login-error");
        inputField.value = "";
    }
    loadingTitle.style.opacity = "0";
    if (target.classList.contains("js-staff-change")) {
        loadingSubmit.classList.add("js-staff-change");
        loadingSubmit.classList.remove("js-staff-reset");
        specialLayout.style.display = "none";

        setTimeout(function () {
            loadingTitle.innerHTML = "Change Password";
            if (changePassWordLayout.style.marginLeft === "0px") {
                changePassWordLayout.style.marginLeft = "50%";
                changePassWordLayout.style.transform = "translate(-10%)";
                resetPassWordLayout.style.opacity = "0";
                loadingTitle.style.opacity = "1";
                document.querySelector(".js-staff-reset-password").style.display = "block";
            }
        }, 200);
    } else {
        loadingSubmit.classList.add("js-staff-reset");
        loadingSubmit.classList.remove("js-staff-change");
        specialLayout.style.display = "block";
        setTimeout(function () {
            loadingTitle.innerHTML = "Reset Password";
            if (changePassWordLayout.style.marginLeft === "0px") {
                resetPassWordLayout.style.marginRight = "50%";
                resetPassWordLayout.style.transform = "translate(10%)";
                changePassWordLayout.style.opacity = "0";
                loadingTitle.style.opacity = "1";
                document.querySelector(".js-staff-reset-password").style.display = "none";
            }
        }, 200);
    }

    setTimeout(function () {
        resetPassWordLayout.style.opacity = "0";
        changePassWordLayout.style.opacity = "0";
        loadingForgetAction.style.visibility = "hidden";
        loadingForget.style.maxHeight = "100%";
        loadingForget.style.top = "0%";
        loadingForget.style.transform = "translateX(0%)";
        loadingForget.style.transform = "translateY(0%)";
        forgetTitle.style.marginTop = "0rem";
        setTimeout(function () {
            inputBox.style.visibility = "visible";
            inputBox.style.opacity = "1";
        }, 800);
    }, 800);
}

function staffChange(target) {
    var staffEmail = document.querySelector(".js-staff-input-email").value;
    var staffPassWord = document.querySelector(".js-staff-reset-new").value;
    var loadingTitle = document.querySelector(".loading-screen__heading.js-forget-loading");
    var loadingInput = document.querySelectorAll(".js-staff-forget");
    var loadingForget = document.querySelector(".loading-sceen__seperate.on-forget");
    var inputBox = document.querySelector(".loading-screen__input-box");
    var loadingForgetAction = document.querySelector(".loading-screen__forget-action");
    var changePassWordLayout = document.querySelector(".js-change-password");
    var resetPassWordLayout = document.querySelector(".js-reset-password");
    var isSuccess = false;
    if (target.classList.contains("js-staff-change")) {
        var staffNewPassword = document.querySelector(".js-staff-reset-password").value;
        $.ajax({
            url: "/Coffie/ChangeStaffPassword",
            type: "post",
            data: {
                staffEmail: staffEmail,
                staffPassWord: staffPassWord,
                staffNewPassword: staffNewPassword,
                controller: "changePassword"
            },
            success: function (response) {
                if (response !== "FAILED") {
                    loadingTitle.style.opacity = "0";
                    setTimeout(function () {
                        loadingTitle.innerHTML = "Change Password Successfully";
                        for (var inputField of loadingInput) {
                            inputField.classList.remove("loading-screen__login-error");
                        }
                        loadingTitle.style.opacity = "1";
                    }, 200);
                    loadingForget.style.top = "";
                    closeStaff();
                    isSuccess = true;
                } else {
                    for (var inputField of loadingInput) {
                        inputField.classList.add("loading-screen__login-error");
                    }
                }
            }
        });
    } else {
        var staffSpecialCode = document.querySelector(".js-staff-special-code").value;
        $.ajax({
            url: "/Coffie/ChangeStaffPassword",
            type: "post",
            data: {
                staffEmail: staffEmail,
                staffNewPassword: staffNewPassword,
                staffSpecialCode: staffSpecialCode,
                controller: "resetPassWord"
            },
            success: function (response) {
                if (response !== "FAILED") {
                    loadingTitle.style.opacity = "0";
                    setTimeout(function () {
                        loadingTitle.innerHTML = "Reset Password Successfully";
                        for (var inputField of loadingInput) {
                            inputField.classList.remove("loading-screen__login-error");
                        }
                        loadingTitle.style.opacity = "1";
                    }, 200);
                    loadingForget.style.top = "";
                    closeStaff();
                    isSuccess = true;
                } else {
                    for (var inputField of loadingInput) {
                        inputField.classList.add("loading-screen__login-error");
                    }
                }
            }
        });
    }
    if (isSuccess === true) {
        inputBox.style.visibility = "";
        inputBox.style.opacity = "0";
        loadingForget.style.transform = "";
        loadingForgetAction.style.visibility = "";
        setTimeout(function () {
            changePassWordLayout.style.opacity = "1";
            resetPassWordLayout.style.opacity = "1";
            resetPassWordLayout.style.marginRight = "0%";
            changePassWordLayout.style.marginLeft = "0";
            changePassWordLayout.style.transform = "translate(0%)";
        }, 500);
    }
}

function closeChangeStaff() {
    var forgetTitle = document.querySelector(".js-forget-loading");
    var loadingForget = document.querySelector(".loading-sceen__seperate.on-forget");
    var changePassWordLayout = document.querySelector(".js-change-password");
    var resetPassWordLayout = document.querySelector(".js-reset-password");
    var specialLayout = document.querySelector(".js-staff-special-code");
    var inputBox = document.querySelector(".loading-screen__input-box");
    var loadingTitle = document.querySelector(".loading-screen__heading.js-forget-loading");
    var loadingForgetAction = document.querySelector(".loading-screen__forget-action");

    resetPassWordLayout.style.marginRight = "0%";
    loadingTitle.style.opacity = "0";
    setTimeout(function () {
        loadingForgetAction.style.visibility = "visible";
        loadingTitle.innerHTML = "Forget Password";
        loadingTitle.style.opacity = "1";
        loadingForget.style.top = "45%";
        loadingForget.style.transform = "";
        loadingForget.style.transform = "";
        inputBox.style.visibility = "";
        inputBox.style.opacity = "0";
        forgetTitle.style.marginTop = "";
        loadingForget.style.maxHeight = "35%";
        changePassWordLayout.style.marginLeft = "0";
        changePassWordLayout.style.transform = "translate(0%)";
        forgetTitle.style.marginTop = "4rem";
        setTimeout(function () {
            changePassWordLayout.style.opacity = "1";
            resetPassWordLayout.style.opacity = "1";
            specialLayout.style.display = "none";
        }, 100);
    }, 200);
}
