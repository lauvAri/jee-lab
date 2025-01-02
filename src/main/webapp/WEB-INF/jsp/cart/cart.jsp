<%@ include file="../common/top.jsp"%>

<div id="BackLink">
    <button class="return-btn">
        <span>
            <a href="mainForm">Return to Main Menu</a>
        </span>
    </button>

</div>

<div id="Catalog-Cart">

    <div id="Cart">
        <h2>Shopping Cart</h2>
        <form action="updateCart" method="post">
            <table id="cart-table">
                <thead>
                    <tr>
                        <th></th>
                        <th><b>Item ID</b></th>
                        <th><b>Product ID</b></th>
                        <th><b>Description</b></th>
                        <th><b>In Stock?</b></th>
                        <th><b>Quantity</b></th>
                        <th><b>List Price</b></th>
                        <th><b>Total Cost</b></th>
                        <th>&nbsp;</th>
                    </tr>
                </thead>


                <tbody>
                    <c:if test="${sessionScope.cart.numberOfItems == 0}">
                        <tr>
                            <td colspan="8"><b>Your cart is empty.</b></td>
                        </tr>
                    </c:if>

                    <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
                        <tr>
                            <td>
                                    ${cartItem.item.descn}
                            </td>
                            <td>
                                <a href="<c:url value="/itemForm?itemId=${cartItem.item.itemId}"/>">${cartItem.item.itemId}</a>
                            </td>
                            <td>${cartItem.item.product.productId}</td>
                            <td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
                                    ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                                    ${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
                            <td>${cartItem.inStock}</td>
                            <td>
                                <input type="text" name="${cartItem.item.itemId}" value="${cartItem.quantity}" id="cartNum" onblur="updateCartNum()">
                            </td>
                            <td><fmt:formatNumber value="${cartItem.item.listPrice}"
                                                  pattern="$#,##0.00" /></td>
                            <td><fmt:formatNumber value="${cartItem.total}"
                                                  pattern="$#,##0.00" /></td>
                            <td>
                                <a href="removeCartItem?workingItemId=${cartItem.item.itemId}" class="Button">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="7">Sub Total:
                            <fmt:formatNumber value="${sessionScope.cart.subTotal}" pattern="$#,##0.00" />
                            <input type="submit" value="Update Cart">
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                </tbody>

            </table>
        </form>

        <c:if test="${sessionScope.cart.numberOfItems > 0}">
            <a href="newOrderForm" class="Button">Proceed to Checkout</a>
        </c:if>
    </div>

    <div id="MyList">
        <c:if test="${sessionScope.loginAccount != null}">
            <c:if test="${!empty sessionScope.loginAccount.listOption}">
                <%@ include file="includeMyList.jsp"%>
            </c:if>
        </c:if>

    </div>
</div>
<script>
    var xhr;
    function updateCartNum(){
        xhr = new XMLHttpRequest();
        var cartNum = document.getElementById("cartNum").value;
        var itemId = document.getElementById("cartNum").name;
        console.log(itemId);
        xhr.onreadystatechange = prossce();
        xhr.open("GET","updateCartAJAX?cartNum=" + cartNum + "&workingItemId=" + itemId,true);
        xhr.send(null);
    }
    function prossce(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                var responseInFo = xhr.responseText;
                //var msg = document.getElementById("cartNum");
                if(responseInFo == "Success"){
                    console.log("Success");
                }else{
                    console.log("Failed");
                }
            }
        }
    }
</script>

<%@ include file="../common/bottom.jsp"%>