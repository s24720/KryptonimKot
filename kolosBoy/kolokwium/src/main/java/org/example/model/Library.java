package org.example.model;

import org.example.data.Book;
import org.example.data.IHaveData;

import java.util.List;

public class Library implements IHaveData<Book> {
    private List<Book> data;

    public Library(List<Book> data) {
        this.data = data;
    }

    public List<Book> getData() {
        return data;
    }

    @Override
    public void showData() {
        for (Book book : data) {
            System.out.println(book.getDescription());
        }
    }
}
