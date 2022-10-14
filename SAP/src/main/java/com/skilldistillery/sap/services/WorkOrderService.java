package com.skilldistillery.sap.services;

import java.util.List;


import com.skilldistillery.sap.entities.WorkOrder;

public interface WorkOrderService {

	public List<WorkOrder> index();
	
	
    public WorkOrder findById(int mid);

    public WorkOrder create(WorkOrder workOrder);

    public WorkOrder update(int id, WorkOrder workOrder);

    public boolean destroy(int id);

}
