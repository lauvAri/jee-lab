

<div id="Footer">

    <div id="Banner">
        <c:if test="${sessionScope.loginAccount != null }">
            <c:if test="${sessionScope.loginAccount.bannerOption}">
                ${sessionScope.loginAccount.bannerName}
            </c:if>
        </c:if>
    </div>

</div>
</div>
<script src="/js/filterData.js"></script>
<script src="/js/toogleFilter.js"></script>
<script src="/js/getCartData.js"></script>
<script src="/js/updateCartPreview.js"></script>

</body>
</html>
