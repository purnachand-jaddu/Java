package com.mentor.training;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionExample {

    public static void invokeConstructorsViaReflection() {
        EagerInitialization reflectionInstance = null;
        EagerInitialization reflectionInstance2 = null;
        Constructor<?>[] constructors = EagerInitialization.class.getDeclaredConstructors();
        Constructor<?> constructor = constructors[0];
        constructor.setAccessible(true);
        try {
            reflectionInstance = (EagerInitialization) constructor.newInstance();
            reflectionInstance2 = (EagerInitialization) constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(EagerInitialization.getInstance());
        System.out.println(reflectionInstance);
        System.out.println(reflectionInstance2);
    }
}
