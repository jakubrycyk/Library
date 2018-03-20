package com.umcs.library.borrow.domain;

import com.umcs.library.book.domain.Book;
import com.umcs.library.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


import static java.time.temporal.ChronoUnit.WEEKS;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne
    private Person person;

    @NotNull
    @ManyToOne
    private Book book;

    @Temporal(TemporalType.DATE)
    @Past
    private Date borrowDate;

    @Temporal(TemporalType.DATE)
    @Null
    private Date returnDate;

    public Borrow(Person person, Book book, Date borrowDate) {
        this.person = person;
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public boolean isLongerThanOneWeek(){
        return LocalDate.now().isAfter(borrowDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(14));
    }

    public double getPenalty(){
        if(isLongerThanOneWeek()){
            return WEEKS.between(borrowDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()) * 2;
        }
        return 0;
    }
}
