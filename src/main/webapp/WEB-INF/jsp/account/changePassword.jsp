<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
    <link rel="stylesheet" href="/css/change_password.css">
    <script src="/js/jquery-3.7.1.min.js"></script>
</head>

<body>
<div class="change-password-container">
    <h1>I've heard you want a new password &#x1F431;</h1>
    <form id="form" action="changePassword" method="post" class="chang-password-form" onsubmit="return validatePasswords()">
        <div class="left-part">
            <div class="form-entry">
                <p class="entry-label">old password</p>
                <input type="password" class="entry-input" id="originalPassword" name="originalPassword" required>
            </div>
            <div class="form-entry">
                <p class="entry-label">new password</p>
                <input type="password" class="entry-input" id="newPassword" name="newPassword" required>
            </div>
            <div class="form-entry">
                <p class="entry-label">confirm new password</p>
                <input type="password" class="entry-input" id="confirmPassword" name="confirmPassword" required>
            </div>
            <div></div>
            <div class="form-entry-btn">
                <button class="submit-btn" onclick="validatePasswords()">
                    confirm
                </button>
                <button id="go-back-btn">
                    <a class="go-back-btn" href="mainForm">
                        go back
                    </a>
                </button>

            </div>
        </div>

        <div class="right-part">
            <img src="images/cat-bg.jpg" alt="" class="cat-img">
        </div>
    </form>
</div>

<script src="/js/checkPassword.js"></script>
</body>

</html>
