package com.example.corso.flow.service;

import com.example.corso.flow.domain.Person;

public interface SampleService {
    String greet();

    String greetName(String name);

    String greetPerson(Person person);
}