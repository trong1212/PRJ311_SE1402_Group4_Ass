-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 27, 2020 lúc 09:58 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shop_manage`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--
USE [shop_manage]
GO
/****** Object:  Table [dbo].[account]    Script Date: 7/25/2019 7:19:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE `account` (
  `aid` int(11) NOT NULL,
  `aname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apass` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `atype` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`aid`, `aname`, `apass`, `atype`) VALUES
(8, 'trong1212', 'trong123', 'trong123'),
(9, 'trongnh1212', 'trong1212', 'Manager'),
(10, 'bay77', '77777', 'Employee');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `bid` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `eid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `billdetail`
--

CREATE TABLE `billdetail` (
  `bdid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `note` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `billdetail`
--

INSERT INTO `billdetail` (`bdid`, `pid`, `price`, `amount`, `note`, `bid`) VALUES
(3, 0, 0, 1, 'cafe', 1),
(4, 0, 10000, 1, 'cafe', 1),
(7, 1, 175000, 5, '', 2),
(8, 2, 380000, 4, '', 3),
(9, 1, 155000, 5, 'cam on', 1),
(12, 0, 0, 3, 'thank you', 1),
(13, 0, 30000, 3, 'thank you', 2),
(14, 1, 105000, 3, 'thank you', 3),
(15, 0, 10000, 1, '', 1),
(16, 0, 20000, 2, '', 1),
(17, 0, 10000, 1, '', 1),
(20, 7, 60000, 6, '', 1),
(21, 9, 240000, 3, '', 1),
(35, 31, 220000, 2, 'hu tieu', 31),
(36, 27, 220000, 2, 'hu tieu', 27),
(38, 29, 95000, 1, '', 29),
(39, 30, 95000, 1, '', 30),
(40, 1, 0, 1, '', 1),
(41, 8, 120000, 1, '', 32),
(45, 1, 95000, 1, '', 27),
(46, 27, 95000, 1, '', 27),
(47, 7, 280000, 1, '', 29),
(48, 1, 123000, 1, 'hu tieu', 1),
(49, -1, 123000, 1, 'hu tieu', 31),
(50, 32, 75000, 5, 'hu tieu', 32),
(51, 8, 55000, 2, '', 1),
(52, 1, 55000, 2, '', 1),
(53, 8, 55000, 2, '', 35),
(54, 35, 55000, 2, '', 35),
(55, 37, 55000, 2, '', 37),
(56, -1, 10000, 1, 'iii', 1),
(57, 1, 10000, 1, 'iii', 1),
(58, 5, 60000, 1, 'iii', 40),
(59, 2, 110000, 5, '', 1),
(60, 1, 0, 12, '', 1),
(61, 1, 0, 12, '', 1),
(62, 1, 25000, 1, '', 1),
(63, 1, 25000, 1, '', 1),
(64, 1, 1444, 1, 'hu tieu', 1),
(65, 1, 285000, 5, '', 1),
(66, 4, 550000, 5, '', 1),
(67, 4, 725000, 5, '', 1),
(68, 7, 625000, 5, '', 1),
(69, 3, 1375000, 20, '', 1),
(70, 1, 140000, 1, '', 1),
(71, 5, 85000, 1, '', 1),
(72, 4, 60000, 1, '', 1),
(73, 7, 60000, 1, '', 1),
(74, 5, 85000, 1, '', 1),
(75, 2, 1185000, 10, '', 1),
(76, 4, 345000, 1, '', 1),
(77, 5, 1535000, 40, '', 1),
(78, 1, 330000, 3, '', 1),
(79, 2, 180000, 2, '', 1),
(80, 1, 800000, 4, '', 1),
(81, 6, 200000, 1, '', 1),
(82, 1, 595000, 3, '', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `cid` int(11) NOT NULL,
  `cname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cphone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cemail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`cid`, `cname`, `cphone`, `cemail`) VALUES
(1, 'Nguyen Huu Trong', '0123456745', 'trong1212@gmail.com'),
(5, 'Đỗ Thành Tài', '0763588233', 'Tai123@gmail.com'),
(6, 'Đỗ Duy Thái', '0354454124', 'thaidui@gmai.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `eid` int(11) NOT NULL,
  `aid` int(11) DEFAULT NULL,
  `ename` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ephone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `eemail` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `etype` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`eid`, `aid`, `ename`, `ephone`, `eemail`, `etype`) VALUES
(3, 3, 'Nguyen Hoang Oanh', '0213456780', 'Oanh12@gmail.com', 'Manager'),
(4, 4, 'Tran Trung Hien', '0763558911', 'HienTH44@gmail.com', 'Employee'),
(6, 6, 'Trương Thanh Toàn', '0765544661', 'Toan@gmail.com', 'Employee'),
(7, 7, 'Trần Văn Bảy', '0145452212', 'Bay7@gmail.com', 'Employee'),
(8, 8, 'Châu quang', '0356645451', 'quang123@gmail.com', 'Employee'),
(9, 9, 'Do Thanh Tai', '0121244651', 'tai@gmail.com', 'Manager'),
(10, 10, 'Toro', '0123212133', 'toro12@gmail.com', 'Employee'),
(11, 11, 'Đỗ Duy Thái', '0322244655', 'thai33@fpt.edu.vn', 'Employee');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `pid` int(11) NOT NULL,
  `pname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ptype` int(11) DEFAULT NULL,
  `pprice` int(11) DEFAULT NULL,
  `psize` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pbrand` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`pid`, `pname`, `ptype`, `pprice`, `psize`, `pbrand`) VALUES
(14, 'Sting', 4, 10000, 'Large', 1),
(16, 'Mi cay truyên thống', 1, 25000, 'Large', 3),
(17, 'Mì cay hải sản', 1, 30000, 'Large', 1),
(18, 'Phở bò viên', 2, 25000, 'Large', 1),
(19, 'Phở bò tái', 2, 30000, 'Large', 1),
(21, '7Up', 4, 10000, 'Large', 1),
(22, 'Sting vàng', 4, 10000, 'Large', 1),
(23, 'Cafe', 4, 20000, 'Small', 1),
(24, 'Phở tái', 2, 25000, 'Large', 1),
(25, 'Hủ tiếu nam vang', 3, 20000, 'Small', 1),
(26, 'Hủ tiếu ', 3, 20000, 'Large', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `productbrand`
--

CREATE TABLE `productbrand` (
  `pbid` int(11) NOT NULL,
  `pbname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `productbrand`
--

INSERT INTO `productbrand` (`pbid`, `pbname`) VALUES
(1, 'VietNam'),
(2, 'China'),
(3, 'Korea');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `producttype`
--

CREATE TABLE `producttype` (
  `ptid` int(11) NOT NULL,
  `ptname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `producttype`
--

INSERT INTO `producttype` (`ptid`, `ptname`) VALUES
(1, 'Mì'),
(2, 'Phở'),
(3, 'Hủ tiếu'),
(4, 'Nước ngọt');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`aid`);

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bid`);

--
-- Chỉ mục cho bảng `billdetail`
--
ALTER TABLE `billdetail`
  ADD PRIMARY KEY (`bdid`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cid`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`eid`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pid`);

--
-- Chỉ mục cho bảng `productbrand`
--
ALTER TABLE `productbrand`
  ADD PRIMARY KEY (`pbid`);

--
-- Chỉ mục cho bảng `producttype`
--
ALTER TABLE `producttype`
  ADD PRIMARY KEY (`ptid`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `billdetail`
--
ALTER TABLE `billdetail`
  MODIFY `bdid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `employee`
--
ALTER TABLE `employee`
  MODIFY `eid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
