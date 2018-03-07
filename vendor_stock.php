<?php
    $server = "localhost";
    $db = "wit";
    $db_username = "root";
    $db_password="";

    // Create connection
    $conn = new mysqli($server, $db_username, $db_password, $db);

    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    } 

    $sql = "SELECT * FROM vendor_order";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        while($row[] = $result->fetch_assoc()){
            $tem = $row;
            $json = json_encode($tem);
         }
    } else {
        echo "0 results";
    }
    echo $json;

    $conn->close();
   ?>