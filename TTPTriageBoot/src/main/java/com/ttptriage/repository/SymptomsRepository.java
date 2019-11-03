package com.ttptriage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttptriage.entities.Symptoms;

import java.util.List;

public interface SymptomsRepository extends JpaRepository<Symptoms, Integer> {

    public List<Symptoms> findSymptomsByPersonId(Integer personId);
}
