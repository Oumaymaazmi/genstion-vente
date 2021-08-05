-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 20 mai 2020 à 14:02
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.1.32

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestiondevente`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(10) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `password`, `nom`, `prenom`, `username`) VALUES
(1, 'admin', 'azmi', 'oumayma', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE `panier` (
  `id` int(10) NOT NULL,
  `adresseLivraison` varchar(255) NOT NULL,
  `totale` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(10) NOT NULL,
  `prix` double NOT NULL,
  `codebare` varchar(255) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `prix`, `codebare`, `libelle`) VALUES
(1, 10, '12GH11', 'chocola'),
(2, 10, '12HJ123', 'fraise'),
(3, 150, '12HK12K', 'robe'),
(4, 1000, '12FGHK1', 'S3 symsung'),
(5, 111, '12JKGJ789', 'jupe');

-- --------------------------------------------------------

--
-- Structure de la table `produitpanier`
--

CREATE TABLE `produitpanier` (
  `id` int(10) NOT NULL,
  `produit` int(10) NOT NULL,
  `panier` int(10) NOT NULL,
  `prix` double NOT NULL,
  `qte` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produitpanier`
--

INSERT INTO `produitpanier` (`id`, `produit`, `panier`, `prix`, `qte`) VALUES
(4, 3, 6, 150, 1),
(3, 1, 6, 10, 1),
(2, 2, 6, 10, 1),
(1, 1, 6, 10, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produitpanier`
--
ALTER TABLE `produitpanier`
  ADD PRIMARY KEY (`id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
