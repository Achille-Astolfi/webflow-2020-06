package com.example.corso.flow.serviceimpl;

import com.example.corso.flow.domain.Person;
import org.springframework.stereotype.Service;

import com.example.corso.flow.service.SampleService;
import org.springframework.util.StringUtils;

@Service
public class SampleServiceImpl implements SampleService {
	@Override
	public String greet() {
		return "Hello World!";
	}

	@Override
	public String greetName(String name) {
		// va bene lo stesso scrivere "Ciao " + name + "!"
		return String.format("Ciao %s!", name);
	}

	@Override
	public String greetPerson(Person person) {
		// Consiglio di buona programmazione: i controlli di conformità/validità dell'input
		// si fanno nelle prime righe del metodo
		if (person == null) {
			return "Errore";
		}
		if (!StringUtils.hasText(person.getFirstName())) {
			return "Errore";
		}
		if (!StringUtils.hasText(person.getPatronymic()) && !StringUtils.hasText(person.getLastName())) {
			return "Errore";
		}
		// Se ho scritto bene le condizioni di validità, arrivo qui e ho un input che è
		// coerente con le specifiche di funzionamento dell'algoritmo
		if (StringUtils.hasText(person.getPatronymic()) && StringUtils.hasText(person.getLastName())) {
			return String.format("Ciao %s %s!", person.getFirstName(), person.getPatronymic());
		} else {
			return String.format("Ciao %s!", person.getFirstName());
		}
	}
}
