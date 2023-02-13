try{
var emailUserElement = document.querySelector(".js-get-email");
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
}catch(Exception){};



