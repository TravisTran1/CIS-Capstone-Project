<?php
// attempts to login to the database.
try {
    $dsn = "sqlsrv:Server=cisdbss.pcc.edu,1433;Database=234a_MissingSemiColons";
    $conn = new PDO($dsn,"234a_MissingSemiColons","MissingSemiColons_FA20_$#%");
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    echo "Failed to connect to database. You will be unable to login or signup at this time. ". '<br>'."Error: ".$e->getMessage();
}
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
<head>
      <meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>
      <title>Notification Account Creation</title>
      <link rel="STYLESHEET" type="text/css" href="style/account.css">
</head>
<body>
<div id='fg_account_content'>
<h1>Notification System</h1>
<!-- displays register and login links-->
<h3>Account Creation</h3>

<ul>
<li><a href='register.php'>Register</a></li>
<li><a href='login.php'>Login</a></li>
</ul>
</div>
</body>
</html>
