<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JPetStore Demo</title>
    <link rel="stylesheet" href="/css/jpetstore.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Playwrite+GB+S:ital,wght@0,100..400;1,100..400&display=swap" rel="stylesheet">
</head>

<body>
<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="/mainForm">
                <img src="images/logo-topbar.gif">
            </a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="/cartForm">
                <img align="middle" name="img_cart" src="/images/cart.gif" />
            </a>
            <img align="middle" src="/images/separator.gif" />
            <c:if test="${sessionScope.loginAccount == null}">
                <a href="signOnForm">Sign In</a>
            </c:if>
            <c:if test="${sessionScope.loginAccount != null}">
                <a href="#">Sign Out</a>
                <a href="#">My Account</a>
            </c:if>
            <a href="#">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="" method="post">
                <input type="text" name="keyword" size="14">
                <input type="submit" value="Search">
            </form>
        </div>

    </div>



</div>

<div id="QuickLinks">
    <a href="/categoryForm?categoryId=FISH"><img src="../images/sm_fish.gif" /></a>
    <a href="#"><img src="../images/separator.gif" /> </a>
    <a href="/categoryForm?categoryId=DOGS"><img src="../images/sm_dogs.gif" /></a>
    <a href="#"><img src="../images/separator.gif" /></a>
    <a href="/categoryForm?categoryId=REPTILES"><img src="../images/sm_reptiles.gif" /></a>
    <a href="#"><img src="../images/separator.gif" /> </a>
    <a href="/categoryForm?categoryId=CATS"><img src="../images/sm_cats.gif" /></a>
    <a href="#"><img src="../images/separator.gif" /> </a>
    <a href="/categoryForm?categoryId=BIRDS"><img src="../images/sm_birds.gif" /></a>
</div>