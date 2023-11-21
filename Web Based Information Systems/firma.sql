-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 
-- Версия на сървъра: 10.1.37-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `firma`
--
CREATE DATABASE IF NOT EXISTS `firma` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `firma`;

-- --------------------------------------------------------

--
-- Структура на таблица `departments`
--

CREATE TABLE `departments` (
  `depart_id` int(10) UNSIGNED NOT NULL,
  `depart` varchar(50) NOT NULL,
  `function` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Схема на данните от таблица `departments`
--

INSERT INTO `departments` (`depart_id`, `depart`, `function`) VALUES
(1, 'Администрация', 'Управленски функции'),
(2, 'Счетоводен', 'Сметки и плащания'),
(3, 'Снабдяване', 'Доставка и материали за производство'),
(4, 'Експедиция', 'Разпределение на готова продукция'),
(5, 'Експлоатация', 'Произвежда продукция'),
(6, 'Транспорт', 'Доставка на готовата продукция');

-- --------------------------------------------------------

--
-- Структура на таблица `employee`
--

CREATE TABLE `employee` (
  `pers_id` int(10) UNSIGNED NOT NULL,
  `first` varchar(20) NOT NULL,
  `father` varchar(20) NOT NULL,
  `last` varchar(20) NOT NULL,
  `sex` enum('мъж','жена') NOT NULL,
  `b_day` date NOT NULL,
  `city` varchar(50) NOT NULL,
  `street` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `depart_id` int(10) UNSIGNED NOT NULL,
  `room_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Схема на данните от таблица `employee`
--

INSERT INTO `employee` (`pers_id`, `first`, `father`, `last`, `sex`, `b_day`, `city`, `street`, `phone`, `depart_id`, `room_id`) VALUES
(1, 'Петър', 'Иванов', 'Тодоров', 'мъж', '1952-10-16', 'Шумен', 'Петра 23', '(054) 4-23-21', 2, 111),
(2, 'Ивайло', 'Петров', 'Иванов', 'мъж', '1966-10-15', 'Шумен', 'Априлов 2', '(054) 6-46-33', 3, 3),
(3, 'Вяра', 'Крумова', 'Пеева', 'жена', '1965-09-23', 'Шумен', 'А. Златаров 5', '(054) 3-25-45', 1, 53),
(4, 'Соня', 'Илиева', 'Томова', 'жена', '1971-07-31', 'Шумен', 'Вит 13', '(054) 5-23-15', 4, 64),
(5, 'Иван', 'Иванов', 'Гюмов', 'мъж', '1960-11-13', 'Шумен', 'Брезник 12', '(054) 2-34-66', 5, 14),
(6, 'Владимир', 'Капчев', 'Генов', 'мъж', '1970-01-21', 'Шумен', 'Батак 43', '(054) 3-78-97', 3, 3),
(7, 'Велислава', 'Петрова', 'Динова', 'жена', '1965-10-22', 'София', 'Младост 2', '(02) 33-45-71', 2, 111),
(8, 'Мария', 'Янева', 'Петрова', 'жена', '1972-04-21', 'Плевен', 'Средна гора 2', '(064) 21-33-67', 1, 53);

-- --------------------------------------------------------

--
-- Структура на таблица `rooms`
--

CREATE TABLE `rooms` (
  `room_id` int(10) UNSIGNED NOT NULL,
  `floor` int(1) UNSIGNED NOT NULL,
  `l_r` set('Ляво','Дясно') NOT NULL,
  `square_surface` decimal(10,2) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Схема на данните от таблица `rooms`
--

INSERT INTO `rooms` (`room_id`, `floor`, `l_r`, `square_surface`) VALUES
(3, 1, 'Ляво', '45.00'),
(14, 3, 'Ляво', '25.00'),
(53, 5, 'Дясно', '40.00'),
(64, 4, 'Дясно', '15.00'),
(111, 2, 'Ляво', '35.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`depart_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`pers_id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`room_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `departments`
--
ALTER TABLE `departments`
  MODIFY `depart_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `pers_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
