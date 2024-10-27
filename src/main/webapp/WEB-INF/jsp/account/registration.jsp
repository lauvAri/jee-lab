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
    <!-- BootStrap图标库 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">

    <link rel="stylesheet" href="css/registration.css">

    <!-- Google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Playwrite+GB+S:ital,wght@0,100..400;1,100..400&display=swap" rel="stylesheet">
</head>
<body>

<div class="main">
    <input type="hidden" id="registrationStatus" value="<%= request.getAttribute("registrationStatus") %>">
    <!-- Sign up form -->
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title">Sign up</h2>

                    <form method="post" action="registration" class="register-form"
                          id="register-form" onsubmit="return validatePasswords()">
                        <div class="form-group">
                            <label for="name"><i
                                    class="zmdi zmdi-account material-icons-name"></i></label> <input
                                type="text" name="name" id="name" placeholder="Your Name" />
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label> <input
                                type="email" name="email" id="email" placeholder="Your Email" />
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
                                type="password" name="pass" id="pass" placeholder="Password" />
                        </div>
                        <div class="form-group">
                            <label for="re_pass"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" name="re_pass" id="re_pass"
                                   placeholder="Repeat your password" />
                        </div>
<%--                        <div class="form-group">--%>
<%--                            <label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>--%>
<%--                            <input type="text" name="contact" id="contact"--%>
<%--                                   placeholder="Contact no" />--%>
<%--                        </div>--%>
                        <div class="form-group">
                            <i class="bi bi-heart">
                                <span class="preferred-animal">preferred animal</span>
                            </i>
                            <select name="favcategory" class="favSelect">
                                <option value="" disabled selected></option>
                                <option value="BIRDS">birds</option>
                                <option value="CATS">cats</option>
                                <option value="DOGS">dogs</option>
                                <option value="FISH">fish</option>
                                <option value="REPTILES">reptiles</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term"
                                   class="agree-term" /> <label for="agree-term"
                                                                class="label-agree-term"><span><span></span></span>I
                            agree all statements in <a href="#" class="term-service">Terms
                                of service</a></label>
                        </div>

                        <div class="form-group form-button">
                            <input type="submit" name="signup" id="signup"
                                   class="form-submit" value="Register" />
                        </div>
                    </form>
                </div>
                <div class="signup-image">
                    <figure>
                        <img src="images/signup-image.jpg" alt="sing up image">
                    </figure>
                    <a href="/loginView" class="signup-image-link">I am already
                        member</a>
                </div>
            </div>
        </div>
    </section>


</div>
<!-- JS -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script>
    const status = document.getElementById("registrationStatus").value;
    if (status === "failed") {
        swal("${requestScope.registrationMsg}", "failed");
    }
    function validatePasswords() {
        const password = document.getElementById('pass').value;
        const confirmPassword = document.getElementById('re_pass').value;

        if (password !== confirmPassword) {
            swal("password and confirm password should keep the same");
            return false;
        } else {
            // 表单验证通过，可以提交表单
            document.getElementById('register-form').submit();
            return true;
        }
    }
</script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>