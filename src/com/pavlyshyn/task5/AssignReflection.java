package com.pavlyshyn.task5;

import java.lang.reflect.Field;

public class AssignReflection {
    Integer integer;

    @Override
    public String toString() {
        return '{' +
                "integer=" + integer +
                '}';
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        AssignReflection assignReflection = new AssignReflection();
        Field f = assignReflection.getClass().getDeclaredField("integer");
        if (f.getType().equals(Integer.class)) {
            f.set(assignReflection, 12);
        }
        System.out.println(assignReflection);
    }
}
