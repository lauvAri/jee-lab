<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="css/myProfile.css">
</head>

<body>
<form action="profile" method="post" class="profile-form">
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
        <input type="text" name="address-1-input" id="address-1-input" class="entry-input" required>
    </div>
    <div class="form-group">
        <span class="entry-label">address 2</span>
        <input type="text" name="address-2-input" id="address-2-input" class="entry-input" required>
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