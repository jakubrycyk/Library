package com.umcs.library.borrow.repository.impl;

import com.umcs.library.borrow.domain.Borrow;
import com.umcs.library.borrow.repository.BorrowRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class BorrowJDBCTemplateRepository implements BorrowRepository{

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Borrow findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Borrow WHERE id=?"
                , new Object[]{id}
                , new BorrowRowMapper());
    }

    @Override
    public List<Borrow> findAll() {
        return jdbcTemplate.query("SELECT * FROM Borrow", new BorrowRowMapper());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Borrow WHERE id=?", id);
    }

    @Override
    public int insert(Borrow borrow) {
        return jdbcTemplate.update("INSERT INTO Borrow (PersonId, BookId, BorrowDate) VALUES(?, ?, ?)",
                borrow.getPersonId(), borrow.getBookId(), Date.valueOf(borrow.getBorrowDate()));
    }

    @Override
    public int update(Borrow borrow) {
        return jdbcTemplate.update("UPDATE Borrow SET PersonId = ?, BookId = ?, BorrowDate = ?, ReturnDate = ? WHERE Id = ?",
                borrow.getPersonId(), borrow.getBookId(), Date.valueOf(borrow.getBorrowDate()), Date.valueOf(borrow.getReturnDate()), borrow.getId());
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(1) FROM Borrow", Integer.class);
    }

    class BorrowRowMapper implements RowMapper<Borrow> {
        @Override
        public Borrow mapRow(ResultSet rs, int rowNum) throws SQLException {
            Borrow borrow = new Borrow();
            borrow.fillFieldsFromResultSet(rs);
            return borrow;
        }
    }
}
