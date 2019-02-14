package com.pavlyshyn.task3;

import com.pavlyshyn.task2.Description;
import com.pavlyshyn.task2.Droid;
import com.pavlyshyn.task2.TestAnnotation;

public class TestAnnotation2 {
    void showValueOfDescription(Class c) {
        TestAnnotation testAnnotation = new TestAnnotation();
        testAnnotation.getAnnotatedDescriptionField(c)
                .stream()
                .map(f -> f.getAnnotationsByType(Description.class))
                .forEach((ab) -> {
                    System.out.println(ab[0].value());
                });
    }

    public static void main(String[] args) {
        TestAnnotation2 testAnnotation2 = new TestAnnotation2();
        testAnnotation2.showValueOfDescription(Droid.class);

    }
}
