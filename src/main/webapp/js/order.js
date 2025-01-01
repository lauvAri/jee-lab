var xhr;
var shipAddressRequired;
let billDiv = document.getElementById("billAddress");
let shipDiv = document.getElementById("shipAddress");
shipDiv.style.display = "none";

function continueBtnClicked(){
    shipAddressRequired = document.getElementById("shippingAddressRequired").checked;
    console.log(shipAddressRequired);
    console.log("click");
    billDiv.style.display = "none";
    shipDiv.style.display = "block";

    initXhr();
}

function initXhr(){
    xhr = new XMLHttpRequest();
    var cardType = document.getElementById("order.cardType").value;
    var cardNum = document.getElementById("order.creditCard").value;
    var expireDate = document.getElementById("order.expiryDate").value;
    var firstName = document.getElementById("order.billToFirstName").value;
    var lastName = document.getElementById("order.billToLastName").value;
    var address1 = document.getElementById("order.billAddress1").value;
    var address2 = document.getElementById("order.billAddress2").value;
    var city = document.getElementById("order.billCity").value;
    var state = document.getElementById("order.billState").value;
    var zip = document.getElementById("order.billZip").value;
    var country = document.getElementById("order.billCountry").value;

    var queryParams = [
        "order.cardType=" + encodeURIComponent(cardType),
        "order.creditCard=" + encodeURIComponent(cardNum),
        "order.expiryDate=" + encodeURIComponent(expireDate),
        "order.billToFirstName=" + encodeURIComponent(firstName),
        "order.billToLastName=" + encodeURIComponent(lastName),
        "order.billAddress1=" + encodeURIComponent(address1),
        "order.billAddress2=" + encodeURIComponent(address2),
        "order.billCity=" + encodeURIComponent(city),
        "order.billState=" + encodeURIComponent(state),
        "order.billCountry=" + encodeURIComponent(country),
        "order.billZip=" + encodeURIComponent(zip),
        "order.shippingAddressRequired=" + encodeURIComponent(shipAddressRequired),
    ].join("&");

    xhr.onreadystatechange = process();
    // 设置请求方法和 URL
    xhr.open("GET", "orderBillAJAX?" + queryParams, true);
    xhr.send();
}

function process(){
    if (xhr.readyState === 4 && xhr.status === 200) {
        console.log("请求成功:", xhr.responseText);
    } else if (xhr.readyState === 4) {
        console.error("请求失败:", xhr.status, xhr.statusText);
    }
}