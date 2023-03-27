package com.uc.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class ProviderApplication {
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		
		SpringApplication.run(ProviderApplication.class, args);
		
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		senderService.sendSimpleEmail("ubcrcabs@gmail.com",
				"This is email body",
				"This is email subject");

	}

}
