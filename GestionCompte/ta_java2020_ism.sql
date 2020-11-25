-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 25 nov. 2020 à 19:27
-- Version du serveur :  5.7.19
-- Version de PHP :  7.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ta_java2020_ism`
--

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `id_compte` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(15) NOT NULL,
  `solde` double NOT NULL,
  `partenaire_id` int(11) NOT NULL,
  PRIMARY KEY (`id_compte`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id_compte`, `numero`, `solde`, `partenaire_id`) VALUES
(1, 'xxxx', 50000, 1),
(2, 'xxxy', 5000000, 2),
(3, 'YYYY', 10, 1),
(4, 'YYYY', 10, 1),
(5, 'cpt1', 500000, 1),
(6, 'cpt1', 500000, 1),
(7, 'cpt1', 500000, 1),
(8, 'xxx2', 100000, 0),
(9, 'xxx2', 100, 8),
(10, 'xxx2', 10000, 8),
(11, 'xxx2', 10000, 8),
(12, 'xxx2', 5, 8),
(13, 'xxx2', 55666, 9),
(14, 'xxx2', 88888, 9),
(15, 'xxx2', 88888, 9),
(16, 'xxx2', 160000, 10),
(17, 'xxx2', 100000, 10);

-- --------------------------------------------------------

--
-- Structure de la table `depot`
--

DROP TABLE IF EXISTS `depot`;
CREATE TABLE IF NOT EXISTS `depot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mnt` double NOT NULL,
  `createAt` varchar(50) NOT NULL,
  `compte_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `depot`
--

INSERT INTO `depot` (`id`, `mnt`, `createAt`, `compte_id`) VALUES
(1, 455, '2020-04-06', 1),
(2, 100000, '2020-11-24', 8),
(3, 100, '2020-11-24', 9),
(4, 10000, '2020-11-24', 10),
(5, 10000, '2020-11-24', 11),
(6, 5, '2020-11-24', 12),
(7, 55666, '2020-11-24', 13),
(8, 88888, '2020-11-24', 14),
(9, 88888, '2020-11-24', 15),
(10, 5000, '2020-11-24', 16),
(11, 50000, '2020-11-24', 17),
(12, 5000, '2020-11-24', 16),
(13, 5000, '2020-11-24', 16),
(14, 50000, '2020-11-24', 16),
(15, 50000, '2020-11-24', 16),
(16, 10000, '2020-11-24', 16),
(17, 20000, '2020-11-24', 16),
(18, 10000, '2020-11-24', 16),
(19, 10000, '2020-11-24', 16),
(20, 50000, '2020-11-24', 17);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `nci` varchar(13) DEFAULT NULL,
  `nomComplet` varchar(100) DEFAULT NULL,
  `adresse` text,
  `tel` varchar(11) DEFAULT NULL,
  `matricule` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `login`, `pwd`, `type`, `nci`, `nomComplet`, `adresse`, `tel`, `matricule`) VALUES
(1, 'partenaire1', 'partenaire1', 'Partenaire', 'partenaire1', 'partenaire1', 'partenaire1', 'partenaire1', NULL),
(2, 'caissier1', 'caissier1', 'Caissier', '', '', NULL, NULL, 'caissier1'),
(3, 'caissier2', 'caissier2', 'AS', NULL, NULL, NULL, NULL, 'caissier3'),
(4, 'caissier1', 'passer', 'Caissier', NULL, NULL, NULL, NULL, 'caissier1'),
(5, 'caissier1', 'passer', 'Caissier', NULL, NULL, NULL, NULL, 'caissier1'),
(6, 'caissier1', 'passer', 'Caissier', NULL, NULL, NULL, NULL, 'caissier1'),
(7, 'caissier1', 'passer', 'Caissier', NULL, NULL, NULL, NULL, 'caissier1'),
(8, 'partenaire1', 'partenaire1', 'Partenaire', 'partenaire2', 'partenaire1', 'partenaire1', 'partenaire1', NULL),
(9, 'partenaire1', 'partenaire1', 'Partenaire', 'partenaire1', 'partenaire1', 'partenaire1', 'partenaire1', NULL),
(10, 'partenaire3', 'partenaire3', 'Partenaire', 'partenaire3', 'partenaire3', 'partenaire3', 'partenaire3', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
