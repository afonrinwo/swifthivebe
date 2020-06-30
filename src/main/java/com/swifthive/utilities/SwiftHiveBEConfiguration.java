package com.swifthive.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.swifthive.model.Response;
import com.swifthive.model.userfunction.UserFunctionObject;
import com.swifthive.model.usermenu.UserMenuObject;
import com.swifthive.model.userrole.UserRoleObject;

@Configuration
@EnableTransactionManagement
public class SwiftHiveBEConfiguration {
	
	@Bean
	public Util util() {
		return new Util();
	}

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
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").exposedHeaders("OPTIONS")
						.allowedHeaders("content-type", "authorization")
						.allowCredentials(true)
						.maxAge(3600);
			}
		};
	}

}
