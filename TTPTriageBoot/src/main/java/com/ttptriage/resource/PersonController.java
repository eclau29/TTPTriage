package com.ttptriage.resource;

import com.ttptriage.entities.Person;
import com.ttptriage.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/all")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
