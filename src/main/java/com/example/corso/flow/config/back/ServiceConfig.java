package com.example.corso.flow.config.back;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.corso.flow.serviceimpl")
public class ServiceConfig {
	@Bean
	public CommonAnnotationBeanPostProcessor commonAnnotationBeanPostProcessor() {
		return new CommonAnnotationBeanPostProcessor();
	}
}
