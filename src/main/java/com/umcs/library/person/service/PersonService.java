package com.umcs.library.person.service;

import com.umcs.library.person.domain.Person;
import com.umcs.library.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    public Person findById(int id){
        return personRepository.findById(id);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public int insert(Person person) {
        return personRepository.insert(person);
    }

    public int deleteById(int id) {
        return personRepository.deleteById(id);
    }

    public int update(Person person) {
        return personRepository.update(person);
    }

    public int count() {
        return personRepository.count();
    }
}
