package com.ttptriage.service;

import java.util.List;

import com.ttptriage.entities.Catastrophe;
import com.ttptriage.entities.Person;

public interface CatastropheService {
	public List<Catastrophe> listAllCatastrophes();
	public Catastrophe create(Catastrophe newCat);
	public Catastrophe findById(int catId);
	public Catastrophe update(int catId, Catastrophe newCatInfo);
	public Boolean deleteCatastrophe(int catId);
	public List<Person> findAllPeopleByCatastropheId(int catId);
	
}
