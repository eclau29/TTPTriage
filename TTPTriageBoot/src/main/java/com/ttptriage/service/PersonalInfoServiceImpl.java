package com.ttptriage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttptriage.entities.Person;
import com.ttptriage.entities.PersonalInfo;
import com.ttptriage.entities.Symptoms;
import com.ttptriage.entities.Vitals;
import com.ttptriage.repository.PersonRepository;
import com.ttptriage.repository.PersonalInfoRepository;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {
	@Autowired
	PersonalInfoRepository pirepo;
	@Autowired
	PersonRepository prepo;

	@Override
	public PersonalInfo create(Person person, PersonalInfo personalInfo) {
//		Person currentPerson = prepo.findById(personId);
		if (person != null) {
//			List<Symptoms> newSymptoms = person.getSymptomsList();
//			List<Vitals> newVitals = person.getVitalsList();
			personalInfo.setPerson(person);
			pirepo.saveAndFlush(personalInfo);
//			for (Symptoms symptom : newSymptoms) {
//				symptom.setPerson(newVictim);
//			}
//			
//			for (Vitals vital : newVitals) {
//				vital.setPerson(newVictim);
//			}
		}
		return personalInfo;
	}

	@Override
	public PersonalInfo getInfo(int personId) {
		Person currentPerson = prepo.findById(personId);
		return currentPerson.getPersonalInfo();
	}

	@Override
	public PersonalInfo updateInfo(int personId, PersonalInfo personalInfo) {
		personalInfo.setPerson(prepo.findById(personId));
		return pirepo.saveAndFlush(personalInfo);
	}

	@Override
	public Boolean deleteInfo(int personId, int infoId) {
		Boolean deleted = false;
		if (prepo.findById(personId).getPersonalInfo().getId() == infoId) {
			try {
				pirepo.deleteById(infoId);
				deleted = true;
			} catch (Exception e) {
				e.printStackTrace();
				deleted = null;
			}
		}
		return deleted;
	}
	
	
}
