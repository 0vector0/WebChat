package com.github.mykhalechko.webchat.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan("com.github.mykhalechko.webchat")
public class ApplicationConfig {
}
