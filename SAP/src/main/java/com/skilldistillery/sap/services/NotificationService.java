package com.skilldistillery.sap.services;

import java.util.List;

import com.skilldistillery.sap.entities.Notification;

public interface NotificationService {

	public List<Notification> index();
	
	
    public Notification findById(int mid);

    public Notification create(Notification notification);

    public Notification update(int id, Notification notification);

    public boolean destroy(int id);

}
