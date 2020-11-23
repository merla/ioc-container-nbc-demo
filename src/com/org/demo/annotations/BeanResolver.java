package com.org.demo.annotations;


import com.org.demo.base.BaseResolver;
import com.org.demo.di.Context;
import com.org.demo.exceptions.ComponentInitializationException;

public class BeanResolver implements BaseResolver {

    private Class<com.org.demo.annotations.Bean> annotatedClass = com.org.demo.annotations.Bean.class;

    public void initClass(Class<?> clazz) {
        if (clazz.isAnnotationPresent(annotatedClass)) {
            try {
                Context.setBean(clazz.getName(), clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            throw new ComponentInitializationException("Cannot initialize component. Make sure it is annotated with @Bean");
        }
    }

    public Class<com.org.demo.annotations.Bean> getAnnotatedClass() {
        return annotatedClass;
    }
}
