<%@ include file="../common/top.jsp"%>

<div id="Welcome">
    <div id="WelcomeContent">
<%--        显示登录用户的firstname--%>
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <svg id="fullsize"  onclick="showFullSize()" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="undefined"><path d="M120-240v-80h720v80H120Zm0-200v-80h720v80H120Zm0-200v-80h720v80H120Z"/></svg>
            <svg id="smallsize" style="display:none" onclick="showSmallSize()" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="undefined"><path d="m256-200-56-56 224-224-224-224 56-56 224 224 224-224 56 56-224 224 224 224-56 56-224-224-224 224Z"/></svg>
            <br />
            <a href="categoryForm?categoryId=FISH"><img src="images/fish_icon.gif" /></a>
            <br />
            <span class="sidebar-detail" style="display: none;">Saltwater, Freshwater</span>
            <br />
            <a href="categoryForm?categoryId=DOGS"><img src="images/dogs_icon.gif" /></a>
            <br />
            <span class="sidebar-detail" style="display: none;">Various Breeds</span>
            <br />
            <a href="categoryForm?categoryId=CATS"><img src="images/cats_icon.gif" /></a>
            <br />
            <span class="sidebar-detail" style="display: none;">Various Breeds, Exotic Varieties</span>
            <br />
            <a href="categoryForm?categoryId=REPTILES"><img src="images/reptiles_icon.gif" /></a>
            <br />
            <span class="sidebar-detail" style="display: none;">Lizards, Turtles, Snakes</span>
            <br />
            <a href="categoryForm?categoryId=BIRDS"><img src="images/birds_icon.gif" /></a>
            <br />
            <span class="sidebar-detail" style="display: none;">Exotic Varieties</span>
        </div>
    </div>
    <script>
        const SidebarContent = document.querySelector('#SidebarContent');
        const details = document.getElementsByClassName('sidebar-detail');
        function showFullSize() {
            SidebarContent.style.width = 'max-content';
            document.querySelector('#fullsize').style.display = 'none';
            document.querySelector('#smallsize').style.display = 'block';
            [...details].forEach(function(detail) {
                detail.style.display='block';
                detail.style.animation="fade-in-item 0.4s linear forwards";
                detail.style.opacity="1";
            });
        }
        function showSmallSize() {
            SidebarContent.style.width = 'min-content';
            document.querySelector('#smallsize').style.display = 'none';
            document.querySelector('#fullsize').style.display = 'block';
            [...details].forEach(function(detail) {
                detail.style.display="none";
                detail.style.animation="fade-in-item 0.4s linear forwards";
                detail.style.opacity="0";
            });
        }
    </script>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap">
                <area alt="Birds" coords="72,2,280,250"
                      href="categoryForm?categoryId=BIRDS" shape="RECT" />
                <area alt="Fish" coords="2,180,72,250"
                      href="categoryForm?categoryId=FISH" shape="RECT" />
                <area alt="Dogs" coords="60,250,130,320"
                      href="categoryForm?categoryId=DOGS" shape="RECT" />
                <area alt="Reptiles" coords="140,270,210,340"
                      href="categoryForm?categoryId=REPTILES" shape="RECT" />
                <area alt="Cats" coords="225,240,295,310"
                      href="categoryForm?categoryId=CATS" shape="RECT" />
                <area alt="Birds" coords="280,180,350,250"
                      href="categoryForm?categoryId=BIRDS" shape="RECT" />
            </map>
            <img height="355" src="images/splash.gif" align="middle"
                 usemap="#estoremap" width="350" /></div>
    </div>

    <div class="MainBanner">
        <ul class="MainBannerImage">
            <li><a href="#"><img src="images/mainBanner_fish.png" alt="Fish"></a></li>
            <li><a href="#"><img src="images/mainBanner_dogs.png" alt="Dogs"></a></li>
            <li><a href="#"><img src="images/mainBanner_reptiles.png" alt="Reptiles"></a></li>
            <li><a href="#"><img src="images/mainBanner_cat.png" alt="Cats"></a></li>
            <li><a href="#"><img src="images/mainBanner_birds.png" alt="Birds"></a></li>
        </ul>
        <!--放置圆点-->
        <ul class="MainBannerNum"></ul>
        <!--左右按钮-->
        <div class="MainBannerBtn">
            <span class="MainBannerPrev"><</span>
            <span class="MainBannerNext">></span>
        </div>
    </div>
</div>


<%@ include file="../common/bottom.jsp"%>