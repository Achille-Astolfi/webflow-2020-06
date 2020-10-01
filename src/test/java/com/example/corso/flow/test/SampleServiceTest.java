package com.example.corso.flow.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.corso.flow.config.test.ServiceTestConfig;
import com.example.corso.flow.service.SampleService;

// L'annotation @RunWith(SpringRunner.class) mi dice che questa class
// contiene test da eseguire in Spring
// Spring viene informato della questione da jUnit e come conseguenza
// tratta l'istanza di questa class come se fosse un Component Spring
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
public class SampleServiceTest {
	// Questa è la dichiarazione con cui un Component Spring dichiara
	// la dipendenza verso un altro Component Spring
	// La regola è sempre quella: il tipo della variabile (in questo
	// caso è un campo) dev'essere quello dell'interface.
	@Autowired
	private SampleService sampleService;

	// Questa è la parte di jUnit: jUnit trova tutti i metodi annotati
	// con @Test e li esegue
	// I metodi static assertXxx permettono a jUnit di raccogliere informazioni
	// su quali metodi ti test hanno successo e quali no
	@Test
	public void autowiredTest() {
		// in realtà questo test è inutile: non sto testando la unit
		// ma sto testando il funzionamento di Spring
		assertNotNull(sampleService);
	}

	// i test utili sono quelli sui metodi della Unit che stiamo testando
	@Test
	public void greetTest() {
		// mi aspetto che "Hello World!" sia il risultato quando invoco il metodo greet()
		assertEquals("Hello World!", sampleService.greet());
	}

	// scrivere il test sul metodo che abbiamo scritto ieri
	@Test
	public void greetNameTest() {
		// mi aspetto che "Ciao Pietro!" sia il risultato quando invoco ...
		assertEquals("Ciao Pietro!", sampleService.greetName("Pietro"));
		assertEquals("Ciao Giulia!", sampleService.greetName("Giulia"));
	}
}
