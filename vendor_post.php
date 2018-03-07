<?php
    $server = "localhost";
    $db = "wit";
    $db_username = "root";
    $db_password="";

    //create the connection
    $conn = mysqli_connect($server, $db_username, $db_password, $db);

    if($conn){

        $quantity = $_POST['quantity'];
        $location = $_POST['location'];
        $preferred_price = $_POST['preferred_price'];
        

        $query = "INSERT INTO farmerstock(quantity, location, preferred_price) VALUES ('$quantity', '$location', '$preferred_price')";
        $result = $conn -> query($query);

        if($result){
            echo "Data saved successfully";
        }else{
            echo "Saving failed";
        }
    }else{
        echo "Connection error";
    }
?>