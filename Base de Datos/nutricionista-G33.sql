-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2023 a las 23:11:59
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
  `horario` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO `comida` (`idComida`, `nombre`, `detalle`, `cantCalorias`, `horario`) VALUES
(1, 'Tostadas', 'Pan tostado con mermelada', 200, 'DESAYUNO'),
(2, 'Ensalada', 'Ensalada de pollo', 400, 'ALMUERZO'),
(3, 'Yogur', 'Yogur con frutas', 150, 'MERIENDA'),
(4, 'Salmón', 'Salmón a la parrilla', 350, 'CENA'),
(5, 'Frutos secos', 'Mezcla de frutos secos', 250, 'SNACK'),
(6, 'Cereal', 'Cereal con leche y galletas', 300, 'DESAYUNO'),
(7, 'Pasta', 'Pasta con salsa de tomate', 450, 'ALMUERZO'),
(8, 'Manzana', 'Manzana con mantequilla de maní', 180, 'MERIENDA'),
(9, 'Tofu', 'Tofu a la parrilla', 320, 'CENA'),
(10, 'Galletas', 'Galletas integrales', 200, 'SNACK'),
(11, 'Ensalda', 'Ensalada con atun', 100, 'ALMUERZO');

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
  `fechaFinal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`idDieta`, `nombre`, `idPaciente`, `fechaInicial`, `pesoInicial`, `pesoFinal`, `fechaFinal`) VALUES
(1, 'Mediterránea', 1, '2023-10-01', 150, 140, '2023-10-15'),
(2, 'Keto', 2, '2023-10-02', 160, 150, '2023-10-16'),
(3, 'Paleo', 3, '2023-10-03', 170, 160, '2023-10-17'),
(4, 'Vegana', 4, '2023-10-04', 180, 170, '2023-10-18'),
(5, 'Vegetariana', 5, '2023-10-05', 190, 180, '2023-10-19'),
(6, 'Atkins', 6, '2023-10-06', 200, 190, '2023-10-20'),
(7, 'Ayuno Intermitente', 7, '2023-10-07', 210, 200, '2023-10-21'),
(8, 'DASH', 8, '2023-10-08', 220, 210, '2023-10-22'),
(9, 'Zona', 9, '2023-10-09', 230, 220, '2023-10-23'),
(10, 'Sopa de Col', 10, '2023-10-10', 240, 250, '2023-10-24'),
(11, 'Guerrero', 11, '2023-10-11', 250, 240, '2023-10-25'),
(12, 'Genotipo', 12, '2023-10-12', 260, 250, '2023-10-26'),
(13, 'Desintoxicación', 13, '2023-10-13', 270, 260, '2023-10-27'),
(14, 'Flexitariana', 14, '2023-10-14', 280, 270, '2023-10-28'),
(15, 'Montaña', 15, '2023-10-15', 290, 280, '2023-10-29'),
(16, 'Playa', 16, '2023-10-16', 300, 290, '2023-10-30'),
(17, 'South Beach', 17, '2023-10-17', 310, 300, '2023-10-31'),
(18, 'Sin Gluten', 18, '2023-10-18', 320, 310, '2023-11-01'),
(19, 'Baja en Carbohidratos', 19, '2023-10-19', 330, 320, '2023-11-02'),
(20, 'Cetogénica', 20, '2023-10-20', 340, 330, '2023-11-03'),
(21, 'Hipertrofia', 21, '2023-10-23', 100, 80, '2023-10-25'),
(22, 'Ayuno intermitente', 22, '2023-10-23', 100, 70, '2023-10-24');

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
(1, 1, 1, 'DESAYUNO'),
(2, 2, 2, 'ALMUERZO'),
(3, 3, 3, 'MERIENDA'),
(4, 4, 4, 'CENA'),
(5, 5, 5, 'SNACK'),
(6, 6, 6, 'DESAYUNO'),
(7, 7, 7, 'ALMUERZO'),
(8, 8, 8, 'MERIENDA'),
(9, 9, 9, 'CENA'),
(10, 10, 10, 'SNACK'),
(12, 6, 21, 'DESAYUNO'),
(13, 6, 21, 'DESAYUNO'),
(14, 2, 21, 'ALMUERZO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `idHistorial` int(11) NOT NULL,
  `idPaciente` int(11) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`idHistorial`, `idPaciente`, `peso`, `fechaRegistro`) VALUES
(1, 1, 70.5, '2020-01-10'),
(2, 2, 68.2, '2021-02-19'),
(3, 3, 75, '2022-03-05'),
(4, 4, 62.8, '2021-05-20'),
(5, 5, 80.1, '2021-07-30'),
(6, 6, 64.7, '2020-01-15'),
(7, 7, 72.3, '2022-01-11'),
(8, 8, 69.9, '2023-03-12'),
(9, 9, 78.4, '2022-05-13'),
(10, 10, 71, '2020-10-14'),
(11, 11, 73.2, '2021-12-20'),
(12, 12, 76.5, '2023-11-16'),
(13, 13, 67.8, '2022-08-18'),
(14, 14, 79.2, '2021-05-19'),
(15, 15, 63.4, '2020-03-20'),
(16, 16, 74.6, '2020-09-22'),
(17, 17, 70.2, '2020-03-21'),
(18, 18, 66, '2021-05-25'),
(19, 19, 82.3, '2022-02-26'),
(20, 20, 68.9, '2022-01-27'),
(21, 10, 120, '2023-10-25'),
(22, 10, 250, '2023-10-25'),
(23, 21, 100, '2023-10-23'),
(24, 21, 90, '2023-10-25'),
(25, 21, 95, '2023-10-25'),
(26, 21, 91, '2023-10-25'),
(27, 21, 88, '2023-10-25'),
(28, 21, 70, '2023-10-23'),
(29, 21, 60, '2023-10-23'),
(30, 22, 70, '2023-10-23'),
(32, 24, 100, '2023-10-23');

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
(1, 'Pérez', 'Juan', 12345678, 'Calle A, Ciudad A', '555-1111'),
(2, 'López', 'María', 23456789, 'Calle B, Ciudad B', '555-2222'),
(3, 'González', 'Carlos', 34567890, 'Calle C, Ciudad C', '555-3333'),
(4, 'Rodríguez', 'Ana', 45678901, 'Calle D, Ciudad D', '555-4444'),
(5, 'Martínez', 'Luis', 56789012, 'Calle E, Ciudad E', '555-5555'),
(6, 'Sánchez', 'Laura', 67890123, 'Calle F, Ciudad F', '555-6666'),
(7, 'Fernández', 'Diego', 78901234, 'Calle G, Ciudad G', '555-7777'),
(8, 'Torres', 'Patricia', 89012345, 'Calle H, Ciudad H', '555-8888'),
(9, 'Romero', 'Jorge', 90123456, 'Calle I, Ciudad I', '555-9999'),
(10, 'Díaz', 'Carmen', 12345677, 'Calle J, Ciudad J', '555-1010'),
(11, 'Pérez', 'Javier', 23456778, 'Calle K, Ciudad K', '555-1111'),
(12, 'García', 'María', 34567879, 'Calle L, Ciudad L', '555-1212'),
(13, 'Rodríguez', 'Daniel', 45678980, 'Calle M, Ciudad M', '555-1313'),
(14, 'Martínez', 'Laura', 56789091, 'Calle N, Ciudad N', '555-1414'),
(15, 'Sánchez', 'Paula', 67890102, 'Calle O, Ciudad O', '555-1515'),
(16, 'González', 'Martín', 78901213, 'Calle P, Ciudad P', '555-1616'),
(17, 'Fernández', 'Andrea', 89012324, 'Calle Q, Ciudad Q', '555-1717'),
(18, 'Torres', 'Francisco', 90123435, 'Calle R, Ciudad R', '555-1818'),
(19, 'Romero', 'María', 12345656, 'Calle S, Ciudad S', '555-1919'),
(20, 'Díaz', 'Guillermo', 23456767, 'Calle T, Ciudad T', '555-2020'),
(21, 'Candioti', 'Cristian', 37685390, 'Jr Viñas', '034155316928'),
(22, 'Candioti', 'Pedro', 48599300, 'Caferata', '0342123644'),
(24, 'Alejo', 'Carlos', 2222222, 'Barcos 20', '0333');

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
  ADD KEY `idComida` (`idComida`),
  ADD KEY `idDieta` (`idDieta`);

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
  MODIFY `idComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  MODIFY `idDietaComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `idHistorial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  ADD CONSTRAINT `dietacomida_ibfk_1` FOREIGN KEY (`idComida`) REFERENCES `comida` (`idComida`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dietacomida_ibfk_2` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`idDieta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
