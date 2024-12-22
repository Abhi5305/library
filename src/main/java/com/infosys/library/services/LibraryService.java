package com.infosys.library.services;

import com.infosys.library.dto.Request;
import com.infosys.library.dto.Response;
import com.infosys.library.entity.Book;

import java.util.List;

public interface LibraryService {
    Response addBook(Request request);
    boolean isBookPresent(String title);
    Book borrowBook(String title);
    List<Book> searchBook(String title,String author, String issuer);
    List<Book> searchBookFromDao(String title,String author, String issuer);

}
