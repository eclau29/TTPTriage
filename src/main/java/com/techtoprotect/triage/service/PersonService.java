//package com.techtoprotect.triage.service;
//
//import com.techtoprotect.triage.dao.PersonDao;
//import com.techtoprotect.triage.model.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//public class PersonService {
//
//    private final PersonDao personDao;
//
//    @Autowired
//    public PersonService(@Qualifier("personDao") PersonDao personDao) {
//        this.personDao = personDao;
//    }
//
//    public int addPerson(Person person) {
//        return personDao.insertPerson(person);
//    }
//}
