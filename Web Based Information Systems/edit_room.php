<?php
session_start();
if(!isset($_SESSION['user']))
{
	header("location: login.php");
	exit();
}
include"db.php";

if(!empty($_POST))
{
	$query="UPDATE rooms
		   SET room_id='".$_POST['room_id']."',
		   floor = '".$_POST['floor']."',
		   l_r = '".$_POST['l_r']."',
		   square_surface = '".$_POST['square_surface']."'
		   WHERE room_id='".$_GET['room_id']."'";
	if($result=mysqli_query($link,$query))
					$message="Работната стая е обновена успешно";
				else
					$message="Грешка при обновяването";
	
	$_GET['room_id']=$_POST['room_id'];
}

if (isset($_GET["room_id"]))
{
	$query="SELECT * FROM rooms WHERE room_id='".$_GET['room_id']."'";
	$result=mysqli_query($link,$query);
	$data=mysqli_fetch_assoc($result);
}




?>
<html>
<head>
	<title>Обновяване на работна стая</title>
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
	<h2> Обновяване на работна стая</h2>
	<?php if(isset($message)) echo$message; ?>
	<form method="POST" action="edit_room.php?room_id=<?php echo$_GET['room_id'];?>">
	<table border="1">
	<tr>
		<td> Номер на стая</td>
		<td><input type="text" name="room_id" value="<?php echo $data['room_id'];?>"/></td>
	</tr>
	<tr>
		<td>Етаж</td>
		<td><input type="text" name="floor" value="<?php echo $data['floor'];?>" /></td>
	</tr>
	<tr>
		<td>Ляво/Дясно</td>
		<td><input type="text" name="l_r" value="<?php echo $data['l_r'];?>"/></td>
	</tr>
	<tr>
		<td> Квадратура </td>
		<td><input type="text" name="square_surface" value="<?php echo $data['square_surface'];?>"/></td>
	</tr>
	<tr>
		<td colspan='2' align='center'><input type="submit" value="Редактирай"/></td>
	</tr>
	</table>
	</form>
	</center>
	</div>
</div>
</body>
</html>
