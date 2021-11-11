<?php
require_once("db.php");


//variable retrieval
$name = $_POST["name"];
$email = $_POST["email"];
$username = $_POST["username"];
$password = $_POST["password"];
$date = date("Y-m-d");


// bcrypt cuz i was told to use bcrypt
$options = [
    'cost' => 12,
    'salt' => "2390jejdskgma39jdijaljlklsja342346yefhd",
];

$hashedpassword = password_hash($password , PASSWORD_BCRYPT,$options);
$hashedpassword_final = substr_replace($hashedpassword, "$2a", "$2y", 3);
//echo 'password(bcrypt)='.$hashedpassword_final.'<br/> ';

//writes into database
try {


    $data = [
        'Subscriber' => 'true',
        'Username' => $username,
        'Password' => $hashedpassword_final,
        'Email' => $email,
        'FullName' => $name,
        'DateLogin' => $date
    ];
    $sql = "INSERT INTO dbo.MS_Users (SendEmail, Username, Password, Email, FullName, DateLogin)  VALUES (?,?,?,?,?,?)";

   $stmt =  $conn->prepare($sql);
   $stmt->execute([true, $username, $hashedpassword_final, $email, $name, $date]);

} catch(PDOException $e) {
    echo $sql . "<br>" . $e->getMessage();
}
echo "Thank you for signing up!";

$conn = null;
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>
    <title>Contact us</title>
    <link rel="STYLESHEET" type="text/css" href="style/account.css" />
</head>
<body>
<li><a href='../presentation/login.php'>Login Here</a></li>
</body>
</html>
