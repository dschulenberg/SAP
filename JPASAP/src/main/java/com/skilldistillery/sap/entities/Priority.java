package com.skilldistillery.sap.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Priority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	  private String level;
	  private String deadline;
		@OneToMany(mappedBy="priority")
		private List<WorkOrder> workOrders;
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public List<WorkOrder> getWorkOrders() {
		return workOrders;
	}
	public void setWorkOrders(List<WorkOrder> workOrders) {
		this.workOrders = workOrders;
	}
	  


}
