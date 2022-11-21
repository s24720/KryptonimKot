package com.example.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.List.*;

public class BookSample {

    public static List<Book>  books = new ArrayList<>(
            of(
                    new Book(1, "Programowanie w Java", LocalDate.of(2002, 01, 01), 10),
                    new Book(2, ".Net Aplikacje", LocalDate.of(2001, 02, 01), 10),
                    new Book(3, "JAVA jest super", LocalDate.of(2002, 03, 01), 10),
                    new Book(4, ".Net też jest spoko", LocalDate.of(2001, 04, 01), 10),
                    new Book(5, "Python na start ", LocalDate.of(2001, 05, 01), 10)
            ));
}
