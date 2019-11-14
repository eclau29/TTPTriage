package com.ttptriage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttptriage.entities.Catastrophe;
import com.ttptriage.entities.Person;

public interface CatastropheRepository extends JpaRepository<Catastrophe, Integer> {

	public List<Catastrophe> findCatastropheByCatId(Integer catId);
//	public List<Person> findPersonsByCatastrophe_Id(Integer catId);
}
