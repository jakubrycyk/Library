package com.umcs.library.book.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Boolean isLost;
    private LocalDate addDate;

    public Book(String title, String author, Boolean isLost, LocalDate addDate) {
        this.title = title;
        this.author = author;
        this.isLost = isLost;
        this.addDate = addDate;
    }

    public void fillFieldsFromResultSet(ResultSet rs) throws SQLException {
        this.id = rs.getInt("Id");
        this.title = rs.getString("Title");
        this.author = rs.getString("Author");
        this.isLost = rs.getBoolean("IsLost");
        Date addDate = rs.getDate("AddDate");
        if (null != addDate) {
            this.addDate = addDate.toLocalDate();
        }
    }


}
