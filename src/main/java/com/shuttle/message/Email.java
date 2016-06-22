package com.shuttle.message;


import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class Email {

	private MailSender mailSender;
	
	 public void setMailSender(MailSender mailSender) {
	        this.mailSender = mailSender;
	    }


	    public void sendEmail(Message emailMessage){

	        SimpleMailMessage message = new SimpleMailMessage();

	        message.setTo(emailMessage.getReceiverEmailAddress());
	        message.setSubject(emailMessage.getSubject());
	        message.setText(emailMessage.getMessageBody());
	        //sending the message
	        mailSender.send(message);

	    }

}
