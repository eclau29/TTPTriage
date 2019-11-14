package com.ttptriage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttptriage.entities.Catastrophe;
import com.ttptriage.entities.Person;
import com.ttptriage.repository.CatastropheRepository;

@Service
public class CatastropheServiceImpl implements CatastropheService {

	@Autowired
	private CatastropheRepository catrepo;

	@Override
	public List<Catastrophe> listAllCatastrophes() {
		return catrepo.findAll();
	}

	@Override
	public Catastrophe create(Catastrophe newCat) {
		return catrepo.saveAndFlush(newCat);
	}

	@Override
	public Catastrophe findById(int catId) {
		Optional<Catastrophe> catOpt = catrepo.findById(catId);
		if (catOpt.isPresent()) {
			Catastrophe foundCat = catOpt.get();
			return foundCat;
		}
		return null;
	}

	@Override
	public Catastrophe update(int catId, Catastrophe newCatInfo) {
		Optional<Catastrophe> catToUpdateOpt = catrepo.findById(catId);
		if (catToUpdateOpt.isPresent()) {
			newCatInfo.setCatId(catId);
			return catrepo.saveAndFlush(newCatInfo);
		}
		return null;
	}

	@Override
	public Boolean deleteCatastrophe(int catId) {
		Boolean deleted = false;
		try {
			catrepo.deleteById(catId);
			deleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			deleted = null;
		}
		return deleted;
	}

	@Override
	public List<Person> findAllPeopleByCatastropheId(int catId) {
		Optional<Catastrophe> catOpt = catrepo.findById(catId);
		List<Person> catVictims = null;
		if (catOpt.isPresent()) {
			Catastrophe cat = catOpt.get();
			catVictims = cat.getVictims();
		}
		return catVictims;
	}

	//TODO: fix this
	@Override
	public Person addVictim(int catId, Person victim) {
		List<Person> victimList = findAllPeopleByCatastropheId(catId);
		victimList.add(victim);
		return catrepo.saveAndFlush(victimList);
	}

}
