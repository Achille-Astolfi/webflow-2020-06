package com.example.corso.flow.config.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

@Configuration
@ComponentScan("com.example.corso.flow.config.back")
@TestPropertySource("/application-test.properties")
public class RepoTestConfig {
}
