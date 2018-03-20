package com.umcs.library.book.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    @Column(columnDefinition = "boolean default false")
    private Boolean isLost;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date addDate;

    public Book(@NotNull String title, @NotNull String author, @NotNull Boolean isLost, @NotNull Date addDate) {
        this.title = title;
        this.author = author;
        this.isLost = isLost;
        this.addDate = addDate;
    }
}
