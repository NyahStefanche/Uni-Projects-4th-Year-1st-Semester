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
	$query = "INSERT INTO employee(pers_id,first,father,last,sex,b_day,city,street,phone,depart_id,room_id)
			  VALUES ('','".$_POST["first"]."','".$_POST["father"]."',' ".$_POST["last"]."'
			  ,'".$_POST["sex"]." ',' ".$_POST["b_day"]." ',' ".$_POST["city"]." ',' ".$_POST["street"]." '
			  ,' ".$_POST["phone"]." ',' ".$_POST["depart_id"]." ',' ".$_POST["room_id"]." ')";
				if($result=mysqli_query($link,$query))
					$message="Служителя е добавен успешно";
				else
					$message="Грешка при добавянето";
}
?>
<html>
<head>
	<title>Добавяне на служител</title>
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
	<h2> Добавяне на нов служител</h2>
	<?php if(isset($message)) echo$message; ?>
	<form method="POST" action="add_employee.php">
	<table border="1">
	<tr>
		<td>Име</td>
		<td><input type="text" name="first" /></td>
	</tr>
	<tr>
		<td>Бащино</td>
		<td><input type="text" name="father"/></td>
	</tr>
	<tr>
		<td>Фамилия</td>
		<td><input type="text" name="last"/></td>
	</tr>
	<tr>
		<td>Пол</td>
		<td><input type="text" name="sex"/></td>
	</tr>
	<tr>
		<td>Дата на раждане</td>
		<td><input type="text" name="b_day"/></td>
	</tr>
	<tr>
		<td>Град</td>
		<td><input type="text" name="city"/></td>
	</tr>
	<tr>
		<td>Улица</td>
		<td><input type="text" name="street"/></td>
	</tr>
	<tr>
		<td>Телефон</td>
		<td><input type="text" name="phone"/></td>
	</tr>
	<tr>
		<td>Номер на отдел</td>
		<td><input type="text" name="depart_id"/></td>
	</tr>
	<tr>
		<td>Номер на стая</td>
		<td><input type="text" name="room_id"/></td>
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