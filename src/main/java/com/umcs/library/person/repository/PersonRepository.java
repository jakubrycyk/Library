package com.umcs.library.person.repository;

import com.umcs.library.person.domain.Person;

import java.util.List;

public interface PersonRepository {

    Person findById(int id);

    List<Person> findAll();

    int deleteById(int id);

    int insert(Person person);

    int update(Person person);

    int count();

}
