package com.techtoprotect.triage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtoprotect.triage.model.Vitals;

public interface VitalsRepository extends JpaRepository<Vitals, Integer> {
//    void addVitals(Vitals vitals);
	List<Vitals> findByPersonId(int personId);
//	Vitals create(Vitals vitals);
}
