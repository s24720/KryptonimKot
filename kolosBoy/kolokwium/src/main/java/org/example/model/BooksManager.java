package org.example.model;

import org.example.data.Book;
import org.example.data.IManageBooks;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BooksManager implements IManageBooks {
    @Override
    public List<Book> getByTitle(List<Book> books, String keyword) {
        return books.stream().
                filter(name->name.getTitle().toLowerCase().contains(keyword)).
                toList();
    }

    @Override
    public List<String> getDescriptions(List<Book> books) {
        return books.stream().
                map(book -> book.getDescription()).
                collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Book>> groupByPublicationYear(List<Book> books) {
        return books.stream().
                collect(Collectors.
                        groupingBy(book -> book.getPublicationDate().getYear()));
    }

    @Override
    public double getTotalPrice(List<Book> books) {
        return books.stream().
                mapToDouble(book -> book.getPrice()).
                sum();
    }
}
