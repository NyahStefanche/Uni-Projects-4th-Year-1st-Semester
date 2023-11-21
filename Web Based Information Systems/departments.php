<?php
session_start();
include"db.php";
if(isset($_GET['depart_id']))
{
	if(!isset($_SESSION['user']))
	{
		header("location: login.php");
		exit();
	}
	$query="DELETE FROM departments
	WHERE depart_id=".$_GET['depart_id'];
	if(mysqli_query($link,$query))
		$message="Отделът е изтрит успешно";
	else
		$message="Грешка при изтриването";
}
?>

<html>
<head>
<title> Отдели </title>
<link href="site.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="main">
	<?php include "menu.php";?>
	<div id="content">
	<center>
	<h2> Информация за отделите на фирмата</h2>
	<?php if(isset($message))echo$message;?>
	<table border="1">
		<tr>
			<th> Номер на отдел</th>
			<th> Име на отдел</th>
			<th> Фунцкия на отдел</th>
			<?php
				if(isset($_SESSION['user']))
				{
			?>
			<th> Редактиране </th>
			<th> Изтриване на отдел</th>
			<?php
				}
			?>
		</tr>
<?php
	$query="SELECT * FROM departments";
	if($result=mysqli_query($link,$query))
	{
		while($row=mysqli_fetch_assoc($result)){
	?>
<tr>
	<td><?php echo$row['depart_id'];?></td>
	<td><?php echo$row['depart'];?></td>
	<td><?php echo$row['function'];?></td>
	<?php
		if(isset($_SESSION['user']))
		{
	?>
	<td><a href="edit_department.php?depart_id=<?php echo$row['depart_id'];?>"> Редактиране </a>
	<td><a href="departments.php?depart_id=<?php echo$row['depart_id'];?>">Изтриване</a>
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
		<tr><td colspan='5' align='center'>Няма записи</td></tr>
		<?php
			}
		?>
		</table>
		</center>
		</div>
</div>
</body>
</html>