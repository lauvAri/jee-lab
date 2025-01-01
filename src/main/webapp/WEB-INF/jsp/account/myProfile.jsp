<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="css/myProfile.css">
    <script>
        // 函数：将驼峰命名转换为带有连字符的字符串
        function camelToKebab(str) {
            return str.replace(/([a-z])([A-Z])/g, '$1-$2').toLowerCase();
        }
        window.onload = function () {
            console.log('hhhh')
            const xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('GET', 'http://localhost:8080/getProfile');
            xmlHttpRequest.responseType = 'json';

            xmlHttpRequest.onreadystatechange = function () {
                if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
                    // const profile = document.getElementById('profile')
                    // console.log(profile);
                    // let data = xmlHttpRequest.response;

                    const userData = xmlHttpRequest.response;
                    console.log(userData);
                    for (let key in userData) {
                        if (userData.hasOwnProperty(key)) {
                            let kebabKey = camelToKebab(key)
                            let obj = document.getElementById(kebabKey + '-input');
                            if (obj !== undefined && obj !== null) {
                                obj.value = userData[key];
                            }

                        }
                    }
                }
            }

            //发送请求
            xmlHttpRequest.send();
        }
    </script>
</head>

<body>
<form action="profile" method="post" class="profile-form" id="profile">
    <h1>your profile matters &#x1F436;</h1>
    <div class="form-group">
        <span class="entry-label">first name</span>
        <input type="text" name="first-name-input" id="first-name-input" class="entry-input" required>
    </div>
    <div class="form-group">
        <span class="entry-label">last name</span>
        <input type="text" name="last-name-input" id="last-name-input" class="entry-input" required>
    </div>
    <div class="form-group">
        <span class="entry-label">email</span>
        <input type="text" name="email-input" id="email-input" class="entry-input" required>
    </div>
    <div class="form-group">
        <span class="entry-label">address 1</span>
        <input type="text" name="address-1-input" id="address1-input" class="entry-input" required>
    </div>
    <div class="form-group">
        <span class="entry-label">address 2</span>
        <input type="text" name="address-2-input" id="address2-input" class="entry-input" required>
    </div>
    <div class="form-group">
        <span class="entry-label">city</span>
        <input type="text" name="city-input" id="city-input" class="entry-input" required>
    </div>
    <div class="form-group">
        <span class="entry-label">country</span>
        <input type="text" name="country-input" id="country-input" class="entry-input" required>
    </div>
    <div class="form-group">
        <span class="entry-label">phone</span>
        <input type="text" name="phone-input" id="phone-input" class="entry-input" required>
    </div>
    <div class="form-group">
        <input type="submit" value="update" class="entry-input submit-btn">
    </div>
</form>

</body>
</html>