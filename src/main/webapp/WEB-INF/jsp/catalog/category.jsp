<%@ include file="../common/top.jsp"%>

<div id="BackLink">
    <button class="return-btn">
        <span>
            <a href="<c:url value="/mainForm"/>">Return to Main Menu</a>
        </span>
    </button>

</div>

<div id="Catalog">

    <h2>${sessionScope.category.name}</h2>

    <table>
        <tr>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${sessionScope.productList}">
            <tr>
                <td>
                   <a href="productForm?productId=${product.productId}">
                           ${product.productId}
                   </a>
                </td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@ include file="../common/bottom.jsp"%>
