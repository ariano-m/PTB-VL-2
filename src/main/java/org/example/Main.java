package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Book;
import org.example.model.BookDate;
import org.example.service.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        LinkedList<Book> books = new LinkedList<>();
        try {
            InputStream fis_file = Main.class.getResourceAsStream("/books.json");
            ObjectMapper mapper = new ObjectMapper();
            books = mapper.readValue(fis_file, new TypeReference<LinkedList<Book>>() { });
        } catch (IOException ioe) {
            System.out.printf(ioe.getMessage());
        }

        System.out.println(books.toString());

        Service filters = new Service();

        // Testing
        String[] filters_pattern = {"a", "Harry", "Kathryn", "#######"};
        for(String s : filters_pattern) {
            System.out.println("Filter '" + s + "'");
            BookDate bookDate = filters.filterBooksByChars(s, books);
            if (bookDate.isEmpty()) {
                System.out.println("Book not found");
            } else {
                System.out.println(bookDate.getAuthor().toString() + " " + bookDate);
            }
            System.out.println("\n\n");
        }
    }
}