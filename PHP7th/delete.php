<?php 
	include("connect.php"); 
	$id = $_GET['id']; 
	$q = "DELETE FROM grocerytb WHERE Id = $id"; 
	if(mysqli_query($con, $q)) {
		echo "Data deleted successfully.";
	} else {
		echo "Error deleting data: " . mysqli_error($con);
	}
?>
