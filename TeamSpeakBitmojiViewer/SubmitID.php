<html>
<body>
<h2>Database Upload Page </h2><br>
<?php
//open database connection, and insert data into table.
$textToFind = "https://render.bitstrips.com";
$url = $_POST["BITURL"];
$validCount = 0;
if( strpos($url, $textToFind) !== False) {   
	$stringSections = explode("-",$url);
	$id =  $stringSections[1]."-".$stringSections[2];
	$validCount++;	
}
else{
	echo "The entered Bitmoji Url was invalid please try again"."<br><br>";
}
$tsID = $_POST["TSID"];
$idLength = strlen($tsID);
if ($tsID[$idLength-1] == "=" && $idLength == 28){
	$validCount++;	
}
else{	
	echo "The entered Teamspeak Unique ID was invalid please try again"."<br><br>";
}
if ($validCount == 2){
	echo "Teamspeak ID: ".$tsID."<br>";
	echo "Bitmoji ID: ".$id."<br>";	
	include 'db_connection.php';
	$conn = OpenCon();
	echo "Connected Successfully". "<br>";
	$sqlQuery = "INSERT INTO userData (tsID, bitmojiID) VALUES ('$tsID','$id')";
	if (mysqli_query($conn,$sqlQuery)){
		echo "Data Sent Successfully"."<br><br>";
	}
	else{
		echo "ERROR: Could not able to execute $sqlQuery. " . mysqli_error($conn)."<br><br>";
	}
	CloseCon($conn);
}
else{
	echo "There was an issue with the data, please try submitting the data again"."<br>";
}
?>
<button onclick="window.location.href = './index.php';">Return to lobby</button>
</body>
</html>
