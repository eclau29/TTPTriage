package com.ttptriage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttptriage.entities.Person;
import com.ttptriage.entities.PersonalInfo;
import com.ttptriage.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	/*
	 * LIST GET /api/patients/ List Patients CREATE POST /api/patients/ Add Patient
	 * READ GET /api/patients/{pid}/ Show Patient UPDATE PUT /api/patients/{pid}/
	 * Update Patient DELETE DELETE /api/patients/{pid}/ Delete Patient
	 */
	@Autowired
	private PersonRepository pRepo;
	@Autowired
	private PersonalInfoService pisvc;

//    @Autowired
//    public PersonService(@Qualifier("personDao") PersonDao personDao) {
//        this.personDao = personDao;
//    }
	public List<Person> listAllPersons() {
		return pRepo.findAll();
	}

//    public int addPerson(Person person) {
//        return pRepo.insertPerson(person);
//    }

	@Override
	public Person create(Person person) {
		PersonalInfo personInfo = person.getPersonalInfo();
		pisvc.create(person, personInfo);
		return person;
	}

	@Override
	public Person findById(int personId) {
		return pRepo.findById(personId);
	}

	@Override
	public Person update(int personId, Person updatedPerson) {
		// we do not want to be able to change the following
		// 		GPS, Id, initial eval time
		// we do not want to be able to change the following in this service:
		// 		List<Symptom>, List<Vital>
		Person personToUpdate = pRepo.findById(personId);
		if (personToUpdate != null) {
			personToUpdate.setCatastrophe(updatedPerson.getCatastrophe());
			personToUpdate.setGender(updatedPerson.getGender());
			personToUpdate.setLocation(updatedPerson.getLocation());
			personToUpdate.setPersonalInfo(updatedPerson.getPersonalInfo());
			personToUpdate.setSymptomsList(updatedPerson.getSymptomsList());
			personToUpdate.setVitalsList(updatedPerson.getVitalsList());
			
			pRepo.saveAndFlush(personToUpdate);
		}

		return personToUpdate;
	}

	@Override
	public Boolean deletePerson(int personId) {
		Boolean deleted = false;
		try {
			pRepo.deleteById(personId);
			deleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			deleted = null;
		}
		return deleted; //returns null if there is no such person.
						//returns false if cannot delete person
	}
}
