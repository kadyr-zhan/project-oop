-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 04 2020 г., 09:07
-- Версия сервера: 10.4.11-MariaDB
-- Версия PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `users`
--

-- --------------------------------------------------------

--
-- Структура таблицы `nutrition`
--

CREATE TABLE `nutrition` (
  `bodytype` varchar(30) CHARACTER SET utf8 NOT NULL,
  `nutrition` mediumtext CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `nutrition`
--

INSERT INTO `nutrition` (`bodytype`, `nutrition`) VALUES
('Ectomorph', '1.Eat every two to four hours.\r\n2.Add at least 500 calories if you want to gain weight or muscle.\r\n3.Choose warm foods over cold foods (better for digestion).\r\n4.Best starchy carbohydrates include oats, brown rice, quinoa, sweet potatoes and potatoes.\r\n5.Best fruit choices include bananas, mangoes, pineapple, papaya, avocado and peaches.\r\n6.Best vegetable choices include broccoli, cauliflower, brussel sprouts, beets and carrots, especially cooked in coconut oil or ghee (clarified butter).\r\n7.Nutrient dense snacks include nuts and seeds, as well as nut butters. '),
('endomorph', 'Because endomorphs tend to be carbohydrate and insulin sensitive, the best nutrition plan for this body type focuses on an even distribution of macronutrients, with carbohydrates coming mostly  from vegetables and smaller amounts of unrefined, high-fiber starches, like quinoa and amaranth. Stay away from the bread, cereal, cracker and cookie aisles of the supermarket! A Paleo-like diet is best suited for an endomorph, where each meal contains protein, vegetables and some healthy fats, like avocado or olive oil. Aim for a nutrient distribution close to 30 percent carbs, 35 percent protein and 35 percent fat.'),
('Endomorph', 'Because endomorphs tend to be carbohydrate and insulin sensitive, the best nutrition plan for this body type focuses on an even distribution of macronutrients, with carbohydrates coming mostly  from vegetables and smaller amounts of unrefined, high-fiber starches, like quinoa and amaranth. Stay away from the bread, cereal, cracker and cookie aisles of the supermarket! A Paleo-like diet is best suited for an endomorph, where each meal contains protein, vegetables and some healthy fats, like avocado or olive oil. Aim for a nutrient distribution close to 30 percent carbs, 35 percent protein and 35 percent fat.'),
('Mesomorph', 'Including small amounts of protein in every meal helps with muscle repair and building. Excellent protein sources include eggs (whole or whites), chicken, turkey, fish, beans, lentils, Greek yogurt and protein powder.\r\n\r\nCarbohydrates are just as important, as the body requires glucose for energy production as well as glycogen resynthesis after exercise. Mesomorphs should mix up their carbohydrate choices to include vegetables, fruit and whole grains, such as quinoa, brown rice and oatmeal. These carbohydrate examples provide belly-filling fiber as well as antioxidants and phytochemicals that help repair exercise-induced muscle damage. Choose seasonal and colorful fruits and vegetables, and make sure to choose organic if it is one of the Dirty Dozen.\r\nHealthy fats, such as nuts, seeds, avocado, coconut oil and olive oil, round out a healthy diet as they contain inflammatory compounds and help promote satiety.');

-- --------------------------------------------------------

--
-- Структура таблицы `training`
--

CREATE TABLE `training` (
  `bodytype` varchar(30) CHARACTER SET utf8 NOT NULL,
  `musclegroup` varchar(30) CHARACTER SET utf8 NOT NULL,
  `exercise` mediumtext CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `training`
--

INSERT INTO `training` (`bodytype`, `musclegroup`, `exercise`) VALUES
('Ectomorph', 'Arms', '1.Barbell Deadlift 3x5\r\n2.Barbell Sumo Deadlift 2x5\r\n3.DB Single Arm Row 2x7\r\n4.Pull-Ups 3x5\r\n5.Barbell Bent Over Rows 3x5'),
('Ectomorph', 'Legs', '1.Back Squat 4x4\r\n2.Front Squat 3x6\r\n3.Hack Squat 4x5\r\n4.Goblet Squat 3x6\r\n5.Stiff-Leg Deadlift 4x5'),
('Ectomorph', 'ABS', '1.Plank 1 min\r\n2.Scissors 3x5\r\n3.Crunches 1 min'),
('Mesomorph', 'Arms', '1.EZ Bar Curl 4x12\r\n2. DB Curl 4x12\r\n3.Hummer Curl 4x10\r\n4.Skull crushers 4x10'),
('Mesomorph', 'Legs', '1.Leg extensions 4x15\r\n2.Leg press 4x15\r\n3.Walking lunges 3x20\r\n4.Hack squats 4x12'),
('Mesomorph', 'ABS', '1.Crunches 10x1\r\n2.Air byke crunches 10x1\r\n3.Sitting twists 10x1\r\n4.Plank 1.5 min\r\n'),
('Endomorph', 'Arms', '1.Dips 4x15\r\n2.Pushdowns 4x15\r\n3.Skull crushers 4x15\r\n4.Hammer curl 4x15'),
('Endomorph', 'Legs', '1.Romanian deadlifts 3x20\r\n2.Lying leg curls 3x20\r\n3.Leg extensions 3x20\r\n4.Leg press 4x15'),
('Endomorph', 'ABS', '1.Crunches 20sec\r\n2.Flutter kicks 20sec\r\n3.High crunches 20sec\r\n4.Raised leg circles 20sec');

-- --------------------------------------------------------

--
-- Структура таблицы `usersinfo`
--

CREATE TABLE `usersinfo` (
  `id` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 NOT NULL,
  `login` varchar(30) CHARACTER SET utf8 NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 NOT NULL,
  `bodytype` varchar(30) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `usersinfo`
--

INSERT INTO `usersinfo` (`id`, `name`, `login`, `password`, `bodytype`) VALUES
(1, 'kadyrzhan', 'kadyr', '123', 'Mesomorph'),
(2, 'bireu', 'smth', '456', 'Endomorph'),
(3, 'ecto', 'ectopus', '789', 'Ectomorph');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `usersinfo`
--
ALTER TABLE `usersinfo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `usersinfo`
--
ALTER TABLE `usersinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
