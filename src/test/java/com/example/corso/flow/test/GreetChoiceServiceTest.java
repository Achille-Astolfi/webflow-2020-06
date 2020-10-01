package com.example.corso.flow.test;

import com.example.corso.flow.config.test.ServiceTestConfig;
import com.example.corso.flow.service.GreetChoiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
public class GreetChoiceServiceTest {
    @Autowired
    private GreetChoiceService greetChoiceService;

    @Test
    public void chooseGreetTestOk() {
        assertEquals("Ciao Cavallo!", greetChoiceService.chooseGreet("Cavallo"));
    }

    @Test
    public void chooseGreetTestKo() {
        assertEquals("Hello World!", greetChoiceService.chooseGreet(null));
        assertEquals("Hello World!", greetChoiceService.chooseGreet(""));
        assertEquals("Hello World!", greetChoiceService.chooseGreet("     "));
    }
}
