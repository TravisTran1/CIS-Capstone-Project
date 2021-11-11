<?PHP

?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>
    <title>Contact us</title>
    <link rel="STYLESHEET" type="text/css" href="style/account.css" />
    <script type='text/javascript' src='../logic/validator.js'></script>
</head>
<body>

<!-- Registration form to sign up as a subscriber. -->
<div id='fg_account'>

<form id='register' method="post" action='../data/register_write.php' onsubmit="return validateForm()" accept-charset='UTF-8'>
<fieldset >
<legend>Register</legend>

<input type='hidden' name='submitted' id='submitted' value='1'/>

<div class='short_explanation'>* required fields</div>

<div class='container'>
    <label for='name' >Your Full Name*: </label><br/>
    <input type='text' name='name' id='name' maxlength="50" /><br/>

</div>
<div class='container'>
    <label for='email' >Email Address*:</label><br/>
    <input type='text' name='email' id='email' maxlength="50" /><br/>

</div>
<div class='container'>
    <label for='username' >UserName*:</label><br/>
    <input type='text' name='username' id='username' maxlength="50" /><br/>

</div>

<div class='container'>
    <label for='password' >Password*:</label><br/>

    <input type='password' name='password' id='password' maxlength="50" />


</div>
<div class='container' style='height:80px;'>
    <label for='password2' >Password Again*:</label><br/>

    <input type='password' name='password2' id='password2' maxlength="50" />


</div>

<div class='container'>
    <input type='submit' name='Submit' value='Submit' />
</div>

</fieldset>
</form>

</body>
</html>