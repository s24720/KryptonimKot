package com.example.model;

import com.example.IHaveData;
import com.example.IManageBooks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library<Book> implements IHaveData<Book> {

    private List<Book> data = new ArrayList<>();

    public Library(List<Book> books) {
        this.data = books;
    }

    @Override
    public List getData() {
        return this.data;
    }

    @Override
    public void showData() {

        for (Book book : this.data) {
            System.out.println(book);
        }
    }
}
