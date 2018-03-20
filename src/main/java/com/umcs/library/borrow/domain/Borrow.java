package com.umcs.library.borrow.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.WEEKS;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Borrow {
    private Integer id;
    private Integer personId;
    private Integer bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Borrow(Integer personId, Integer bookId, LocalDate borrowDate) {
        this.personId = personId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public void fillFieldsFromResultSet(ResultSet rs) throws SQLException {
        this.id = rs.getInt("Id");
        this.personId = rs.getInt("PersonId");
        this.bookId = rs.getInt("BookId");
        Date borrowDate = rs.getDate("BorrowDate");
        if (null != borrowDate) {
            this.borrowDate = borrowDate.toLocalDate();
        }
        Date returnDate = rs.getDate("ReturnDate");
        if (null != returnDate) {
            this.returnDate = returnDate.toLocalDate();
        }
    }

    public boolean isLongerThanOneWeek(){
        return returnDate.isAfter(borrowDate.plusWeeks(1));
    }

    public double getPenalty(){
        if(isLongerThanOneWeek()){
            return WEEKS.between(borrowDate, returnDate) * 2;
        }
        return 0;
    }
}
