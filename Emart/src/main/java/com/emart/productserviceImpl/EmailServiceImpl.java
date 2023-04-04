package com.emart.productserviceImpl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.emart.model.Email;
import com.emart.service.EmailService;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public String sendSimpleMail(Email email) {

		// creating simple mail
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		try {
			// setting up details
			mailMessage.setFrom(sender);
			mailMessage.setTo(email.getRecipient());
			mailMessage.setText(email.getMsgBody());
			mailMessage.setSubject(email.getSubject());

			// sending mail
			javaMailSender.send(mailMessage);
			return "Mail Send Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "didnt send the mail";
		}
	}

	@Override
	public String sendMailWithAttchment(Email email) {

		// creating mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {
			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(email.getRecipient());
			mimeMessageHelper.setText(email.getMsgBody());
			mimeMessageHelper.setSubject(email.getSubject());

			// adding attachment
			FileSystemResource file = new FileSystemResource(new File(email.getAttachment()));
			mimeMessageHelper.addAttachment(file.getFilename(), file);

			// sending mails
			javaMailSender.send(mimeMessage);

			return "mail send Successfully";

		} catch (Exception e) {

			e.printStackTrace();
			return "something went wrong in mail";

		}
	}

}
