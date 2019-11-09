package com.ttptriage.service;

import java.util.List;

import com.ttptriage.entities.Person;

public interface PersonService {
	/*
	 *  LIST	GET		/api/patients/			List Patients
		CREATE	POST	/api/patients/			Add Patient
		READ	GET		/api/patients/{pid}/	Show Patient
		UPDATE	PUT		/api/patients/{pid}/	Update Patient
		DELETE	DELETE	/api/patients/{pid}/	Delete Patient
	 */
	
	public List<Person> listAllPersons();
	public Person create(Person person);
	public Person findById(int personId);
	public Person update(int personId, Person person);
	public Boolean deletePerson(int personId);
}
