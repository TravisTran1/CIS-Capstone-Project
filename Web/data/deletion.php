<?php

session_start();
$Values =  $_GET['userid'];
//echo $Values;
//function to create alert message

try {
    $dsn = "sqlsrv:Server=cisdbss.pcc.edu,1433;Database=234a_MissingSemiColons";
    $conn = new PDO($dsn,"234a_MissingSemiColons","MissingSemiColons_FA20_$#%");
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

// sql to delete a record
$sql = "DELETE FROM MS_Users WHERE UserID= $Values";

// use exec() because no results are returned
$statement = $conn->prepare($sql);
$conn->exec($sql);
$statement->execute([$Values]);
//echo "Account deleted successfully";

sleep(3);
header("location:../presentation/deleted.php");
} catch(PDOException $e) {
    echo $sql . "<br>" . $e->getMessage();

}
$conn = null;
?>