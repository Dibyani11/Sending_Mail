package com.email_generate;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;


	public void sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("dibyanibisoi@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		
		System.out.println("Mail send sucessfully");		
	}

	
	public void sendEmailWithAttachment(String toEmail, String subject, String body,String attachment) throws MessagingException {
		
		MimeMessage mail = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mail,true);
		mimeMessageHelper.setFrom("dibyanibisoi@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource sysResource = new FileSystemResource(new File(attachment));
		mimeMessageHelper.addAttachment(sysResource.getFilename(), sysResource);
		
		mailSender.send(mail);
		
	}
}
