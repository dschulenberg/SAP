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

class NotificationTest {
	
	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Notification notification;

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
		notification = em.find(Notification.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		notification = null;
	}

	@Test
	void test_Notification_entity_mapping() {
		assertNotNull(notification);
		assertEquals("HVAC seems to be down", notification.getDescription());
	}
	@Test
	void test_Department_entity_mapping() {
		assertNotNull(notification);
		assertEquals("HVAC", notification.getDepartment().getName());
	}
	

}
