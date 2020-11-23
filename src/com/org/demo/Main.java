package com.org.demo;


import com.org.demo.di.Context;
import com.org.demo.di.DependencyInjectionFactory;
import com.org.demo.tests.TestBean;

public class Main {

    public static void main(String[] args) {
        DependencyInjectionFactory.init();
        ((TestBean) Context.getBean("com.org.demo.tests.TestBean")).writeMessage();
    }
}
