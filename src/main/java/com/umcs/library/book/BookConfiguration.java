package com.umcs.library.book;

import com.umcs.library.book.domain.factory.BookFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfiguration {

    @Bean
    public BookFactoryBean bookFactoryBean1(){
        BookFactoryBean bookFactoryBean = new BookFactoryBean();
        bookFactoryBean.setTitle("Księga Jungli");
        bookFactoryBean.setAuthor("Tomek Baś");
        return bookFactoryBean;
    }
}
