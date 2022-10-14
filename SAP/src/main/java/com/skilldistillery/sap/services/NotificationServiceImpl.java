package com.skilldistillery.sap.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sap.entities.Notification;
import com.skilldistillery.sap.repositories.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	NotificationRepository notiRepo;

	@Override
	public List<Notification> index() {
		return notiRepo.findAll();
	}

	@Override
	public Notification findById(int id) {
		Optional<Notification> notificationOpt = notiRepo.findById(id);
		Notification notification = null;
		if (notificationOpt.isPresent()) {
			notification = notificationOpt.get();
		  return notification;
		}
		return notification;
	}

	@Override
	public Notification create(Notification notification) {
		return notiRepo.saveAndFlush(notification);
	}

	@Override
	public Notification update(int id, Notification notification) {
		Notification originalNoti = findById(id);
		//get department by id
		originalNoti.setDepartment(notification.getDepartment());
		originalNoti.setDescription(notification.getDescription());
		originalNoti.setLocation(notification.getLocation());
		originalNoti.setComplete(notification.isComplete());
		originalNoti.setEnable(notification.isEnable());
		notiRepo.save(originalNoti);
		return originalNoti;
	}

	@Override
	public boolean destroy(int id) {
		Notification originalNoti = findById(id);
		originalNoti.setEnable(false);	
		notiRepo.save(originalNoti);
		return true;
	}

}
