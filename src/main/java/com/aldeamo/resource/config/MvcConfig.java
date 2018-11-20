package com.aldeamo.resource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	@Value("${application.resources-folder}")
	private String resourcesFolder;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("/files/**")
			.addResourceLocations(resourcesFolder)
			.setCachePeriod(3600)
			.resourceChain(true)
			.addResolver(new GzipResourceResolver())
			.addResolver(new PathResourceResolver());
	}
	
}
