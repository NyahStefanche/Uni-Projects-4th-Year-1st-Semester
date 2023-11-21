<?php
session_start();
include"db.php";
if(isset($_GET['pers_id']))
{
	if(!isset($_SESSION['user']))
	{
		header("location: login.php");
		exit();
	}
	$query="DELETE FROM employee
	WHERE pers_id=".$_GET['pers_id'];
	if(mysqli_query($link,$query))
		$message="Служителят е изтрит успешно";
	else
		$message="Грешка при изтриването";
}
?>

<html>
<head>
<title> Служители </title>
<link href="site.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="main">
	<?php include "menu.php";?>
	<div id="content">
	<center>
	<h2> Информация за служителите на фирмата</h2>
	<?php if(isset($message))echo$message;?>
	<table border="1">
	<tr>
	<th> Номер на служител</th>
	<th> Име </th>
	<th> Презиме</th>
	<th> Фамилия </th>
	<th> Пол </th>
	<th> Рожден ден </th>
	<th> Град </th>
	<th> Улица </th>
	<th> Телефон </th>
	<th> Отдел № </th>
	<th> Стая </th>
	<?php
		if(isset($_SESSION['user']))
		{
	?>
	<th> Редактиране </th>
	<th> Изтриване </th>
	<?php
		}
	?>
	</tr>
<?php
	$query="SELECT * FROM employee";
	if($result=mysqli_query($link,$query))
	{
		while($row=mysqli_fetch_assoc($result)){
	?>
<tr>
	<td><?php echo$row['pers_id'];?></td>
	<td><?php echo$row['first'];?></td>
	<td><?php echo$row['father'];?></td>
	<td><?php echo$row['last'];?></td>
	<td><?php echo$row['sex'];?></td>
	<td><?php echo$row['b_day'];?></td>
	<td><?php echo$row['city'];?></td>
	<td><?php echo$row['street'];?></td>
	<td><?php echo$row['phone'];?></td>
	<td><?php echo$row['depart_id'];?></td>
	<td><?php echo$row['room_id'];?></td>
	<?php
		if(isset($_SESSION['user']))
		{
	?>
	<td><a href="edit_employee.php?pers_id=<?php echo$row['pers_id'];?>"> Редактиране </a>
	<td><a href="employee.php?pers_id=<?php echo$row['pers_id'];?>">Изтриване</a></td>
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
<tr><td colspan='6' align='center'> Няма записи</td></tr>
<?php
	}
?>
	</table>
	</center>
	</div>
</div>
</body>
</html>