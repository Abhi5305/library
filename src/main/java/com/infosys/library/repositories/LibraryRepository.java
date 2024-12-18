package com.infosys.library.repositories;

import com.infosys.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Book,Long> {
    Book findByBookTitle(String title);
}
