package com.example.corso.flow.test;

import com.example.corso.flow.config.test.ServiceTestConfig;
import com.example.corso.flow.service.DoubleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
public class DoubleServiceTest {
    @Autowired
    private DoubleService doubleService;

    @Test
    public void sumAsDoubleTest() {
        assertEquals(2.2, doubleService.sumAsDouble(1.1, 1.1), 0.0001);
    }
}
