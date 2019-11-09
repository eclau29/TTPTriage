package com.ttptriage.service;

import java.util.List;

import com.ttptriage.entities.Vitals;

public interface VitalsService {

	List<Vitals> getVitals(Integer personId);
	Vitals getByPerson_IdAndVitals_Id(Integer personId, Integer vitalsId);
	Vitals addVitals(Integer personId, Vitals vitals);
	Vitals update(Integer personId, Integer vitalsId, Vitals vitals);
	Boolean deleteVitals(Integer personId, Integer vitalsId);
}
