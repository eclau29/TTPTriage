package com.ttptriage.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttptriage.entities.Person;
import com.ttptriage.entities.PersonalInfo;
import com.ttptriage.entities.Vitals;
import com.ttptriage.repository.PersonRepository;
import com.ttptriage.service.PersonServiceImpl;
import com.ttptriage.service.PersonalInfoServiceImpl;
import com.ttptriage.service.VitalsServiceImpl;

@RestController
@RequestMapping(value = "api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonServiceImpl psvc;
    @Autowired
    private VitalsServiceImpl vsvc;
    @Autowired
    private PersonalInfoServiceImpl infosvc;

    @GetMapping(value = "/all")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
    
    @GetMapping(value = "/{personId}")
    public Person getPersonById(@PathVariable int personId) {
    	return personRepository.findById(personId);
    }
    
    @GetMapping(path="/{personId}/vitals/", consumes = "application/json", produces="application/json")
    public List<Vitals> getVitals(@RequestBody Person person){
    	return vsvc.getVitals(person.getId());
    }
    
    @PostMapping(path="/{personId}/vitals/")
    public Vitals addVitals(@RequestBody Integer personId, Vitals vitals){
    	return vsvc.addVitals(personId, vitals);
    }
    
    @GetMapping(path="/{personId}/vitals/{vitalsId}")
    public Vitals getVitalsById(@PathVariable Integer personId, @PathVariable Integer vitalsId) {
    	return vsvc.getByPerson_IdAndVitals_Id(personId, vitalsId);
    }
    
    @PutMapping(path="/{personId}/vitals/{vitalsId}")
    public Vitals editVitals(@PathVariable Integer personId, @PathVariable Integer vitalsId, @RequestBody Vitals vitals ) {
    	Vitals currentVitals = vsvc.getByPerson_IdAndVitals_Id(personId, vitalsId);
    	if (currentVitals != null) {
    		vitals.setPerson(currentVitals.getPerson());
    		vitals = vsvc.update(personId, currentVitals.getId(), vitals);
    		return vitals;
    	}
    	return null;
    }
    
    @DeleteMapping(path="/{personId}/vitals/{vitalsId}")
    public Boolean deleteVitals(@PathVariable Integer personId, @PathVariable Integer vitalsId) {
    	Boolean deleted = false;
    	Vitals vitalsToDelete = vsvc.getByPerson_IdAndVitals_Id(personId, vitalsId);
    	if (vitalsToDelete != null) {
    		try {
				vsvc.deleteVitals(personId, vitalsId);
				deleted = true;
			} catch (Exception e) {
				e.printStackTrace();
				deleted = null;
			}
    	}
    	return deleted;
    }
    
    @GetMapping(path="/{personId}/personalInfo/")
    public PersonalInfo getPersonalInfo (@PathVariable Integer personId) {
    	return infosvc.getInfo(personId);
    }
    @DeleteMapping(path="/{personId}/personalInfo/{infoId}")
    public Boolean getPersonalInfo (@PathVariable Integer personId, @PathVariable Integer infoId) {
    	return infosvc.deleteInfo(personId, infoId);
    }
    
    @PostMapping(path="/{personId}/personalInfo/")
    public PersonalInfo createPersonalInfo(@PathVariable Integer personId, @RequestBody PersonalInfo personalInfo) {
    	return infosvc.create(personId, personalInfo);
    }
    
    @PutMapping(path="/{personId}/personalInfo/")
    public PersonalInfo updatePersonalInfo(@PathVariable Integer personId, @RequestBody PersonalInfo personalInfo ) {
    	PersonalInfo infoToUpdate = infosvc.getInfo(personId);
    	if (infoToUpdate != null) {
    		personalInfo.setPerson(infoToUpdate.getPerson());
    		personalInfo = infosvc.updateInfo(infoToUpdate.getId(), personalInfo);
    		return personalInfo;
    	}
    	return null;
    }
    
    
    
}
    
    
    

