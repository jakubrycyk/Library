package com.umcs.library.person.service;

import com.umcs.library.person.domain.Person;
import com.umcs.library.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Optional<Person> findById(int id){
        return personRepository.findById(id);
    }

    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    public void insert(Person person) {
        personRepository.save(person);
    }

    public void deleteById(int id) {
        personRepository.deleteById(id);
    }

    public void update(Person person) {
        personRepository.save(person);
    }

    public long count() {
        return personRepository.count();
    }
}
