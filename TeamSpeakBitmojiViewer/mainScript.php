<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Debarras TS Room</title>
    </head>
    <body>
		<h1>Debarras TS Room</h1>
		<div id="mySidepanel" class="sidepanel">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<form action="SubmitID.php" method="post">
				TeamSpeak Unique ID: <br><input type="text" name="TSID" required><br>
				Bitmoji URL:<br><input type="text" name="BITURL" required><br><br>
				<input type="submit"><br><br>
			</form>
			<div id = "sidePanelText">
			<u>HELP:</u><br><br>
			<u>To get your TeamSpeak Unique ID</u><br>Go to the TeamSpeak app, click tools then identities click advanced and it will then display your ID <br><br>
			<u>To get your Bitmoji URL</u><br>Install the Bitmoji chrome extension then use this <a href="https:www.bitmoji.com/account_v2/">link</a><br>
			Sign in with snapchat, right click on the welcome image, and copy the address<br></div>
		</div>
		<button class="openbtn" onclick="openNav()">&#9776; Upload Data</button>
		<div id="all"></div>
	</body>
	<style>
	body {
	  font-family: "Lato", sans-serif;
	}

	.sidepanel  {
	  width: 0;
	  position: fixed;
	  z-index: 1;
	  height: 350px;
	  top: 100;
	  right: 0;
	  background-color: #f1f1f1;
	  overflow-x: hidden;
	  transition: 0.5s;
	  padding-top: 60px;
	}
	.sidepanel a {
	  text-decoration: none;
	  color: #818181;
	  transition: 0.1s;
	}

	.sidepanel a:hover {
	  color: #f1f1f1;
	}

	.sidepanel .closebtn {
	  position: absolute;
	  top: 0;
	  right: 25px;
	  font-size: 36px;
	}

	.openbtn {
		position: fixed;
		z-index: 1;
		top: 0;
		right: 0;
		font-size: 20px;
		cursor: pointer;
		background-color: #111;
		color: white;
		padding: 10px 15px;
		border: none;
	}

	.openbtn:hover {
	  background-color:#444;
	}
	</style>
	<script>
		function openNav() {
		  document.getElementById("mySidepanel").style.width = "350px";
		}

		function closeNav() {
		  document.getElementById("mySidepanel").style.width = "0";
		}
	</script>
	<?php
	include 'db_connection.php';
	date_default_timezone_set("Europe/London");
	include './libraries/TeamSpeak3/TeamSpeak3.php';
	TeamSpeak3::init();
	header("Content-Type: text/html; charset=utf8");
	$status = "offline";
	$count = 0;
	$max = 0;

	//connect to teamspeak, query the server to find active users, if it fails, display error message
	//server query login, and server ip address have been removed for safety reasons.
	try {
		$ts3 = TeamSpeak3::factory("serverquery:/"."/sqAdmin:ID@serverAddress:port/?server_port=port&use_offline_as_virtual=1&no_query_clients=1");
		$status = $ts3->getProperty("virtualserver_status");
		$count = $ts3->getProperty("virtualserver_clientsonline") - $ts3->getProperty("virtualserver_queryclientsonline");
		$max = $ts3->getProperty("virtualserver_maxclients");
		$clients = $ts3->clientlist(array(""));
		echo '<span class="ts3status">TS3 Server Status: ' . $status . '</span><br/><span class="ts3_clientcount">Clients online: ' . $count . '/' . $max ."</br></br>".  '</span>';
		//set all possible position ids, and min max for random index picker
		$positionIDS = [10215150,10215152,10213214,10214361,10214424,10214461,10214464,10214470,10214483,10214485,10214495,10214497,
		10214498,10214500,10214502,10214503,10214504,10214505,10214507,10214510,10214511,10214531,10214537,10214550,10214648,10214650,
		10214653,10214653,10214654,10214655,10214656,10214657,10214658,10214659,10214660,10214661,10214662,10214663,10214664,10214665,
		10214666,10214721,10214897,10214898,10214899,10214901,10214902,10214903,10215406,10215543];
		$min = 0;
		$max = 49;
		//Cycle through all connect clients querying their ids in the database
		foreach ($clients as $cl) {
			$name = $cl->client_nickname;
			$uid = $cl->client_unique_identifier;
			//echo "Username: ".$name."</br>ID: ".$uid."</br></br>"; 
			//query the database to find the active TS ids		
			$conn = OpenCon();
			$sql = "SELECT bitmojiID FROM userData WHERE(tsID = '$uid')";
			$result = $conn->query($sql);		
			if ($result->num_rows > 0) {
				// output data of each row
				while($row = $result->fetch_assoc()) {
					$bitmojiID = $row["bitmojiID"];
					$index = mt_rand($min, $max);
					$comicID = $positionIDS[$index];
					$imgUrl = "https://render.bitstrips.com/v2/cpanel/".$comicID."-" . $bitmojiID . "-v1.png?transparent=1&width=200";					
					$imageData = base64_encode(file_get_contents($imgUrl));
					echo '<img src="data:image/jpeg;base64,'.$imageData.'">';
				}
			} else {			
				$bitmojiID = "128256895_1_s1";						
				$index = mt_rand($min, $max);
				$comicID = $positionIDS[$index];
				$imgUrl = "https://render.bitstrips.com/v2/cpanel/".$comicID."-" . $bitmojiID . "-v1.png?transparent=1&width=200";
				$imageData = base64_encode(file_get_contents($imgUrl));
				echo '<img src="data:image/jpeg;base64,'.$imageData.'">';
			}
			CloseCon($conn);
		}	
	}
	catch (Exception $e) {
		echo '<div style="background-color:red; color:white; display:block; font-weight:bold;">QueryError: ' . $e->getCode() . ' ' . $e->getMessage() . '</div>';
	}
	?>

</html>
