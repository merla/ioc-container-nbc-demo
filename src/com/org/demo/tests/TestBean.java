package com.org.demo.tests;


import com.org.demo.annotations.Bean;
import com.org.demo.annotations.Dependency;

@Bean
public class TestBean {

    @Dependency
    public com.org.demo.tests.MessageService messageService;

    public void writeMessage() {
        System.out.println(messageService.getMessage());
    }

}
