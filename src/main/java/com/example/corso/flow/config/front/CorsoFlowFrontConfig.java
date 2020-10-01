package com.example.corso.flow.config.front;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Decido di usare il progetto spring-webmvc con l'annotation @EnableWebMvc
//Sono obbligato a implementare l'interface WebMvcConfigurer e/o estendere
//WebMvcConfigurerAdapter (con Spring >= 5 posso evitare l'Adapter).
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.example.corso.flow.controller")
public class CorsoFlowFrontConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// <mvc:resources mapping="/resources/webjars/**" location="/resources/
		// classpath:META-INF/resources/webjars/"/>
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/",
				"classpath:META-INF/resources/webjars/");
		// <mvc:resources mapping="/sandbox*" location="/"/>
		registry.addResourceHandler("/sandbox*").addResourceLocations("/");
	}

}
