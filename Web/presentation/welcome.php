<?php
// Initialize the session
session_start();
$Values = $_GET['userid'];
//echo $Values;

?>
<!-- displays a successful login page -->
    <!DOCTYPE html>
    <html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="style/account.css">
    <style type="text/css">
        body{ font: 14px sans-serif; text-align: center; }
    </style>
</head>
<body>
<div class="page-header">
    <h1>Hi, <b><?php echo htmlspecialchars($_SESSION["username"]); ?></b>. Welcome.</h1>
</div>
<p>
    <a href="logout.php" class="logout">Sign Out of Your Account</a>
    <br>
<!-- Confirms account deletion -->
    <a href="../data/deletion.php?userid=<?php echo $Values;?>" onClick="return confirm('Click OK to confirm account deletion.')" class="delete"> Delete Account</a>
</p>
</body>
    </html>
