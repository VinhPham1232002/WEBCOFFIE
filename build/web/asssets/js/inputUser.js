var inputPasswordElement = document.querySelector(".table__input[type='password']");
var inputElements = document.querySelectorAll(".table__input");
var submitElement = document.querySelector(".table__input-submit");
var regexEmail = new RegExp("^\\w+([\\.-]?\\w+)+@\\w+([\\.:]?\\w+)+(\\.[a-zA-Z0-9]{2,3})+$");
var regexPassword = new RegExp("^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$");
//Check if user enter user enter anything to account and password input
function checkInputUser() {
    var inputElementAccount = inputElements[0].value;
    var inputElementPassword = inputElements[1].value;
    var checkAccount = document.querySelector('.js-check-email');
    var checkPassword = document.querySelector('.js-check-password');

    try {
        if (inputElementAccount.length > 0 && inputElementAccount !== "" && inputElementPassword.length > 0 && inputElementPassword !== "") {
            submitElement.disabled = false;
        } else {
            submitElement.disabled = true;
        }

        if (inputElementAccount.length > 0 && inputElementAccount !== "" && regexEmail.test(inputElementAccount)) {
            checkAccount.style.display = 'block';
        } else {
            checkAccount.style.display = 'none';
        }

        if (inputElementPassword.length > 0 && inputElementPassword !== "" && regexPassword.test(inputElementPassword)) {
            checkPassword.style.display = 'block';
        } else {
            checkPassword.style.display = 'none';
        }
    } catch (Exception) {
    }
}

//User select gender then show checked in class
function onCheckBox(label) {
    var inputElement = label.previousElementSibling;
    var radioCheckBox = label.lastElementChild;
    var radioCheckBoxCurrent = document.querySelector(".radio.checked");

    if (!inputElement.checked) {
        radioCheckBox.classList.add("checked");
        if (radioCheckBoxCurrent !== null) {
            radioCheckBoxCurrent.classList.remove("checked");
        }
    }
}
//For prevent user change settings to current gender
function onCheckBoxRadio(label) {
    var inputElement = label.previousElementSibling;
    var radioCheckBox = label.lastElementChild;
    var radioCheckBoxCurrent = document.querySelector(".radio.checked");
    var submitElementInput = document.querySelector(".table__changing-submit");
    var currentGender = document.querySelector(".js-gender").innerText.trim();

    if (!inputElement.checked) {
        radioCheckBox.classList.add("checked");
        submitElementInput.disabled = false;
        if (radioCheckBoxCurrent !== null) {
            radioCheckBoxCurrent.classList.remove("checked");
        }
    }

    if (label.innerText.trim() !== currentGender) {
        submitElementInput.disabled = false;
    } else {
        submitElementInput.disabled = true;
    }
}


//Check if user enter all information in info after sign in 
var inputInfoElements = document.querySelectorAll(".js-table__input");
var submitInfoElement = document.querySelector(".js__input-submit");

function checkUserSignIn() {
    var inputElementNickName = inputInfoElements[0].value;
    var inputElementPhone = inputInfoElements[1].value;
    var checkNickName = document.querySelector(".js-nickname");
    var checkPhone = document.querySelector(".js-phone");

    if (inputElementNickName.length > 0 && inputElementNickName !== "" && inputElementPhone.length > 0 && inputElementPhone !== "") {
        if (checkBoxEvent) {
            submitInfoElement.disabled = false;
        } else {
            submitInfoElement.disabled = true;
        }
    } else {
        submitInfoElement.disabled = true;
    }

    if (inputElementNickName.length > 0 && inputElementNickName !== "") {
        checkNickName.style.display = 'block';
    } else {
        checkNickName.style.display = 'none';
    }

    if (inputElementPhone.length > 0 && inputElementPhone !== "") {
        checkPhone.style.display = 'block';
    } else {
        checkPhone.style.display = 'none';
    }

}

function checkBoxEvent() {
    return true;
}

document.querySelectorAll(".table__radio-group input[type=radio]").forEach((input) => {
    input.addEventListener('change', checkBoxEvent);
})

//Show password
var tablePasswordElement = document.querySelector(".table__password-icon-svg");
function showPassword() {
    var showPasswordElement = document.querySelector(".table__input.js-input-password");
    console.log(showPasswordElement.type);
    if (showPasswordElement.type === "password") {
        showPasswordElement.type = "text";
    } else {
        showPasswordElement.type = "password";
    }
}
if (tablePasswordElement !== null) {
    tablePasswordElement.addEventListener("click", showPassword);
}

function form_password_change() {
    var newPasswordElement = document.querySelector(".table__changing-new-text");
    var tableInputElements = document.querySelectorAll(".table__changing-input");
    var confirmPasswordElement = document.querySelector(".table__changing-confirm-text");
    var messageError = `<span class="table__msg-error-text"></span>`;
    var email = document.querySelector(".js-heading-email").innerText.trim();
    var currentPassword = tableInputElements[0];
    var newPassword = tableInputElements[1];
    var confirmPassword = tableInputElements[2];
    var isCorrect = false;

    if (newPasswordElement.firstElementChild === null) {
        newPasswordElement.insertAdjacentHTML("beforeend", messageError);
    }

    if (confirmPasswordElement.firstElementChild === null) {
        confirmPasswordElement.insertAdjacentHTML("beforeend", messageError);
    }

    if (newPassword.value.length === 0) {
        newPasswordElement.classList.add("table__msg-error-color");
        newPasswordElement.firstElementChild.innerHTML = " - Your new password cannot be empty";
    } else {
        newPasswordElement.classList.remove("table__msg-error-color");
        if (newPasswordElement.firstElementChild !== null) {
            newPasswordElement.firstElementChild.remove();
        }
    }


    if (newPassword.value !== confirmPassword.value) {
        confirmPasswordElement.classList.add("table__msg-error-color");
        confirmPasswordElement.firstElementChild.innerHTML = " - Passwords do not match!";
    } else {
        confirmPasswordElement.classList.remove("table__msg-error-color");
        if (confirmPasswordElement.firstElementChild !== null) {
            confirmPasswordElement.firstElementChild.remove();
        }
        if (newPassword.value.length > 0 && newPassword.value.length < 8) {
            if (newPasswordElement.firstElementChild === null) {
                newPasswordElement.insertAdjacentHTML("beforeend", messageError);
            }
            newPasswordElement.classList.add("table__msg-error-color");
            newPasswordElement.firstElementChild.innerHTML = " - Must be 8 or more in length";
        } else if (newPassword.value.length > 0 && !regexPassword.test(newPassword.value)) {
            if (newPasswordElement.firstElementChild === null) {
                newPasswordElement.insertAdjacentHTML("beforeend", messageError);
            }
            newPasswordElement.classList.add("table__msg-error-color");
            newPasswordElement.firstElementChild.innerHTML = " - Password is too weak or common to use";
        } else {
            if (newPasswordElement.firstElementChild !== null && newPassword.value.length > 0) {
                newPasswordElement.firstElementChild.remove();
            }
            if (confirmPasswordElement.firstElementChild !== null) {
                confirmPasswordElement.firstElementChild.remove();
            }
            isCorrect = true;
        }
    }
    console.log(isCorrect);
    if (isCorrect === true) {
        console.log("Hello");
        $.ajax({
            url: "/Coffie/ChangingController",
            type: "post",
            data: {
                inputChange: newPassword.value,
                email: email,
                currentpassword: currentPassword.value,
                controller: "password"
            },
            success: function (response) {
                if (response === "False") {
                    var currentText = document.querySelector(".table__changing-input-text.table__changing-current-text");
                    currentText.insertAdjacentHTML("beforeend", messageError);
                    currentText.classList.add("table__msg-error-color");
                    currentText.firstElementChild.innerHTML = " - Password do not match!";
                } else {
                    document.querySelector(".table__changing-overlay").click();
                }
            }
        });
    }
}

function validateFormUser() {
    var emailValidateEmail = document.querySelector(".js-error-email");
    var passwordValidate = document.querySelector(".js-error-password");
    var isCheckedEmail = false;
    var isCheckPassword = false;
    var inputEmailElement = inputElements[0];
    var inputPasswordElement = inputElements[1];

    if (inputEmailElement.value.length > 0 && inputEmailElement.value !== "" && regexEmail.test(inputEmailElement.value)) {
        isCheckedEmail = true;
    }

    if (inputPasswordElement.value.length > 0 && inputPasswordElement.value !== "" && regexPassword.test(inputPasswordElement.value)) {
        isCheckPassword = true;
    }

    if (isCheckPassword === false && inputPasswordElement.value.length >= 8) {
        passwordValidate.innerHTML = 'This password can be easily guessed by third parties. Please use a combination of uppercase and lowercase letters, numbers, and symbols.';
    } else if (isCheckPassword === false && inputPasswordElement.value.length < 8) {
        passwordValidate.innerHTML = 'Passwords must be between 8 to 20 characters.';
    }

    if (isCheckedEmail && isCheckPassword) {
        emailValidateEmail.style.display = 'none';
        passwordValidate.style.display = 'none';
        inputEmailElement.classList.remove("wrong-info");
        inputPasswordElement.classList.remove("wrong-info");
        return true;
    } else if (isCheckedEmail === false && isCheckPassword === true) {
        emailValidateEmail.style.display = 'block';
        passwordValidate.style.display = 'none';
        inputEmailElement.classList.add("wrong-info");
        inputPasswordElement.classList.remove("wrong-info");
    } else if (isCheckPassword === false && isCheckedEmail === true) {
        passwordValidate.style.display = 'block';
        emailValidateEmail.style.display = 'none';
        inputEmailElement.classList.remove("wrong-info");
        inputPasswordElement.classList.add("wrong-info");
    } else {
        passwordValidate.style.display = 'block';
        emailValidateEmail.style.display = 'block';
        inputEmailElement.classList.add("wrong-info");
        inputPasswordElement.classList.add("wrong-info");
    }
    return false;
}

//Vinh
function validateFormLogin() {
    var loginEmailError = `<p class="table__error-msg js-error-email">Incorrect e-mail address</p>`
    var loginPasswordError = `<p class="table__error-msg js-error-password">Your password must be between 8 and 20 half-width characters.</p>`
    document.querySelector(".table__input-field:first-child").insertAdjacentHTML("beforeend", loginEmailError);
    document.querySelector(".table__input-field:nth-child(2)").insertAdjacentHTML("beforeend", loginPasswordError);
    var inputEmail = document.querySelector(".js-input-email");
    var inputPassword = document.querySelector(".js-input-password");
    var ischeckedEmail = false;
    var ischeckPassword = false;
    var regexEmail = new RegExp("^\\w+([\\.-]?\\w+)+@\\w+([\\.:]?\\w+)+(\\.[a-zA-Z0-9]{2,3})+$");


    var emailValidateEmail = document.querySelector(".js-error-email");
    var passwordValidate = document.querySelector(".js-error-password");

    if (inputEmail.value.length > 0 && inputEmail.value !== "" && regexEmail.test(inputEmail.value)) {
        ischeckedEmail = true;
    }

    if ((inputPassword.value.length >= 8 && inputPassword.value.length <= 20) && inputPassword.value.length !== "") {
        ischeckPassword = true;
    }

    if (ischeckedEmail === true && ischeckPassword === true) {
        inputEmail.classList.remove("wrong-info");
        inputPassword.classList.remove("wrong-info");
        emailValidateEmail.style.display = 'none';
        passwordValidate.style.display = 'none';
        emailValidateEmail.remove();
        passwordValidate.remove();
        return true;
    } else if (ischeckedEmail === false && ischeckPassword === true) {
        inputEmail.classList.add("wrong-info");
        emailValidateEmail.style.display = 'block';
        inputPassword.classList.remove("wrong-info");
        passwordValidate.style.display = 'none';
        passwordValidate.remove();
    } else if (ischeckPassword === false && ischeckedEmail === true) {
        inputEmail.classList.remove("wrong-info");
        emailValidateEmail.style.display = 'none';
        passwordValidate.style.display = 'block';
        inputPassword.classList.add("wrong-info");
        emailValidateEmail.remove();
    } else {
        inputPassword.classList.add("wrong-info");
        passwordValidate.style.display = 'block';
        inputEmail.classList.add("wrong-info");
        emailValidateEmail.style.display = 'block';
    }
    return false;
}
function validate_form() {
    const recaptcha_box_checked = (grecaptcha.getResponse()) ? true : false;
    var captcha = document.querySelector(".js-error-captcha");

    if (recaptcha_box_checked) {
        return true;
    } else {
        captcha.style.display = 'block';
        return false;
    }
}

function checkInputChangeUser(target) {
    var inputUserName = target.value;
    var submitElementInput = document.querySelector(".table__changing-submit");

    if (inputUserName === target.defaultValue || inputUserName.length === 0) {
        submitElementInput.disabled = true;
    } else {
        submitElementInput.disabled = false;
    }
}

function checkInputChangeBothUser() {
    var inputUserName = document.querySelectorAll(".table__changing-input")[0].value;
    var inputPassword = document.querySelectorAll(".table__changing-input")[1].value;
    var submitElementInput = document.querySelector(".table__changing-submit");

    if (inputUserName.length > 0 && inputPassword.length > 0) {
        submitElementInput.disabled = false;
    } else {
        submitElementInput.disabled = true;
    }
}

//Duong
function getImageFile(targetImg) {
//    targetImg -> Đường dẫn của ảnh mà mình upload
//"C:\Users\phong\Downloads\293299870_2578038545664359_7558936964386191200_n.jpg"
    var allowFile = ["jpg", "jpeg", "png", "gif"];
    var isFileCorrect = false;
    var finalChecked = false;
    var fileType = null;
    var reader = new FileReader();

    for (var i of allowFile) {
        if (targetImg.value.includes(i)) {
            isFileCorrect = true;
            fileType = i;
            break;
        }
    }

    document.querySelector(".side-bar").insertAdjacentHTML("afterend", changeImageError);

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
            document.querySelector(".table__changing-current-image").style.backgroundImage = "url(" + event.target.result + ")";
        };
        reader.readAsDataURL(targetImg.files[0]);
        document.querySelector(".table__change-img .table__changing-submit").disabled = false;
        document.querySelector(".table__msg-file").remove();
        return;
    } else {
        if (document.querySelector(".table__change.table__change-img").style.display === "block") {
            document.querySelector(".table__msg-file").style.display = "block";
            document.querySelector(".table__change.table__change-img").style.display = "none";
            document.querySelector(".table__change.table__change-img").remove();
            setTimeout(function () {
                document.querySelector(".table__msg-file .table__changing-box").style.transform = "scale(1)";
            }, 300);
        }
    }
}

function checkBoxInputCancelled(target) {
    var subtmiOrder = document.querySelector(".table__purchase.order-cancelled .purchase__submit-btn");
    var targetInput = target.parentNode.children[0];
    targetInput.checked = true;    

    if (targetInput.checked === true) {
        subtmiOrder.disabled = false;
    }
}