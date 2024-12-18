package com.infosys.library.services.impl;

import com.infosys.library.dto.Request;
import com.infosys.library.dto.Response;
import com.infosys.library.entity.Book;
import com.infosys.library.repositories.LibraryRepository;
import com.infosys.library.services.LibraryService;
import com.infosys.library.util.ResponseGenerator;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository libraryRepository;
    private final ResponseGenerator responseGenerator;

    public LibraryServiceImpl(LibraryRepository libraryRepository, ResponseGenerator responseGenerator) {
        this.libraryRepository = libraryRepository;
        this.responseGenerator = responseGenerator;
    }

    @Override
    public Response addBook(Request request) {
        Book book = new Book();
        book.setBookTitle(request.getBookTitle());
        book.setAuthor(request.getAuthor());
        book.setIssuer(request.getIssuer());
         libraryRepository.save(book);
        return responseGenerator.createResponse("Book is added to the library successfully!");
    }

    @Override
    public boolean isBookPresent(String title) {
        return libraryRepository.findByBookTitle(title) != null;
    }

    @Override
    public Book borrowBook(String title) {
        Book book = libraryRepository.findByBookTitle(title);
        String bookTitle = book.getBookTitle();
        if(bookTitle.equalsIgnoreCase(title)){
            return book;
        } else{
            throw new RuntimeException("mentioned book not found!");
        }
    }


}
