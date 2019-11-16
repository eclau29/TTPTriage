package com.ttptriage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttptriage.entities.Person;
import com.ttptriage.entities.Symptoms;
import com.ttptriage.repository.PersonRepository;
import com.ttptriage.repository.SymptomsRepository;

@Service
public class SymptomsServiceImpl implements SymptomsService {

	@Autowired
	private SymptomsRepository srepo;
	@Autowired
	private PersonRepository prepo;
	
	@Override
	public Symptoms createOneSymptom(int personId, Symptoms symptom) {
		Person currentPerson = prepo.findById(personId);
		System.err.println("in create one sympton " + currentPerson);
		if (currentPerson != null) {
			symptom.setPerson(currentPerson);
		}
		return srepo.saveAndFlush(symptom);
	}

	@Override
	public List<Symptoms> getPersonsSymptoms(int personId) {
		return srepo.findSymptomsByPersonId(personId);
	}

	@Override
	public Symptoms getOneSymptom(int personId, int symptomId) {
		return srepo.findBySymptomsIdAndPerson_Id(symptomId, personId);
	}

	@Override
	public Symptoms updateOneSymptom(int personId, int symptomId, Symptoms newSx) {
		Symptoms sxToUpdate = srepo.findBySymptomsIdAndPerson_Id(symptomId, personId);
		newSx.setSymptomsId(symptomId);
		newSx.setPerson(sxToUpdate.getPerson());
		return srepo.saveAndFlush(newSx);
	}

	@Override
	public Boolean deleteOneSymptom(int personId, int symptomId) {
		Boolean deleted = false;
		Symptoms sx = srepo.findBySymptomsIdAndPerson_Id(symptomId, personId);
		if (sx != null) {
			try {
				srepo.deleteById(sx.getSymptomsId());
				deleted = true;
			} catch (Exception e) {
				e.printStackTrace();
				deleted = null;
			}
		}
		return deleted;
	}
}
