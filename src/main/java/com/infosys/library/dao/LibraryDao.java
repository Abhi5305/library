package com.infosys.library.dao;

import com.infosys.library.entity.Book;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class LibraryDao {
    public List<Book> listOfbooks(){
        return Arrays.asList(
                new Book(100,"Godan","Munsi Premchand","Golu"),
                new Book(101,"Gavan","Munsi Premchand","Prince"),
                new Book(102,"Unsuitable Boy","Karan Johan","Muskan"),
                new Book(103,"My 100th Century","Sachin Tendulkar","Chhoti"),
                new Book(104,"An ordinary life","Nawazuddin Siddiki","Prince"),
                new Book(105,"I am no Mashiha","Sonu Sood","Golu"),
                new Book(106,"Aap hi best hai","Anupam Kher","Muskan"),
                new Book(107,"Kiss Of My life","Imran Hasmi","Prince"),
                new Book(108,"My story Kamladas","Sanjay Dutt","Chhoti"),
                new Book(109,"A century is not enough","Saurav Ganguli","Goliu"),
                new Book(110,"Khullam Khulla","Rishi Kapoor","Chhoti"),
                new Book(111,"Lesson life not me","Anupam Kher","Chhoti"),
                new Book(112,"Pregnancy Bible","Kareena Kapoor","Chhoti")
        );
    }
}
