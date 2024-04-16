-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2024 at 05:33 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlsv`
--

-- --------------------------------------------------------

--
-- Table structure for table `diem`
--

CREATE TABLE `diem` (
  `mssv` int(11) NOT NULL,
  `MaMH` varchar(10) NOT NULL,
  `score` float DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `diem`
--

INSERT INTO `diem` (`mssv`, `MaMH`, `score`) VALUES
(1, 'DTDM', 4),
(1, 'LTDT', 10),
(1, 'PTHTPT', 9),
(1, 'QTMHTKT', 7),
(1, 'TKANHT', 6),
(1, 'TKMTUD', 8),
(2, 'DTDM', 4),
(2, 'LTDT', 8),
(2, 'PTHTPT', 4),
(2, 'QTMHTKT', 6),
(2, 'TKANHT', 9),
(2, 'TKMTUD', 4),
(3, 'DTDM', 10),
(3, 'LTDT', 3),
(3, 'PTHTPT', 3),
(3, 'QTMHTKT', 9),
(3, 'TKANHT', 9),
(3, 'TKMTUD', 8),
(4, 'DTDM', 4),
(4, 'LTDT', 5),
(4, 'PTHTPT', 9),
(4, 'QTMHTKT', 4),
(4, 'TKANHT', 3),
(4, 'TKMTUD', 4),
(5, 'DTDM', 10),
(5, 'LTDT', 8),
(5, 'PTHTPT', 7),
(5, 'QTMHTKT', 10),
(5, 'TKANHT', 6),
(5, 'TKMTUD', 10),
(6, 'DTDM', 5),
(6, 'LTDT', 4),
(6, 'PTHTPT', 5),
(6, 'QTMHTKT', 5),
(6, 'TKANHT', 5),
(6, 'TKMTUD', 10),
(7, 'DTDM', 8),
(7, 'LTDT', 5),
(7, 'PTHTPT', 10),
(7, 'QTMHTKT', 7),
(7, 'TKANHT', 9),
(7, 'TKMTUD', 8),
(8, 'DTDM', 3),
(8, 'LTDT', 5),
(8, 'PTHTPT', 3),
(8, 'QTMHTKT', 9),
(8, 'TKANHT', 10),
(8, 'TKMTUD', 7),
(9, 'DTDM', 5),
(9, 'LTDT', 4),
(9, 'PTHTPT', 3),
(9, 'QTMHTKT', 5),
(9, 'TKANHT', 7),
(9, 'TKMTUD', 8),
(10, 'DTDM', 6),
(10, 'LTDT', 4),
(10, 'PTHTPT', 4),
(10, 'QTMHTKT', 4),
(10, 'TKANHT', 5),
(10, 'TKMTUD', 9),
(11, 'DTDM', 10),
(11, 'LTDT', 5),
(11, 'PTHTPT', 5),
(11, 'QTMHTKT', 3),
(11, 'TKANHT', 5),
(11, 'TKMTUD', 4),
(12, 'DTDM', 4),
(12, 'LTDT', 4),
(12, 'PTHTPT', 3),
(12, 'QTMHTKT', 7),
(12, 'TKANHT', 3),
(12, 'TKMTUD', 6),
(13, 'DTDM', 9),
(13, 'LTDT', 5),
(13, 'PTHTPT', 3),
(13, 'QTMHTKT', 10),
(13, 'TKANHT', 7),
(13, 'TKMTUD', 10),
(14, 'DTDM', 10),
(14, 'LTDT', 10),
(14, 'PTHTPT', 3),
(14, 'QTMHTKT', 3),
(14, 'TKANHT', 7),
(14, 'TKMTUD', 8),
(15, 'DTDM', 5),
(15, 'LTDT', 5),
(15, 'PTHTPT', 4),
(15, 'QTMHTKT', 8),
(15, 'TKANHT', 7),
(15, 'TKMTUD', 4),
(16, 'DTDM', 7),
(16, 'LTDT', 8),
(16, 'PTHTPT', 3),
(16, 'QTMHTKT', 5),
(16, 'TKANHT', 7),
(16, 'TKMTUD', 5),
(17, 'DTDM', 5),
(17, 'LTDT', 4),
(17, 'PTHTPT', 6),
(17, 'QTMHTKT', 6),
(17, 'TKANHT', 4),
(17, 'TKMTUD', 10),
(18, 'DTDM', 4),
(18, 'LTDT', 5),
(18, 'PTHTPT', 10),
(18, 'QTMHTKT', 7),
(18, 'TKANHT', 7),
(18, 'TKMTUD', 9),
(19, 'DTDM', 8),
(19, 'LTDT', 3),
(19, 'PTHTPT', 8),
(19, 'QTMHTKT', 9),
(19, 'TKANHT', 8),
(19, 'TKMTUD', 10),
(20, 'DTDM', 9),
(20, 'LTDT', 9),
(20, 'PTHTPT', 6),
(20, 'QTMHTKT', 5),
(20, 'TKANHT', 6),
(20, 'TKMTUD', 8);

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

CREATE TABLE `lop` (
  `Malop` varchar(20) NOT NULL,
  `TenLop` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lop`
--

INSERT INTO `lop` (`Malop`, `TenLop`) VALUES
('DHCNTT17A', 'DHCNTT17A'),
('DHCNTT17B', 'DHCNTT17B'),
('DHCNTT17C', 'DHCNTT17C');

-- --------------------------------------------------------

--
-- Table structure for table `monhoc`
--

CREATE TABLE `monhoc` (
  `MaMH` varchar(16) NOT NULL,
  `TenMH` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `monhoc`
--

INSERT INTO `monhoc` (`MaMH`, `TenMH`) VALUES
('DTDM', 'Điện toán đám mây'),
('LTDT', 'Lý thuyết đồ thị'),
('PTHTPT', 'Phát triển hệ th'),
('QTMHTKT', 'Quản trị mạng và hỗ trợ kỹ thuật'),
('TKANHT', 'Triển khai an ninh hệ thống'),
('TKMTUD', 'Thống kê máy tính ứng dụng');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `mssv` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `year` int(11) NOT NULL,
  `Malop` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`mssv`, `name`, `year`, `Malop`) VALUES
(1, 'Nguyễn Trung Anh', 2003, 'DHCNTT17A'),
(2, 'Trần Thị Bình', 2001, 'DHCNTT17B'),
(3, 'Huỳnh Minh Thư', 2003, 'DHCNTT17B'),
(4, 'Phạm Minh Giang', 2002, 'DHCNTT17A'),
(5, 'Hoàng Mai Thịnh', 2000, 'DHCNTT17B'),
(6, 'Vũ Hồng Phương', 2001, 'DHCNTT17C'),
(7, 'Đặng Thị Giang', 1999, 'DHCNTT17A'),
(8, 'Bùi Anh Hoàng', 2002, 'DHCNTT17B'),
(9, 'Lê Tuấn Tài', 2002, 'DHCNTT17B'),
(10, 'Ngô Quốc Tín', 2000, 'DHCNTT17C'),
(11, 'Trần Thành Chung', 2001, 'DHCNTT17A'),
(12, 'Lý Hải Đăng', 1999, 'DHCNTT17B'),
(13, 'Nguyễn Thị Loan', 2002, 'DHCNTT17C'),
(14, 'Hoàng Minh Tân', 2000, 'DHCNTT17A'),
(15, 'Phan Thị Như Ý', 2001, 'DHCNTT17B'),
(16, 'Lâm Hồng Sương', 1999, 'DHCNTT17C'),
(17, 'Trương Tấn Phát', 2002, 'DHCNTT17A'),
(18, 'Võ Thị Quyên', 2000, 'DHCNTT17B'),
(19, 'Dương Văn Sáng', 2001, 'DHCNTT17C'),
(20, 'Mai Thanh Sương', 1999, 'DHCNTT17A'),
(21, 'Võ Văn Hiếu ', 1999, 'DHCNTT17A'),
(23, 'Lê Thị Hoài Ân', 2003, 'DHCNTT17A'),
(24, 'Võ Thị Yến Nhi', 2001, 'DHCNTT17A');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diem`
--
ALTER TABLE `diem`
  ADD PRIMARY KEY (`mssv`,`MaMH`),
  ADD KEY `fk_MaMH` (`MaMH`);

--
-- Indexes for table `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`Malop`);

--
-- Indexes for table `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`MaMH`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`mssv`),
  ADD KEY `fk_MaLop` (`Malop`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `diem`
--
ALTER TABLE `diem`
  ADD CONSTRAINT `fk_MSSV` FOREIGN KEY (`mssv`) REFERENCES `students` (`mssv`),
  ADD CONSTRAINT `fk_MaMH` FOREIGN KEY (`MaMH`) REFERENCES `monhoc` (`MaMH`) ON UPDATE CASCADE;

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `fk_MaLop` FOREIGN KEY (`Malop`) REFERENCES `lop` (`Malop`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
