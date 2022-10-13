package com.skilldistillery.sap.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriorityTest {
	
	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Priority priority;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPASAP");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		priority = em.find(Priority.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		priority = null;
	}

	@Test
	void test_Prioity_entity_mapping() {
		assertNotNull(priority);
		assertEquals("Alpha", priority.getLevel());
	}
	@Test
	void test_WorkOrder_entity_mapping() {
		assertNotNull(priority);
		assertEquals("0000-414-1U1", priority.getWorkOrders().get(0).getEquipment());
	}
	

}
