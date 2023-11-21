<?php
session_start();
include"db.php";
if(isset($_GET['room_id']))
{
	if(!isset($_SESSION['user']))
	{
		header("location: login.php");
		exit();
	}
	$query="DELETE FROM rooms
	WHERE room_id=".$_GET['room_id'];
	if(mysqli_query($link,$query))
		$message="Работната стая е изтрита успешно";
	else
		$message="Грешка при изтриването";
}
?>

<html>
<head>
<title> Стаи </title>
<link href="site.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="main">
	<?php include "menu.php";?>
	<div id="content">
	<center>
	<h2> Информация за работните стаи на фирмата</h2>
	<?php if(isset($message)) echo$message;?>
	<table border="1">
	<tr>
	<th> Номер на стая</th>
	<th> Етаж </th>
	<th> Ляво/Дясно</th>
	<th> Площ </th>
	<?php
		if(isset($_SESSION['user']))
		{
	?>
	<th> Редактиране </th>
	<th> Изтриване</th>
	<?php
		}
	?>
	</tr>
<?php	
	$query="SELECT * FROM rooms";
	if($result=mysqli_query($link,$query))
	{
		while($row=mysqli_fetch_assoc($result)){
	?>
<tr>
	<td><?php echo$row['room_id'];?></td>
	<td><?php echo$row['floor'];?></td>
	<td><?php echo$row['l_r'];?></td>
	<td><?php echo$row['square_surface'];?>кв.м.</td>
	<?php
		if(isset($_SESSION['user']))
		{
	?>
	<td><a href="edit_room.php?room_id=<?php echo$row['room_id'];?>"> Редактиране </a>
	<td><a href="rooms.php?room_id=<?php echo$row['room_id'];?>">Изтриване</a></td>
	<?php
		}
	?>
</tr>
<?php
			}
	}
	else
	{
?>
<tr><td colspan='5' align='center'> Няма записи</td></tr>
<?php
	}
?>
<tr>
	<td colspan='5' align='center'>
		<a href="add_room.php"> Добавяне на стая</a>
	</td>
</tr>
	</table>
	</center>
	</div>
</div>
</body>
</html>
	