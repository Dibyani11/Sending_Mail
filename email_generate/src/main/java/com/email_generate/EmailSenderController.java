package com.email_generate;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderController {

	@Autowired
	EmailSenderService senderService;
	
	@GetMapping("/send")
	public void sendMail() {
		senderService.sendEmail("dibyni.b@dikshatech.com", "Subject of email", "Body");
	}
	
	@GetMapping("/withAttachment")
	public void sendAttachment() throws MessagingException {
		senderService.sendEmailWithAttachment("dibyni.b@dikshatech.com", "SUBJECT", "Sending mail with attachment",
				"C:\\Users\\Diksha\\Downloads/diksha.pdf");
	}
}
