package com.umcs.library.book.repository.impl;


import com.umcs.library.book.domain.Book;
import com.umcs.library.book.repository.BookRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class BookJDBCTemplateRepository implements BookRepository{

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Book WHERE id=?", new Object[]{id}, new BookRowMapper());
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM Book", new BookRowMapper());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    @Override
    public int insert(Book book) {
        return jdbcTemplate.update("INSERT INTO Book (Title, Author, AddDate, IsLost) VALUES(?, ?, ?, ?)",
                book.getTitle(), book.getAuthor(), LocalDate.now(), false);
    }

    @Override
    public int update(Book book) {
        return jdbcTemplate.update("UPDATE Book SET Title = ?, Author = ?, AddDate = ?, IsLost = ? WHERE Id = ?",
                book.getTitle(), book.getAuthor(), Date.valueOf(book.getAddDate()), book.getIsLost(), book.getId());
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(1) FROM Book", Integer.class);
    }

    @Override
    public int getBorrowedCount() {
        return jdbcTemplate.queryForObject("SELECT count(bok.Id) FROM Book bok LEFT JOIN Borrow bor ON bok.Id = bor.BookId WHERE bor.ReturnDate IS NULL AND bor.BookId IS NOT NULL", Integer.class);
    }

    class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.fillFieldsFromResultSet(rs);
            return book;
        }
    }

}
