package com.example.corso.flow.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.corso.flow.service.SampleService;

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
}
