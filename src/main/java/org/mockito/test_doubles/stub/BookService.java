package org.mockito.test_doubles.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> AplicarDescuentoALibros(int descuento, int rangoDeDias){

        List<Book> librosConsultadosEnBD =bookRepository.findNewBooks(rangoDeDias);

        for(Book book: librosConsultadosEnBD){
            if(book.getPrice() >= 500){
                int descuentoCalculado = (int) (book.getPrice() * .10);
                int precioFinal = book.getPrice() - descuentoCalculado;
                book.setPrice(precioFinal);
            }
        }

        return librosConsultadosEnBD;
    }

}
