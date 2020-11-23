package com.org.demo.annotations;


import com.org.demo.base.BaseResolver;
import com.org.demo.di.Context;
import com.org.demo.exceptions.ComponentInitializationException;

public class InjectableResolver implements BaseResolver {

    private Class<com.org.demo.annotations.Injectable> annotatedClass = com.org.demo.annotations.Injectable.class;

    public void initClass(Class<?> clazz) {
        if (clazz.isAnnotationPresent(annotatedClass)) {
            try {
                Context.setInjectable(clazz.getName(), clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            throw new ComponentInitializationException("Cannot initialize component. Make sure it is annotated with @Injectable");
        }
    }

    public Class<com.org.demo.annotations.Injectable> getAnnotatedClass() {
        return annotatedClass;
    }
}
