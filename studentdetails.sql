-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2015 at 03:03 PM
-- Server version: 5.6.11
-- PHP Version: 5.5.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `daham_pasala`
--

-- --------------------------------------------------------

--
-- Table structure for table `studentdetails`
--

CREATE TABLE IF NOT EXISTS `studentdetails` (
  `regId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(70) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `admissionClass` varchar(8) NOT NULL,
  `registeredDate` date NOT NULL,
  PRIMARY KEY (`regId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `studentdetails`
--

INSERT INTO `studentdetails` (`regId`, `firstName`, `lastName`, `dob`, `address`, `gender`, `admissionClass`, `registeredDate`) VALUES
(3, 'Thilanka', 'Bowala', '1991-09-13', '54, Nalandarama road, Nugegoda', 'Female', 'Grade 12', '2015-06-21'),
(4, 'Chathuri', 'Thilakarathna', '1991-11-17', '23,pahala yagoda, Gampaha', 'Female', 'Grade 11', '2015-06-21'),
(11, 'Malsha', 'Nadeeshanie', '1991-03-11', '56, xxxx road, Matara', 'Female', 'Grade 12', '2015-06-20');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
