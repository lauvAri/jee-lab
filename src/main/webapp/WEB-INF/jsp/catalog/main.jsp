<%@ include file="../common/top.jsp"%>

<div id="Welcome">
    <div id="WelcomeContent">
<%--        显示登录用户的firstname--%>
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <a href="<c:url value="/categoryForm?categoryId=FISH"/>"><img src="<c:url value="/images/fish_icon.gif"/>" /></a>
            <br />
            Saltwater, Freshwater
            <br />
            <a href="<c:url value="/categoryForm?categoryId=DOGS"/>"><img src="<c:url value="/images/dogs_icon.gif"/>" /></a>
            <br />
            Various Breeds
            <br />
            <a href="<c:url value="/categoryForm?categoryId=CATS"/>"><img src="<c:url value="/images/cats_icon.gif"/>" /></a>
            <br />
            Various Breeds, Exotic Varieties
            <br />
            <a href="<c:url value="/categoryForm?categoryId=REPTILES"/>"><img src="<c:url value="/images/reptiles_icon.gif"/>" /></a>
            <br />
            Lizards, Turtles, Snakes
            <br />
            <a href="<c:url value="/categoryForm?categoryId=BIRDS"/>"><img src="<c:url value="/images/birds_icon.gif"/>" /></a>
            <br />
            Exotic Varieties
        </div>
    </div>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap">
                <area alt="Birds" coords="72,2,280,250"
                      href="<c:url value="/categoryForm?categoryId=BIRDS"/>" shape="RECT" />
                <area alt="Fish" coords="2,180,72,250"
                      href="<c:url value="/categoryForm?categoryId=FISH"/>" shape="RECT" />
                <area alt="Dogs" coords="60,250,130,320"
                      href="<c:url value="/categoryForm?categoryId=DOGS"/>" shape="RECT" />
                <area alt="Reptiles" coords="140,270,210,340"
                      href="<c:url value="/categoryForm?categoryId=REPTILES"/>" shape="RECT" />
                <area alt="Cats" coords="225,240,295,310"
                      href="<c:url value="/categoryForm?categoryId=CATS"/>" shape="RECT" />
                <area alt="Birds" coords="280,180,350,250"
                      href="<c:url value="/categoryForm?categoryId=BIRDS"/>" shape="RECT" />
            </map>
            <img height="355" src="<c:url value="/images/splash.gif"/>" align="middle"
                 usemap="#estoremap" width="350" /></div>
    </div>

    <div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/bottom.jsp"%>