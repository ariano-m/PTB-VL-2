package org.example.service;

import org.example.model.Book;
import org.example.model.BookDate;

import java.util.*;

public class Service {

    public BookDate filterBooksByChars(String filter, List<Book> books) {
        Optional<BookDate> opt =  this.filter(filter, books);
        return opt.orElseGet(() -> new BookDate(new Book(), ""));
    }

    private Optional<BookDate> filter(String filter, List<Book> books) {

        for (Book b : books) {
            if (b.getPublicationTimestamp() == 0) {
                System.out.println("Libro sin fecha de publicación: " + b.getTitle());
            }
        }

        String formatDate = "dd-MM-yy";
        HashMap<String, BookDate> map = new HashMap<>();
        for (Book b : books) {
            if (b.getTitle().contains(filter) &&
                    b.getSummary().contains(filter) &&
                    b.getAuthor().getBio().contains(filter)) {
                BookDate bookDate = new BookDate(b, formatDate);
                if (!map.containsKey(b.getAuthor().getName())) {
                    map.put(b.getAuthor().getName(), bookDate);
                } else {
                    Book bookMap = map.get(b.getAuthor().getName());
                    if (b.getPublicationTimestamp() > bookMap.getPublicationTimestamp()) {
                        map.replace(bookMap.getAuthor().getName(), bookDate);
                    }
                }
            }
        }

        List<BookDate> filteredBooksL = new LinkedList<>(map.values());
        Comparator<BookDate> sortByTimeStampAndLength = Comparator
                .comparing(BookDate::getPublicationTimestamp)
                .thenComparing(b -> b.getSummary().length());

        filteredBooksL.sort(sortByTimeStampAndLength);

        if (filteredBooksL.size() > 0) {
            return Optional.ofNullable(filteredBooksL.get(0));
        }

        return Optional.empty();
    }

}
