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
	$query = "INSERT INTO departments(depart_id,depart,function)
			  VALUES ('','".$_POST["depart"]."','".$_POST["function"]."')";
				if($result=mysqli_query($link,$query))
					$message="Отдела е добавен успешно";
				else
					$message="Грешка при добавянето";
}
?>
<html>
<head>
	<title>Добавяне на отдел</title>
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
	<h2> Добавяне на нов отдел</h2>
	<?php if(isset($message)) echo$message; ?>
	<form method="POST" action="add_department.php">
	<table border="1">
	<tr>
		<td> Номер на отдела</td>
		<td><input type="text" name="depart_id"/></td>
	</tr>
	<tr>
		<td>Отдел</td>
		<td><input type="text" name="depart" /></td>
	</tr>
	<tr>
		<td>Дейност</td>
		<td><input type="text" name="function"/></td>
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