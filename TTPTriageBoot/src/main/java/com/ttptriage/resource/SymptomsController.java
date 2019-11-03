package com.ttptriage.resource;

import com.ttptriage.entities.Symptoms;
import com.ttptriage.repository.PersonRepository;
import com.ttptriage.repository.SymptomsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "api/symptoms")
@RestController
public class SymptomsController {

    @Autowired
    SymptomsRepository symptomsRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/all")
    public List<Symptoms> getAllSymptoms(HttpServletRequest request, HttpServletResponse response){
        List<Symptoms> allSymptoms = new ArrayList<>();
        try {
           allSymptoms = symptomsRepository.findAll();
        }
        catch (Exception e) {
            response.setStatus(400);
        }
        response.setStatus(200);
        return allSymptoms;
    }


    @GetMapping(value = "/all/{id}")
    public List<Symptoms> getAllSymptomsByPersonId(@Param("id") Integer id, HttpServletRequest request, HttpServletResponse response){
        List<Symptoms> allSymptoms = new ArrayList<>();
//        Person person = personRepository.findById(id).get();
//        if (person != null) {
//
//        }
        try {
            allSymptoms = symptomsRepository.findSymptomsByPersonId(id);
        }
        catch (Exception e) {
            response.setStatus(400);
        }
        response.setStatus(200);
        return allSymptoms;
    }

    @PostMapping(path = "/createSymptoms", consumes = "application/json", produces = "application/json")
    public void createSymptomsForPerson(@RequestBody Symptoms symp, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (symp != null) {
                symptomsRepository.saveAndFlush(symp);
            }
        } catch (Exception e) {
            response.setStatus(400);
        }
        response.setStatus(200);
    }
}
