/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 10.1.37-MariaDB : Database - fp_pbkk
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fp_pbkk` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `fp_pbkk`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id_admin` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nama_admin` varchar(100) NOT NULL,
  `nrp_admin` char(14) NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `email_admin` varchar(150) NOT NULL,
  `password` varchar(128) NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

/*Table structure for table `file_from_transaksi` */

DROP TABLE IF EXISTS `file_from_transaksi`;

CREATE TABLE `file_from_transaksi` (
  `id_transaksi` int(11) unsigned NOT NULL,
  `id_file` int(11) unsigned NOT NULL,
  KEY `id_transaksi` (`id_transaksi`),
  KEY `id_file` (`id_file`),
  CONSTRAINT `file_from_transaksi_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi_print` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `file_from_transaksi_ibfk_2` FOREIGN KEY (`id_file`) REFERENCES `file_print` (`id_file`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `file_from_transaksi` */

/*Table structure for table `file_print` */

DROP TABLE IF EXISTS `file_print`;

CREATE TABLE `file_print` (
  `id_file` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `path_file` varchar(120) NOT NULL,
  PRIMARY KEY (`id_file`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `file_print` */

/*Table structure for table `transaksi_print` */

DROP TABLE IF EXISTS `transaksi_print`;

CREATE TABLE `transaksi_print` (
  `id_transaksi` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_admin` int(11) unsigned NOT NULL,
  `tanggal_transaksi` date NOT NULL,
  `waktu_transaksi` time NOT NULL,
  `total_harga` int(11) NOT NULL COMMENT 'Dalam rupiah',
  `nama_user` varchar(150) NOT NULL,
  `nrp_user` char(14) NOT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `id_admin` (`id_admin`),
  CONSTRAINT `transaksi_print_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transaksi_print` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
