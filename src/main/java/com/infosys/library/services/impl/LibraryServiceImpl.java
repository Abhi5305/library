package com.infosys.library.services.impl;

import com.infosys.library.dao.LibraryDao;
import com.infosys.library.dto.Request;
import com.infosys.library.dto.Response;
import com.infosys.library.entity.Book;
import com.infosys.library.repositories.LibraryRepository;
import com.infosys.library.services.LibraryService;
import com.infosys.library.util.ResponseGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository libraryRepository;
    private final ResponseGenerator responseGenerator;
    private final LibraryDao libraryDao;

    public LibraryServiceImpl(LibraryRepository libraryRepository, ResponseGenerator responseGenerator, LibraryDao libraryDao) {
        this.libraryRepository = libraryRepository;
        this.responseGenerator = responseGenerator;
        this.libraryDao = libraryDao;
    }

    @Override
    public Response addBook(Request request) {
        Book book = new Book();
        book.setTitle(request.getBookTitle());
        book.setAuthor(request.getAuthor());
        book.setIssuer(request.getIssuer());
         libraryRepository.save(book);
        return responseGenerator.createResponse("Book is added to the library successfully!");
    }

    @Override
    public boolean isBookPresent(String title) {
        return libraryRepository.findByTitle(title) != null;
    }

    @Override
    public Book borrowBook(String title) {
        Book book = libraryRepository.findByTitle(title);
        String bookTitle = book.getTitle();
        if(bookTitle.equalsIgnoreCase(title)){
            return book;
        } else{
            throw new RuntimeException("mentioned book not found!");
        }
    }
    public List<Book> searchBookFromDao(String title,String author, String issuer){
        if(title != null && author != null && issuer != null){
            return libraryDao.listOfbooks().stream().filter(b->b.getTitle().equalsIgnoreCase(title) && b.getAuthor().equalsIgnoreCase(author) && b.getIssuer().equalsIgnoreCase(issuer)).toList();
        }else if(author != null && issuer != null){
            return libraryDao.listOfbooks().stream().filter(b-> b.getAuthor().equalsIgnoreCase(author) && b.getIssuer().equalsIgnoreCase(issuer)).toList();
        } else if(title != null && issuer != null){
            return libraryDao.listOfbooks().stream().filter(b->b.getTitle().equalsIgnoreCase(title) && b.getIssuer().equalsIgnoreCase(issuer)).toList();
        }else if(author != null && title != null){
            return libraryDao.listOfbooks().stream().filter(b->b.getTitle().equalsIgnoreCase(title) && b.getAuthor().equalsIgnoreCase(author)).toList();
        }  else if (author != null) {
            return libraryDao.listOfbooks().stream().filter(b-> b.getAuthor().equalsIgnoreCase(author)).toList();
        } else if (issuer !=null) {
            return libraryDao.listOfbooks().stream().filter(b-> b.getIssuer().equalsIgnoreCase(issuer)).toList();
        }else if (title !=null) {
            return libraryDao.listOfbooks().stream().filter(b->b.getTitle().equalsIgnoreCase(title)).toList();
        }else{
            return libraryDao.listOfbooks();
        }
    }
    public List<Book> searchBook(String title,String author, String issuer){
        if(title != null && author != null && issuer != null){
            return libraryRepository.findByTitleAndAuthorAndIssuer(title,author,issuer);
        }else if(author != null && issuer != null){
            return libraryRepository.findByAuthorAndIssuer(author,issuer);
        } else if(title != null && issuer != null){
            return libraryRepository.findByTitleAndIssuer(title,issuer);
        }else if(author != null && title != null){
            return libraryRepository.findByAuthorAndTitle(author,title);
        }  else if (author != null) {
            return libraryRepository.findByAuthor(author);
        } else if (issuer !=null) {
            return libraryRepository.findByIssuer(issuer);
        }else{
            return libraryRepository.findAll();
        }
    }

}
