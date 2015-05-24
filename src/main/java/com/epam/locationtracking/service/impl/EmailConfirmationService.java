package com.epam.locationtracking.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.epam.locationtracking.exception.EmailServiceException;
import com.epam.locationtracking.service.EmailService;

@Service
public class EmailConfirmationService implements EmailService {
	
	@Resource(name = "mailSender")
	JavaMailSenderImpl mailSender;
	
	@Resource(name = "templateEngine")
	SpringTemplateEngine templateEngine;

	@Override
	public void send(String userName, String userEmail, String confirmationLink) {
		// Prepare the evaluation context
		final Context ctx = new Context();
		ctx.setVariable("userName", userName);
		ctx.setVariable("subscriptionDate", new Date());
		ctx.setVariable("confirmationLink", confirmationLink);

		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		MimeMessageHelper message;
		try {
			message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			message.setSubject("Example HTML email with inline image");
			message.setFrom("thymeleaf@example.com");
			message.setTo(userEmail);
			// Create the HTML body using Thymeleaf
			final String htmlContent = this.templateEngine.process(
					"email-confirmation.html", ctx);
			message.setText(htmlContent, true); // true = isHtml
		} catch (MessagingException e) {
			throw new EmailServiceException(
					"Can't send registration confirmation email", e);
		}

		// Send mail
		mailSender.send(mimeMessage);

	}
}
