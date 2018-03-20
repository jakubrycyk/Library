package com.umcs.library.person.controller;

import com.umcs.library.person.domain.Person;
import com.umcs.library.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public Optional<Person> findById(int id){
        return personService.findById(id);
    }

    public List<Person> findAll() {
        return personService.findAll();
    }

    public void insert(Person person) {
        personService.insert(person);
    }

    public void deleteById(int id) {
        personService.deleteById(id);
    }

    public void update(Person person) {
        personService.update(person);
    }

    public long count() {
        return personService.count();
    }
}
