package org.example.model;

public class Book {
    private int id;
    private String title;
    private int pages;
    private String summary;
    private long publicationTimestamp;
    private Author author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public long getPublicationTimestamp() {
        return publicationTimestamp;
    }

    public void setPublicationTimestamp(long publicationTimestamp) {
        this.publicationTimestamp = publicationTimestamp;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", summary='" + summary + '\'' +
                ", publicationTimestamp=" + publicationTimestamp +
                ", author=" + author +
                '}';
    }
}
