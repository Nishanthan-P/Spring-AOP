package com.example.demo.config;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@SpringBootApplication
public class AppConfig implements WebMvcConfigurer{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	   // registry.addViewController("/login").setViewName("login");
	   // registry.addViewController("/error").setViewName("errorPage");
	}
	
	 	@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    	System.out.println("inside addResourceHandlers");
	            registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	            registry.addResourceHandler("swagger-ui.html")
	            .addResourceLocations("classpath:/META-INF/resources/");
	       
	            registry.addResourceHandler("/webjars/**")
	            .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }
	 	
	 	@Bean
	 	public ViewResolver internalResourceViewResolver() {
	 	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
//	 	    bean.setViewClass(JstlView.class);
	 	    bean.setPrefix("/WEB-INF/view/");
	 	    bean.setSuffix(".jsp");
	 	    return bean;
	 	}
	 	
	 	 @Override
	     public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	         Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	         builder.indentOutput(true);
	         converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
	     }
	 	 
	 	@Override
	    public void addCorsMappings(CorsRegistry registry) {
	    	registry.addMapping("/**");
	    }
}
