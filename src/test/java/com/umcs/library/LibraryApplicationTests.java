package com.umcs.library;

import com.umcs.library.book.domain.Book;
import com.umcs.library.book.repository.BookRepository;
import com.umcs.library.book.service.BookService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Mockito.mock;


@RunWith(SpringRunner.class)
@SpringBootTest
@ImportResource("classpath:test-config.xml")
public class LibraryApplicationTests {

    @Autowired
    private BookRepository bookRepository;
    private BookService bookService;

    @Before
    public void setUp(){
        bookService = new BookService(bookRepository);
        BookRepository bookRepository = mock(BookRepository.class);
        Book b1 = new Book("bookTitle1", "bookAutor1", false, LocalDate.now().minusYears(20));
        Book b2 = new Book("bookTitle2", "bookAutor2", false, LocalDate.now().minusYears(10));
        Mockito.when(bookRepository.findAll()).thenReturn(Arrays.asList(b1, b2));
        Mockito.when(bookRepository.findById(1)).thenReturn(b1);
    }

    @Test
    public void shouldBeTrue() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldReturnBook(){
        Assert.assertNotNull(bookService.findById(1));
    }

    @Test
    public void shouldReturnAllBooks(){
        Assert.assertEquals(2, bookService.findAll().size());
    }

    @Test
    public void shoudReturnEqualBook(){
        Assert.assertEquals("bookTitle1", bookService.findById(1).getTitle());
    }

}
