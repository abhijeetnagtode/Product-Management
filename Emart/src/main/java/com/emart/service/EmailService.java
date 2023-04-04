package com.emart.service;

import com.emart.model.Email;

public interface EmailService {

	String sendSimpleMail(Email email);

	String sendMailWithAttchment(Email email);

}
