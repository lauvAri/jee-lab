<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JPetStore Demo</title>
    <link rel="stylesheet" href="css/mypetstore.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Playwrite+GB+S:ital,wght@0,100..400;1,100..400&display=swap" rel="stylesheet">
    <script src="js/jquery-3.7.1.min.js"></script>
    <script src="js/mainBanner.js"></script>
</head>

<body>
<div id="app">
<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="mainForm">
                <img src="images/logo-topbar.gif">
            </a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="cartForm">
                <img align="middle" name="img_cart" src="images/cart.gif" />
            </a>
            <img align="middle" src="images/separator.gif" />
            <c:if test="${sessionScope.loginAccount == null}">
                <a href="/registrationView">Sign In</a>
            </c:if>
            <c:if test="${sessionScope.loginAccount != null}">
                <a href="logout">Sign Out</a>
                <a href="changePasswordView">Change Password</a>
                <a href="profileView">My Account</a>
            </c:if>
            <a href="#">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="search" method="post" id="search-form">
                <input type="text" name="keyword" size="14" id="keyword"
                       autocomplete="off" placeholder="search the pet" required>
                <button type="submit">
                    <svg xmlns="http://www.w3.org/2000/svg"
                         viewBox="0 0 512 512"
                         width="20px"
                         height="20px"
                    > <!--!Font Awesome Free 6.7.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.-->
                        <path d="M416 208c0 45.9-14.9 88.3-40 122.7L502.6 457.4c12.5 12.5 12.5 32.8 0 45.3s-32.8 12.5-45.3 0L330.7 376c-34.4 25.2-76.8 40-122.7 40C93.1 416 0 322.9 0 208S93.1 0 208 0S416 93.1 416 208zM208 352a144 144 0 1 0 0-288 144 144 0 1 0 0 288z"/> </svg >
                </button>
            </form>
        </div>
        <div id="search-suggestion">
            <ul id="search-suggestion-content" style="display: none">

            </ul>
        </div>
    </div>

    <script src="/js/searchSuggestion.js"></script>



</div>

<div id="QuickLinks">
    <a href="/categoryFilter?categoryId=FISH"><img src="../images/sm_fish.gif" /></a>
    <a href="#"><img src="../images/separator.gif" /> </a>
    <a href="/categoryFilter?categoryId=DOGS"><img src="../images/sm_dogs.gif" /></a>
    <a href="#"><img src="../images/separator.gif" /></a>
    <a href="/categoryFilter?categoryId=REPTILES"><img src="../images/sm_reptiles.gif" /></a>
    <a href="#"><img src="../images/separator.gif" /> </a>
    <a href="/categoryFilter?categoryId=CATS"><img src="../images/sm_cats.gif" /></a>
    <a href="#"><img src="../images/separator.gif" /> </a>
    <a href="/categoryFilter?categoryId=BIRDS"><img src="../images/sm_birds.gif" /></a>
</div>