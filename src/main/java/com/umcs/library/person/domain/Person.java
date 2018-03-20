package com.umcs.library.person.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Past
    private Date dob;

    @Temporal(TemporalType.DATE)
    @Past
    private Date createDate;

    public Person(@NotNull String firstName, @NotNull String lastName, @NotNull Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

}
