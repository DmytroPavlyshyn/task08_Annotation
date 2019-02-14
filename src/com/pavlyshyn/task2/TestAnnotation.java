package com.pavlyshyn.task2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestAnnotation {
    public List<Field> getAnnotatedDescriptionField(Class c){
        List<Field> fields = new ArrayList<>(Arrays.asList(c.getDeclaredFields()));
        return fields.stream()
                .filter(field -> field.isAnnotationPresent(Description.class))
                .collect(Collectors.toList());
    }
    public void showAnnotatedDescriptionField(Class c){
        getAnnotatedDescriptionField(c)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        TestAnnotation testAnnotation = new TestAnnotation();
      testAnnotation.showAnnotatedDescriptionField(Droid.class);
    }
}
