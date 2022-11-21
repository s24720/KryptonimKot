package com.example;

import com.example.data.Book;
import com.example.model.ClassDescription;
import com.example.model.Library;
import com.example.data.BookSample;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.data.BookSample.books;


public class Main {
    public static void main(String[] args) {


        System.out.println("Zaczynamy. Życzę powodzenia :)");

        Library library = new Library(BookSample.books);

        ClassDescription bookDescriptor = new ClassDescription(Book.class);
        System.out.println(bookDescriptor.getInfo());
//        bookDescriptor.getInfo();

        System.out.println(getPriceOfJavaBooksPublicizedIn2002());
        System.out.println(showNetBooksPublicizedIn2001());


    }
//    private static double getPriceOfJavaBooksPublicizedIn2002(List<Book> books){

        private static double getPriceOfJavaBooksPublicizedIn2002(){
            return books
                    .stream()
                    .filter(book -> book.getTitle().toLowerCase().contains("java"))
                    .filter(book -> book.getPublicationDate().getYear() == 2002)
                    .mapToDouble(Book::getPrice).sum();
        }

        private static List<String> showNetBooksPublicizedIn2001(){
//            String print = BookSample.books
//                    .stream()
//                    .filter(book -> book.getTitle().equalsIgnoreCase("net"))
//                    .filter(book -> book.getPublicationDate().getYear() == 2001)
//                    .map(Book::getDescription)
//                    .toString();
//            System.out.println(print);
       
            return books
                    .stream()
                    .filter(book -> book.getTitle().toLowerCase().contains("net"))
                    .filter(book -> book.getPublicationDate().getYear() == 2001)
                    .map(Book::getDescription)
                    .collect(Collectors.toList());
    }
}
