--
-- Base de datos: `clinicaDental`
--
CREATE DATABASE IF NOT EXISTS `clinicadental` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `clinicadental`;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `codUsuario` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `envio` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `contrasenya` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `ultimaModContrasenya` datetime DEFAULT NULL,
  `activacionHash` varchar(128) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `codUsuario`, `nombre`, `apellidos`, `envio`, `email`, `contrasenya`, `ultimaModContrasenya`, `activacionHash`, `telefono`, `estado`) VALUES
(6, 'mvelasquez', 'Moisés Eduardo', 'Velásquez Oliva', 'Colonia Primero de Julio, zona 5, Mixco', 'moises.eduardo@gmail.com', '$2y$10$me3cuwKGjzsr9PJCzAimAep1dzjC4uXCdhMUGEM90W317jXaeFCVm', '2020-02-02 17:04:56', NULL, NULL, 1),
(7, 'mvelasquez1', 'Moisés Eduardo', 'Oliva/A36102', NULL, 'moises.velasquez@yahoo.es', '$2y$10$v/aVuWzcYe7aMs0m/zF9YuBTF0ppr6fNqQVCyah6i1GFsvyzfJXTK', '2019-12-09 18:24:49', NULL, NULL, 1),
(8, NULL, 'Moisés Eduardo', 'Oliva/a36102', NULL, 'mvelasquez@micorreo.com', '$2y$10$BD.a3pBo7GHmIhKukJF2HOmuGxxff48mjcCURBTo5WYt9D6yUGVvC', '2020-02-17 18:18:35', 'd48c2a9a35f58d636450ab0789de0c98d38cd74e5dbff4780125385a9701be95', NULL, 0);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--