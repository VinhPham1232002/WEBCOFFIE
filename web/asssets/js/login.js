function onClickForgetPassword() {
    document.body.insertAdjacentHTML("beforeend", forgetTableElement);
    var tableForgetElement = document.querySelector(".table__forget");
    var overLayForget = document.querySelector(".table__forget-overlay");

    if (tableForgetElement.style.display === "none") {
        tableForgetElement.style.display = "block";
        overLayForget.style.opacity = "1";
    }
}

function closeForgetPassword() {
    var overLayForgetElement = document.querySelector(".table__forget-overlay");
    var tableSignOutElement = document.querySelector(".table__forget");

    if (tableSignOutElement.style.display === "block") {
        overLayForgetElement.style.opacity = "0";
        setTimeout(function () {
            tableSignOutElement.style.display = 'none';
            tableSignOutElement.remove();
        }, 175);
    }
}

/*Vinh*/
function forgetFormValidate() {
    var emailMessageError = `<p class="table__error-msg js-error-forg-email">Incorrect e-mail address</p>`;
    document.querySelector(".table__changing-input-box div").insertAdjacentHTML("beforeend", emailMessageError);

    var regexEmail = new RegExp("^\\w+([\\.-]?\\w+)+@\\w+([\\.:]?\\w+)+(\\.[a-zA-Z0-9]{2,3})+$");
    var isCheckEmail = false;
    var inputEmail = document.querySelector(".js-forg-email");
    var emailValidateEmail = document.querySelector(".js-error-forg-email");

    if (inputEmail.value.length > 0 && inputEmail.value !== "" && regexEmail.test(inputEmail.value)) {
        isCheckEmail = true;
    }

    if (isCheckEmail === true) {
        inputEmail.classList.remove("wrong-info");
        emailValidateEmail.style.display = 'none';
        emailValidateEmail.remove();
        const load = document.getElementById('load');
        load.style.display = 'grid';
        return true;
    } else {
        inputEmail.classList.add("wrong-info");
        emailValidateEmail.style.display = 'block';
    }
    return false;
}

try {
    if (document.querySelector(".js-process").style.display === "none") {
        document.querySelector(".js-process").style.display = "block";
        setTimeout(function () {
            document.querySelector(".js-process").style.transform = "translateY(300px)";
        }, 5000);
    }
} catch (Exception) {
}
;
