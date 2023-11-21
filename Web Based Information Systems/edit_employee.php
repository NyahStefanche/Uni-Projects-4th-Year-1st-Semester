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
	$query="UPDATE employee
		   SET first = '".$_POST['first']."',
		   father = '".$_POST['father']."',
		   last = '".$_POST['last']."',
		   sex = '".$_POST['sex']."',
		   b_day = '".$_POST['b_day']."',
		   city = '".$_POST['city']."',
		   street = '".$_POST['street']."',
		   phone = '".$_POST['phone']."',
		   depart_id = '".$_POST['depart_id']."',
		   room_id = '".$_POST['room_id']."'
		   WHERE pers_id='".$_GET['pers_id']."'";
	if($result=mysqli_query($link,$query))
					$message="Служителят е обновен успешно";
				else
					$message="Грешка при обновяването";
	
	$_GET['first']=$_POST['first'];
}

if (isset($_GET["pers_id"]))
{
	$query="SELECT * FROM employee WHERE pers_id='".$_GET['pers_id']."'";
	$result=mysqli_query($link,$query);
	$data=mysqli_fetch_assoc($result);
}
?>
<html>
<head>
	<title>Обновяване на служител</title>
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
	<h2> Обновяване на служител</h2>
	<?php if(isset($message)) echo$message; ?>
	<form method="POST" action="edit_employee.php?pers_id=<?php echo$_GET['pers_id'];?>">
	<table border="1">
	<tr>
		<td>Име</td>
		<td><input type="text" name="first" value="<?php echo $data['first'];?>"/></td>
	</tr>
	<tr>
		<td>Бащино</td>
		<td><input type="text" name="father" value="<?php echo $data['father'];?>"/></td>
	</tr>
	<tr>
		<td>Фамилия</td>
		<td><input type="text" name="last" value="<?php echo $data['last'];?>"/></td>
	</tr>
	<tr>
		<td>Пол</td>
		<td><input type="text" name="sex" value="<?php echo $data['sex'];?>"/></td>
	</tr>
	<tr>
		<td>Дата на раждане</td>
		<td><input type="text" name="b_day" value="<?php echo $data['b_day'];?>"/></td>
	</tr>
	<tr>
		<td>Град</td>
		<td><input type="text" name="city" value="<?php echo $data['city'];?>"/></td>
	</tr>
	<tr>
		<td>Улица</td>
		<td><input type="text" name="street" value="<?php echo $data['street'];?>"/></td>
	</tr>
	<tr>
		<td>Телефон</td>
		<td><input type="text" name="phone" value="<?php echo $data['phone'];?>"/></td>
	</tr>
	<tr>
		<td>Номер на отдел</td>
		<td><input type="text" name="depart_id" value="<?php echo $data['depart_id'];?>"/></td>
	</tr>
	<tr>
		<td>Номер на стая</td>
		<td><input type="text" name="room_id" value="<?php echo $data['room_id'];?>"/></td>
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