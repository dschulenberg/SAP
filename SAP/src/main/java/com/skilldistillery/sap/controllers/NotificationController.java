package com.skilldistillery.sap.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sap.entities.Notification;
import com.skilldistillery.sap.services.NotificationService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost/" })
public class NotificationController {

	@Autowired
	private NotificationService notiServe;
	
	@GetMapping("notifications")
	public List<Notification> index(HttpServletRequest req, HttpServletResponse res) {		
		return notiServe.index();		
	}
	
	@GetMapping("notifications/{id}")
	public Notification findById(@PathVariable int id, HttpServletRequest req, HttpServletResponse res) {
		
		Notification notification = notiServe.findById(id);
		if(notification ==null) {
			res.setStatus(404);
		}
		return notification;
	}
	@PostMapping("notifications")
	public Notification createNotification(@RequestBody Notification notification, HttpServletRequest req, HttpServletResponse res) {
		Notification created = null;
		
		try {
			created= notiServe.create(notification);
			res.setStatus(201);
		}catch(Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return created;
	}
	@PutMapping("notifications/{id}")
	public Notification updateNotification(@RequestBody Notification notification, @PathVariable int id, HttpServletRequest req, HttpServletResponse res) {
		Notification updated= null;
		
		try {
			updated= notiServe.update(id, notification);
		}catch(Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return updated;
	}
	
	@DeleteMapping("notifications/{id}")
	public boolean deleteMixer(@PathVariable int id, HttpServletRequest req, HttpServletResponse res) {
		boolean deleted=notiServe.destroy(id);
		if(deleted) {
			res.setStatus(204);
		}else {
			res.setStatus(404);
		}
		return deleted;
	}
}
