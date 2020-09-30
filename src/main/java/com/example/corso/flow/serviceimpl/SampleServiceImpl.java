package com.example.corso.flow.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.corso.flow.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {
	public String greet() {
		return "Hello World!";
	}
}
