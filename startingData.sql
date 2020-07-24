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
           ,0)
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
           ,0)
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
	   ('super.admin',202007241003,202007241003,'super.admin','2020-07-24T10:06:24.993','2020-07-24T10:06:24.993','Profile Setup','CreateMenu','Create Menu','admin/createMenu','SM001','fa fa-user-circle-o','admin/Profile',1),
	   ('super.admin',202007241003,202007241003,'super.admin','2020-07-24T10:06:24.993','2020-07-24T10:06:24.993','Services','mapMenu','Map Menu','admin/mapMenu','SM001','fa fa-tasks','admin/Services',1),
	   ('super.admin',202007241003,202007241003,'super.admin','2020-07-24T10:06:24.993','2020-07-24T10:06:24.993','Services','modifyMapMenu','Modify Map Menu','admin/modifyMapMenu','SM001','fa fa-tasks','admin/Services',1),
	   ('super.admin',202007241003,202007241003,'super.admin','2020-07-24T10:06:24.993','2020-07-24T10:06:24.993','Services','PendingAuthorization','Pending Authorization','admin/pendingAuthorization','SM001','fa fa-tasks','admin/Services',1)
	   
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
           ,'1|2'
           ,1)
GO

