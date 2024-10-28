<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <link href="<c:url value="/css/jpetstore.css"/>" rel="stylesheet">
</head>
<body>
<div id="Content">
    <h1>hello</h1>
    <p><a href="<c:url value="/mainForm"/>">go to mainForm</a></p>
    <p><a href="<c:url value="/loginView"/>">SignIn</a></p>
    <p><a href="<c:url value="/registrationView"/>">SignUp</a></p>

</div>
</body>
</html>