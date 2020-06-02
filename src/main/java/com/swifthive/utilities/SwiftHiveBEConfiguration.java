package com.swifthive.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.swifthive.manager.UserFunction;
import com.swifthive.manager.UserMenu;
import com.swifthive.manager.UserRole;
import com.swifthive.model.Response;
import com.swifthive.model.createMenu.CreateMenuObject;
import com.swifthive.model.userRole.UserRoleObject;
import com.swifthive.model.userfunction.UserFunctionObject;

@Configuration
@PropertySource("classpath:responseCode.properties")
public class SwiftHiveBEConfiguration {

	@Bean
	public Response createFunctionResponse() {
		return new Response();
	}
	
	@Bean
	public CreateMenuObject createMenuObject() {
		return new CreateMenuObject();
	}
	
	@Bean
	public UserMenu userMenu() {
		return new UserMenu();
	}
	
	@Bean
	public UserRoleObject userRoleObject() {
		return new UserRoleObject();
	}
	
	@Bean
	public UserRole userRole() {
		return new UserRole();
	}
	
	@Bean
	public UserFunctionObject userFunctionObject() {
		return new UserFunctionObject();
	}
	
	@Bean
	public UserFunction createFunction() {
		return new UserFunction();
	}
	
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.getEntityManagerFactory();
		return transactionManager;
	}
	
}
