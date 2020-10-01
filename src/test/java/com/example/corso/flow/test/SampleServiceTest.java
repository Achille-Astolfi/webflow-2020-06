package com.example.corso.flow.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.corso.flow.config.test.ServiceTestConfig;
import com.example.corso.flow.service.SampleService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
public class SampleServiceTest {
	@Autowired
	private SampleService sampleService;

	@Test
	public void autowiredTest() {
		assertNotNull(sampleService);
	}
}
