package com.ttptriage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttptriage.entities.Vitals;

public interface VitalsRepository extends JpaRepository<Vitals, Integer> {
//    void addVitals(Vitals vitals);
	List<Vitals> findVitalsByPersonId(int personId);
//	Vitals create(Vitals vitals);
}
