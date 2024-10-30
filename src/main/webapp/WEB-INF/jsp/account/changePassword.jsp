<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/change_password.css">
</head>

<body>
<div class="change-password-container">
    <h1>I've heard you want a new password &#x1F431;</h1>
    <c:if test="${sessionScope.changePasswordInfo != null}">
        <p class="warningMsg">${sessionScope.changePasswordInfo}</p>
        <% session.setAttribute("changePasswordInfo", null);  %>
    </c:if>
    <form action="changePassword" method="post" class="chang-password-form" onsubmit="return validatePasswords()">
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
            <div class="form-entry">
                <button class="submit-btn" onclick="validatePasswords()">
                    confirm
                </button>
                <a class="go-back-btn" href="/mainForm">
                    go back
                </a>
            </div>
        </div>

        <div class="right-part">
            <img src="/images/cat-bg.jpg" alt="" class="cat-img">
        </div>
    </form>
</div>

<!-- Modal -->
<div class="modal fade" id="validationModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Validation Result</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" id="modalMessage">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    function validatePasswords() {
        const originalPassword = document.getElementById('originalPassword').value;
        const newPassword = document.getElementById('newPassword').value;
        const confirmPassword = document.getElementById('confirmPassword').value;
        const modalMessage = document.getElementById('modalMessage');

        if (newPassword === originalPassword) {
            modalMessage.textContent = 'New password cannot be the same as the original password.';
            $('#validationModal').modal('show');
            return false;
        }

        if (newPassword !== confirmPassword) {
            modalMessage.textContent = 'New password and confirm password do not match.';
            $('#validationModal').modal('show');
            return false;
        }

        return true;
    }
</script>
</body>

</html>
