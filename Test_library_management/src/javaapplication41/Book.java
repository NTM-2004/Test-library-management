package javaapplication41;

public class Book {
    private String isbn, title, author, publisher, status;

    public Book(String isbn, String title, String author, String publisher, String status) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.status = status;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getStatus() {
        return status;
    }    

    public void setStatus(String status) {
        this.status = status;
    }
    
}

// Note