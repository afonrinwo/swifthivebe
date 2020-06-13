package com.swifthive.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.swifthive.model.Response;
import com.swifthive.model.userfunction.UserFunctionObject;
import com.swifthive.model.usermenu.UserMenuObject;
import com.swifthive.model.userrole.UserRoleObject;

@Configuration
@PropertySource("classpath:responseCode.properties")
public class SwiftHiveBEConfiguration {

	@Bean
	public Response createFunctionResponse() {
		return new Response();
	}
	
	@Bean
	public UserMenuObject createMenuObject() {
		return new UserMenuObject();
	}
	
	
	@Bean
	public UserRoleObject userRoleObject() {
		return new UserRoleObject();
	}
	
	
	@Bean
	public UserFunctionObject userFunctionObject() {
		return new UserFunctionObject();
	}
	

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.getEntityManagerFactory();
		return transactionManager;
	}
	
}
