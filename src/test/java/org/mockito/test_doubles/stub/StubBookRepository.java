package org.mockito.test_doubles.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StubBookRepository implements BookRepository {

   @Override
    public List<Book> findNewBooks(int days) {
       //500 - %10 = 450, 800 - %10 = 720, 750 - %10 = 675
       Book book1 = new Book("1","Mockito in 3 lessons", LocalDate.now(), 500);
       Book book2 = new Book("2","Mockito in 3 lessons", LocalDate.now(), 800);
       Book book3 = new Book("3", "ockito in 3 lessons", LocalDate.now(), 750);

       List<Book> SimulaBD = new ArrayList<>();
       SimulaBD.add(book1);
       SimulaBD.add(book2);
       SimulaBD.add(book3);

        return SimulaBD;
    }
}
