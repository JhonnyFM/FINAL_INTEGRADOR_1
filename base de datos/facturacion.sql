-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-12-2020 a las 00:40:36
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `facturacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `codCliente` int(11) NOT NULL,
  `nombres` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codCliente`, `nombres`, `apellidos`, `direccion`) VALUES
(1, 'Manuel', 'Neuer', 'ca. Alemania'),
(2, 'Robert', 'Lewandowski', 'polonia'),
(3, 'Jorge', 'Benavides', 'ca. latina'),
(4, 'Anthony Steve', 'Mandujano', 'ca. sol'),
(5, 'Ricardo Alonso', 'Gutierrez Velasco', 'ca. san genaro'),
(6, 'Miguel', 'Delgado', 'av. argentina 169'),
(11, 'jordan', 'pauca', 'ARMATAMBO'),
(12, 'yoel', 'monge', 'qweqe'),
(13, 'carlos', 'correa', 'ventanilla'),
(14, 'luis', 'guerra', 'callao'),
(15, 'faride', 'rodriguez', 'san isidro'),
(16, 'eduardo', 'maguiña', 'lince'),
(17, 'rocio', 'carbajal', 'lima'),
(23, 'carlos', 'slim', 'ytrytr');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallefactura`
--

CREATE TABLE `detallefactura` (
  `codDetalle` int(11) NOT NULL,
  `codFactura` int(11) NOT NULL,
  `codProducto` int(11) NOT NULL,
  `codBarra` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `nombreProducto` varchar(75) COLLATE utf8_spanish_ci NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioVenta` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `detallefactura`
--

INSERT INTO `detallefactura` (`codDetalle`, `codFactura`, `codProducto`, `codBarra`, `nombreProducto`, `cantidad`, `precioVenta`, `total`) VALUES
(57, 5, 1, '10101010', 'TECLADO USB', 7, '90.00', '630.00'),
(58, 6, 4, '10101013', 'CASE ATX', 9, '300.00', '2700.00'),
(59, 7, 4, '10101013', 'CASE ATX', 9, '300.00', '2700.00'),
(60, 8, 5, '10101014', 'WEBCAM', 5, '80.00', '400.00'),
(61, 8, 7, '10101016', 'SSD 1TB', 4, '800.00', '3200.00'),
(62, 9, 7, '10101016', 'SSD 1TB', 5, '800.00', '4000.00'),
(63, 10, 6, '10101015', 'MEMORIA RAM 8 GB DDR4', 8, '150.00', '1200.00'),
(64, 10, 5, '10101014', 'WEBCAM', 5, '80.00', '400.00'),
(65, 11, 1, '10101010', 'TECLADO USB', 7, '90.00', '630.00'),
(66, 12, 1, '10101010', 'TECLADO USB', 6, '90.00', '540.00'),
(67, 12, 6, '10101015', 'MEMORIA RAM 8 GB DDR4', 9, '150.00', '1350.00'),
(68, 13, 5, '10101014', 'WEBCAM', 4, '80.00', '320.00'),
(69, 13, 7, '10101016', 'SSD 1TB', 1, '800.00', '800.00'),
(70, 14, 7, '10101016', 'SSD 1TB', 2, '800.00', '1600.00'),
(71, 14, 1, '10101010', 'TECLADO USB', 1, '90.00', '90.00'),
(72, 14, 4, '10101013', 'CASE ATX', 2, '300.00', '600.00'),
(73, 16, 5, '10101014', 'WEBCAM', 2, '80.00', '160.00'),
(74, 17, 3, '10101012', 'PANTALLA LED 32°', 4, '250.00', '1000.00'),
(75, 18, 4, '10101013', 'CASE ATX', 1, '300.00', '300.00'),
(76, 20, 5, '10101014', 'WEBCAM', 1, '80.00', '80.00'),
(77, 22, 7, '10101016', 'SSD 1TB', 1, '800.00', '800.00'),
(78, 23, 6, '10101015', 'MEMORIA RAM 8 GB DDR4', 9, '150.00', '1350.00'),
(79, 25, 4, '10101013', 'CASE ATX', 2, '300.00', '600.00'),
(80, 26, 6, '10101015', 'MEMORIA RAM 8 GB DDR4', 9, '150.00', '1350.00'),
(81, 27, 7, '10101016', 'SSD 1TB', 1, '800.00', '800.00'),
(82, 29, 6, '10101015', 'MEMORIA RAM 8 GB DDR4', 1, '150.00', '150.00'),
(83, 30, 6, '10101015', 'MEMORIA RAM 8 GB DDR4', 2, '150.00', '300.00'),
(84, 31, 7, '10101016', 'SSD 1TB', 1, '800.00', '800.00'),
(85, 32, 7, '10101016', 'SSD 1TB', 12, '800.00', '9600.00');

--
-- Disparadores `detallefactura`
--
DELIMITER $$
CREATE TRIGGER `trgActualizarstock` AFTER INSERT ON `detallefactura` FOR EACH ROW BEGIN
  update producto set stockActual=stockActual-NEW.cantidad where codProducto=NEW.codProducto;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `codFactura` int(11) NOT NULL,
  `numeroFactura` int(11) NOT NULL,
  `codVendedor` int(11) NOT NULL,
  `codCliente` int(11) NOT NULL,
  `totalVenta` decimal(10,2) NOT NULL,
  `fechaRegistro` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`codFactura`, `numeroFactura`, `codVendedor`, `codCliente`, `totalVenta`, `fechaRegistro`) VALUES
(5, 1, 2, 2, '630.00', '2020-12-20 00:07:08'),
(6, 2, 2, 11, '2700.00', '2020-12-20 00:07:08'),
(7, 3, 2, 2, '2700.00', '2020-12-20 00:07:08'),
(8, 4, 2, 13, '3600.00', '2020-12-20 00:07:08'),
(9, 5, 2, 11, '4000.00', '2020-12-20 00:07:08'),
(10, 6, 2, 14, '1600.00', '2020-12-20 00:07:08'),
(11, 7, 3, 23, '630.00', '2020-12-20 00:07:08'),
(12, 8, 3, 2, '1890.00', '2020-12-20 00:07:08'),
(13, 9, 3, 15, '1120.00', '2020-12-20 00:07:08'),
(14, 10, 3, 17, '2290.00', '2020-12-20 00:07:08'),
(16, 11, 3, 1, '160.00', '2020-12-20 00:07:08'),
(17, 12, 3, 1, '1000.00', '2020-12-20 00:07:08'),
(18, 13, 3, 3, '300.00', '2020-12-20 00:07:08'),
(20, 14, 3, 4, '80.00', '2020-12-20 00:07:08'),
(22, 15, 3, 5, '800.00', '2020-12-20 00:07:08'),
(23, 16, 3, 6, '1350.00', '2020-12-20 00:07:08'),
(25, 17, 3, 4, '600.00', '2020-12-20 00:07:08'),
(26, 18, 3, 1, '1350.00', '2020-12-20 00:07:08'),
(27, 19, 3, 6, '800.00', '2020-12-20 00:07:08'),
(29, 20, 3, 2, '150.00', '2020-12-20 00:07:08'),
(30, 21, 3, 16, '300.00', '2020-12-20 00:07:08'),
(31, 22, 3, 5, '800.00', '2020-12-20 00:07:08'),
(32, 23, 3, 12, '9600.00', '2020-12-20 00:07:08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codProducto` int(11) NOT NULL,
  `nombreProducto` varchar(80) NOT NULL,
  `precioVenta` decimal(8,2) NOT NULL,
  `stockMinimo` int(11) NOT NULL,
  `stockActual` int(11) NOT NULL,
  `codBarra` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codProducto`, `nombreProducto`, `precioVenta`, `stockMinimo`, `stockActual`, `codBarra`) VALUES
(1, 'TECLADO USB', '90.00', 10, 32, '10101010'),
(3, 'PANTALLA LED 32°', '250.00', 10, 90, '10101012'),
(4, 'CASE ATX', '300.00', 10, 41, '10101013'),
(5, 'WEBCAM', '80.00', 20, 38, '10101014'),
(6, 'MEMORIA RAM 8 GB DDR4', '150.00', 15, 1, '10101015'),
(7, 'SSD 1TB', '800.00', 25, 37, '10101016'),
(8, 'LAPTOP DELL 5577 5000 I5-7300HQ', '3500.00', 2, 5, 'RLRKKSZBZVTQNDF'),
(9, 'LAPTOP LENOVO L340-15IWL I5-8250U', '1960.00', 4, 10, 'ATQBOJZEQCKSVBK'),
(10, 'MB ASUS PRIME A320M-K ( PRIME A320M-K ) AM4', '255.00', 3, 10, 'WPFFAJVCBYFABMC'),
(11, 'MB GIGABYTE A320M-S2H ( GA-A320M-S2H ) AM4', '241.00', 10, 2, 'ZNBDPVFDUAYQHAI'),
(12, 'MB NZXT Z370 N7 ( N7-Z37XT-B1 ) LGA 1151 / NEGRO', '1005.00', 10, 8, 'BMXVWPFDFKDUYDD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `codUsuario` int(11) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `codVendedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`codUsuario`, `nombreUsuario`, `password`, `codVendedor`) VALUES
(1, 'pauca', 'acb8d4e77a66169d8b611d4107b1fdfbaf0a75f065c995d788517f406e3043e0f17d9b8ec4e6129e8e4b0cf3cc7b33eaac11304f5777385d6d8c8f760527ce63', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `codVendedor` int(11) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `dni` int(8) NOT NULL,
  `celular` int(10) NOT NULL,
  `direccion` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`codVendedor`, `nombres`, `apellidos`, `dni`, `celular`, `direccion`) VALUES
(1, 'Luis', 'Becerra', 45675432, 987645321, 'chorrillos'),
(2, 'Miguel', 'Trauco', 56785432, 987654789, 'Iquitos'),
(3, 'Roberto', 'Pauca Laos', 56432178, 987534128, 'ca. cesar vallejo mz. 12 lt. 8'),
(4, 'Carlos', 'Correa', 12345643, 987654312, 'ventanilla');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codCliente`);

--
-- Indices de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD PRIMARY KEY (`codDetalle`),
  ADD KEY `FK_detallefactura_factura` (`codFactura`),
  ADD KEY `FK_detallefactura_producto` (`codBarra`),
  ADD KEY `FK_detallefactura_prodcto` (`codProducto`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`codFactura`),
  ADD KEY `codVendedor` (`codVendedor`,`codCliente`),
  ADD KEY `codCliente` (`codCliente`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codProducto`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codUsuario`),
  ADD KEY `codVendedor` (`codVendedor`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`codVendedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  MODIFY `codDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `codFactura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `codProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `codVendedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD CONSTRAINT `FK_detallefactura_prodcto` FOREIGN KEY (`codProducto`) REFERENCES `producto` (`codProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detallefactura_ibfk_1` FOREIGN KEY (`codFactura`) REFERENCES `factura` (`codFactura`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`codVendedor`) REFERENCES `vendedor` (`codVendedor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`codCliente`) REFERENCES `cliente` (`codCliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`codVendedor`) REFERENCES `vendedor` (`codVendedor`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
