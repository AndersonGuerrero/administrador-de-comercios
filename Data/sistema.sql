-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 20-09-2015 a las 17:40:20
-- Versión del servidor: 5.6.24
-- Versión de PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `sistema`
--
CREATE DATABASE IF NOT EXISTS `sistema` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sistema`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `CEDULA` varchar(30) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `APELLIDO` varchar(30) NOT NULL,
  `DIRECCION` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`CEDULA`, `NOMBRE`, `APELLIDO`, `DIRECCION`) VALUES
('24390246', 'ANDERSON', 'GUERERRO', 'VIRGEN DE FATIMA\n'),
('25583670', 'JORGE LEONARDO', 'HENRIQUEZ PADRON', 'FATIMA'),
('26954043', 'SAMUEL', 'GUERRERO', 'XXX');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

CREATE TABLE IF NOT EXISTS `configuracion` (
  `ID` varchar(5) NOT NULL,
  `RIF` varchar(30) NOT NULL,
  `EMPRESA` varchar(50) NOT NULL,
  `IVA` varchar(10) NOT NULL,
  `CORREO` varchar(50) NOT NULL,
  `TELEFONO` varchar(30) NOT NULL,
  `TELEFONO2` varchar(30) NOT NULL,
  `TELEFONO3` varchar(30) NOT NULL,
  `DIRECCION` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `configuracion`
--

INSERT INTO `configuracion` (`ID`, `RIF`, `EMPRESA`, `IVA`, `CORREO`, `TELEFONO`, `TELEFONO2`, `TELEFONO3`, `DIRECCION`) VALUES
('01', 'Rif Empresa', 'Empresa C.A', '0.00', 'empresa@Hotmail.com', 'telefono 1', 'telefono 2', 'telefono3', 'direccion de la empresa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturacion`
--

CREATE TABLE IF NOT EXISTS `facturacion` (
  `COD_FAC` smallint(8) unsigned zerofill NOT NULL,
  `CLIENTE` varchar(30) NOT NULL,
  `FECHA` varchar(15) NOT NULL,
  `HORA` varchar(15) NOT NULL,
  `IVA` varchar(15) NOT NULL,
  `USUARIO` varchar(30) NOT NULL,
  `ESTADO` varchar(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fac_prod`
--

CREATE TABLE IF NOT EXISTS `fac_prod` (
  `id` int(11) NOT NULL,
  `COD_FACT` smallint(8) unsigned zerofill NOT NULL,
  `COD_PRO` varchar(30) NOT NULL,
  `CANTIDAD` varchar(30) NOT NULL,
  `COSTO` varchar(30) NOT NULL,
  `estado` varchar(2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `CODIGO` varchar(50) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `MARCA` varchar(30) NOT NULL,
  `MODELO` varchar(30) NOT NULL,
  `DESCRIPCION` varchar(100) NOT NULL,
  `COSTO_COMPRA` varchar(30) NOT NULL,
  `COSTO_VENTA` varchar(30) NOT NULL,
  `UBICACION` int(11) NOT NULL,
  `CANTIDAD` varchar(30) NOT NULL,
  `COD_PROVEEDOR` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE IF NOT EXISTS `proveedores` (
  `CODIGO` varchar(30) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `DIRECCION` text NOT NULL,
  `CORREO` varchar(50) NOT NULL,
  `CODIGO_POSTAL` varchar(30) NOT NULL,
  `FAX` varchar(30) NOT NULL,
  `NOMBRE_VEND` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepciones`
--

CREATE TABLE IF NOT EXISTS `recepciones` (
  `COD_RECEP` smallint(5) unsigned zerofill NOT NULL,
  `COD_PRO` varchar(50) NOT NULL,
  `COD_PROD` varchar(50) NOT NULL,
  `FECHA` varchar(15) NOT NULL,
  `HORA` varchar(15) NOT NULL,
  `COSTO` varchar(30) NOT NULL,
  `CANTIDAD` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefonos`
--

CREATE TABLE IF NOT EXISTS `telefonos` (
  `Id` varchar(30) NOT NULL,
  `telefono` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `telefonos`
--

INSERT INTO `telefonos` (`Id`, `telefono`) VALUES
('P-001', '0244-1234567'),
('P-001', '0244-7654321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_pago`
--

CREATE TABLE IF NOT EXISTS `tipo_pago` (
  `id` int(11) NOT NULL,
  `COD_FACT` smallint(8) unsigned zerofill NOT NULL,
  `TIPO_PAGO` varchar(20) NOT NULL,
  `CANTIDAD` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `USUARIO` varchar(30) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `INVENTARIO` tinyint(1) NOT NULL,
  `FACTURAS` tinyint(1) NOT NULL,
  `FACTURACION` tinyint(1) NOT NULL,
  `CLIENTES` tinyint(1) NOT NULL,
  `CONFIGURACION` tinyint(1) NOT NULL,
  `PROVEEDORES` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`USUARIO`, `PASSWORD`, `INVENTARIO`, `FACTURAS`, `FACTURACION`, `CLIENTES`, `CONFIGURACION`, `PROVEEDORES`) VALUES
('ANDERSON GUERRERO', 'igpkwu_', 1, 1, 1, 1, 1, 1),
('JORGE', '56789a', 0, 0, 1, 1, 0, 0),
('SAMUEL', '{iu}mte', 1, 0, 0, 0, 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`CEDULA`);

--
-- Indices de la tabla `configuracion`
--
ALTER TABLE `configuracion`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indices de la tabla `facturacion`
--
ALTER TABLE `facturacion`
  ADD PRIMARY KEY (`COD_FAC`);

--
-- Indices de la tabla `fac_prod`
--
ALTER TABLE `fac_prod`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`CODIGO`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`CODIGO`);

--
-- Indices de la tabla `recepciones`
--
ALTER TABLE `recepciones`
  ADD PRIMARY KEY (`COD_RECEP`);

--
-- Indices de la tabla `tipo_pago`
--
ALTER TABLE `tipo_pago`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`USUARIO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `facturacion`
--
ALTER TABLE `facturacion`
  MODIFY `COD_FAC` smallint(8) unsigned zerofill NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `fac_prod`
--
ALTER TABLE `fac_prod`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT de la tabla `recepciones`
--
ALTER TABLE `recepciones`
  MODIFY `COD_RECEP` smallint(5) unsigned zerofill NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `tipo_pago`
--
ALTER TABLE `tipo_pago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
