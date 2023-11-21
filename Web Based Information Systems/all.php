<?php
session_start();
?>
<html>
<head>
<title> Информация за всички служители на фирмата </title>
<link href="site.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="main">
	<?php include "menu.php";?>
	<div id="content">
	<center>
	<h2> Информация за всички служители на фирмата</h2>
	<table border="1">
	<tr>
	<th> Номер на служител</th>
	<th> Име </th>
	<th> Презиме</th>
	<th> Фамилия </th>
	<th> Отдел </th>
	<th> Стая </th>
	</tr>

<?php include "db.php";
	$query="SELECT employee.*,departments.*,rooms.*
	FROM employee
	LEFT JOIN departments
	ON employee.depart_id = departments.depart_id
	LEFT JOIN rooms ON employee.room_id= rooms.room_id
	ORDER BY pers_id";
	if($result=mysqli_query($link,$query))
	{
		while($row=mysqli_fetch_assoc($result)){
	?>
<tr>
	<td><?php echo$row['pers_id'];?></td>
	<td><?php echo$row['first'];?></td>
	<td><?php echo$row['father'];?></td>
	<td><?php echo$row['last'];?></td>
	<td><?php echo$row['depart_id'];?></td>
	<td><?php echo$row['room_id'];?></td>
</tr>
<?php
			}
	}
	else
	{
?>
<tr><td colspan='4' align='center'> Няма записи</td></tr>
<?php
	}
?>
	</table>
	</center>
	</div>
</div>
</body>
</html>