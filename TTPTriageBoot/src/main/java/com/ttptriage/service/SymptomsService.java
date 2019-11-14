package com.ttptriage.service;

import java.util.List;

import com.ttptriage.entities.Symptoms;

public interface SymptomsService {

	public Symptoms createOneSymptom(int personId, Symptoms symptoms);
	public List<Symptoms>getPersonsSymptoms(int personId);
	public Symptoms getOneSymptom(int personId, int symptomId);
	public Symptoms updateOneSymptom(int personId, int symptomId, Symptoms symptomInfo);
	public Boolean deleteOneSymptom(int personId, int symptomId);
}
