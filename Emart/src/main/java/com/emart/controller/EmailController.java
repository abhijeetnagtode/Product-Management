package com.emart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.model.Email;
import com.emart.service.EmailService;

@RestController
@RequestMapping("/mail")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/simpleMail")
	public ResponseEntity<String> sendSimpleMail(@RequestBody Email email) {
		String status = emailService.sendSimpleMail(email);
		return ResponseEntity.ok().body(status);
	}

	@PostMapping("/attachmentMail")
	public ResponseEntity<String> sendMailWithAttchment(@RequestBody Email email) {
		String status = emailService.sendMailWithAttchment(email);
		return ResponseEntity.ok().body(status);
	}

}
