package org.mockito.test_doubles.stub;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceStub {

    @Test
    public void TestDoubleWithoutMockito() {

        BookRepository bookRepository = new StubBookRepository();
        BookService bookService = new BookService(bookRepository);

        List<Book> listadoTest = bookService.AplicarDescuentoALibros(10,7);

        //500 - %10 = 450, 800 - %10 = 720, 750 - %10 = 675
        //500 - %10 = 450, 400 - %10 = 360, 350 - %10 = 315
        assertEquals(3, listadoTest.size());
        assertEquals(450, listadoTest.get(0).getPrice());
        assertEquals(720, listadoTest.get(1).getPrice());
        assertEquals(675, listadoTest.get(2).getPrice());

    }

    @Test
    public void TestDoubleWithMockito(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1", "Mockito in action", LocalDate.now(), 1500);
        Book book2 = new Book("2", "Maven for dummies", LocalDate.now(), 1700);

        List<Book> listaLibros = bookRepository.findNewBooks(7);
        listaLibros.add(book1);
        listaLibros.add(book2);

        when(bookRepository.findNewBooks(7)).thenReturn(listaLibros);

        List<Book> listaLibrosConDescuento = bookService.AplicarDescuentoALibros(10,7);
        assertEquals(2,listaLibros.size());
        assertEquals(1350, listaLibrosConDescuento.get(0).getPrice());
        assertEquals(1530, listaLibrosConDescuento.get(1).getPrice());
    }
}
