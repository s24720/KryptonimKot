package com.example;

import com.example.data.Book;

import java.util.List;
import java.util.Map;

public interface IManageBooks {
    List<Book> getByTitle(List<Book> books, String keyword);
    List<String> getDescription(List<Book> books);
    Map<Integer, List<Book>> gruopByPublicationYear(List<Book> books);
    double getTotalPrice(List<Book> books);

}
