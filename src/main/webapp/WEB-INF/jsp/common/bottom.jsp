

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
</body>
</html>
