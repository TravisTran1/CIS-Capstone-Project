<?php

//connects to database and clarifies errors
$dsn = "sqlsrv:Server=cisdbss.pcc.edu,1433;Database=234a_MissingSemiColons";
$conn = new PDO($dsn,"234a_MissingSemiColons","MissingSemiColons_FA20_$#%");
$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

