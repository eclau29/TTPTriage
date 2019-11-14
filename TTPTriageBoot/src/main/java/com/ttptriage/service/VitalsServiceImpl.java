package com.ttptriage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttptriage.entities.Person;
import com.ttptriage.entities.Vitals;
import com.ttptriage.repository.PersonRepository;
import com.ttptriage.repository.VitalsRepository;

@Service
public class VitalsServiceImpl implements VitalsService {

//    private final VitalsDao vitalsDao;
//
//    @Autowired
//    public VitalsServiceImpl(@Qualifier("vitalsDao") VitalsDao vitalsDao) {
//        this.vitalsDao = vitalsDao;
//    }
//
//    public Integer addVitals(Vitals vitals) {
//        return vitalsDao.insertVitals(vitals);
//    }
	@Autowired
	VitalsRepository vrepo;
	@Autowired
	PersonRepository prepo;
	
	@Override
	public List<Vitals> getVitals(Integer personId) {
		Optional<Person> personOpt = prepo.findById(personId);
		List<Vitals> foundVitals = null;
		if (personOpt.isPresent()) {
			Person person = personOpt.get();
			foundVitals = person.getVitalsList();
		}
		return foundVitals;
	}

	@Override
	public Vitals getByPerson_IdAndVitals_Id(Integer personId, Integer vitalsId) {
		return vrepo.findByIdAndPerson_Id(vitalsId, personId);
	}

	@Override
	public Boolean deleteVitals(Integer personId, Integer vitalsId) {
		Vitals vitalsToDelete = vrepo.findByIdAndPerson_Id(vitalsId, personId);
		Boolean deleted = false;
		if (vitalsToDelete != null) {
			try {
				vrepo.deleteById(vitalsId);
				deleted = true;
			} catch (Exception e) {
				e.printStackTrace();
				deleted = null;
			}
		}
		return deleted;
	}

	@Override
	public Vitals addVitals(Integer personId, Vitals vitals) {
		Optional<Person> currentPerson = prepo.findById(personId);
		if (currentPerson.isPresent()) {
			vitals.setPerson(currentPerson.get());
			vrepo.saveAndFlush(vitals);
		}
		return vitals;
	}

	@Override
	public Vitals update(Integer personId,Integer vitalsId, Vitals vitals) {
		Vitals currVitals = vrepo.findByIdAndPerson_Id(vitalsId, personId);
		vitals.setId(vitalsId);
		vitals.setPerson(currVitals.getPerson());
		return vrepo.saveAndFlush(vitals);
	}

}
