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

import com.ttptriage.entities.Catastrophe;
import com.ttptriage.entities.Person;
import com.ttptriage.entities.PersonalInfo;
import com.ttptriage.entities.Symptoms;
import com.ttptriage.entities.Vitals;
import com.ttptriage.repository.PersonRepository;
import com.ttptriage.service.CatastropheService;
import com.ttptriage.service.PersonService;
import com.ttptriage.service.PersonalInfoService;
import com.ttptriage.service.SymptomsService;
import com.ttptriage.service.VitalsService;

@RestController
@RequestMapping(value = "api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService psvc;
    @Autowired
    private VitalsService vsvc;
    @Autowired
    private PersonalInfoService infosvc;
    @Autowired
    private SymptomsService symsvc;
    @Autowired
    private CatastropheService catsvc;

    //postman success
    @GetMapping(value = "/all")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
    
    //postman success
    @GetMapping(value = "/{personId}")
    public Person getPersonById(@PathVariable int personId) {
    	return personRepository.findById(personId);
    }
    
    //PostMan success
    @GetMapping(path="/{personId}/vitals/")
    public List<Vitals> getVitals(@PathVariable int personId){
    	return vsvc.getVitals(personId);
    }
    
    //fail: 403
    @PostMapping(path="/{personId}/vitals/")
    public Vitals addVitals(@RequestBody Vitals vitals, @PathVariable Integer personId ){
    	System.err.println("Person Id: " + personId + " Vitals: " + vitals);
    	return vsvc.addVitals(personId, vitals);
    }
    
    //postman success
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
    
	//PostMan success
    @GetMapping(path="/{personId}/personalInfo/")
    public PersonalInfo getPersonalInfo (@PathVariable Integer personId) {
    	return infosvc.getInfo(personId);
    }
    
    
    @DeleteMapping(path="/{personId}/personalInfo/{infoId}")
    public Boolean deletePersonalInfo1(@PathVariable Integer personId, @PathVariable Integer infoId) {
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
    
  //PostMan success
    @GetMapping(path="/{personId}/symptoms")
    public List<Symptoms> getPersonsSymptoms (@PathVariable Integer personId){
    	return symsvc.getPersonsSymptoms(personId);
    }
    
    
    @PostMapping(path="/{personId}/symptoms")
    public Symptoms addSymptoms(@PathVariable Integer personId, @RequestBody Symptoms newSymptoms) {
    	newSymptoms.setPerson(psvc.findById(personId));
    	return symsvc.createOneSymptom(personId, newSymptoms);
    }
    
    
    @PutMapping(path="/{personId}/symptoms/{symptomsId}")
    public Symptoms updateSymptoms(@PathVariable Integer personId,@PathVariable Integer symptomsId,
    		@RequestBody Symptoms newSymptoms) {
    	return symsvc.updateOneSymptom(personId, symptomsId, newSymptoms);
    }
    
    
    @DeleteMapping(path="/{personId}/symptoms/{symptomsId}")
    public Boolean deletePersonalInfo (@PathVariable Integer personId, @PathVariable Integer symptomsId) {
    	return symsvc.deleteOneSymptom(personId, symptomsId);
    }
    
  	public Person addVictim(int catId, Person victim) {
  		Catastrophe cat = catsvc.findById(catId);
  		Person newVictim = psvc.create(victim);
  		cat.getVictims().add(newVictim);
  		return newVictim;
  	}
}
    
    
    

