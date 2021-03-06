package com.ttptriage.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ttptriage.entities.Symptoms;

class SymptomsTests {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Symptoms symptoms;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("triagepu");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		symptoms = em.find(Symptoms.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		symptoms = null;
	}

//	@Test
	void assert_symptoms_not_null() {
		assertNotNull(symptoms);
		assertEquals("laceration", symptoms.getInjury());
	}

}
