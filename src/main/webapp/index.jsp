<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>index</title>--%>
<%--    <link href="/css/mypetstore.css" rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div id="Content">--%>
<%--    <h1>hello</h1>--%>
<%--    <p><a href="/mainForm">go to mainForm</a></p>--%>
<%--    <p><a href="/loginView">SignIn</a></p>--%>
<%--    <p><a href="/registrationView">SignUp</a></p>--%>

<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>index</title>
    <link rel="stylesheet" href="css/index.css">
    <!-- Google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Playwrite+GB+S:ital,wght@0,100..400;1,100..400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/registration.css">
</head>

<body>
<header>
    <img src="images/logo.png" alt="cat" class="logo">
    <ul>
        <li><a href="mainForm">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li>
    </ul>
</header>
<div class="first-page">
    <h1>
            <span>
                Welcome to this
            </span>
        <br>
        <span>
                online pet store😀
            </span>
        <br>
        <div class="arrow-icon">
            <svg xmlns="http://www.w3.org/2000/svg" height="100px" viewBox="0 -960 960 960" width="100px"
                 fill="white">
                <path
                        d="M480-200 240-440l56-56 184 183 184-183 56 56-240 240Zm0-240L240-680l56-56 184 183 184-183 56 56-240 240Z" />
            </svg>
        </div>
    </h1>
</div>

<div class="shell">
    <div class="box">
        <img src="images/index-bird.jpg">
        <span>bird</span>
    </div>
    <div class="box">
        <img src="images/index-cat.jpg">
        <span>cat</span>
    </div>
    <div class="box">
        <img src="images/index-dog.jpg">
        <span>dog</span>
    </div>
    <div class="box">
        <img src="images/index-fish.jpg">
        <span>fish</span>
    </div>
    <div class="box">
        <img src="images/index-reptiles.jpg">
        <span>reptiles</span>
    </div>
</div>

<div class="second-page">
    <div class="start">
        <p>Let's get started.</p>
        <div class="btn-container">

            <button class="login-btn">
                <span class="cover"></span>
                <a href="loginView" >
                    Sign In
                </a>
            </button>
           <button class="register-btn">
               <span class="cover"></span>
               <a href="registrationView" >
                   Sign Up
               </a>
           </button>

        </div>
    </div>
</div>
</body>

</html>