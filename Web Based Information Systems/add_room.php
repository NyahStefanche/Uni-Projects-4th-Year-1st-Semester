<?php
session_start();
if(!isset($_SESSION['user']))
{
	header("location: login.php");
	exit();
}
if(!empty($_POST))
{
	include"db.php";
	$query = "INSERT INTO rooms(room_id,floor,l_r,square_surface)
			  VALUES ('".$_POST["room_id"]."','".$_POST["floor"]."','".$_POST["l_r"]."','"
			  .$_POST["square_surface"]."')";
				if($result=mysqli_query($link,$query))
					$message="Работната стая е добавен успешно";
				else
					$message="Грешка при добавянето";
}
?>
<html>
<head>
	<title>Добавяне на работна стая</title>
	<link href="site.css" rel="stylesheet" type="text/css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="main">
	<div id="menu">
		<?php include "menu.php"; ?>
	</div>
	<div id="content">
	<center>
	<h2> Добавяне на нова работна стая</h2>
	<?php if(isset($message)) echo$message; ?>
	<form method="POST" action="add_room.php">
	<table border="1">
	<tr>
		<td> Номер на стая</td>
		<td><input type="text" name="room_id"/></td>
	</tr>
	<tr>
		<td>Етаж</td>
		<td><input type="text" name="floor" /></td>
	</tr>
	<tr>
		<td>Ляво/Дясно</td>
		<td><input type="text" name="l_r"/></td>
	</tr>
	<tr>
		<td> Квадратура </td>
		<td><input type="text" name="square_surface"/></td>
	</tr>
	<tr>
		<td colspan='2' align='center'><input type="submit" value="Добави"/></td>
	</tr>
	</table>
	</form>
	</center>
	</div>
</div>
</body>
</html>