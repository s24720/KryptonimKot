package com.example.data;

import com.example.Info;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Info(id = 12345, name = "Jan", surname = "Kowalski")
public class Book implements IHaveDescription{

    private long id;
    private String title;
    private LocalDate publicationDate;
    private double price;

    public Book(long id, String title, LocalDate publicationDate, double price) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", price=" + price +
                '}';
//        return "id: %d, title: %s, publication: %s, price: %f".formatted(id, title, publicationDate.format(DateTimeFormatter.ofPattern("d-MMM-yyyy")), price);

    }
}
