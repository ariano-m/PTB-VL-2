package org.example.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class BookDate extends Book {
    private Date date;
    public BookDate(Book b, String format) {
        super();

        if (format.isEmpty()) {
            format = "dd-MM-yy";
        }

        try {
            Date date1 = new Date(b.getPublicationTimestamp());
            String datestr = date1.toInstant().toString();
            this.date = new SimpleDateFormat(format).parse(datestr);
        } catch (ParseException pe) {
            System.out.println("ERROR " + pe.getMessage());
        }

        setBook(b);
    }

    private void setBook(Book b) {
        this.setAuthor(b.getAuthor());
        this.setId(b.getId());
        this.setPages(b.getPages());
        this.setTitle(b.getTitle());
        this.setPublicationTimestamp(b.getPublicationTimestamp());
        this.setSummary(b.getSummary());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BookDate{" +
                "date=" + date +
                '}';
    }

    public boolean isEmpty() {
        return (Objects.equals(this.getTitle(), "") || this.getTitle() == null)
                && this.getAuthor() == null;
    }
}
