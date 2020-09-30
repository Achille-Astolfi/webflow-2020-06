package com.example.corso.flow.application;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.corso.flow.serviceimpl.SampleServiceImpl;

public class StaticFlowApplication {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext spring = new AnnotationConfigApplicationContext("com.example.corso.flow.config.back")) {
			SampleServiceImpl sampleServiceImpl = spring.getBean(SampleServiceImpl.class);
			System.out.println(sampleServiceImpl.greet());
		}
	}
}
