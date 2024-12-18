package com.infosys.library.services;

import com.infosys.library.dto.Request;
import com.infosys.library.dto.Response;
import com.infosys.library.entity.Book;

public interface LibraryService {
    Response addBook(Request request);
    boolean isBookPresent(String title);
    Book borrowBook(String title);
}
