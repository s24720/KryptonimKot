package com.example.model;

import com.example.Info;
import com.example.data.Book;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ClassDescription {

    private Class<?> clazz;

    public ClassDescription(Class<?> c) {
        this.clazz = c;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getFullName(){
        return this.clazz.getName();

    }
    public List<String> getMethodsName(){
        return Arrays.stream(this.clazz.getDeclaredMethods()).map(Method::getName).toList();
//        return Arrays.stream(this.clazz.getClass().getDeclaredMethods()).map(m-> m.getName()).toList();


    }
    public List<String> getFieldNames(){
        return Arrays.stream(this.clazz.getDeclaredFields()).map(Field::getName).toList();
//        return Arrays.stream(this.clazz.getClass().getDeclaredFields()).map(m-> m.getName()).toList();

    }


    public String getInfo(){
        int indexNumber = clazz.getAnnotation(Info.class).id();
        String firstName = clazz.getAnnotation(Info.class).name();
        String lastName = clazz.getAnnotation(Info.class).surname();

        if(!clazz.isAnnotationPresent(Info.class)) {
            return null;
        }
        return "index: s%d, first name: %s, last name: %s".formatted(indexNumber, firstName, lastName);
    }
}

//    public String getInfo(){
//        int indexNumber = clazz.getAnnotation(Info.class).id();
//        String firstName = clazz.getAnnotation(Info.class).name();
//        String lastName = clazz.getAnnotation(Info.class).surname();
//
//        if(!clazz.isAnnotationPresent(Info.class)) {
//            return null;
//        }
//        return "index: s%d, first name: %s, last name: %s".formatted(indexNumber, firstName, lastName);
//    }
//    }

//    public void getInfo(){
//        var BookClass = Book.class;
//
//        Arrays.stream(BookClass.getDeclaredFields())
//                .filter(field -> field.isAnnotationPresent(Info.class)).forEach(field ->
//                {
//                    var annotation = field.getAnnotation(Info.class);
//                    //wypisuje wartości podane w annotacji
//                    System.out.println(annotation.id());
//                    System.out.println(annotation.name());
//                    System.out.println(annotation.surname());
//                });
//
//    }



//    public void getInfo() {
//        for (Method m : this.clazz.getMethods()) {
//            Info produce = m.getAnnotation(Info.class);
//            if (produce != null) {
//                System.out.println(produce.name() + " " + produce.id());
//            }
//        }
//    }
//}

