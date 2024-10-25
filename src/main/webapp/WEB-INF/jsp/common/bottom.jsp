</div>

<div id="Footer">

    <div id="PoweredBy">&nbsp<a href="https://baidu.com">www.baidu.com</a>
    </div>

    <div id="Banner">
        <c:if test="${sessionScope.loginAccount != null }">
            <c:if test="${sessionScope.loginAccount.bannerOption}">
                ${sessionScope.loginAccount.bannerName}
            </c:if>
        </c:if>
    </div>

</div>

</body>
</html>
