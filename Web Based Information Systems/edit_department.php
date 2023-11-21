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
	$query="UPDATE departments
		   SET depart_id='".$_POST['depart_id']."',
		   depart = '".$_POST['depart']."',
		   function = '".$_POST['function']."'
		   WHERE depart_id='".$_GET['depart_id']."'";
	if($result=mysqli_query($link,$query))
					$message="Отдела е обновена успешно";
				else
					$message="Грешка при обновяването";
	
	$_GET['depart_id']=$_POST['depart_id'];
}

if (isset($_GET["depart_id"]))
{
	$query="SELECT * FROM departments WHERE depart_id='".$_GET['depart_id']."'";
	$result=mysqli_query($link,$query);
	$data=mysqli_fetch_assoc($result);
}
?>
<html>
<head>
	<title>Обновяване на отдел</title>
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
	<h2> Обновяване на отдел</h2>
	<?php if(isset($message)) echo$message; ?>
	<form method="POST" action="edit_department.php?depart_id=<?php echo $_GET['depart_id'];?>">
	<table border="1">
	<tr>
		<td> Номер на отдела</td>
		<td><input type="text" name="depart_id" value="<?php echo $data['depart_id'];?>"/></td>
	</tr>
	<tr>
		<td>Отдел</td>
		<td><input type="text" name="depart" value="<?php echo $data['depart'];?>"/></td>
	</tr>
	<tr>
		<td>Дейност</td>
		<td><input type="text" name="function" value="<?php echo $data['function'];?>"/></td>
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