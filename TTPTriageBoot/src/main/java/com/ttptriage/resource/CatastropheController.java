package com.ttptriage.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ttptriage.repository.PersonalInfoRepository;
import com.ttptriage.service.CatastropheService;
import com.ttptriage.service.PersonService;
import com.ttptriage.service.PersonalInfoService;


@RestController
@RequestMapping(value = "api/catastrophe")
public class CatastropheController {
	@Autowired
	private CatastropheService catsvc;
	@Autowired
	private PersonService psvc;
	@Autowired
	private PersonalInfoService pInfoSvc;
	
	//PostMan success
	@GetMapping(value = "/all")
	public List<Catastrophe> getAllCatastrophes(){
		return catsvc.listAllCatastrophes();
	}
	
	@PostMapping(value = "/all")
	public Catastrophe addCatastrophe(@RequestBody Catastrophe newCat) {
		return catsvc.create(newCat);
	}
	
	//PostMan success
	@GetMapping(value = "/{catastropheId}")
	public Catastrophe getCatastropheById(@PathVariable int catastropheId) {
		return catsvc.findById(catastropheId);
	}
	
	@PutMapping(path = "/{catastropheId}")
	public Catastrophe updateCatastrophe (@PathVariable int catastropheId, @RequestBody Catastrophe newCatInfo) {
		return catsvc.update(catastropheId, newCatInfo);
	}
	
	
	//PostMan success
	@GetMapping(value = "/{catastropheId}/victims")
	public List<Person> getCatastrophePersons(@PathVariable int catastropheId){
		return catsvc.findAllPeopleByCatastropheId(catastropheId);
	}
	
	@PostMapping(path="/{catId}/victims/")
	//can I put multiple @RequestBody's as parameters?  ie @RB Symptoms, @RB Vitals, @RB PersonalInfo
  	public Person addVictim(@PathVariable int catId, @RequestBody Person victim) {
		List<Symptoms> newSymptoms = victim.getSymptomsList();
		List<Vitals> newVitals = victim.getVitalsList();
		PersonalInfo thisVictimsInfo = victim.getPersonalInfo();
		
		System.err.println("catid: " + catId);
		
  		Catastrophe cat = catsvc.findById(catId);
  		System.err.println("victim before add: " + victim);
  		
  		victim.setCatastrophe(cat);
  		victim.setSymptomsList(new ArrayList<Symptoms>());
  		victim.setVitalsList(new ArrayList<Vitals>());
  		Person newVictim = psvc.create(victim);
  		
  		for (Symptoms symptom : newSymptoms) {
  			symptom.setPerson(newVictim);
  			System.out.println(symptom.getPerson().getId());
  		}
  		
  		for (Vitals vital : newVitals) {
			vital.setPerson(newVictim);
			
		}
  		
  		newVictim.setSymptomsList(newSymptoms);
  		newVictim.setVitalsList(newVitals);
  		psvc.update(newVictim.getId(), newVictim);
  		
  		cat.getVictims().add(newVictim);
  		System.err.println("victim after add: " + newVictim);
  		catsvc.update(catId, cat);
  		return victim;
  	}
	
}
