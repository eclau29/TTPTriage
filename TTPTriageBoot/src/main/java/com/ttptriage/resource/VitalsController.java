package com.ttptriage.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttptriage.entities.Person;
import com.ttptriage.entities.Vitals;
import com.ttptriage.service.VitalsService;

@RestController
@RequestMapping(value = "api/vitals")
public class VitalsController {

    @Autowired
    private VitalsService svc;


//    public VitalsController(VitalsRepository vitalsRepository) {
//        this.vitalsRepository = vitalsRepository;
//    }
    
    
    
    
    
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
