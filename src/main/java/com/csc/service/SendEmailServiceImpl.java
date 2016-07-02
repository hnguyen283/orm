package com.csc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service ("sendService")
public class SendEmailServiceImpl implements SendEmailService {
	@Autowired
	private MailSender crunchifymail; 
	@Override
	public void ReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
		// TODO Auto-generated method stub
		SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
		crunchifyMsg.setFrom(fromAddress);
		crunchifyMsg.setTo(toAddress);
		crunchifyMsg.setSubject(subject);
		crunchifyMsg.setText(msgBody);
		crunchifymail.send(crunchifyMsg);
	}
	
}
