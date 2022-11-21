package org.example.annotation;


import org.example.annotation.MyAnnotation;

@MyAnnotation(message = "1234")
public class AnnotationProcessor {
    @MyAnnotation
    private int value;

    @MyAnnotation(valueMax = 69)
    public AnnotationProcessor(int value) {
        this.value = value;
    }

    @MyAnnotation(valueMin = 7)
    private static void printer() {

    }
}
