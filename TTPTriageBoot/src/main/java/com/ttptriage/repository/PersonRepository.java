package com.ttptriage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttptriage.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	public Person findById(int personId);
	
}
