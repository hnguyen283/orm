package com.csc.service;

public interface SendEmailService {
	public void ReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody);
}
