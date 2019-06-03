-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2018 at 09:51 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `orocare`
--

-- --------------------------------------------------------

--
-- Table structure for table `cusorder`
--

CREATE TABLE `cusorder` (
  `orderID` int(11) NOT NULL,
  `cusName` varchar(100) NOT NULL,
  `cusID` int(100) NOT NULL,
  `productID` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `discount` double NOT NULL,
  `total` double NOT NULL,
  `location` varchar(100) NOT NULL,
  `type` varchar(15) NOT NULL,
  `status` varchar(20) NOT NULL,
  `dateAdded` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cusorder`
--

INSERT INTO `cusorder` (`orderID`, `cusName`, `cusID`, `productID`, `qty`, `discount`, `total`, `location`, `type`, `status`, `dateAdded`) VALUES
(1, 'sahan', 2, 5, 15, 500, 4000, 'kottawa', 'Internal', '', '2018-09-08'),
(4, 'john', 1, 5, 20, 30, 5970, 'kottawa', 'External', '', '2018-09-08'),
(18, 'gygy', 2, 5, 15, 500, 4000, 'kottawa', 'Internal', '', '2018-09-05'),
(26, 'gygy', 2, 5, 50, 1000, 14000, 'kottawa', 'Internal', '', '2018-09-03'),
(27, 'Cargills', 1, 5, 25, 500, 7000, 'kottawa', 'External', '', '2018-08-08'),
(28, 'Cargills', 1, 5, 15, 100, 4400, 'kottawa', 'Internal', '', '2018-09-04'),
(29, 'gygy', 2, 5, 25, 500, 7000, 'kottawa', 'Internal', '', '2018-08-02'),
(30, 'Cargills', 1, 5, 11, 0, 3300, 'kottawa', 'Internal', 'confirmed', '2018-09-04'),
(31, 'gygy', 2, 5, 15, 0, 4500, 'kottawa', 'External', 'confirmed', '2018-09-03'),
(32, 'Cargills', 1, 5, 5, 10, 1490, 'kottawa', 'External', 'confirmed', '2018-09-03'),
(33, 'Cargills', 1, 5, 5, 10, 1490, 'kottawa', 'External', 'pending', '2018-08-01'),
(34, 'Cargills', 1, 5, 8, 1, 2399, 'rathmalana', 'Internal', 'confirmed', '2018-09-18'),
(35, 'Cargills', 1, 5, 800, 2.2, 1.7999999999999998, 'sas', 'Internal', 'confirmed', '2018-09-18');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(40) NOT NULL,
  `Email` varchar(35) NOT NULL,
  `Type` varchar(10) NOT NULL,
  `Phone` varchar(12) NOT NULL,
  `DateAdded` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `Name`, `Address`, `Email`, `Type`, `Phone`, `DateAdded`) VALUES
(1, 'Cargills', 'Cargills Nugegoda', 'cargills@gmail.com', 'Long Term', '0112810254', '2018-09-03 00:00:00'),
(4, 'sadasd', 'sadasdasd', 'dad@dad.sqa', 'One Time', '0711235478', '2018-09-08 00:00:00'),
(8, 'sahan', 'yuyyy', 'alex@gmail.com', 'One Time', '0716523243', '2018-09-14 15:11:26'),
(10, 'Sahan Illandara', 'colombo', 'alex@gmail.com', 'One Time', '0714341237', '2018-09-14 16:39:46');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmployeeID` int(11) NOT NULL,
  `Firstname` varchar(40) NOT NULL,
  `Middlename` varchar(40) NOT NULL,
  `Lastname` varchar(40) NOT NULL,
  `logCount` tinyint(1) NOT NULL,
  `Mobile` varchar(15) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `nic` varchar(20) NOT NULL,
  `Status` varchar(30) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Position` varchar(30) NOT NULL,
  `StartDate` date NOT NULL,
  `Email` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeID`, `Firstname`, `Middlename`, `Lastname`, `logCount`, `Mobile`, `Address`, `nic`, `Status`, `Gender`, `DateOfBirth`, `Position`, `StartDate`, `Email`) VALUES
(1038, 'Manoj', 'Lakshan', 'Niranthaka', 1, '0714254784', 'Kaduwela', '951245687V', 'active', 'Male', '1995-09-03', 'CEO', '2018-09-03', 'Manoj@gmail.com'),
(1039, 'Sahan', 'Niranthaka', 'Jayawardene', 0, '0711111111', 'Werahera', '181231452V', 'Inactive', 'Male', '2018-09-14', 'Manager', '2018-09-14', 'sahan@gmail.com'),
(1040, 'navindu', 'dakshitha', 'wijesuriya', 0, '0778683177', 'gampaha', '963334613v', 'Inactive', 'Male', '1996-09-14', 'employee', '2018-09-14', 'navindu@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `emp_deleted`
--

CREATE TABLE `emp_deleted` (
  `recID` int(11) NOT NULL,
  `empID` int(11) NOT NULL,
  `del_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `financeexp`
--

CREATE TABLE `financeexp` (
  `finID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` varchar(80) NOT NULL,
  `amount` double NOT NULL,
  `date` datetime NOT NULL,
  `dateAdded` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `financeexp`
--

INSERT INTO `financeexp` (`finID`, `name`, `type`, `amount`, `date`, `dateAdded`) VALUES
(2, 'sad', 'Other', 12, '2018-09-15 00:00:00', '2018-09-15');

-- --------------------------------------------------------

--
-- Table structure for table `financein`
--

CREATE TABLE `financein` (
  `finID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` varchar(80) NOT NULL,
  `amount` double NOT NULL,
  `date` datetime NOT NULL,
  `dateAdded` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `financein`
--

INSERT INTO `financein` (`finID`, `name`, `type`, `amount`, `date`, `dateAdded`) VALUES
(2, 'sasa', 'Employee', 1213, '2018-09-18 00:00:00', '2018-09-15');

-- --------------------------------------------------------

--
-- Table structure for table `notify_prod`
--

CREATE TABLE `notify_prod` (
  `notID` int(11) NOT NULL,
  `prodID` int(11) NOT NULL,
  `stockID` int(11) NOT NULL,
  `location` varchar(200) NOT NULL,
  `description` varchar(500) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `adDate` date NOT NULL,
  `updDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notify_prod`
--

INSERT INTO `notify_prod` (`notID`, `prodID`, `stockID`, `location`, `description`, `type`, `status`, `adDate`, `updDate`) VALUES
(348, 9, 42, 'saduniiiii', 'Stock for Product ID : 9, Stock No : 42 at location : saduniiiii is currently getting low', NULL, 'notRead', '2018-10-01', '2018-10-01 01:18:48'),
(349, 5, 50, 'dddddd', 'Stock for Product ID : 5, Stock No : 50 at location : dddddd is currently getting low', NULL, 'notRead', '2018-10-01', '2018-10-01 01:18:49'),
(350, 9, 42, 'saduniiiii', 'Stock for Product ID - 9, on Location - saduniiiii is near to get expired. (Expiry Date : 2018-10-13 , 12 days remaining.', 'exp', 'notRead', '2018-10-01', '2018-10-01 01:18:50'),
(351, 9, 49, 'kllkkk', 'Stock for Product ID - 9, on Location - kllkkk is near to get expired. (Expiry Date : 2018-10-27 , 26 days remaining.', 'exp', 'notRead', '2018-10-01', '2018-10-01 01:18:51'),
(352, 5, 50, 'dddddd', 'Stock for Product ID - 5, on Location - dddddd is near to get expired. (Expiry Date : 2018-11-03 , 33 days remaining.', 'exp', 'notRead', '2018-10-01', '2018-10-01 01:18:52');

-- --------------------------------------------------------

--
-- Table structure for table `notify_raw`
--

CREATE TABLE `notify_raw` (
  `notID` int(11) NOT NULL,
  `rawID` int(11) NOT NULL,
  `stockID` int(11) NOT NULL,
  `location` varchar(200) NOT NULL,
  `description` varchar(500) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `adDate` date NOT NULL,
  `updDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notify_raw`
--

INSERT INTO `notify_raw` (`notID`, `rawID`, `stockID`, `location`, `description`, `type`, `status`, `adDate`, `updDate`) VALUES
(37, 1, 10, 'minuwangoda', 'Stock for Material ID : 1, Stock No : 10 at location : minuwangoda is currently getting low', NULL, 'notRead', '2018-10-01', '2018-10-01 01:19:36'),
(38, 1, 12, 'ggh', 'Stock for Material ID : 1, Stock No : 12 at location : ggh is currently getting low', NULL, 'notRead', '2018-10-01', '2018-10-01 01:19:37');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Description` varchar(40) NOT NULL,
  `Size` varchar(20) NOT NULL,
  `Flavour` varchar(20) NOT NULL,
  `Weight` double NOT NULL,
  `dateAdded` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductID`, `Name`, `Description`, `Size`, `Flavour`, `Weight`, `dateAdded`) VALUES
(5, 'OroMango', 'Mango Flavoured', 'Small', 'Mango', 200, '2018-09-03'),
(7, 'dsad', 'asdas', 'Small', 'dasd', 111, '2018-09-08'),
(8, 'gggggggggg', 'ada', 'Small', 'wdsad', 11, '2018-09-08'),
(9, 'sda', 'asd', 'Small', 'adsa', 121, '2018-09-15');

-- --------------------------------------------------------

--
-- Table structure for table `raw_mat`
--

CREATE TABLE `raw_mat` (
  `rawID` int(11) NOT NULL,
  `rawName` varchar(60) NOT NULL,
  `raw_Desc` varchar(500) NOT NULL,
  `dateAdded` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `raw_mat`
--

INSERT INTO `raw_mat` (`rawID`, `rawName`, `raw_Desc`, `dateAdded`) VALUES
(1, 'cinnamon', '123abcdefsasadas', '2018-08-16');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `SalaryID` int(11) NOT NULL,
  `EmployeeID` int(11) NOT NULL,
  `Allowance` double NOT NULL,
  `Deduction` double NOT NULL,
  `Epf` double NOT NULL,
  `Etf` double NOT NULL,
  `epfRate` double NOT NULL,
  `etfRate` double NOT NULL,
  `Leaves` int(11) NOT NULL,
  `netSalary` double NOT NULL,
  `calculatedSalary` double NOT NULL,
  `month` varchar(200) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`SalaryID`, `EmployeeID`, `Allowance`, `Deduction`, `Epf`, `Etf`, `epfRate`, `etfRate`, `Leaves`, `netSalary`, `calculatedSalary`, `month`, `Date`) VALUES
(1, 1033, 1000, 1399, 8400, 5600, 12, 8, 2, 70000, -44939700, 'March', '2018-09-03'),
(2, 1038, 1000, 500, 8040, 5360, 12, 8, 3, 67000, 59460, 'April', '2018-09-04'),
(3, 1038, 444, 500, 220.00000000000003, 120, 2.2, 1.2, 2, 10000, 9724, 'February', '2018-08-14');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `salesID` int(11) NOT NULL,
  `proName` varchar(50) NOT NULL,
  `prID` int(100) NOT NULL,
  `cuID` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `discount` double NOT NULL,
  `totEarn` double NOT NULL,
  `profit` double NOT NULL,
  `dateSold` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`salesID`, `proName`, `prID`, `cuID`, `qty`, `discount`, `totEarn`, `profit`, `dateSold`) VALUES
(1, 'OroMango', 5, 1, 50, 100, 14900, 4900, '2018-07-09'),
(2, 'OroMango', 5, 2, 15, 500, 4000, 1000, '2018-09-05'),
(3, 'OroBanana ', 5, 1, 15, 1000, 3400, 500, '2018-08-14'),
(4, 'OroMango', 5, 2, 20, 250, 5750, 1750, '2018-08-22'),
(5, 'none', 5, 1, 50, 2500, 12500, 750, '2018-08-22'),
(6, 'OroMango', 5, 2, 25, 250, 7250, 2250, '2018-08-08'),
(8, 'OroMango', 5, 1, 50, 1000, 14000, 4000, '2018-09-03'),
(9, 'OroMango', 5, 1, 15, 100, 4400, 1400, '2018-09-04'),
(10, 'OroMango', 5, 1, 25, 500, 7000, 3000, '2018-08-08'),
(11, 'OroMango', 5, 1, 11, 0, 3300, 1100, '2018-09-04'),
(12, 'OroMango', 5, 1, 5, 10, 1490, 490, '2018-09-03'),
(13, 'OroMango', 5, 2, 15, 0, 4500, 1500, '2018-09-03'),
(14, 'OroMango', 5, 2, 15, 0, 4500, 1500, '2018-09-03'),
(15, 'OroMango', 5, 1, 5, 10, 1490, 315, '2018-09-04'),
(17, 'OroMango', 5, 1, 2, 2.2, 1.7999999999999998, -0.20000000000000018, '2018-09-18'),
(18, 'OroMango', 5, 1, 2, 2.2, 1.7999999999999998, -0.20000000000000018, '2018-09-18'),
(19, 'dsad', 7, 4, 200, 15, 1119985, 1007985, '2018-09-30'),
(20, 'dsad', 7, 8, 400, 25, 2239975, 2015975, '2018-09-30');

-- --------------------------------------------------------

--
-- Table structure for table `stockproduct`
--

CREATE TABLE `stockproduct` (
  `stockID` int(11) NOT NULL,
  `prodID` int(11) DEFAULT NULL,
  `location` varchar(200) NOT NULL,
  `avl_qty` int(11) NOT NULL,
  `unitCost` double NOT NULL,
  `exp_Date` date NOT NULL,
  `manu_Date` date NOT NULL,
  `sellPrice` double NOT NULL,
  `added_Date` date NOT NULL,
  `updDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stockproduct`
--

INSERT INTO `stockproduct` (`stockID`, `prodID`, `location`, `avl_qty`, `unitCost`, `exp_Date`, `manu_Date`, `sellPrice`, `added_Date`, `updDate`) VALUES
(42, 9, 'saduniiiii', 12, 60, '2018-10-13', '2018-09-12', 220, '2018-09-21', '2018-10-01 00:19:12'),
(49, 9, 'kllkkk', 80, 60, '2018-10-27', '2018-09-12', 100, '2018-09-29', '2018-10-01 00:20:17'),
(50, 5, 'dddddd', 12, 200, '2018-11-03', '2018-09-11', 220, '2018-09-16', '2018-10-01 00:21:05'),
(54, 7, 'hacp', 200, 560, '2019-09-29', '2018-09-29', 5600, '2018-09-29', '2018-09-29 18:44:52');

-- --------------------------------------------------------

--
-- Table structure for table `stockraw`
--

CREATE TABLE `stockraw` (
  `stockID` int(11) NOT NULL,
  `rawID` int(11) NOT NULL,
  `location` varchar(500) NOT NULL,
  `qty` int(11) NOT NULL,
  `unitCost` double NOT NULL,
  `expDate` date NOT NULL,
  `adDate` date NOT NULL,
  `updDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stockraw`
--

INSERT INTO `stockraw` (`stockID`, `rawID`, `location`, `qty`, `unitCost`, `expDate`, `adDate`, `updDate`) VALUES
(10, 1, 'minuwangoda', 20, 600, '2018-09-29', '2018-09-29', '2018-09-29 16:44:34'),
(11, 1, 'kkkk', 25, 670, '2020-09-29', '2018-09-29', '2018-09-29 18:43:45'),
(12, 1, 'ggh', 12, 12, '2019-09-29', '2018-09-29', '2018-09-29 18:44:25');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupplierID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `BusinessType` varchar(20) NOT NULL,
  `NatureofBusiness` varchar(20) NOT NULL,
  `BRNo` varchar(20) NOT NULL,
  `dateAdded` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupplierID`, `Name`, `Address`, `Email`, `StartDate`, `EndDate`, `BusinessType`, `NatureofBusiness`, `BRNo`, `dateAdded`) VALUES
(1, 'Agro', 'Colombo', 'agro@gmail.com', '2018-09-04', '2018-09-07', 'Cooperate', 'Manufacturer', 'BR10214587', '2018-09-03'),
(3, 'abb', 'hjgjhghf', 'abbb@gmail.com', '2018-09-04', '2018-09-13', 'Cooperate', 'Manufacturer', 'bgg12', '2018-09-04'),
(4, 'just', 'dfghjkfghj', 'abbb@gmail.com', '2018-09-04', '2018-09-13', 'Cooperate', 'Manufacturer', 'bgg12', '2019-09-04'),
(5, 'sad', 'dasdsad', 'ad@da.com', '2018-09-12', '2018-09-22', 'Cooperate', 'Manufacturer', 'adadasd', '2018-09-15'),
(6, 'Agro Chemicals', 'Colombo', 'agro@gmail.com', '2019-08-01', '2020-08-01', 'Cooperate', 'Manufacturer', 'BR254812541', '2018-09-15');

-- --------------------------------------------------------

--
-- Table structure for table `supply_order`
--

CREATE TABLE `supply_order` (
  `sup_order_id` int(11) NOT NULL,
  `material_name` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total_price` int(11) NOT NULL,
  `order_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supply_order`
--

INSERT INTO `supply_order` (`sup_order_id`, `material_name`, `quantity`, `total_price`, `order_date`) VALUES
(1, 'Cinammon', 10, 1000, '2018-09-22');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserID` int(11) NOT NULL,
  `empID` int(11) NOT NULL,
  `Username` varchar(30) DEFAULT NULL,
  `Password` varchar(300) DEFAULT NULL,
  `EmployeePriviledge` tinyint(1) NOT NULL,
  `CustomerPriviledge` tinyint(1) NOT NULL,
  `SupplierPriviledge` tinyint(1) NOT NULL,
  `ProductPriviledge` tinyint(1) NOT NULL,
  `StockPriviledge` tinyint(1) NOT NULL,
  `OrderPriviledge` tinyint(1) NOT NULL,
  `SalesPriviledge` tinyint(1) NOT NULL,
  `SalaryPriviledge` tinyint(1) NOT NULL,
  `UtilityPriviledge` tinyint(1) NOT NULL,
  `FinancePriviledge` tinyint(1) NOT NULL,
  `UserPriviledge` tinyint(1) NOT NULL,
  `NotificationPriviledge` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `empID`, `Username`, `Password`, `EmployeePriviledge`, `CustomerPriviledge`, `SupplierPriviledge`, `ProductPriviledge`, `StockPriviledge`, `OrderPriviledge`, `SalesPriviledge`, `SalaryPriviledge`, `UtilityPriviledge`, `FinancePriviledge`, `UserPriviledge`, `NotificationPriviledge`) VALUES
(24, 1038, 'OC1038', '', 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1),
(25, 1039, NULL, NULL, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0),
(26, 1040, NULL, NULL, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_external`
--

CREATE TABLE `user_external` (
  `extID` int(11) NOT NULL,
  `fname` varchar(200) NOT NULL,
  `lname` varchar(200) NOT NULL,
  `uname` varchar(50) NOT NULL,
  `password` varchar(300) NOT NULL,
  `dateAdded` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_external`
--

INSERT INTO `user_external` (`extID`, `fname`, `lname`, `uname`, `password`, `dateAdded`) VALUES
(2, 'Admin', 'Super', 'admin', '61cc0e405f4b518d264c089ac8b642ef', '2018-09-30 23:35:03'),
(3, 'Admin', 'Super', 'admin', '61cc0e405f4b518d264c089ac8b642ef', '2018-09-30 23:36:24');

-- --------------------------------------------------------

--
-- Table structure for table `utility`
--

CREATE TABLE `utility` (
  `UtilityID` int(11) NOT NULL,
  `type` varchar(35) NOT NULL,
  `name` varchar(40) NOT NULL,
  `date` date NOT NULL,
  `Amount` double NOT NULL,
  `added_dte` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utility`
--

INSERT INTO `utility` (`UtilityID`, `type`, `name`, `date`, `Amount`, `added_dte`) VALUES
(2, 'dsds', 'ds', '2018-09-24', 3000, '2018-09-03'),
(3, 'adsa', 'dsad', '2018-09-20', 111, '2018-09-15');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cusorder`
--
ALTER TABLE `cusorder`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `order_fk` (`cusID`),
  ADD KEY `order_fk_prod` (`productID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmployeeID`),
  ADD UNIQUE KEY `nic_2` (`nic`),
  ADD KEY `nic` (`nic`) USING BTREE;

--
-- Indexes for table `emp_deleted`
--
ALTER TABLE `emp_deleted`
  ADD PRIMARY KEY (`recID`),
  ADD KEY `emp_del_fk` (`empID`);

--
-- Indexes for table `financeexp`
--
ALTER TABLE `financeexp`
  ADD PRIMARY KEY (`finID`);

--
-- Indexes for table `financein`
--
ALTER TABLE `financein`
  ADD PRIMARY KEY (`finID`);

--
-- Indexes for table `notify_prod`
--
ALTER TABLE `notify_prod`
  ADD PRIMARY KEY (`notID`),
  ADD KEY `not_prod_fk` (`prodID`),
  ADD KEY `stock_id_fk` (`stockID`);

--
-- Indexes for table `notify_raw`
--
ALTER TABLE `notify_raw`
  ADD PRIMARY KEY (`notID`),
  ADD KEY `st_raw_fk` (`rawID`),
  ADD KEY `stockraw_id_fk` (`stockID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`);

--
-- Indexes for table `raw_mat`
--
ALTER TABLE `raw_mat`
  ADD PRIMARY KEY (`rawID`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`SalaryID`),
  ADD KEY `EmployeeID` (`EmployeeID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`salesID`),
  ADD KEY `sales_fk_pr` (`prID`),
  ADD KEY `sales_fk_cus` (`cuID`);

--
-- Indexes for table `stockproduct`
--
ALTER TABLE `stockproduct`
  ADD PRIMARY KEY (`stockID`),
  ADD UNIQUE KEY `unique_index` (`prodID`,`location`),
  ADD KEY `prodID` (`prodID`) USING BTREE;

--
-- Indexes for table `stockraw`
--
ALTER TABLE `stockraw`
  ADD PRIMARY KEY (`stockID`),
  ADD UNIQUE KEY `unique_index` (`rawID`,`location`),
  ADD KEY `rawID` (`rawID`) USING BTREE;

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SupplierID`);

--
-- Indexes for table `supply_order`
--
ALTER TABLE `supply_order`
  ADD PRIMARY KEY (`sup_order_id`),
  ADD UNIQUE KEY `material_name` (`material_name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserID`),
  ADD KEY `user_fk_emp` (`empID`);

--
-- Indexes for table `user_external`
--
ALTER TABLE `user_external`
  ADD PRIMARY KEY (`extID`);

--
-- Indexes for table `utility`
--
ALTER TABLE `utility`
  ADD PRIMARY KEY (`UtilityID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cusorder`
--
ALTER TABLE `cusorder`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `EmployeeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1041;

--
-- AUTO_INCREMENT for table `emp_deleted`
--
ALTER TABLE `emp_deleted`
  MODIFY `recID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `financeexp`
--
ALTER TABLE `financeexp`
  MODIFY `finID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `financein`
--
ALTER TABLE `financein`
  MODIFY `finID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `notify_prod`
--
ALTER TABLE `notify_prod`
  MODIFY `notID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=353;

--
-- AUTO_INCREMENT for table `notify_raw`
--
ALTER TABLE `notify_raw`
  MODIFY `notID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `ProductID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `raw_mat`
--
ALTER TABLE `raw_mat`
  MODIFY `rawID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `salary`
--
ALTER TABLE `salary`
  MODIFY `SalaryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `salesID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `stockproduct`
--
ALTER TABLE `stockproduct`
  MODIFY `stockID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `stockraw`
--
ALTER TABLE `stockraw`
  MODIFY `stockID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `SupplierID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `supply_order`
--
ALTER TABLE `supply_order`
  MODIFY `sup_order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `user_external`
--
ALTER TABLE `user_external`
  MODIFY `extID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `utility`
--
ALTER TABLE `utility`
  MODIFY `UtilityID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `emp_deleted`
--
ALTER TABLE `emp_deleted`
  ADD CONSTRAINT `emp_del_fk` FOREIGN KEY (`empID`) REFERENCES `employee` (`EmployeeID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `notify_prod`
--
ALTER TABLE `notify_prod`
  ADD CONSTRAINT `not_prod_fk` FOREIGN KEY (`prodID`) REFERENCES `product` (`ProductID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stock_id_fk` FOREIGN KEY (`stockID`) REFERENCES `stockproduct` (`stockID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `notify_raw`
--
ALTER TABLE `notify_raw`
  ADD CONSTRAINT `st_raw_fk` FOREIGN KEY (`rawID`) REFERENCES `stockraw` (`rawID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stockraw_id_fk` FOREIGN KEY (`stockID`) REFERENCES `stockraw` (`stockID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `stockproduct`
--
ALTER TABLE `stockproduct`
  ADD CONSTRAINT `prod_fk` FOREIGN KEY (`prodID`) REFERENCES `product` (`ProductID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `stockraw`
--
ALTER TABLE `stockraw`
  ADD CONSTRAINT `raw_fk` FOREIGN KEY (`rawID`) REFERENCES `raw_mat` (`rawID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_fk_emp` FOREIGN KEY (`empID`) REFERENCES `employee` (`EmployeeID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
