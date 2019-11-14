package com.ttptriage.resource;

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
import com.ttptriage.service.CatastropheService;


@RestController
@RequestMapping(value = "api/catastrophe")
public class CatastropheController {
	@Autowired
	private CatastropheService catsvc;
	
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
	
	@PostMapping(value = "/{catastropheId}/victims")
	public Person addVictim(@PathVariable int catastropheId, @RequestBody Person newVictim) {
		return catsvc.
	}
	
	

}
