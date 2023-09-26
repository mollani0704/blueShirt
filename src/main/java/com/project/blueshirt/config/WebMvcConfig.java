package com.project.blueshirt.config;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.project.blueshirt.filter.TestInterceptor;

@Configurable
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Value("${file.path}")
	private String filePath;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TestInterceptor())
			.order(1)
			.addPathPatterns("/**");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/image/**")
			.addResourceLocations("file:///" + filePath)
			.setCachePeriod(60 * 60)
			.resourceChain(true)
			.addResolver(new PathResourceResolver() {
				@Override
				protected Resource getResource(String resourcePath, Resource location) throws IOException {
					resourcePath = URLDecoder.decode(resourcePath, StandardCharsets.UTF_8);
					return super.getResource(resourcePath, location);
				}
			});
	}
	
}
