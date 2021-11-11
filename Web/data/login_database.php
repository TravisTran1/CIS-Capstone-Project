<?php
session_start();


$username = $_POST["username"];
$password = $_POST["password"];
$message = "";

try {

//connects to database and clarifies errors
    $dsn = "sqlsrv:Server=cisdbss.pcc.edu,1433;Database=234a_MissingSemiColons";
    $conn = new PDO($dsn,"234a_MissingSemiColons","MissingSemiColons_FA20_$#%");
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    //echo"connected";

    if(isset($_POST["loginButton"]))
    {
        $options = [
            'cost' => 12,
            'salt' => "2390jejdskgma39jdijaljlklsja342346yefhd",
        ];

        $hashedpassword = password_hash($password , PASSWORD_BCRYPT,$options);
        $hashedpassword_final = substr_replace($hashedpassword, "$2a", "$2y", 3);
        //echo $hashedpassword;
        {
            $query = "SELECT UserID FROM MS_Users WHERE Username = ? AND Password = ?";
            $statement = $conn->prepare($query);
            $statement->execute([$username, $hashedpassword_final]);

            $count = $statement->rowCount();

            if($count != 0)
            {
                $_SESSION["username"] = $_POST["username"];
                $_SESSION["loggedin"] = true;
                //echo "username= ".$_SESSION["username"];
                $result = $statement->fetchColumn();

                header("location:../presentation/welcome.php?userid=$result");
            }
            else
            {
                //$message = '<label>Wrong Data, please go back.</label>';
                //echo $message;
                header("location:../presentation/wronginfo.php");
            }
        }
    }
}
catch(PDOException $error)
{
    $message = $error->getMessage();
    echo $message;
}