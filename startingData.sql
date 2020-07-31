USE [master]
GO

/****** Object:  Database [SwiftHive]    Script Date: 7/27/2020 9:22:28 AM ******/
DROP DATABASE [SwiftHive]
GO

/****** Object:  Database [SwiftHive]    Script Date: 7/27/2020 9:22:28 AM ******/
CREATE DATABASE [SwiftHive]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SwiftHive', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\SwiftHive.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'SwiftHive_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\SwiftHive_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SwiftHive].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [SwiftHive] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [SwiftHive] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [SwiftHive] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [SwiftHive] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [SwiftHive] SET ARITHABORT OFF 
GO

ALTER DATABASE [SwiftHive] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [SwiftHive] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [SwiftHive] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [SwiftHive] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [SwiftHive] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [SwiftHive] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [SwiftHive] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [SwiftHive] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [SwiftHive] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [SwiftHive] SET  DISABLE_BROKER 
GO

ALTER DATABASE [SwiftHive] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [SwiftHive] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [SwiftHive] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [SwiftHive] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [SwiftHive] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [SwiftHive] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [SwiftHive] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [SwiftHive] SET RECOVERY FULL 
GO

ALTER DATABASE [SwiftHive] SET  MULTI_USER 
GO

ALTER DATABASE [SwiftHive] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [SwiftHive] SET DB_CHAINING OFF 
GO

ALTER DATABASE [SwiftHive] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [SwiftHive] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [SwiftHive] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [SwiftHive] SET QUERY_STORE = OFF
GO

ALTER DATABASE [SwiftHive] SET  READ_WRITE 
GO


------------------------------------------------------------------------------------------------------------------------


USE [SwiftHive]
GO

INSERT INTO [dbo].[user_function]
           ([approved_by]
           ,[approved_client_id]
           ,[client_id]
           ,[created_by]
           ,[date_approved]
           ,[date_created]
           ,[function_name]
           ,[merchant_id]
           ,[status])
     VALUES
           ('super.admin'
           ,20200724100624993
           ,20200724100624993
           ,'super.admin'
		   ,'2020-07-24T10:06:24.993'
           ,'2020-07-24T10:06:24.993'
           ,'Super Admin'
           ,'SM001'
           ,1)
GO

GO

INSERT INTO [dbo].[user_role]
           ([approved_by]
           ,[approved_client_id]
           ,[client_id]
           ,[created_by]
           ,[date_approved]
           ,[date_created]
           ,[merchant_id]
           ,[role_name]
           ,[status])
     VALUES
           ('super.admin'
           ,20200724100624993
           ,20200724100624993
           ,'super.admin'
           ,'2020-07-24T10:06:24.993'
           ,'2020-07-24T10:06:24.993'
           ,'SM001'
           ,'All'
           ,1)
GO

GO

INSERT INTO [dbo].[user_profile]
           ([approved_by]
           ,[approved_client_id]
           ,[client_id]
           ,[created_by]
           ,[date_approved]
           ,[date_created]
           ,[email]
           ,[first_name]
           ,[function_name]
           ,[last_name]
           ,[merchant_id]
           ,[mobile_number]
           ,[role_name]
           ,[status]
           ,[user_name])
     VALUES
           ('super.admin'
           ,202007241003
           ,202007241003
           ,'super.admin'
           ,'2020-07-24T10:06:24.993'
           ,'2020-07-24T10:06:24.993'
           ,'afonrinwo@gmail.com'
           ,'Super'
           ,'Super Admin'
           ,'Admin'
           ,'SM001'
           ,'08000000000'
           ,'All'
           , 1
           ,'super.admin')
GO

GO

INSERT INTO [dbo].[profile_key]
           ([unique_id]
           ,[email]
           ,[last_password_change_date]
           ,[merchant_id]
           ,[mobile_number]
           ,[off_set]
           ,[password_count]
           ,[user_name])
     VALUES
           (1
           ,'afonrinwo@gmail.com'
           ,'2020-07-24T10:06:24.993'
           ,'SM001'
           ,'08000000000'
           ,'8c3f7da1ffc82fd0c928cfcffba21bbece4cd771e05ca4d39d785f42614e9e70f4973a6e1d72f44847802a10a431cd6c36d85eab9c7db59984920615dfd274d8'
           ,1
           ,'super.admin')
GO

GO

INSERT INTO [dbo].[user_menu]
           ([approved_by]
           ,[approved_client_id]
           ,[client_id]
           ,[created_by]
           ,[date_approved]
           ,[date_created]
           ,[menu_category]
           ,[menu_component]
           ,[menu_name]
           ,[menu_path]
           ,[merchant_id]
           ,[nav_icon]
           ,[nav_item]
           ,[status])
     VALUES
	   ('super.admin',202007241003,202007241003,'super.admin','2020-07-24T10:06:24.993','2020-07-24T10:06:24.993','Profile Setup','createMenu','Create Menu','admin/createMenu','SM001','fa fa-user-circle-o','admin/Profile',1),
	   ('super.admin',202007241003,202007241003,'super.admin','2020-07-24T10:06:24.993','2020-07-24T10:06:24.993','Services','mapMenu','Map Menu','admin/mapMenu','SM001','fa fa-tasks','admin/Services',1),
	   ('super.admin',202007241003,202007241003,'super.admin','2020-07-24T10:06:24.993','2020-07-24T10:06:24.993','Services','modifyMapMenu','Modify Map Menu','admin/modifyMapMenu','SM001','fa fa-tasks','admin/Services',1),
	   ('super.admin',202007241003,202007241003,'super.admin','2020-07-24T10:06:24.993','2020-07-24T10:06:24.993','Services','pendingAuthorization','Pending Authorization','admin/pendingAuthorization','SM001','fa fa-tasks','admin/Services',1)
	   
GO

GO

INSERT INTO [dbo].[map_menu]
           ([approved_by]
           ,[approved_client_id]
           ,[client_id]
           ,[created_by]
           ,[date_approved]
           ,[date_created]
           ,[function_name]
           ,[merchant_id]
           ,[role_name]
           ,[selected_menu_list]
           ,[status])
     VALUES
           ('super.admin'
           ,202007241003
           ,202007241003
           ,'super.admin'
           ,'2020-07-24T10:06:24.993'
           ,'2020-07-24T10:06:24.993'
           ,'Super Admin'
           ,'SM001'
           ,'All'
           ,'1|2|3|4'
           ,1)
GO

