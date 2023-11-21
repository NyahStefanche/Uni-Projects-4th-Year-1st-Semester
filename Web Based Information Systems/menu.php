<div id="menu">
	<a href="index.php"> Начало </a>
	<a href="employee.php">Служители</a>
	<a href="departments.php"> Отдели</a>
	<a href="rooms.php"> Стаи</a>
	<a href="all.php"> Пълна информация</a>
<?php
if(isset($_SESSION['user']))
{
?>
	<a href="add_room.php"> Добави стая</a>
	<a href="add_department.php"> Добави отдел</a>
	<a href="add_employee.php"> Добави работник</a>
	<a href="logout.php"> Изход </a>
<?php
}
else
{
?>
<a href="login.php">Вход</a>
<?php
}
?>
	</div>