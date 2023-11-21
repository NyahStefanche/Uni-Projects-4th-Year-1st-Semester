<?php
	session_start();
	include"db.php";
	if(!empty($_POST))
	{
		$query="SELECT * FROM admins
						 WHERE user='".$_POST['user']."'
						 AND password='".md5($_POST['pass'])."'";
		$result=mysqli_query($link,$query);
		$user_data=mysqli_fetch_assoc($result);
		if(!empty($user_data))
		{
			$_SESSION['user']=$user_data['user'];
			$_SESSION['type']=$user_data['type'];
			session_write_close();
			header("location: index.php");
			exit();
		}
		else $message="Грешно потребителско име или парола!";
	}	
?>
<html>
<head>
<title> Вход </title>
<link href="site.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="main">
<div id="menu">
<?php include("menu.php"); ?>
</div>
<div id="content">
<center>
<h2> Въведете потребителско име и парола </h2>
<?php if(isset($message)) echo$message; ?>
<form action="login.php" method="post">
<table align="center" border="1" style="border:1px solid#000000;">
<tr>
	<td> Потребител: </td>
	<td><input type="text"name="user" style="width:200px"/></td>
</tr>
<tr>
	<td> Парола:</td>
	<td><input type="password" name="pass" style="width:200px"/></td>
</tr>
</tr>
	<td colspan="2" align="center"><input type="submit" value="Вход"/></td>
</tr>
</table>
</form>
</center>
</div>
</div>
</body>
</html>