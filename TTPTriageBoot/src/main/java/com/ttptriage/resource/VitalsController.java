package com.ttptriage.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttptriage.entities.Person;
import com.ttptriage.entities.Vitals;
import com.ttptriage.repository.PersonRepository;
import com.ttptriage.repository.VitalsRepository;

@RestController
@RequestMapping(value = "api/vitals")
public class VitalsController {

    @Autowired
    VitalsRepository vitalsRepository;


//    public VitalsController(VitalsRepository vitalsRepository) {
//        this.vitalsRepository = vitalsRepository;
//    }
    
    @PostMapping(path="/{personId}/getVitals/", consumes = "application/json", produces="application/json")
    public List<Vitals> getVitals(@RequestBody Person person){
    	List<Vitals> vitalsList = vitalsRepository.findVitalsByPersonId(person.getId());
    	return vitalsList;
    }
    
//    @PostMapping(value="/{personId}/createVitals")
//    public Vitals createVitals(@RequestBody Vitals vitals, @PathVariable int personId, HttpServletRequest req, HttpServletResponse resp) {
//    	try {
//    		Person managedPerson = null;
//    		vitalsRepository.create(vitals);
//    		Optional<Person> person = pRepo.findById(personId);
//    		if (person.isPresent()) {
//    			managedPerson = person.get();
//    			vitals.setPerson(managedPerson);
//    			vitalsRepository.saveAndFlush(vitals);
//    			resp.setStatus(201);
//    		}
//    		StringBuffer url = req.getRequestURL();
//			System.out.println(url);
//			url.append("/");
//			url.append(personId);
//			System.out.println(url);
//			String newAddrUrl = url.toString();
//			resp.addHeader("Location", newAddrUrl);
//			return vitals;
//    	}
//    	catch (Exception e) {
//			e.printStackTrace();
//			resp.setStatus(400);
//			vitals = null;
//		}
//    	return vitals;
//    	
//    }

}
