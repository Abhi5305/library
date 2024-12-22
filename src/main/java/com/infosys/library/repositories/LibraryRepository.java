package com.infosys.library.repositories;

import com.infosys.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Book,Long> {
    Book findByTitle(String title);
    List<Book> findByIssuer(String issuer);
    List<Book> findByAuthor(String author);
    @Query("SELECT b FROM Book b WHERE b.author = :author AND b.issuer = :issuer")
    List<Book> findByAuthorAndIssuer(@Param("author") String author, @Param("issuer") String issuer);

    @Query("SELECT b FROM Book b WHERE b.title = :title AND b.author = :author AND b.issuer = :issuer")
    List<Book> findByTitleAndAuthorAndIssuer(String title, String author, String issuer);

    @Query("SELECT b FROM Book b WHERE b.title = :title AND b.issuer = :issuer")
    List<Book> findByTitleAndIssuer(String title, String issuer);

    @Query("SELECT b FROM Book b WHERE b.author = :author AND b.title = :title")
    List<Book> findByAuthorAndTitle(String author, String title);
}
