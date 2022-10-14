package com.skilldistillery.sap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sap.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

	Notification getNotificationById(int id);

}
