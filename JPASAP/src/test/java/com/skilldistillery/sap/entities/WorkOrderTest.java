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

class WorkOrderTest {
	
	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private WorkOrder workOrder;

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
		workOrder = em.find(WorkOrder.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		workOrder = null;
	}

	@Test
	void test_WorkOrder_entity_mapping() {
		assertNotNull(workOrder);
		assertEquals("HVAC seems to be down", workOrder.getDescription());
	}
	@Test
	void test_Notification_entity_mapping() {
		assertNotNull(workOrder);
		assertEquals("Bldg 100, rm 201", workOrder.getNotification().getLocation());
	}
	@Test
	void test_Priority_entity_mapping() {
		assertNotNull(workOrder);
		assertEquals("Delta", workOrder.getPriority().getLevel());
	}
	

}
