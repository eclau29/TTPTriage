package com.techtoprotect.triage.repository;

import com.techtoprotect.triage.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
