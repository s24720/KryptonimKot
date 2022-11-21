package com.example.model;

import com.example.IManageBooks;
import com.example.data.Book;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BooksManager implements IManageBooks {
    @Override
    public List<Book> getByTitle(List<Book> books, String keyword) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(keyword)).toList();
    }

    @Override
    public List<String> getDescription(List<Book> books) {
        return books.stream()
                .map(Book::getDescription).toList();
    }

    @Override
    public Map<Integer, List<Book>> gruopByPublicationYear(List<Book> books) {
        return null;
    }
//
//    @Override
//    public Map<Integer, List<Book>> gruopByPublicationYear(List<Book> books) {
//
////        return books.stream()
////                .collect(Collectors.groupingBy(book -> book.getPublicationDate().getYear()
////                , Collectors.mapping(book -> book.getPublicationDate().getYear()
////                        , Collectors.toMap())));
//    }

    @Override
    public double getTotalPrice(List<Book> books) {
        return books.stream()
                .collect(Collectors.summarizingDouble(Book::getPrice)).getSum();
    }
}
