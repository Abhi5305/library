package com.infosys.library.dto;

import jakarta.validation.constraints.NotBlank;

public class Request {
    @NotBlank(message = "Book title is required!")
    private String bookTitle;
    private String author;
    private String issuer;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
