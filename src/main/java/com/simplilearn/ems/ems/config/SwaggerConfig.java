package com.simplilearn.ems.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// This annotation enables the swagger support in the application
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket postsApi() {
		// This method called on the Docket bean that returns a "ApiSelectorBuilder"
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(metadata())
				.select().paths(PathSelectors.any()).build();
	}
	
	private ApiInfo metadata() {
		String title ="Employee Management System API";
		String description ="EMS API reference guid.";
		String version ="1.0.0";
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.termsOfServiceUrl("https://www.ems.com/")
				.version(version)
				.build();
	}
}
