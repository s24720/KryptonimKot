package org.example;


import org.example.annotation.*;
import org.example.lambda.*;
import org.example.model.*;
import org.example.reflekcje.*;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        lambda();
        reflekcje();
        annotation();
    }

    public static void lambda() {

        iFruit apple = new Apple(5, Color.RED);
        iFruit orange = new Orange(4, Color.ORANGE);
        List<iFruit> fruitList = new ArrayList<>();
        fruitList.add(apple);
        fruitList.add(orange);

        /** bez lamby */
        for (iFruit fruit : fruitList) {
            System.out.println(fruit.getColor());
            System.out.println(fruit.isGood());
        }
        /** z lambą */
        fruitList.forEach(fruit -> {
            System.out.println(fruit.getColor());
            System.out.println(fruit.isGood());
        });


        Action action = new Action(() -> System.out.println("hello"));
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.getSelectedGenders().add(Gender.FEMALE);
        action.SelectByGender((searchParameter) -> searchParameter.getSelectedGenders().size() > 1, searchParameters);


        Function<Double, Double> half = a -> a / 2.0;
        System.out.println(half.apply(10.1));

        List<Person> personList = PeopleSamples.Data;
        List<String> personNames = personList.stream().map(person -> person.getName()).toList();

        Predicate<String> hasName = name -> name.startsWith("A");
        System.out.println();
        System.out.println(personNames.stream().anyMatch(hasName));

        Consumer<Integer> display = integer -> System.out.println(integer);

        display.accept(10);

        //Consumer 2* każdy element z listy
        Consumer<List<Integer> > modify = list -> list.replaceAll(integer -> 2 * integer);

        // Consumer do wyświetlania listy
        Consumer<List<Integer> > dispList = list -> list.forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        modify.accept(list);

        dispList.accept(list);

        //ustawiamy Supplier, żeby zwracał randowoą wartość
        Supplier<Double> randomValue = () -> Math.random();

        System.out.println(randomValue.get());
    }
    private static void reflekcje() {
        Class<?> subjectClass = Subject.class;
        System.out.println(subjectClass.getName());
        System.out.println(subjectClass.getPackageName());

        List<Method> methodList = Arrays.stream(subjectClass.getDeclaredMethods()).toList();
        methodList.forEach(Main::getMethodInfo);//nazwa metody
        Constructor<?>[] constructors = subjectClass.getConstructors();
        Arrays.stream(constructors).forEach(constructor -> System.out.println(constructor.getName()));
    }

    private static void getMethodInfo(Method method) {
        System.out.println();
        System.out.println("Medoda: "+method.getName());
        System.out.println("Modyfikator: "+ Modifier.toString(method.getModifiers()));
        System.out.println("Zwracny Obiekt: "+method.getReturnType());
        System.out.println("Liczba parametrow: "+method.getParameterCount());
        System.out.println("Parametry: "+ Arrays.toString(method.getParameterTypes()));
    }

    private static void annotation() {
        var annotationProcessorClass = AnnotationProcessor.class;
        Arrays.stream(annotationProcessorClass.getDeclaredFields()).filter(field -> field.isAnnotationPresent(MyAnnotation.class)).forEach(field -> {
            var annotation = field.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.message());
            System.out.println(annotation.valueMax());
            System.out.println(annotation.valueMin());
        });
        Arrays.stream(annotationProcessorClass.getDeclaredMethods()).filter(method -> method.isAnnotationPresent(MyAnnotation.class)).forEach(System.out::println);
        Arrays.stream(annotationProcessorClass.getConstructors()).filter(constructor -> constructor.isAnnotationPresent(MyAnnotation.class)).forEach(System.out::println);
    }
}
