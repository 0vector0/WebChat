package com.github.mykhalechko.webchat.util;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class JSPConfig {

    @Bean
    public InternalResourceViewResolver getViewResolver() {

        System.out.println("getViewResolver");

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
