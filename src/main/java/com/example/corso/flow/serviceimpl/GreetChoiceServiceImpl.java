package com.example.corso.flow.serviceimpl;

import com.example.corso.flow.service.GreetChoiceService;
import com.example.corso.flow.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetChoiceServiceImpl implements GreetChoiceService {
    @Autowired
    private SampleService sampleService;

    @Override
    public String chooseGreet(String name) {
        if (name != null && !name.trim().isEmpty()) {
            return sampleService.greetName(name);
        } else {
            return sampleService.greet();
        }
    }
}
