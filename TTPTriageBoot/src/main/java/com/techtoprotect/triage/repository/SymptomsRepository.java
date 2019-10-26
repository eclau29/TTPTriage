package com.techtoprotect.triage.repository;

import com.techtoprotect.triage.model.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SymptomsRepository extends JpaRepository<Symptoms, Integer> {

    public List<Symptoms> findSymptomsByPersonId(Integer personId);
}
