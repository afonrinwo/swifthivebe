package com.swifthive.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.swifthive.model.Response;
import com.swifthive.model.function.FunctionObject;
import com.swifthive.model.menu.MenuObject;
import com.swifthive.model.menu.NavigationParamObject;
import com.swifthive.model.profile.ProfileKeyObject;
import com.swifthive.model.profile.ProfileObject;
import com.swifthive.model.role.RoleObject;

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
	public MenuObject menuObject() {
		return new MenuObject();
	}

	@Bean
	public RoleObject roleObject() {
		return new RoleObject();
	}

	@Bean
	public FunctionObject functionObject() {
		return new FunctionObject();
	}

	@Bean
	public ProfileObject profileObject() {
		return new ProfileObject();
	}
	
	@Bean
	public ProfileKeyObject profileKeyObject() {
		return new ProfileKeyObject();
	}
	
	@Bean
	public NavigationParamObject navigationParamObject() {
		return new NavigationParamObject();
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
