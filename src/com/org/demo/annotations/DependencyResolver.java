package com.org.demo.annotations;



import com.org.demo.di.Context;

import java.lang.reflect.Field;

public class DependencyResolver {

    public void initDependencies(Object bean) {
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(com.org.demo.annotations.Dependency.class)) {
                try {
                    field.set(bean, Context.getInjectable(field.getType().getName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
