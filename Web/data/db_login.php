<?php
// attempts to login to the database.
try {
    $db = new PDO('sqlsrv:Server=cisdbss.pcc.edu,1433;Database=234a_MissingSemiColons', '234a_MissingSemiColons', 'MissingSemiColons_FA20_$#%');
    $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
} catch (PDOException $e) {
    echo "Connection failed : ". $e->getMessage();
}
