package com.umcs.library.book.domain.factory;

import com.umcs.library.book.domain.Book;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;

@Setter
public class BookFactoryBean implements FactoryBean<Book> {

    private String title;
    private String author;

    @Override
    public Book getObject() throws Exception {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @PostConstruct
    public void setup() throws Throwable {
        Assert.notNull(this.title, "the 'title' must not be null");
        Assert.notNull(this.author, "the 'author' must not be null");
    }
}
