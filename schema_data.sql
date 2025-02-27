USE [master]
GO
/****** Object:  Database [booking_db]    Script Date: 1/17/2025 11:34:28 PM ******/
CREATE DATABASE [booking_db]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'booking_db', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\booking_db.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'booking_db_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\booking_db_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [booking_db] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [booking_db].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [booking_db] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [booking_db] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [booking_db] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [booking_db] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [booking_db] SET ARITHABORT OFF 
GO
ALTER DATABASE [booking_db] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [booking_db] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [booking_db] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [booking_db] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [booking_db] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [booking_db] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [booking_db] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [booking_db] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [booking_db] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [booking_db] SET  DISABLE_BROKER 
GO
ALTER DATABASE [booking_db] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [booking_db] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [booking_db] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [booking_db] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [booking_db] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [booking_db] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [booking_db] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [booking_db] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [booking_db] SET  MULTI_USER 
GO
ALTER DATABASE [booking_db] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [booking_db] SET DB_CHAINING OFF 
GO
ALTER DATABASE [booking_db] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [booking_db] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [booking_db] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [booking_db] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [booking_db] SET QUERY_STORE = ON
GO
ALTER DATABASE [booking_db] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [booking_db]
GO
/****** Object:  Table [dbo].[Appointments]    Script Date: 1/17/2025 11:34:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Appointments](
	[appointment_id] [uniqueidentifier] NOT NULL,
	[slot_id] [uniqueidentifier] NOT NULL,
	[patient_id] [uniqueidentifier] NOT NULL,
	[reserved_at] [datetime] NOT NULL,
	[status] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[appointment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Doctors]    Script Date: 1/17/2025 11:34:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Doctors](
	[doctor_id] [uniqueidentifier] NOT NULL,
	[doctor_name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[doctor_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Patients]    Script Date: 1/17/2025 11:34:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Patients](
	[patient_id] [uniqueidentifier] NOT NULL,
	[patient_name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[patient_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Slots]    Script Date: 1/17/2025 11:34:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Slots](
	[slot_id] [uniqueidentifier] NOT NULL,
	[time] [datetime] NOT NULL,
	[doctor_id] [uniqueidentifier] NOT NULL,
	[is_reserved] [bit] NOT NULL,
	[reserved_at] [datetime] NULL,
	[cost] [decimal](10, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[slot_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Appointments] ([appointment_id], [slot_id], [patient_id], [reserved_at], [status]) VALUES (N'378b9d88-ec2d-4076-9292-91d04b4f1737', N'3875db7d-328e-430c-a1fc-0c3c91b83d1d', N'cea65717-5fd2-4470-87a5-9a360059e65c', CAST(N'2024-01-01T08:30:00.000' AS DateTime), N'OPENED')
GO
INSERT [dbo].[Doctors] ([doctor_id], [doctor_name]) VALUES (N'ca90e3d6-26d2-4dcb-a876-85c46787e7cf', N'Dr. Jane Smith')
INSERT [dbo].[Doctors] ([doctor_id], [doctor_name]) VALUES (N'481d6c9b-a991-4fc5-81a7-ac17ab31699b', N'Dr. John Doe')
INSERT [dbo].[Doctors] ([doctor_id], [doctor_name]) VALUES (N'41ea7d8d-3809-47d2-94e7-e948b4cc4ecb', N'Dr. Smith')
INSERT [dbo].[Doctors] ([doctor_id], [doctor_name]) VALUES (N'a72b534c-0e78-4bb3-af5a-f26719182d69', N'Dr. Magdy Yacoub')
GO
INSERT [dbo].[Patients] ([patient_id], [patient_name]) VALUES (N'cea65717-5fd2-4470-87a5-9a360059e65c', N'Bob Williams')
INSERT [dbo].[Patients] ([patient_id], [patient_name]) VALUES (N'c94c6f81-9141-4711-b373-bdbf83ebd49c', N'Alice Johnson')
GO
INSERT [dbo].[Slots] ([slot_id], [time], [doctor_id], [is_reserved], [reserved_at], [cost]) VALUES (N'3875db7d-328e-430c-a1fc-0c3c91b83d1d', CAST(N'2024-01-01T09:00:00.000' AS DateTime), N'ca90e3d6-26d2-4dcb-a876-85c46787e7cf', 1, CAST(N'2024-01-01T08:30:00.000' AS DateTime), CAST(100.00 AS Decimal(10, 2)))
INSERT [dbo].[Slots] ([slot_id], [time], [doctor_id], [is_reserved], [reserved_at], [cost]) VALUES (N'cf85450c-2586-4c07-bc0e-20a5d0a77077', CAST(N'2025-01-05T12:30:00.000' AS DateTime), N'a72b534c-0e78-4bb3-af5a-f26719182d69', 0, NULL, CAST(100.00 AS Decimal(10, 2)))
INSERT [dbo].[Slots] ([slot_id], [time], [doctor_id], [is_reserved], [reserved_at], [cost]) VALUES (N'6821d698-305c-4518-85c7-39a8a2c1ba09', CAST(N'2025-01-05T10:30:00.000' AS DateTime), N'a72b534c-0e78-4bb3-af5a-f26719182d69', 0, NULL, CAST(500.00 AS Decimal(10, 2)))
INSERT [dbo].[Slots] ([slot_id], [time], [doctor_id], [is_reserved], [reserved_at], [cost]) VALUES (N'c7f1a652-6173-488d-9c85-a6263f941c34', CAST(N'2024-01-01T10:00:00.000' AS DateTime), N'ca90e3d6-26d2-4dcb-a876-85c46787e7cf', 0, NULL, CAST(100.00 AS Decimal(10, 2)))
INSERT [dbo].[Slots] ([slot_id], [time], [doctor_id], [is_reserved], [reserved_at], [cost]) VALUES (N'e4673325-fe62-4ee5-be29-ada4fcb41e80', CAST(N'2025-01-05T10:30:00.000' AS DateTime), N'ca90e3d6-26d2-4dcb-a876-85c46787e7cf', 0, NULL, CAST(150.00 AS Decimal(10, 2)))
INSERT [dbo].[Slots] ([slot_id], [time], [doctor_id], [is_reserved], [reserved_at], [cost]) VALUES (N'c676380d-7790-4699-9a1b-bbf60d2f40b2', CAST(N'2024-01-02T09:00:00.000' AS DateTime), N'481d6c9b-a991-4fc5-81a7-ac17ab31699b', 0, NULL, CAST(120.00 AS Decimal(10, 2)))
INSERT [dbo].[Slots] ([slot_id], [time], [doctor_id], [is_reserved], [reserved_at], [cost]) VALUES (N'9ca40441-37a4-4d47-ab3c-cebc72270f51', CAST(N'2025-01-05T11:30:00.000' AS DateTime), N'a72b534c-0e78-4bb3-af5a-f26719182d69', 0, NULL, CAST(500.00 AS Decimal(10, 2)))
GO
/****** Object:  Index [IX_Slots_IsReserved]    Script Date: 1/17/2025 11:34:28 PM ******/
CREATE NONCLUSTERED INDEX [IX_Slots_IsReserved] ON [dbo].[Slots]
(
	[is_reserved] ASC,
	[doctor_id] ASC,
	[time] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Appointments] ADD  DEFAULT (getdate()) FOR [reserved_at]
GO
ALTER TABLE [dbo].[Appointments] ADD  DEFAULT ('Opened') FOR [status]
GO
ALTER TABLE [dbo].[Slots] ADD  DEFAULT ((0)) FOR [is_reserved]
GO
ALTER TABLE [dbo].[Appointments]  WITH CHECK ADD  CONSTRAINT [FK_Appointments_Patient] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patients] ([patient_id])
GO
ALTER TABLE [dbo].[Appointments] CHECK CONSTRAINT [FK_Appointments_Patient]
GO
ALTER TABLE [dbo].[Appointments]  WITH CHECK ADD  CONSTRAINT [FK_Appointments_Slot] FOREIGN KEY([slot_id])
REFERENCES [dbo].[Slots] ([slot_id])
GO
ALTER TABLE [dbo].[Appointments] CHECK CONSTRAINT [FK_Appointments_Slot]
GO
ALTER TABLE [dbo].[Slots]  WITH CHECK ADD  CONSTRAINT [FK_Slots_Doctor] FOREIGN KEY([doctor_id])
REFERENCES [dbo].[Doctors] ([doctor_id])
GO
ALTER TABLE [dbo].[Slots] CHECK CONSTRAINT [FK_Slots_Doctor]
GO
ALTER TABLE [dbo].[Appointments]  WITH CHECK ADD  CONSTRAINT [CHK_Status_ValidValues] CHECK  (([Status]='OPENED' OR [Status]='CANCELED' OR [Status]='COMPLETED'))
GO
ALTER TABLE [dbo].[Appointments] CHECK CONSTRAINT [CHK_Status_ValidValues]
GO
USE [master]
GO
ALTER DATABASE [booking_db] SET  READ_WRITE 
GO
