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

class DepartmentTest {
	
	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Department department;

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
		department = em.find(Department.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		department = null;
	}

	@Test
	void test_Department_entity_mapping() {
		assertNotNull(department);
		assertEquals("Mechanical Maintenance", department.getName());
	}
	@Test
	void test_Notification_entity_mapping() {
		assertNotNull(department);
		assertEquals("Compresor leaking", department.getNotifications().get(0).getDescription());
	}
	

}
