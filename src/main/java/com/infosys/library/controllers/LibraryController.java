package com.infosys.library.controllers;

import com.infosys.library.dto.Request;
import com.infosys.library.dto.Response;
import com.infosys.library.entity.Book;
import com.infosys.library.services.LibraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@Tag(name="Library", description = "APIs to manage Library")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
    @Operation(summary = "Add Book", description = "a book gets added")
    @PostMapping("/add")
    public ResponseEntity<Response> addBook(@RequestBody @Valid Request request){
        Response response = libraryService.addBook(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @Operation(summary = "Get Book By title", description = "Retrieve specific book by its title")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Book found !"),
            @ApiResponse(responseCode = "500", description = "Couldn't find mentioned book!")
    })
    @GetMapping("/book/{title}")
    public ResponseEntity<Book> borrowBook(@PathVariable String title){
        Book newBook = libraryService.borrowBook(title);
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBook(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String issuer){
        List<Book> newBook = libraryService.searchBookFromDao(title,author, issuer);
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }
}
