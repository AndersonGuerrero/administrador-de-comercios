-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 17-11-2019 a las 03:49:52
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `CEDULA` varchar(30) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `APELLIDO` varchar(30) NOT NULL,
  `DIRECCION` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`CEDULA`, `NOMBRE`, `APELLIDO`, `DIRECCION`) VALUES
('1088361028', 'YORBELLY', 'MONOGA', 'PEREIRA, CUBA'),
('24390246', 'ANDERSON', 'GUERERRO', 'VIRGEN DE FATIMA\n'),
('25583670', 'JORGE LEONARDO', 'HENRIQUEZ PADRON', 'FATIMA'),
('26954043', 'SAMUEL', 'GUERRERO', 'XXX');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

CREATE TABLE `configuracion` (
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
('01', '24390246', 'G-SOFTWARE C.A', '0.00', 'Guerreroelmaster@Gmail.com', '0412-0418557', '0412-0418557', '0212-5656868', 'VIRGEN DE FATIMA EDO ARAGUA\n LOCAL #20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturacion`
--

CREATE TABLE `facturacion` (
  `COD_FAC` smallint(8) UNSIGNED ZEROFILL NOT NULL,
  `CLIENTE` varchar(30) NOT NULL,
  `FECHA` varchar(15) NOT NULL,
  `HORA` varchar(15) NOT NULL,
  `IVA` varchar(15) NOT NULL,
  `USUARIO` varchar(30) NOT NULL,
  `ESTADO` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `facturacion`
--

INSERT INTO `facturacion` (`COD_FAC`, `CLIENTE`, `FECHA`, `HORA`, `IVA`, `USUARIO`, `ESTADO`) VALUES
(00000001, '24390246', '01/04/2013', '14:10:45', '0.00', 'anderson', '0'),
(00000002, '24390246', '02/04/2013', '13:35:47', '0.00', 'anderson', '1'),
(00000003, '24390246', '02/04/2013', '14:03:36', '0.00', 'anderson', '0'),
(00000004, '24390246', '02/04/2013', '14:09:29', '0.00', 'anderson', '1'),
(00000005, '24390246', '02/04/2013', '16:59:00', '0.00', 'anderson', '0'),
(00000006, '24390246', '02/04/2013', '17:03:34', '0.00', 'anderson', '0'),
(00000007, '24390246', '02/04/2013', '18:01:54', '0.00', 'anderson', '1'),
(00000008, '24390246', '02/04/2013', '18:21:40', '0.00', 'anderson', '1'),
(00000009, '25583670', '03/04/2013', '20:53:56', '0.00', 'anderson', '1'),
(00000010, '25583670', '03/04/2013', '20:54:56', '0.00', 'anderson', '0'),
(00000011, '25583670', '03/04/2013', '21:00:53', '0.00', 'anderson', '1'),
(00000012, '26954043', '05/04/2013', '17:13:30', '0.00', 'ANDERSON GUERRERO', '1'),
(00000013, '1088361028', '16/11/2019', '21:48:34', '0.00', 'ANDERSON GUERRERO', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fac_prod`
--

CREATE TABLE `fac_prod` (
  `COD_FACT` smallint(8) UNSIGNED ZEROFILL NOT NULL,
  `COD_PRO` varchar(30) NOT NULL,
  `CANTIDAD` varchar(30) NOT NULL,
  `COSTO` varchar(30) NOT NULL,
  `estado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `fac_prod`
--

INSERT INTO `fac_prod` (`COD_FACT`, `COD_PRO`, `CANTIDAD`, `COSTO`, `estado`) VALUES
(00000001, '001', '1:UD', '150.00', '0'),
(00000002, '002', '1:UD', '150.00', '0'),
(00000004, '001', '4:UD', '150.00', '1'),
(00000003, '001', '1:UD', '150.00', '0'),
(00000002, '001', '1:UD', '150.00', '1'),
(00000006, '002', '1:UD', '300.00', '0'),
(00000006, '001', '2:UD', '156.00', '0'),
(00000005, '002', '1:UD', '300.00', '0'),
(00000007, '002', '1:UD', '300.00', '1'),
(00000007, '001', '1:UD', '150.00', '1'),
(00000008, '003', '1:MT', '400.00', '1'),
(00000008, '004', '1:MT', '300.00', '1'),
(00000008, '005', '1:MT', '200.00', '1'),
(00000008, '002', '1:UD', '300.00', '1'),
(00000008, '001', '1:UD', '150.00', '1'),
(00000009, '002', '1:UD', '300.00', '1'),
(00000010, '002', '1:UD', '300.00', '0'),
(00000011, '002', '1:UD', '300.00', '1'),
(00000011, '001', '7:UD', '150.00', '1'),
(00000012, '002', '5:UD', '300.00', '1'),
(00000013, '003', '1:MT', '400.00', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
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

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`CODIGO`, `NOMBRE`, `MARCA`, `MODELO`, `DESCRIPCION`, `COSTO_COMPRA`, `COSTO_VENTA`, `UBICACION`, `CANTIDAD`, `COD_PROVEEDOR`) VALUES
('001', 'XX', 'XXX', 'XXX', 'XXX', '100.00', '150.00', 12, '13:UD', 'SIN PROVEEDOR'),
('002', 'CABILLA', 'XXX', 'XXX', 'XXX', '200.00', '300.00', 50, '7:UD', 'SIN PROVEEDOR'),
('003', 'ARENA', 'XX', 'XXX', 'ARENA LAVADA', '350.00', '400.00', 5, '1:MT', 'P-001'),
('004', 'ARENA', 'XXX', 'XXX', 'ARENA CERNIDA', '250.00', '300.00', 5, '1:MT', 'P-001'),
('005', 'PIEDRA', 'XXX', 'XXX', 'PIEDRA', '150.00', '200.00', 5, '1:MT', 'P-001'),
('006', 'BLOQUE', 'XXX', '15 CM', 'BLOQUE DE CEMENTO ', '4.50', '5.00', 5, '1000:UD', 'P-001'),
('007', 'BLOQUE', 'XXX', '15 CM', 'BLOQUE ROJO', '3.00', '4.00', 5, '501:UD', 'P-001'),
('008', 'ALAMBRE', 'XXX', 'XXX', 'ALAMBRE LIZO', '5.00', '10.00', 18, '21:UD', 'P-001');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `CODIGO` varchar(30) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `DIRECCION` text NOT NULL,
  `CORREO` varchar(50) NOT NULL,
  `CODIGO_POSTAL` varchar(30) NOT NULL,
  `FAX` varchar(30) NOT NULL,
  `NOMBRE_VEND` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`CODIGO`, `NOMBRE`, `DIRECCION`, `CORREO`, `CODIGO_POSTAL`, `FAX`, `NOMBRE_VEND`) VALUES
('P-001', 'LAS MINAS', 'VILLA DE CURA EDO ARAGUA \nAVENIDA BOLIVAR', 'Lasminas@gmail.com', '2125', '123456789', 'JUAN PABLO AGRAZ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepciones`
--

CREATE TABLE `recepciones` (
  `COD_RECEP` smallint(5) UNSIGNED ZEROFILL NOT NULL,
  `COD_PRO` varchar(50) NOT NULL,
  `COD_PROD` varchar(50) NOT NULL,
  `FECHA` varchar(15) NOT NULL,
  `HORA` varchar(15) NOT NULL,
  `COSTO` varchar(30) NOT NULL,
  `CANTIDAD` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `recepciones`
--

INSERT INTO `recepciones` (`COD_RECEP`, `COD_PRO`, `COD_PROD`, `FECHA`, `HORA`, `COSTO`, `CANTIDAD`) VALUES
(00001, 'P-001', '003', '02/04/2013', '18:12:46', '350.00', '2:MT'),
(00002, 'P-001', '004', '02/04/2013', '18:14:08', '250.00', '2:MT'),
(00003, 'P-001', '005', '02/04/2013', '18:14:42', '150.00', '2:MT'),
(00004, 'P-001', '006', '02/04/2013', '18:38:55', '4.50', '1000:UD'),
(00005, 'P-001', '007', '02/04/2013', '18:39:30', '3.00', '500:UD'),
(00006, 'P-001', '008', '02/04/2013', '18:49:49', '5.00', '10:UD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefonos`
--

CREATE TABLE `telefonos` (
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

CREATE TABLE `tipo_pago` (
  `COD_FACT` smallint(8) UNSIGNED ZEROFILL NOT NULL,
  `TIPO_PAGO` varchar(20) NOT NULL,
  `CANTIDAD` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_pago`
--

INSERT INTO `tipo_pago` (`COD_FACT`, `TIPO_PAGO`, `CANTIDAD`) VALUES
(00000001, 'EFECTIVO', '150.00'),
(00000002, 'EFECTIVO', '450.00'),
(00000003, 'EFECTIVO', '100.00'),
(00000003, 'CHEQUE', '6.00'),
(00000003, 'SESTA TICKET', '45.00'),
(00000004, 'EFECTIVO', '74555.00'),
(00000006, 'EFECTIVO', '1100.00'),
(00000007, 'EFECTIVO', '400.00'),
(00000007, 'CHEQUE', '50.00'),
(00000008, 'EFECTIVO', '1400.00'),
(00000009, 'EFECTIVO', '300.00'),
(00000010, 'EFECTIVO', '350.00'),
(00000011, 'EFECTIVO', '350.00'),
(00000011, 'CHEQUE', '1000.00'),
(00000012, 'EFECTIVO', '1500.00'),
(00000013, 'EFECTIVO', '450.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
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
-- Indices de la tabla `facturacion`
--
ALTER TABLE `facturacion`
  ADD PRIMARY KEY (`COD_FAC`);

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
  MODIFY `COD_FAC` smallint(8) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `recepciones`
--
ALTER TABLE `recepciones`
  MODIFY `COD_RECEP` smallint(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
