package com.pavlyshyn.task6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class InvokeReflection {
    void myMethod(String a, int... args) {
        System.out.println("a = " + a + " args = " + Arrays.toString(args));
    }

    void myMethod(String... args) {
        System.out.println("args = " + Arrays.toString(args));
    }
    static void invokeMyMethod(InvokeReflection obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = InvokeReflection.class.getDeclaredMethod("myMethod", String[].class);
        method.invoke(obj,new Object[]{new String[]{"Java","C#"}});
        method = InvokeReflection.class.getDeclaredMethod("myMethod", String.class, int[].class);
        method.invoke(obj,"Hello",new int[]{2,3,4,5,6});

    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InvokeReflection invokeReflection = new InvokeReflection();
        InvokeReflection.invokeMyMethod(invokeReflection);
    }
}
