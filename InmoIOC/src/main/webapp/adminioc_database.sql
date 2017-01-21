-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 21-01-2017 a las 21:26:04
-- Versión del servidor: 5.7.11
-- Versión de PHP: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `adminioc_database`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_category`
--

CREATE TABLE `db_category` (
  `id_category` int(10) NOT NULL,
  `name` varchar(24) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `db_category`
--

INSERT INTO `db_category` (`id_category`, `name`) VALUES
(1, 'Pis'),
(2, 'Casa'),
(3, 'Parking'),
(4, 'Local comercial'),
(5, 'Nau'),
(6, 'Solar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_cities`
--

CREATE TABLE `db_cities` (
  `id_city` int(10) NOT NULL,
  `city` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `db_cities`
--

INSERT INTO `db_cities` (`id_city`, `city`) VALUES
(1, 'Barcelona'),
(2, 'Girona'),
(3, 'Lleida'),
(4, 'Tarragona'),
(5, 'Madrid'),
(6, 'València');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_incidence`
--

CREATE TABLE `db_incidence` (
  `id_incidence` int(10) NOT NULL,
  `id_user` int(10) NOT NULL,
  `description` varchar(512) COLLATE utf8_spanish_ci NOT NULL,
  `id_status` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `db_incidence`
--

INSERT INTO `db_incidence` (`id_incidence`, `id_user`, `description`, `id_status`) VALUES
(4, 18, 'Es possible negociar preus?', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_incidence_status`
--

CREATE TABLE `db_incidence_status` (
  `id_status` int(10) NOT NULL,
  `status` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `db_incidence_status`
--

INSERT INTO `db_incidence_status` (`id_status`, `status`) VALUES
(1, 'Oberta'),
(2, 'En procés'),
(3, 'Solucionada'),
(4, 'Cancel·lada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_payments`
--

CREATE TABLE `db_payments` (
  `id_payment` int(10) UNSIGNED NOT NULL,
  `id_selling` int(10) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `date_payment` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `db_payments`
--

INSERT INTO `db_payments` (`id_payment`, `id_selling`, `amount`, `date_payment`) VALUES
(4, 8, '850000.00', '2017-01-21 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_property`
--

CREATE TABLE `db_property` (
  `id_property` int(10) UNSIGNED NOT NULL,
  `name` varchar(32) COLLATE utf8_spanish_ci NOT NULL,
  `address` varchar(128) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_city` int(10) NOT NULL,
  `id_category` int(10) DEFAULT NULL,
  `sell_type` int(2) UNSIGNED NOT NULL DEFAULT '0',
  `base_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `contact` varchar(128) COLLATE utf8_spanish_ci DEFAULT NULL,
  `available` tinyint(1) NOT NULL DEFAULT '1',
  `id_user` int(10) DEFAULT NULL,
  `reg_selling` tinyint(1) NOT NULL DEFAULT '0',
  `image` blob
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `db_property`
--

INSERT INTO `db_property` (`id_property`, `name`, `address`, `id_city`, `id_category`, `sell_type`, `base_price`, `contact`, `available`, `id_user`, `reg_selling`, `image`) VALUES
(1, 'Casa 4 de 200m2 i 3 plantes', 'C/ Castell del camí, 345', 1, 2, 1, '250000.00', 'Pere Cases d\'inmoIOC', 0, 1, 1, ''),
(2, 'Pis 50m2 Barcelona', 'C/ Mallorca, 234 08080 Pis 4 porta 2', 1, 1, 1, '85000.00', '934564532', 1, 2, 1, NULL),
(12, 'Lloguer Pis molt ample 500m2', 'C/ fontanes, 456 Pis 4 Porta 3', 1, 1, 2, '900.00', '934567234', 1, 1, 1, NULL),
(13, 'Traspàs Local comercial 1000m2', 'Polígon indústrial Camp Tarragona', 4, 5, 3, '850000.00', '65489898', 1, 1, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_roles`
--

CREATE TABLE `db_roles` (
  `id_role` int(10) NOT NULL,
  `role` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `description` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `db_roles`
--

INSERT INTO `db_roles` (`id_role`, `role`, `description`) VALUES
(1, 'admin', 'Rol Administrador'),
(2, 'user', 'Rol Usuari');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_selling`
--

CREATE TABLE `db_selling` (
  `id_selling` int(10) UNSIGNED NOT NULL,
  `id_user` int(10) UNSIGNED NOT NULL,
  `id_property` int(10) UNSIGNED NOT NULL,
  `expected_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `sell_type` int(2) NOT NULL DEFAULT '0',
  `date_start` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_end` datetime NOT NULL,
  `id_status` int(10) NOT NULL,
  `id_user_payment` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `db_selling`
--

INSERT INTO `db_selling` (`id_selling`, `id_user`, `id_property`, `expected_price`, `sell_type`, `date_start`, `date_end`, `id_status`, `id_user_payment`) VALUES
(9, 1, 12, '990.00', 2, '2017-01-21 00:00:00', '2017-07-21 00:00:00', 2, NULL),
(8, 1, 13, '850000.00', 1, '2017-01-21 00:00:00', '2017-07-21 00:00:00', 6, 2),
(7, 2, 2, '93500.00', 1, '2017-01-21 00:00:00', '2017-07-21 00:00:00', 5, 18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_selltype`
--

CREATE TABLE `db_selltype` (
  `id_type` int(10) UNSIGNED NOT NULL,
  `name` varchar(25) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `db_selltype`
--

INSERT INTO `db_selltype` (`id_type`, `name`) VALUES
(1, 'Compra/Venda'),
(2, 'Lloguer'),
(3, 'Traspàs');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_status`
--

CREATE TABLE `db_status` (
  `id_status` int(10) NOT NULL,
  `status` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `db_status`
--

INSERT INTO `db_status` (`id_status`, `status`) VALUES
(1, 'En venda'),
(2, 'En lloguer'),
(3, 'En traspàs'),
(4, 'No disponible'),
(5, 'Reservat'),
(6, 'Venut'),
(7, 'Llogat'),
(8, 'Traspassat');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_user`
--

CREATE TABLE `db_user` (
  `id_user` int(10) UNSIGNED NOT NULL,
  `username` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(32) COLLATE utf8_spanish_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(128) COLLATE utf8_spanish_ci NOT NULL,
  `registration_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_role` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `db_user`
--

INSERT INTO `db_user` (`id_user`, `username`, `password`, `name`, `email`, `registration_date`, `id_role`) VALUES
(1, 'admin', 'admin', 'Administrador InmoIOC', 'administrador@inmoioc.com', '2016-11-05 23:00:00', 1),
(2, 'pau', 'pau', 'Pau Sánchez', 'pau.sanchez@gmail.com', '2016-11-05 23:00:00', 2),
(18, 'user', 'user', 'Isabel Fuentes', 'isabel.f@gmail.com', '2017-01-20 23:00:00', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `db_category`
--
ALTER TABLE `db_category`
  ADD PRIMARY KEY (`id_category`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indices de la tabla `db_cities`
--
ALTER TABLE `db_cities`
  ADD PRIMARY KEY (`id_city`);

--
-- Indices de la tabla `db_incidence`
--
ALTER TABLE `db_incidence`
  ADD PRIMARY KEY (`id_incidence`);

--
-- Indices de la tabla `db_incidence_status`
--
ALTER TABLE `db_incidence_status`
  ADD PRIMARY KEY (`id_status`);

--
-- Indices de la tabla `db_payments`
--
ALTER TABLE `db_payments`
  ADD PRIMARY KEY (`id_payment`);

--
-- Indices de la tabla `db_property`
--
ALTER TABLE `db_property`
  ADD PRIMARY KEY (`id_property`);

--
-- Indices de la tabla `db_roles`
--
ALTER TABLE `db_roles`
  ADD PRIMARY KEY (`id_role`);

--
-- Indices de la tabla `db_selling`
--
ALTER TABLE `db_selling`
  ADD PRIMARY KEY (`id_selling`);

--
-- Indices de la tabla `db_selltype`
--
ALTER TABLE `db_selltype`
  ADD PRIMARY KEY (`id_type`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indices de la tabla `db_status`
--
ALTER TABLE `db_status`
  ADD PRIMARY KEY (`id_status`);

--
-- Indices de la tabla `db_user`
--
ALTER TABLE `db_user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`,`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `db_category`
--
ALTER TABLE `db_category`
  MODIFY `id_category` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `db_cities`
--
ALTER TABLE `db_cities`
  MODIFY `id_city` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `db_incidence`
--
ALTER TABLE `db_incidence`
  MODIFY `id_incidence` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `db_incidence_status`
--
ALTER TABLE `db_incidence_status`
  MODIFY `id_status` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `db_payments`
--
ALTER TABLE `db_payments`
  MODIFY `id_payment` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `db_property`
--
ALTER TABLE `db_property`
  MODIFY `id_property` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `db_roles`
--
ALTER TABLE `db_roles`
  MODIFY `id_role` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `db_selling`
--
ALTER TABLE `db_selling`
  MODIFY `id_selling` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `db_selltype`
--
ALTER TABLE `db_selltype`
  MODIFY `id_type` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `db_status`
--
ALTER TABLE `db_status`
  MODIFY `id_status` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `db_user`
--
ALTER TABLE `db_user`
  MODIFY `id_user` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
