-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-12-2022 a las 03:43:37
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `crudterminado`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--


CREATE TABLE `socios` (
  `idSocio` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `cuil` varchar(11) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `localidad` varchar(40) NOT NULL,
  `codigoPostal` varchar(6) NOT NULL,
  `peso` float(40) NOT NULL,
  `fnac` date NOT NULL,
  `email` varchar(30) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `activo` boolean NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`idSocio`, `nombre`, `apellido`, `dni`, `cuil`, `direccion`, `localidad`, `codigoPostal`, `peso`, `fnac`, `email`, `telefono`, `activo`) VALUES
(1, 'Pablo', 'Moldes', '34875167', '20348751674', 'San Martín 424', 'Quilmes', '1878', 85.4, '1993-12-11', 'pmoldes@gmail.com', '1145786784', true),
(2, 'Juan', 'Perez', '38545127', '20385451274', 'Rivadavia 784', 'Quilmes', '1878', 75.1, '1993-01-12', 'jperez@gmail.com', '1124575154', false),

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `socios`
--
ALTER TABLE `socios`
  ADD PRIMARY KEY (`idSocio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `socios`
--
ALTER TABLE `socios`
  MODIFY `idSocio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
