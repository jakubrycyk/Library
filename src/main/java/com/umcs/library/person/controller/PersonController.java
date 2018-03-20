package com.umcs.library.person.controller;

import com.umcs.library.person.domain.Person;
import com.umcs.library.person.service.PersonService;

import java.util.List;

public class PersonController {

    private PersonService personService;

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public Person findById(int id){
        return personService.findById(id);
    }

    public List<Person> findAll() {
        return personService.findAll();
    }

    public int insert(Person person) {
        return personService.insert(person);
    }

    public int deleteById(int id) {
        return personService.deleteById(id);
    }

    public int update(Person person) {
        return personService.update(person);
    }

    public int count() {
        return personService.count();
    }
}
