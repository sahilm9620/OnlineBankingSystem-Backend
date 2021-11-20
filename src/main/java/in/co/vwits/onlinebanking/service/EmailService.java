package in.co.vwits.onlinebanking.service;

import java.io.IOException;

import javax.mail.MessagingException;


import freemarker.template.TemplateException;

public interface EmailService {
	 public void sendEmail(Object user,String templateName,String title,String email) throws MessagingException, IOException, TemplateException;
	 String getEmailContent(Object user,String templateName) throws IOException, TemplateException;
}
