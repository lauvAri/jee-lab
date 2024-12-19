<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet"
          href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Playwrite+GB+S:ital,wght@0,100..400;1,100..400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/registration.css">
    <%--boxicons--%>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <style>
        #gen-code-btn {
            display: inline-block;
            border-radius: 6px;
            padding:12px 6px;
            background:#1da0f2;
            color:#fff;
            cursor: pointer;
        }
        .bx-check {
            display: none;
            color: green;
            font-weight: bold;
            font-size: 12px;
            margin-left: 4px;
        }
        .green {
            border: 2px solid green;
            border-radius: 4px;
        }
        .red {
            border: 2px solid red;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
<div class="main">

    <!-- Sing in  Form -->
    <section class="sign-in">
        <div class="container">
            <div class="signin-content">
                <div class="signin-image">
                    <figure>
                        <img src="images/signin-image.jpg" alt="sing up image">
                    </figure>
                    <a href="registrationView" class="signup-image-link">Create an
                        account</a>
                </div>

                <div class="signin-form">
                    <h2 class="form-title">Sign in</h2>
                    <form method="post" action="login" class="register-form"
                          id="login-form" onsubmit="return checkVeri()">
                        <div class="form-group" id="username-box">
                            <label for="username">
                                <i class="zmdi zmdi-account material-icons-name"></i>
                                <i class='bx bx-check'></i>
                            </label>
                            <input
                                type="text" name="username" id="username"
                                placeholder="Your Name" />
                            <i class='bx bx-check'></i>
                        </div>
                        <div class="form-group" id="password-box">
                            <label for="password">
                                <i class="zmdi zmdi-lock"></i>
                                <i class='bx bx-check'></i>
                            </label>
                            <input
                                type="password" name="password" id="password"
                                placeholder="Password" />
                        </div>
                        <div class="form-group" id="captcha-box">
                            <span id="gen-code-btn">get captcha</span>
                            <input type="text" id="veri-code" name="veri-code" autocomplete="off">
                            <div id="verify-code-view" style="width:100%;margin-top:4px"></div>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="remember-me" id="remember-me"
                                   class="agree-term" /> <label for="remember-me"
                                                                class="label-agree-term"><span><span></span></span>Remember
                            me</label>
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signin" id="signin"
                                   class="form-submit" value="Log in" />
                        </div>
                    </form>
                    <div class="social-login">
                        <span class="social-label">Or login with</span>
                        <ul class="socials">
                            <li><a href="#"><i
                                    class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                            <li><a href="#"><i
                                    class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                            <li><a href="#"><i
                                    class="display-flex-center zmdi zmdi-google"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>

</div>

<!-- JS -->
<script src="/js/jquery-3.7.1.min.js"></script>
<script src="js/main.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script>
    const status = document.getElementById("status").value;
    if (status === "failed") {
        swal("${requestScope.loginMsg}");
    }
</script>
<script src="/js/checkLogin.js"></script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
