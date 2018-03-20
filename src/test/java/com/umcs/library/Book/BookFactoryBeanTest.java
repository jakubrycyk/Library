package com.umcs.library.Book;

import com.umcs.library.book.domain.Book;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookFactoryBeanTest {

    @Autowired
    private Book book;

    @Test
    public void shouldBeNotNull(){
        Assert.assertNotNull(book);
    }

    @Test
    public void shouldBeEqual(){
        Assert.assertEquals(book.getTitle(), "Księga Jungli");
    }

}
