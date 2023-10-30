-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2023 a las 01:56:12
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nutricionista`
--
CREATE DATABASE IF NOT EXISTS `nutricionista` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `nutricionista`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida`
--

CREATE TABLE `comida` (
  `idComida` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `cantCalorias` int(11) NOT NULL,
  `Horario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO `comida` (`idComida`, `nombre`, `detalle`, `cantCalorias`, `Horario`) VALUES
(57, 'Batido de Bananas', 'batido de bananas y leche', 250, 'DESAYUNO'),
(58, 'Avena con plátano', 'Avena cocida con plátano y almendras', 250, 'DESAYUNO'),
(59, 'Yogur con fresas', 'Yogur natural con fresas frescas y miel', 200, 'DESAYUNO'),
(60, 'Tostadas integrales', 'Tostadas integrales con aguacate y huevo pochado', 300, 'DESAYUNO'),
(61, 'Batido de proteínas', 'Batido de proteínas con espinacas y frutas', 220, 'DESAYUNO'),
(62, 'Salmón a la parrilla', 'Salmón fresco a la parrilla con espárragos y quinua', 350, 'ALMUERZO'),
(63, 'Ensalada de pollo', 'Ensalada de pollo a la parrilla con aguacate y vinagreta', 400, 'ALMUERZO'),
(64, 'Wrap de pavo', 'Wrap de pavo con verduras y hummus', 320, 'ALMUERZO'),
(65, 'Ensalada de garbanzos', 'Ensalada de garbanzos con atún y aceitunas', 300, 'ALMUERZO'),
(66, 'Tofu con brócoli', 'Tofu salteado con brócoli y salsa de soja', 280, 'ALMUERZO'),
(67, 'Hummus con zanahorias', 'Hummus casero con zanahorias crujientes', 200, 'MERIENDA'),
(68, 'Yogur griego con frutas', 'Yogur griego con fresas y arándanos', 180, 'MERIENDA'),
(69, 'Almendras', 'Almendras crudas para un bocadillo saludable', 160, 'MERIENDA'),
(70, 'Manzana con mantequilla de almendras', 'Manzana con mantequilla de almendras', 220, 'MERIENDA'),
(71, 'Salmón al horno', 'Salmón al horno con espárragos y quinua', 350, 'CENA'),
(72, 'Ensalada de atún', 'Ensalada de atún con espinacas, huevo duro y aceite de oliva', 220, 'CENA'),
(73, 'Tofu salteado con brócoli', 'Tofu salteado con brócoli y salsa de soja baja en sodio', 220, 'CENA'),
(74, 'Sopa de lentejas', 'Sopa casera de lentejas con verduras', 180, 'CENA'),
(75, 'Pechuga de pavo', 'Pechuga de pavo magra con espinacas y tomates', 180, 'CENA'),
(76, 'Quinua con verduras', 'Quinua cocida con brócoli, pimientos y champiñones', 250, 'ALMUERZO'),
(77, 'Pollo a la plancha', 'Pechuga de pollo a la plancha con brócoli al vapor', 300, 'ALMUERZO'),
(78, 'Arroz a la valenciana', 'Arroz con verduras', 450, 'DESAYUNO'),
(79, 'Manzana', 'Fruta fresca', 52, 'SNACK'),
(80, 'Zanahoria', 'Vegetal crudo', 41, 'SNACK'),
(81, 'Yogur natural', 'Lácteo bajo en grasa', 59, 'SNACK'),
(82, 'Almendras', 'Nueces crudas', 576, 'SNACK'),
(83, 'Hummus', 'Dip de garbanzos', 166, 'SNACK'),
(84, 'Palomitas de maíz', 'Granos de maíz reventados', 375, 'SNACK'),
(85, 'Edamame', 'Soja verde inmadura', 122, 'SNACK'),
(86, 'Pepino', 'Vegetal fresco', 15, 'SNACK'),
(87, 'Queso cottage', 'Lácteo bajo en grasa', 98, 'SNACK'),
(88, 'Huevo duro', 'Proteína completa', 68, 'SNACK'),
(89, 'Avena', 'Grano entero cocido', 154, 'SNACK'),
(90, 'Plátano', 'Fruta fresca', 105, 'SNACK'),
(91, 'Ciruelas pasas', 'Fruta seca', 240, 'SNACK'),
(92, 'Naranja', 'Fruta fresca', 43, 'SNACK'),
(93, 'Fresas', 'Fruta fresca', 32, 'SNACK'),
(94, 'Uvas', 'Fruta fresca', 69, 'SNACK'),
(95, 'Kiwi', 'Fruta fresca', 41, 'SNACK'),
(96, 'Melocotón', 'Fruta fresca', 39, 'SNACK'),
(97, 'Piña', 'Fruta fresca', 50, 'SNACK'),
(98, 'Mango', 'Fruta fresca', 60, 'SNACK'),
(99, 'Chuletas', 'Chuletas de cerdo', 100, 'CENA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `idDieta` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `fechaInicial` date NOT NULL,
  `pesoInicial` double NOT NULL,
  `pesoFinal` double NOT NULL,
  `fechaFinal` date NOT NULL,
  `altura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`idDieta`, `nombre`, `idPaciente`, `fechaInicial`, `pesoInicial`, `pesoFinal`, `fechaFinal`, `altura`) VALUES
(16, 'Mediterranea', 48, '2023-12-15', 80, 60, '2023-12-15', 168),
(17, 'Hiposodica', 44, '2023-10-15', 100, 90, '2023-12-15', 0),
(18, 'Diabetica', 46, '2023-10-16', 80, 70, '2023-11-16', 0),
(19, 'hipertrofica', 46, '2023-08-16', 95, 70, '2023-10-16', 0),
(20, 'cualquiera', 40, '2023-09-01', 100, 80, '2023-10-01', 0),
(22, 'Musculacion', 57, '2023-10-23', 80, 77, '2023-10-29', 180);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dietacomida`
--

CREATE TABLE `dietacomida` (
  `idDietaComida` int(11) NOT NULL,
  `idComida` int(11) NOT NULL,
  `idDieta` int(11) NOT NULL,
  `Horario` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dietacomida`
--

INSERT INTO `dietacomida` (`idDietaComida`, `idComida`, `idDieta`, `Horario`) VALUES
(52, 57, 16, 'DESAYUNO'),
(53, 58, 16, 'DESAYUNO'),
(54, 61, 16, 'DESAYUNO'),
(55, 63, 16, 'ALMUERZO'),
(56, 77, 16, 'ALMUERZO'),
(57, 62, 16, 'ALMUERZO'),
(58, 71, 16, 'CENA'),
(59, 74, 16, 'CENA'),
(60, 70, 16, 'MERIENDA'),
(61, 68, 16, 'MERIENDA'),
(63, 57, 17, 'DESAYUNO'),
(64, 61, 17, 'DESAYUNO'),
(65, 77, 17, 'ALMUERZO'),
(66, 62, 17, 'ALMUERZO'),
(67, 76, 17, 'ALMUERZO'),
(68, 68, 17, 'MERIENDA'),
(69, 69, 17, 'MERIENDA'),
(70, 72, 17, 'CENA'),
(71, 69, 18, 'MERIENDA'),
(72, 78, 18, 'DESAYUNO'),
(73, 57, 18, 'DESAYUNO'),
(74, 72, 20, 'CENA'),
(75, 69, 22, 'MERIENDA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `idHistorial` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `peso` double NOT NULL,
  `fechaRegistro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`idHistorial`, `idPaciente`, `peso`, `fechaRegistro`) VALUES
(11, 48, 70, '2023-10-15'),
(12, 44, 100, '2023-10-15'),
(13, 44, 97, '2023-10-15'),
(14, 46, 80, '2023-10-16'),
(15, 46, 79, '2023-10-16'),
(16, 46, 95, '2023-08-16'),
(18, 40, 100, '2023-09-01'),
(19, 40, 99, '2023-10-13'),
(20, 40, 95, '2023-10-14'),
(21, 40, 94, '2023-10-15'),
(22, 40, 92, '2023-10-06'),
(23, 40, 90, '2023-10-12'),
(24, 40, 79, '2023-10-14'),
(25, 40, 80, '2023-10-14'),
(26, 40, 81, '2023-10-16'),
(27, 54, 120, '2023-10-20'),
(28, 46, 93, '2023-10-20'),
(29, 46, 80, '2023-10-20'),
(30, 56, 100, '2023-10-25'),
(31, 56, 105, '2023-10-29'),
(32, 57, 80, '2023-10-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `apellido` varchar(70) NOT NULL,
  `nombre` varchar(70) NOT NULL,
  `dni` int(11) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `apellido`, `nombre`, `dni`, `domicilio`, `telefono`) VALUES
(30, 'González', 'María', 10000001, 'Calle A, Nº 123', '555-1234'),
(31, 'Rodríguez', 'Juan', 10000002, 'Avenida B, Nº 456', '555-2345'),
(32, 'López', 'Carlos', 10000003, 'Calle C, Nº 789', '555-3456'),
(33, 'Pérez', 'Laura', 10000004, 'Avenida D, Nº 012', '555-4567'),
(34, 'Martínez', 'Diego', 10000005, 'Calle E, Nº 1234', '555-5678'),
(35, 'Fernández', 'Ana', 10000006, 'Avenida F, Nº 2345', '555-6789'),
(36, 'Sánchez', 'Pedro', 10000007, 'Calle G, Nº 3456', '555-7890'),
(37, 'Ramírez', 'Luis', 10000008, 'Avenida H, Nº 4567', '555-8901'),
(38, 'Torres', 'Marta', 10000009, 'Calle I, Nº 5678', '555-9012'),
(39, 'Gómez', 'Javier', 10000010, 'Avenida J, Nº 6789', '555-1234'),
(40, 'Luna', 'Sofía', 10000011, 'Calle K, Nº 7890', '555-2345'),
(41, 'Díaz', 'Andrés', 10000012, 'Avenida L, Nº 8901', '555-3456'),
(42, 'Vargas', 'Carmen', 10000013, 'Calle M, Nº 9012', '555-4567'),
(43, 'Ortega', 'Miguel', 10000014, 'Avenida N, Nº 0123', '555-5678'),
(44, 'Chávez', 'Elena', 10000015, 'Calle O, Nº 1234', '555-6789'),
(45, 'Silva', 'Ricardo', 10000016, 'Avenida P, Nº 2345', '555-7890'),
(46, 'Ríos', 'Luisa', 10000017, 'Calle Q, Nº 3456', '555-8901'),
(47, 'Mendoza', 'Alejandro', 10000018, 'Avenida R, Nº 4567', '555-9012'),
(48, 'Castro', 'Valeria', 10000019, 'Calle S, Nº 5678', '555-1234'),
(49, 'Núñez', 'Fernando', 10000020, 'Avenida T, Nº 6789', '555-2345'),
(54, 'Gomez', 'Cristian', 32413421, 'Pje monserrat 2528', '4344467'),
(56, 'Aguilar', 'pedro', 12312321, 'asdasd', '12345'),
(57, 'Candioti', 'Cristian', 37685390, 'Jr VIÑAS 9753', '03421236543');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`idComida`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`idDieta`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  ADD PRIMARY KEY (`idDietaComida`),
  ADD KEY `dietacomida_ibfk_1` (`idComida`),
  ADD KEY `dietacomida_ibfk_2` (`idDieta`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`idHistorial`),
  ADD KEY `historial_ibfk_1` (`idPaciente`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comida`
--
ALTER TABLE `comida`
  MODIFY `idComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  MODIFY `idDietaComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `idHistorial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE;

--
-- Filtros para la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  ADD CONSTRAINT `dietacomida_ibfk_1` FOREIGN KEY (`idComida`) REFERENCES `comida` (`idComida`) ON DELETE CASCADE,
  ADD CONSTRAINT `dietacomida_ibfk_2` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`idDieta`) ON DELETE CASCADE;

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
