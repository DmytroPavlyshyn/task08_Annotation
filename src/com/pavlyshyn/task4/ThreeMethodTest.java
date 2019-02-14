package com.pavlyshyn.task4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ThreeMethodTest {
    public void firstMethod(int a){
        System.out.println(a);
    }
    public int secondMethod(String[] a){
        return a.length;
    }
    public boolean thirdMethod(int a, int b){
        return a>b;
    }
    @SuppressWarnings("unchecked")
    public static void  invokeThreeMethods(ThreeMethodTest threeMethodTest,int a, int b, String[] c) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class cl = ThreeMethodTest.class;
        Method firstMethod = cl.getDeclaredMethod("firstMethod", int.class);
        Method secondMethod = cl.getDeclaredMethod("secondMethod", String[].class);
        Method thirdMethod = cl.getDeclaredMethod("thirdMethod", int.class, int.class);
        System.out.print("First method: ");
        firstMethod.invoke(threeMethodTest,a);
        System.out.println("Second method: " +  secondMethod.invoke(threeMethodTest,new Object[]{c}));
        System.out.println("Third method: " + thirdMethod.invoke(threeMethodTest,a,b));
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ThreeMethodTest threeMethodTest = new ThreeMethodTest();
        ThreeMethodTest.invokeThreeMethods(threeMethodTest,4,2, new String[]{"Hello", "World"});
    }
}
