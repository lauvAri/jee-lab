<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>

<div id="BackLink">
    <a href="/mainForm">Return to Main Menu</a>
</div>

<div id="Catalog">

    <c:if test="${requestScope.productList != null && requestScope.productList.size() >= 1}">
        <table>
            <h1>searching for me?</h1>
            <tr>
                <th>&nbsp;</th>
                <th>Product ID</th>
                <th>Name</th>
            </tr>
            <c:forEach var="product" items="${requestScope.productList}">
                <tr>
                    <td>
                        <a href="/productForm?productId=${product.productId}">${product.description}</a>
                    </td>
                    <td>
                        <b>
                            <a href="/productForm?productId=${product.productId}">${product.productId}</a>
                        </b>
                    </td>
                    <td>${product.name}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${!(requestScope.productList != null && requestScope.productList.size() >= 1)}">
        <p style="color:red;font-size:26px">Oops! No matched result.🤔</p>
        <p style="color:green">We are sorry there is no ${requestScope.searchKeyword} in our store</p>
        <a href="#">You can contact us for more information</a>
    </c:if>

</div>

<%@ include file="../common/bottom.jsp"%>





