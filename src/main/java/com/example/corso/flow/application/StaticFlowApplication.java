package com.example.corso.flow.application;

import com.example.corso.flow.service.SampleService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.corso.flow.serviceimpl.SampleServiceImpl;

public class StaticFlowApplication {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext spring = new AnnotationConfigApplicationContext("com.example.corso.flow.config.back")) {
			// il metodo si chiama getBean ma dovrebbe chiamarsi getComponent perché è proprio quello che fa: restituisce il component
			// questo che ho scritto è il metodo "white box": non sto usando l'interface ma sto usando direttamente la class
//			SampleServiceImpl sampleServiceImpl = spring.getBean(SampleServiceImpl.class);
//			System.out.println(sampleServiceImpl.greet());
			// quando invece uso il tipo dell'interface allora uso il metodo "black box": è il modo nella teoria più corretto
			SampleService sampleService = spring.getBean(SampleService.class);
			System.out.println(sampleService.greet());
			// vado a testare la nuova funzionalità
			System.out.println(sampleService.greetName("Achille"));
		}
	}
}
