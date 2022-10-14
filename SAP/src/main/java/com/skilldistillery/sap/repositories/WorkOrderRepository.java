package com.skilldistillery.sap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sap.entities.User;
import com.skilldistillery.sap.entities.WorkOrder;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Integer> {

	WorkOrder getWorkOrderById(int id);

}
