package com.email.MailBuddy.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "https://mail.google.com")
@RestController
@RequestMapping("/api/email")
public class EmailGeneratorController {

	private final EmailGeneratorService emailGeneratorService;

	public EmailGeneratorController(EmailGeneratorService emailGeneratorService) {
		this.emailGeneratorService = emailGeneratorService;
	}

	@PostMapping("/generate")
	public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
		String response = emailGeneratorService.generateEmailReply(emailRequest);
		return ResponseEntity.ok(response);
	}
}
